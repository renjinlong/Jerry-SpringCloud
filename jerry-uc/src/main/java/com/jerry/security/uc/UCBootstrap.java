package com.jerry.security.uc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by ace on 2017/9/3.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableTransactionManagement
@EnableWebMvc
@MapperScan("com.jerry.security.uc.mapper")
@EnableFeignClients
public class UCBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(UCBootstrap.class, args);
    }
}

