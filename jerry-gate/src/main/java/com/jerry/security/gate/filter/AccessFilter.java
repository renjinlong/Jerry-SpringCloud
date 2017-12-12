package com.jerry.security.gate.filter;

import com.alibaba.fastjson.JSON;
import com.jerry.security.auth.common.util.jwt.IJWTInfo;
import com.jerry.security.auth.common.util.jwt.JWTHelper;
import com.jerry.security.common.constants.CommonConstants;
import com.jerry.security.common.exception.auth.ClientForbiddenException;
import com.jerry.security.common.msg.BaseResponse;
import com.jerry.security.common.msg.ObjectRestResponse;
import com.jerry.security.gate.rpc.ClientAuthRpc;
import com.jerry.security.gate.util.user.JwtTokenUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author renjinlong
 * @Package com.jerry.security.gate.filter
 * @Description: TODO
 * @date 2017/11/27 下午2:38
 */
@SuppressWarnings("ALL")
@Component
public class AccessFilter extends ZuulFilter {

    @Value("${jwt.token-header}")
    private String userTokenHeader;
    @Value("${client.token-header}")
    private String clientTokenHeader;
    @Value("${client.id}")
    private String clientId;
    @Value("${client.secret}")
    private String clientSecret;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private ClientAuthRpc clientAuthRpc;


    private Logger log = LoggerFactory.getLogger(AccessFilter.class);

    public AccessFilter() {
        super();
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        //在网关里处理用户token
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        //过滤/api/auth不走token验证流程
        if (request.getRequestURI().substring("/api".length()).startsWith("/auth/jwt"))
            return null;

        String token = request.getHeader(userTokenHeader);

        try {
//            IJWTInfo infoFromToken = jwtTokenUtil.getInfoFromToken(token);
            BaseResponse resp = clientAuthRpc.getAccessToken(clientId, clientSecret);
            if (resp.getStatus() == 200) {
                ObjectRestResponse<String> clientToken = (ObjectRestResponse<String>) resp;
                ctx.addZuulRequestHeader(clientTokenHeader, clientToken.getData());
            }else{
                throw new ClientForbiddenException("gate client secret is Error");
            }
        } catch (ClientForbiddenException e) {
            ctx.setResponseBody(JSON.toJSONString(new BaseResponse(e.getStatus(), e.getMessage())));
        } catch (Exception e) {
            ctx.setResponseBody(JSON.toJSONString(new BaseResponse(CommonConstants.EX_TOKEN_ERROR_CODE, "token error or token expired")));
            e.printStackTrace();
        }

        return null;
    }

}
