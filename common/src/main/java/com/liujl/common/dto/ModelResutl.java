package com.liujl.common.dto;

/**
 * 单个体返回结果
 * Created by junlong_liu on 2018/7/31.
 */
public class ModelResutl<T> extends CommonResult {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
