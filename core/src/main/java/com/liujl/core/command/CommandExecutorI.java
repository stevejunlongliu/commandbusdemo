package com.liujl.core.command;

import com.liujl.common.dto.CommonResult;

/**
 * Created by liujl on 2018/8/2.
 */
public interface CommandExecutorI<R extends CommonResult, C extends com.liujl.common.dto.Command> {
    public R execute(C cmd);
}
