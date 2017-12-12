package com.jerry.security.uc.interceptor;

import com.jerry.security.auth.common.util.jwt.IJWTInfo;
import com.jerry.security.common.exception.auth.ClientForbiddenException;
import com.jerry.security.common.msg.BaseResponse;
import com.jerry.security.common.msg.ObjectRestResponse;
import com.jerry.security.uc.rpc.ClientAuthRpc;
import com.jerry.security.uc.util.client.ClientTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 */
@Configuration
public class ClientInterceptor extends HandlerInterceptorAdapter {

    @Value("${client.token-header}")
    private String tokenHeader;
    @Value("${client.id}")
    private String clientId;
    @Value("${client.secret}")
    private String clientSecret;

    @Autowired
    ClientTokenUtil clientTokenUtil;

    @Autowired
    ClientAuthRpc clientAuthRpc;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(tokenHeader);
        IJWTInfo infoFromToken = clientTokenUtil.getInfoFromToken(token);
        String uniqueName = infoFromToken.getUniqueName();
        BaseResponse resp = clientAuthRpc.getAllowedClient(clientId, clientSecret);
        if (resp.getStatus() == 200) {
            ObjectRestResponse<List<String>> allowedClient = (ObjectRestResponse<List<String>>) resp;
            for (String client : allowedClient.getData()) {
                if (client.equals(uniqueName)) {
                    return super.preHandle(request, response, handler);
                }
            }
        }

        throw new ClientForbiddenException("Client is Forbidden!");
    }
}
