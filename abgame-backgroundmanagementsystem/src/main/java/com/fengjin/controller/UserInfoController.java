package com.fengjin.controller;

import com.fengjin.entity.UserInfoEntity;
import com.fengjin.model.LoginModel;
import com.fengjin.service.UserInfoService;
import com.fengjin.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "userinfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "userinfo")
    public ModelAndView userInfoList() {
        List<UserInfoEntity> userInfoEntityList = userInfoService.userManager();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("userInfoEntityList", userInfoEntityList);
        return modelAndView;
    }

    //登陆
    @RequestMapping(value = "login.action")
    public String login(LoginModel model) {
        return userInfoService.login(model);
    }
}
