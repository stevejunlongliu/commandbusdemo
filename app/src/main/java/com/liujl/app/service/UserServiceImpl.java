package com.liujl.app.service;

import com.liujl.app.dto.UserInfoAddCmd;
import com.liujl.app.serviceI.UserServiceI;
import com.liujl.common.dto.CommonResult;
import com.liujl.core.command.CommandBusI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liujl on 2018/8/3.
 */
@Service
public class UserServiceImpl implements UserServiceI {

    @Autowired
    private CommandBusI commandBus;

    @Override
    public CommonResult add(UserInfoAddCmd userInfoAddCmd) {
        return (CommonResult) commandBus.send(userInfoAddCmd);
    }
}
