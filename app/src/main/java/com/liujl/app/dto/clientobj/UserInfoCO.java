package com.liujl.app.dto.clientobj;

import com.liujl.common.dto.ClientObject;

import lombok.Data;

/**
 * Created by liujl on 2018/8/3.
 */
@Data
public class UserInfoCO extends ClientObject {

    private String id;
    private String name;
    private String depart;


}
