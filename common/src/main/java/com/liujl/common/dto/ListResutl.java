package com.liujl.common.dto;

import java.util.Collection;

/**
 * 列表返回结果
 * Created by junlong_liu on 2018/7/31.
 */
public class ListResutl<T> {
    private int total;

    private Collection<T> data;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Collection<T> getData() {
        return data;
    }

    public void setData(Collection<T> data) {
        this.data = data;
    }
}
