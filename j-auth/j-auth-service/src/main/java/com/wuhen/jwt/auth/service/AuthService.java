package com.wuhen.jwt.auth.service;

import java.util.Map;

/**
 * @Author: 王筱哲
 * @Date: 2019/6/13
 * @Time: 17:33
 */
public interface AuthService {

  String authentication(String username, String password) ;

  Map verifyUser(String token);
}
