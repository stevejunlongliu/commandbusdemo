package com.liujl.core.assembler;

/**
 * 消息，查询，HSF等接口的参数装配
 * Created by liujl on 2018/7/31.
 */
public interface AssemblerI<F, T> {

    default T assemble(F from) {
        return null;
    }

    default void assemble(F from, T to) {
    }
}
