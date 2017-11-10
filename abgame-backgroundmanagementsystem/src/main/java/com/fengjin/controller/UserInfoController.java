package com.fengjin.controller;

import com.fengjin.entity.UserInfoEntity;
import com.fengjin.model.LoginModel;
import com.fengjin.service.UserInfoService;
import com.fengjin.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "userinfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    //登陆
    @ResponseBody
    @RequestMapping(value = "login.action")
    public String login(LoginModel model) {
        return userInfoService.login(model);
    }

    //跳转首页
    @RequestMapping(value = "index.action")
    public String gameindex() {
        return "index";
    }
}
