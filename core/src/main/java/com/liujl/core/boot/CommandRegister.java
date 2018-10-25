package com.liujl.core.boot;

import com.google.common.collect.Iterables;

import com.liujl.core.command.CommandExecutorI;
import com.liujl.core.command.CommandHub;
import com.liujl.core.command.CommandInterceptorI;
import com.liujl.core.command.CommandInvocation;
import com.liujl.common.dto.Command;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by liujl on 2018/8/2.
 */
@Component
public class CommandRegister implements RegisterI, ApplicationContextAware {
    @Autowired
    private CommandHub commandHub;

    private ApplicationContext applicationContext;

    @Override
    public void doRegistration(Class<?> targetClz) {
        Class<? extends Command> commandClz = getCommandFromExecutor(targetClz);
        CommandInvocation commandInvocation = new CommandInvocation();
        commandInvocation.setCommandExecutor((CommandExecutorI) applicationContext.getBean(targetClz));
        commandInvocation.setPreInterceptors(collectInterceptors(commandClz, true));
        commandInvocation.setPostInterceptors(collectInterceptors(commandClz, false));
        commandHub.getCommandRepository().put(commandClz, commandInvocation);
    }

    //根据executor获得需要执行的command
    private Class<? extends Command> getCommandFromExecutor(Class<?> commandExecutorClz) {
        Method[] methods = commandExecutorClz.getDeclaredMethods();
        for (Method method : methods) {
            Class<?>[] exeParams = method.getParameterTypes();
            /**
             * This is for return right response type on exception scenarios
             */
            //todo 判断CoreConstant在实际中的使用，不是阿里的业务是否也会强制需要使用
//            if (CoreConstant.EXE_METHOD.equals(method.getName()) && exeParams.length == 1
//                    && Command.class.isAssignableFrom(exeParams[0]) && !method.isBridge()) {
            if (exeParams.length == 1
                    && Command.class.isAssignableFrom(exeParams[0]) && !method.isBridge()) {
                commandHub.getResponseRepository().put(exeParams[0], method.getReturnType());
                return (Class<? extends Command>) exeParams[0];
            }
        }
        return null;//todo 异常抛出的处理
//        throw new InfraException("Command param in " + commandExecutorClz + " " + CoreConstant.EXE_METHOD
//                + "() is not detected");
    }


    //todo 确认做了什么
    private Iterable<CommandInterceptorI> collectInterceptors(Class<? extends Command> commandClass, boolean pre) {
        /**
         * add 通用的Interceptors
         */
        Iterable<CommandInterceptorI> commandItr = Iterables.concat((pre ? commandHub.getGlobalPreInterceptors() : commandHub.getGlobalPostInterceptors()));
        /**
         * add command自己专属的Interceptors
         */
        Iterables.concat(commandItr, (pre ? commandHub.getPreInterceptors() : commandHub.getPostInterceptors()).get(commandClass));
        /**
         * add parents的Interceptors
         */
        Class<?> superClass = commandClass.getSuperclass();
        while (Command.class.isAssignableFrom(superClass)) {
            Iterables.concat(commandItr, (pre ? commandHub.getPreInterceptors() : commandHub.getPostInterceptors()).get(commandClass));
            superClass = superClass.getSuperclass();
        }
        return commandItr;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
