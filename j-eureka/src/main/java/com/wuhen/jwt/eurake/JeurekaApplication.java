package com.wuhen.jwt.eurake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: 王筱哲
 * @Date: 2019/6/13
 * @Time: 13:19
 */
@SpringBootApplication
@EnableEurekaServer
public class JeurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JeurekaApplication.class);
    }
}
