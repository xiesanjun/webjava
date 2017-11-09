package com.fengjin.service;

import com.fengjin.entity.UserInfoEntity;
import com.fengjin.model.LoginModel;

import java.util.List;

public interface UserInfoService {

    public abstract String login(LoginModel model);

    public abstract List<UserInfoEntity> userManager();
}
