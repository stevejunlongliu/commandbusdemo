package com.liujl.core.command;

import com.liujl.common.dto.CommonResult;

/**
 * Created by liujl on 2018/8/2.
 */
public interface CommandBusI {
    public CommonResult send(com.liujl.common.dto.Command cmd);
}
