package com.jerry.security.gate.filter;

import com.alibaba.fastjson.JSON;
import com.jerry.security.auth.common.util.jwt.IJWTInfo;
import com.jerry.security.auth.common.util.jwt.JWTHelper;
import com.jerry.security.common.constants.CommonConstants;
import com.jerry.security.common.msg.BaseResponse;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author renjinlong
 * @Package com.jerry.security.gate.filter
 * @Description: TODO
 * @date 2017/11/27 下午2:38
 */
@Component
public class PreFilter extends ZuulFilter {



    private Logger log = LoggerFactory.getLogger(PreFilter.class);

    public PreFilter() {
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

        String token = request.getHeader("access-token");

        try {
            IJWTInfo infoFromToken = JWTHelper.getInfoFromToken(token, "client/pub.key");
        } catch (Exception e) {
            ctx.setResponseBody(JSON.toJSONString(new BaseResponse(CommonConstants.EX_TOKEN_ERROR_CODE, "token error or token expired")));
            e.printStackTrace();
        }

        return null;
    }

}
