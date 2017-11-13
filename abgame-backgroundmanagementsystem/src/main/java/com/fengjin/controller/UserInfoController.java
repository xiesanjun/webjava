package com.fengjin.controller;

import com.fengjin.entity.UserInfoEntity;
import com.fengjin.model.DataGrid;
import com.fengjin.model.LoginModel;
import com.fengjin.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "userinfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    //登陆
    @ResponseBody
    @RequestMapping(value = "login.action", method = RequestMethod.POST)
    public String login(LoginModel model) {
        return userInfoService.login(model);
    }

    //跳转首页
    @RequestMapping(value = "index.action")
    public String index() {
        return "index";
    }

    //获取用户信息并分页
    @ResponseBody
    @RequestMapping(value = "userinfo.action", method = RequestMethod.POST)
    public DataGrid getUserInfoList(Integer page, Integer rows) {
        DataGrid dataGrid = userInfoService.getUserList(page, rows);
        return dataGrid;
    }

    @RequestMapping(value = "gmmanager.action")
    public String gmmanagerindex() {
        return "GMmanager/userinfo";
    }
}
