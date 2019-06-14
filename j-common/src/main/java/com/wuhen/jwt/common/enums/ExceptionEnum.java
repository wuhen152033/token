package com.wuhen.jwt.common.enums;

/**
 * @Author: 王筱哲
 * @Date: 2019/4/27
 * @Time: 17:41
 */
public enum ExceptionEnum {

    /**
     *无效的用户名和密码
     */
    INVALID_USERNAME_PASSWORD(400,"无效的用户名和密码"),
    /**
     * 未经许可
     */
    UNAUTHORIZED(400,"未经许可/登录已过期")
    ;
    /**
     * 返回码
     */

    private int code;
    /**
     *  返回内容
     */

    private String msg;

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }


    ExceptionEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    ExceptionEnum() {
    }

}
