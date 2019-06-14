package com.wuhen.jwt.user.service.impl;

import com.wuhen.jwt.common.enums.ExceptionEnum;
import com.wuhen.jwt.common.exception.LyException;
import com.wuhen.jwt.user.entity.User;

import com.wuhen.jwt.user.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 王筱哲
 * @Date: 2019/6/13
 * @Time: 13:34
 */
@Service
public class UserServiceImpl {
    @Autowired
    private UserMapper userMapper;

    public User queryByUsernameAndPassword(String username, String password) {

        //查询用户名
        User recod = new User();
        recod.setUsername(username);
        User user = userMapper.selectOne(recod);

        //校验
        if (user == null) {
            throw new LyException(ExceptionEnum.INVALID_USERNAME_PASSWORD);
        }

        if (!StringUtils.equals(user.getPassword(), password)) {
            throw new LyException(ExceptionEnum.INVALID_USERNAME_PASSWORD);

        }
        //成功返回结果
        return user;
    }
}
