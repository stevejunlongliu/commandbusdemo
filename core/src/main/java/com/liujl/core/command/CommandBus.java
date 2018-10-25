package com.liujl.core.command;

import com.liujl.common.dto.CommonResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.liujl.common.dto.Command;

/**
 * Created by liujl on 2018/8/2.
 */
@Component
public class CommandBus implements CommandBusI {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CommandHub commandHub;

    @Override
    public CommonResult send(com.liujl.common.dto.Command cmd) {

        CommonResult result = null;
        try {
            // 从commondhub中取出执行句柄进行执行
            result = commandHub.getCommandInvocation(cmd.getClass()).invoke(cmd);
        } catch (Exception e) {

            result = handleException(cmd, result, e);
        }
        return null;
    }

    //包装错误信息
    private CommonResult handleException(Command cmd, CommonResult result, Exception exception) {
        //todo
        return result;
    }


}
