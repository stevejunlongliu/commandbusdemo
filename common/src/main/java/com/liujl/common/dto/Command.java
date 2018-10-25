package com.liujl.common.dto;

/**
 * 操作抽象
 * Created by junlong_liu on 2018/7/31.
 */
public abstract class Command extends DTO {

    private static final long serialVersionUID = 1L;

    //操作人
    private String userid;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
