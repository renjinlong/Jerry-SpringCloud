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
        log.info("pre……");
        // TODO: 2017/9/4  身份不通过跟oauth、jwt  40101 
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.put("start", System.currentTimeMillis());
        return null;
    }

}
