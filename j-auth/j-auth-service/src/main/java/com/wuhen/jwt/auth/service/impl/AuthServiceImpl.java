package com.wuhen.jwt.auth.service.impl;

import com.wuhen.jwt.auth.client.UserClient;
import com.wuhen.jwt.auth.config.JwtProperties;
import com.wuhen.jwt.auth.entity.UserInfo;
import com.wuhen.jwt.auth.service.AuthService;
import com.wuhen.jwt.auth.utils.JwtUtils;
import com.wuhen.jwt.common.enums.ExceptionEnum;
import com.wuhen.jwt.common.exception.LyException;
import com.wuhen.jwt.user.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 王筱哲
 * @Date: 2019/6/13
 * @Time: 20:46
 */
@Service
@EnableConfigurationProperties(JwtProperties.class)
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserClient userClient;

    @Autowired
    private JwtProperties properties;

    /**
     * 用户授权
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public String authentication(String username, String password) {


        //1.调用微服务查询用户信息
        User user = this.userClient.queryUser(username, password);
        //2.查询结果为空，则直接返回null
        if (user == null) {
            throw new LyException(ExceptionEnum.INVALID_USERNAME_PASSWORD);
        }
        //3.查询结果不为空，则生成token
        String token = null;
        try {
            token = JwtUtils.generateToken(new UserInfo(user.getId(), user.getUsername()),
                    properties.getPrivateKey(), properties.getExpire());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //如果token为空
        if (StringUtils.isBlank(token)) {
            throw new LyException(ExceptionEnum.UNAUTHORIZED);
        }
        return token;

    }

    /**
     * 用户验证
     *
     * @param token
     * @return
     */
    @Override
    public Map verifyUser(String token) {

        //1.从token中解析token信息
        UserInfo userInfo = null;
        try {
            userInfo = JwtUtils.getInfoFromToken(token, this.properties.getPublicKey());
            //2.解析成功要重新刷新token
            token = JwtUtils.generateToken(userInfo, this.properties.getPrivateKey(), this.properties.getExpire());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //解析失败
        if (userInfo == null) {
            throw new LyException(ExceptionEnum.UNAUTHORIZED);
        }
        Map map=new HashMap();
        map.put(1,userInfo);
        map.put(2,token);

        //2.解析成功返回用户信息
        return map;


    }
}
