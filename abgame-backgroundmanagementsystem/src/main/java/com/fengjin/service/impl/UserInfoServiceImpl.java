package com.fengjin.service.impl;

import com.fengjin.dao.UserDao;
import com.fengjin.dao.UserInfoDao;
import com.fengjin.entity.UserEntity;
import com.fengjin.entity.UserInfoEntity;
import com.fengjin.model.LoginModel;
import com.fengjin.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    private UserDao userDao;


    /**
     * 登陆
     *
     * @param model
     * @return
     */
    @Override
    public String login(LoginModel model) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(model.getLogin());
        userEntity.setLoginToken(model.getPassword());
        System.out.println(model.getLogin());
        System.out.println(model.getPassword());
        UserEntity entity = userDao.login(userEntity);
        if (entity != null) {
            return "success";
        }
        return null;
    }

    /**
     * 获取用户信息列表
     *
     * @return List<UserInfoEntity>
     */
    @Override
    public List<UserInfoEntity> userManager() {
        return userInfoDao.getUserInfoList();
    }
}
