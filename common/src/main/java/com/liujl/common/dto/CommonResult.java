package com.liujl.common.dto;

/**
 * 通用返回结果
 * Created by junlong_liu on 2018/7/31.
 */
public class CommonResult extends DTO {

    private static final long serialVersionUID = 1L;

    private boolean isSuccess;

    private String errCode;

    private String errMessage;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

    //标记是否成功
    public void noticeSuccess(String errCode, String msg) {
        this.setSuccess("200".equals(errCode) ? true : false);
        this.setErrCode(errCode);
        this.setErrMessage(msg);
    }
}
