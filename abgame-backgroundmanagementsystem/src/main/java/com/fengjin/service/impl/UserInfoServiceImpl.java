package com.fengjin.service.impl;

import com.fengjin.dao.UserInfoDao;
import com.fengjin.entity.UserInfoEntity;
import com.fengjin.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public List<UserInfoEntity> userManager() {
        return userInfoDao.getUserInfoList();
    }
}
