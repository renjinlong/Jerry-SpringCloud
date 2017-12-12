package com.jerry.security.auth.config;

import com.jerry.security.common.handler.GlobalExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

}
