package com.fengjin.service.impl;

import com.fengjin.dao.UserDao;
import com.fengjin.dao.UserInfoDao;
import com.fengjin.entity.UserEntity;
import com.fengjin.entity.UserInfoEntity;
import com.fengjin.model.DataGrid;
import com.fengjin.model.LoginModel;
import com.fengjin.service.UserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private HttpServletRequest request;


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
            HttpSession session = request.getSession();
            session.setAttribute("entity", entity);
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
    public List<UserInfoEntity> getUserInfoList() {
        return userInfoDao.getUserInfoList();
    }

    /**
     * 分页
     *
     * @param page
     * @param rows
     * @return
     */
    @Override
    public DataGrid getUserList(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<UserInfoEntity> userInfoList = getUserInfoList();
        PageInfo<UserInfoEntity> pageInfo = new PageInfo<UserInfoEntity>(userInfoList);
        DataGrid dataGrid = new DataGrid();
        dataGrid.setTotal(pageInfo.getTotal());
        dataGrid.setRows(userInfoList);
        return dataGrid;
    }
}
