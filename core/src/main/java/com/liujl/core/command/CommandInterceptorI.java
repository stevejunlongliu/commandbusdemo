package com.liujl.core.command;

import com.liujl.common.dto.CommonResult;
import com.liujl.common.dto.Command;

/**
 * 拦截器抽象
 * Created by liujl on 2018/8/2.
 */
public interface CommandInterceptorI {
    /**
     * 命令执行前
     * Pre-processing before command execution
     */
    default public void preIntercept(Command command) {
    } ;

    /**
     * post
     * Post-processing after command execution
     *
     * @param result, Note that response could be null, check it before use
     */
    default public void postIntercept(Command command, CommonResult result) {
    }

    ;
}
