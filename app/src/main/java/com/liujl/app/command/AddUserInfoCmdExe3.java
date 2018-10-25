package com.liujl.app.command;

import com.liujl.app.dto.UserInfoAddCmd;
import com.liujl.common.dto.CommonResult;
import com.liujl.core.command.Command;
import com.liujl.core.command.CommandExecutorI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by liujl on 2018/8/3.
 */
@Command
public class AddUserInfoCmdExe3 implements CommandExecutorI<CommonResult, UserInfoAddCmd> {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public CommonResult execute(UserInfoAddCmd cmd) {
        logger.info("AddUserInfoCmdExe3 add user :" + cmd.getUser());
        CommonResult result = new CommonResult();
        return result;
    }
}
