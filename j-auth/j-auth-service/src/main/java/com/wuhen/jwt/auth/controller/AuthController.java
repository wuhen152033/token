package com.wuhen.jwt.auth.controller;

import com.wuhen.jwt.auth.config.JwtProperties;
import com.wuhen.jwt.auth.entity.UserInfo;
import com.wuhen.jwt.auth.service.AuthService;
import com.wuhen.jwt.common.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: 王筱哲
 * @Date: 2019/6/13
 * @Time: 17:32
 */
@RestController
@EnableConfigurationProperties(JwtProperties.class)
public class AuthController {

    @Autowired
    private AuthService authService;
    @Autowired
    private JwtProperties properties;

    @PostMapping("accredit")
    public ResponseEntity<Void> authentication(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        //1.登录校验
        String token = this.authService.authentication(username, password);
        //2.将token写入cookie，并指定httpOnly为true，防止通过js获取和修改
        CookieUtils.setCookie(request, response, properties.getCookieName(), token, properties.getCookieMaxAge(), true);
        return ResponseEntity.ok().build();
    }

    /**
     * 用户验证
     *
     * @param token
     * @return
     */
    @GetMapping("verify")
    public ResponseEntity<UserInfo> verifyUser(@CookieValue("j-cookie") String token,
                                               HttpServletRequest request,
                                               HttpServletResponse response) {
        String token1 = authService.verifyUser(token).get(2).toString();
        //3.更新Cookie中的token

        CookieUtils.setCookie(request, response, this.properties.getCookieName(), token1, this.properties.getCookieMaxAge());
        return ResponseEntity.ok((UserInfo) authService.verifyUser(token).get(1));

    }

}
