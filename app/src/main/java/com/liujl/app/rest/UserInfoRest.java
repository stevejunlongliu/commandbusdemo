package com.liujl.app.rest;

import com.liujl.app.dto.UserInfoAddCmd;
import com.liujl.app.dto.clientobj.UserInfoCO;
import com.liujl.app.serviceI.UserServiceI;
import com.liujl.common.dto.CommonResult;
import com.liujl.core.boot.Bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiOperation;

/**
 * Created by liujl on 2018/8/3.
 */
@RestController(value = "user")
public class UserInfoRest {

    @Autowired
    UserServiceI userService;

    @ApiOperation(value = "新增用户", notes = "新增用户")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public CommonResult questiontoDetailList() throws Exception {
        CommonResult result = new CommonResult();

        UserInfoAddCmd addCmd = new UserInfoAddCmd();
        UserInfoCO u = new UserInfoCO();
        u.setId("1");
        u.setName("哈哈");
        u.setDepart("开心家族");
        addCmd.setUser(u);
        userService.add(addCmd);

        result.noticeSuccess("200", "成功");
        return result;

//        List<String> packages = new ArrayList<>();
//        packages.add("com.liujl.app");
//        Bootstrap b = new Bootstrap();
//        b.setPackages(packages);
//        b.init();
    }

    @ApiOperation(value = "测试", notes = "测试")
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public CommonResult test() throws Exception {
        CommonResult result = new CommonResult();

        List<String> packages = new ArrayList<>();
        packages.add("com.liujl.app");
        Bootstrap b = new Bootstrap();
        b.setPackages(packages);
       // b.init();
        result.noticeSuccess("200", "成功");
        return result;
    }

}
