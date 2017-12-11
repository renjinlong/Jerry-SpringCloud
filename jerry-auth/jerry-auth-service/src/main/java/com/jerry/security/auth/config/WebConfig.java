package com.jerry.security.auth.service.config;

import com.jerry.security.common.handler.GlobalExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author renjinlong
 * @Title:
 * @Package com.jerry.security.uc.config
 * @Description: TODO
 * @date 2017/11/30 上午11:24
 */
@Configuration
public class WebConfig {

    @Bean
    GlobalExceptionHandler getGlobalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

}
