package com.jerry.security.uc.config;

import com.jerry.security.common.handler.GlobalExceptionHandler;
import com.jerry.security.uc.interceptor.ClientInterceptor;
import com.jerry.security.uc.interceptor.JWTInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author renjinlong
 * @Title:
 * @Package com.jerry.security.uc.config
 * @Description: TODO
 * @date 2017/11/30 上午11:24
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    GlobalExceptionHandler getGlobalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getClientInterceptor()).addPathPatterns("/**");
//        registry.addInterceptor(getJWTInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

//    //这里必须使用新对象必须使用@Bean才可以使用
//    @Bean
//    public JWTInterceptor getJWTInterceptor() {
//        return new JWTInterceptor();
//    }

    @Bean
    public ClientInterceptor getClientInterceptor() {
        return new ClientInterceptor();
    }
}
