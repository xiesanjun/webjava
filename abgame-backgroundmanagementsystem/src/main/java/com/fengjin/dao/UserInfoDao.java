package com.fengjin.dao;

import com.fengjin.entity.UserInfoEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoDao {

    public abstract List<UserInfoEntity> getUserInfoList();
}
