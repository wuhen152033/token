package com.wuhen.jwt.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author: 王筱哲
 * @Date: 2019/6/13
 * @Time: 13:31
 */
@SpringBootApplication(scanBasePackages="com.wuhen.jwt")
@EnableDiscoveryClient
@MapperScan("com.wuhen.jwt.user.mapper")
public class JuserApplication {

    public static void main(String[] args) {
        SpringApplication.run(JuserApplication.class);
    }
}
