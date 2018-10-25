package com.liujl.common.dto;

import java.util.List;

/**
 * 翻页查询实体
 * Created by junlong_liu on 2018/7/31.
 */
public class PageQuery extends Query {

    //页码
    private int page;
    //每页数据数量
    private int size;
    //是否需要返回查询数据总数
    private boolean needTotalCount = true;
    //排序信息
    private List<OrderDesc> orderDescs;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isNeedTotalCount() {
        return needTotalCount;
    }

    public void setNeedTotalCount(boolean needTotalCount) {
        this.needTotalCount = needTotalCount;
    }

    public List<OrderDesc> getOrderDescs() {
        return orderDescs;
    }

    public void setOrderDescs(List<OrderDesc> orderDescs) {
        this.orderDescs = orderDescs;
    }
}
