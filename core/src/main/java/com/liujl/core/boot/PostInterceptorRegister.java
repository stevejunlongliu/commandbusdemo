package com.liujl.core.boot;

import com.liujl.core.command.CommandHub;
import com.liujl.core.command.CommandInterceptorI;
import com.liujl.core.command.PostInterceptor;
import com.liujl.common.dto.Command;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by liujl on 2018/8/2.
 */
@Component
public class PostInterceptorRegister implements RegisterI, ApplicationContextAware {
    @Autowired
    private CommandHub commandHub;

    private ApplicationContext applicationContext;

    @Override
    public void doRegistration(Class<?> targetClz) {

        CommandInterceptorI commandInterceptor = (CommandInterceptorI) applicationContext.getBean(targetClz);
        PostInterceptor postInterceptorAnn = targetClz.getDeclaredAnnotation(PostInterceptor.class);
        Class<? extends Command>[] supportClasses = postInterceptorAnn.commands();
        registerInterceptor(supportClasses, commandInterceptor);

    }

    private void registerInterceptor(Class<? extends Command>[] supportClasses, CommandInterceptorI commandInterceptor) {
        if (null == supportClasses || supportClasses.length == 0) {
            commandHub.getGlobalPostInterceptors().add(commandInterceptor);
            return;
        }
        for (Class<? extends Command> supportClass : supportClasses) {
            commandHub.getPostInterceptors().put(supportClass, commandInterceptor);
        }
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
