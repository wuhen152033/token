package com.wuhen.jwt.user.controller;

import com.wuhen.jwt.user.entity.User;
import com.wuhen.jwt.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 王筱哲
 * @Date: 2019/6/13
 * @Time: 13:34
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("query")
    public ResponseEntity<User> queryByUsernameAndPassword(
            @RequestParam("username")String username,
            @RequestParam("password")String password
    ){
       return ResponseEntity.ok(userService.queryByUsernameAndPassword(username,password));
    }
}
