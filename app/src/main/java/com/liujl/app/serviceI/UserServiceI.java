package com.liujl.app.serviceI;

import com.liujl.app.dto.UserInfoAddCmd;
import com.liujl.common.dto.CommonResult;

/**
 * Created by liujl on 2018/8/3.
 */
public interface UserServiceI {
    CommonResult add(UserInfoAddCmd customerAddCmd);
}
