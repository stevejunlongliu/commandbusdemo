package com.liujl.common.dto;

/**
 * 排序
 * Created by junlong_liu on 2018/7/31.
 */
public class OrderDesc {
    private String col;
    private boolean asc = true;

    public String getCol() {
        return col;
    }

    public void setCol(String col) {
        this.col = col;
    }

    public boolean isAsc() {
        return asc;
    }

    public void setAsc(boolean asc) {
        this.asc = asc;
    }
}
