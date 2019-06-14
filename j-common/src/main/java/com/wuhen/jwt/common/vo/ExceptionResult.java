package com.wuhen.jwt.common.vo;


import com.wuhen.jwt.common.enums.ExceptionEnum;

/**
 * @Author: wuhen
 * @Date: 2019/4/25
 * @Time: 20:58
 */
public class ExceptionResult {
    private int states;
    private String message;
    private Long timestamp;

    public int getStates() {
        return states;
    }

    public void setStates(int states) {
        this.states = states;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public ExceptionResult(ExceptionEnum em){
        this.states=em.getCode();
        this.message=em.getMsg();
        this.timestamp=System.currentTimeMillis();
    }

}
