package com.fengjin.dao;

import com.fengjin.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    /**
     * 登陆
     *
     * @param entity
     * @return
     */
    public abstract UserEntity login(UserEntity entity);
}
