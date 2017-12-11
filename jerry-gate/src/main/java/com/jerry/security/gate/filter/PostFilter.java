package com.jerry.security.gate.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author renjinlong
 * @Package com.jerry.security.gate.filter
 * @Description: TODO
 * @date 2017/11/27 下午2:38
 */
@Component
public class PostFilter extends ZuulFilter {
    Logger log = LoggerFactory.getLogger(PostFilter.class);

    public PostFilter() {
        super();
    }

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
//        log.info("post....");
//        RequestContext ctx = RequestContext.getCurrentContext();
//        long total = System.currentTimeMillis() - (long) ctx.get("start");
//        // ctrl alt l 格式化快捷建
//        // rsponse
////        ctx.addZuulResponseHeader();
//        log.info("the request use :" + total + "ms");
//        try {
//            int i = 1 / 0;
//        } catch (exception e) {
//            setFailedRequest(e.getMessage(),500);
//        }
        return null;
    }

    private void setFailedRequest(String body, int code) {
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.setResponseStatusCode(code);
        if (ctx.getResponseBody() == null) {
            ctx.setResponseBody(body);
            ctx.setSendZuulResponse(false);
        }
    }
}
