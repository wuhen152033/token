package com.wuhen.jwt.user.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author: 王筱哲
 * @Date: 2019/6/13
 * @Time: 13:49
 */
@Data
@Table(name = "j_user")
public class User {

    /**
     * 自增id
     */
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 创建时间
     */
    private Date created;
}
