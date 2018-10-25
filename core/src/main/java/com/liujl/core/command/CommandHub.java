package com.liujl.core.command;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.ListMultimap;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by liujl on 2018/8/2.
 */
@Component
public class CommandHub {

    @Getter
    @Setter
    private ListMultimap<Class/*CommandClz*/, CommandInterceptorI> preInterceptors = LinkedListMultimap.create();
    @Getter
    @Setter
    private ListMultimap<Class/*CommandClz*/, CommandInterceptorI> postInterceptors = LinkedListMultimap.create();
    @Getter
    @Setter
    private List<CommandInterceptorI> globalPreInterceptors = new ArrayList<>(); //全局通用的PreInterceptors
    @Getter
    @Setter
    private List<CommandInterceptorI> globalPostInterceptors = new ArrayList<>(); //全局通用的PostInterceptors

    @Getter
    @Setter
    private Map<Class/*CommandClz*/, CommandInvocation> commandRepository = new HashMap<>();

    @Getter
    private Map<Class/*CommandClz*/, Class/*ResponseClz*/> responseRepository = new HashMap<>();

    public CommandInvocation getCommandInvocation(Class cmdClass) {
        //取出需要执行命令
        CommandInvocation commandInvocation = commandRepository.get(cmdClass);
        if (commandRepository.get(cmdClass) == null)

            try {//todo 是否需要申明异常，抛出业务异常
                throw new Exception(cmdClass + " is not registered in CommandHub, please register first");
            } catch (Exception e) {
                e.printStackTrace();
            }
        return commandInvocation;
    }
}
