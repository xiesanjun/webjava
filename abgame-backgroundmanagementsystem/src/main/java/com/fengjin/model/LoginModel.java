package com.fengjin.model;

import java.io.Serializable;

/**
 * 登陆模型
 */
public class LoginModel implements Serializable {

    private String login;//用户
    private String password;//密码

    public LoginModel() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
