package com.liujl.core.command;

import com.google.common.collect.FluentIterable;

import com.liujl.common.dto.CommonResult;

import java.util.List;

import lombok.Setter;

/**
 * 调用命令抽象
 * Created by liujl on 2018/8/2.
 */
public class CommandInvocation<R extends CommonResult, C extends com.liujl.common.dto.Command> {


    @Setter
    private CommandExecutorI<R,C> commandExecutor;
    @Setter
    private Iterable<CommandInterceptorI> preInterceptors;
    @Setter
    private Iterable<CommandInterceptorI> postInterceptors;

    public CommandInvocation() {

    }

    public CommandInvocation(CommandExecutorI<R, C> commandExecutor, List<CommandInterceptorI> preInterceptors,
                             List<CommandInterceptorI> postInterceptors){
        this.commandExecutor = commandExecutor;
        this.preInterceptors = preInterceptors;
        this.postInterceptors = postInterceptors;
    }

    public R invoke(C command) {
        preIntercept(command);
        R response = null;
        try {
            response = commandExecutor.execute(command);
            response.setSuccess(true);
        }
        finally {
            //make sure post interceptors performs even though exception happens
            postIntercept(command, response);
        }
        return response;
    }

    private void postIntercept(C command, R response) {
        for (CommandInterceptorI postInterceptor : FluentIterable.from(postInterceptors).toSet()) {
            postInterceptor.postIntercept(command, response);
        }
    }

    private void preIntercept(C command) {
        for (CommandInterceptorI preInterceptor : FluentIterable.from(preInterceptors).toSet()) {
            preInterceptor.preIntercept(command);
        }
    }

}
