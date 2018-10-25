package com.liujl.app.dto;

import com.liujl.app.dto.clientobj.UserInfoCO;
import com.liujl.common.dto.Command;

import lombok.Data;

/**
 * Created by liujl on 2018/8/3.
 */
@Data
public class UserInfoAddCmd extends Command  {
    private UserInfoCO user;
}
