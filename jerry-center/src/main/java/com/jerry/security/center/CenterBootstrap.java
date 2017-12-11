package com.jerry.security.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author renjinlong
 * @Title: CenterBootstrap
 * @Package com.jerry.security.center
 * @Description: 服务注册发现eureka
 * @date 2017/11/27 下午2:13
 */
@EnableEurekaServer
@SpringBootApplication
public class CenterBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(CenterBootstrap.class, args);
    }
}
