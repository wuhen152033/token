package com.wuhen.jwt.common.exception;


import com.wuhen.jwt.common.enums.ExceptionEnum;

/**
 * @Author: 王筱哲
 * @Date: 2019/4/25
 * @Time: 20:03
 */
public class LyException extends RuntimeException {

    private ExceptionEnum exceptionEnum;

    public ExceptionEnum getExceptionEnum() {
        return exceptionEnum;
    }

    public void setExceptionEnum(ExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
    }

    public LyException(ExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
    }

    public LyException() {
    }


}
