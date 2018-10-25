package com.liujl.core.boot;

/**
 * 注册器抽象 //todo 什么初始化调用的register
 * Created by liujl on 2018/8/2.
 */
public interface RegisterI {
    public void doRegistration(Class<?> targetClz);
}
