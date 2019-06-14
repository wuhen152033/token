package com.wuhen.jwt.auth.client;


import com.wuhen.jwt.user.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: 王筱哲
 * @Date: 2019/6/13
 * @Time: 20:40
 */

@FeignClient(value = "user-service")
public interface UserClient{

    /**
     * 用户验证
     * @param username
     * @param password
     * @return
     */
    @PostMapping("query")
    User queryUser(@RequestParam("username")String username, @RequestParam("password")String password);

}
