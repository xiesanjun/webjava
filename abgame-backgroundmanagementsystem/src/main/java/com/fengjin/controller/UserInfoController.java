package com.fengjin.controller;

import com.fengjin.entity.UserInfoEntity;
import com.fengjin.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "userinfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private HttpServletRequest request;

    public String userInfoList() {
        List<UserInfoEntity> userInfoEntityList = userInfoService.userManager();
        request.setAttribute("userInfoEntityList", userInfoEntityList);
        return "userInfoList";
    }
}
