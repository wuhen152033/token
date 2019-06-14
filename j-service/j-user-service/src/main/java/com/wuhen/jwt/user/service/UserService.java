package com.wuhen.jwt.user.service;

import com.wuhen.jwt.user.entity.User;

/**
 * @Author: wuhen
 * @Date: 2019/6/14
 * @Time: 16:06
 */
public interface UserService {
    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
    User queryByUsernameAndPassword(String username, String password);
}
