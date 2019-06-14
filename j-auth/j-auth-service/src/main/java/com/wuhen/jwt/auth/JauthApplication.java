package com.wuhen.jwt.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: 王筱哲
 * @Date: 2019/6/13
 * @Time: 15:57
 */
@SpringBootApplication(scanBasePackages="com.wuhen.jwt")
@EnableDiscoveryClient
@EnableFeignClients
public class JauthApplication {

    public static void main(String[] args) {
        SpringApplication.run(JauthApplication.class);
    }
}
