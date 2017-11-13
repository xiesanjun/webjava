package com.fengjin.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fengjin.util.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;

public class UserInfoEntity extends BaseEntity {
    /**
     * 用户ID
     */
    private int id;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 注册时间
     */
    private String registrationtime;
    /**
     * 注册ip
     */
    private String registrationip;
    /**
     * 归属地
     */
    private String attribution;
    /**
     * 系统
     */
    private String system;
    /**
     * 运营商
     */
    private String operator;
    /**
     * 在线状态 0-在线，1-离线
     */
    private int onlinestatus;
    /**
     * 账号状态 0-正常，1-封禁
     */
    private int accountstatus;
    /**
     * 最后一次登陆时间
     */
    private String lastlogintime;
    /**
     * 充值时间
     */
    private String rechargetime;
    /**
     * 充值金额
     */
    private String rechargeamount;
    /**
     * 充值次数
     */
    private int rechargetimes;
    /**
     * 充值方式
     */
    private String rechargemethod;
    /**
     * 兑换次数
     */
    private int exchangetimes;
    /**
     * 兑换元宝
     */
    private String exchangeingots;
    /**
     * 游戏房间/输赢金币
     */
    private String gameroom;
    /**
     * 账号剩余元宝
     */
    private String accountremainingingots;
    /**
     * 账号剩余金币
     */
    private String accountremaininggold;
    /**
     * 保险箱剩余金币
     */
    private String saferemaininggold;
    /**
     * 保险箱剩余元宝
     */
    private String saferemainingingot;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRegistrationtime() {
        return registrationtime;
    }

    public void setRegistrationtime(String registrationtime) {
        this.registrationtime = registrationtime;
    }

    public String getRegistrationip() {
        return registrationip;
    }

    public void setRegistrationip(String registrationip) {
        this.registrationip = registrationip;
    }

    public String getAttribution() {
        return attribution;
    }

    public void setAttribution(String attribution) {
        this.attribution = attribution;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getOnlinestatus() {
        return onlinestatus;
    }

    public void setOnlinestatus(int onlinestatus) {
        this.onlinestatus = onlinestatus;
    }

    public int getAccountstatus() {
        return accountstatus;
    }

    public void setAccountstatus(int accountstatus) {
        this.accountstatus = accountstatus;
    }

    public String getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(String lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public String getRechargetime() {
        return rechargetime;
    }

    public void setRechargetime(String rechargetime) {
        this.rechargetime = rechargetime;
    }

    public String getRechargeamount() {
        return rechargeamount;
    }

    public void setRechargeamount(String rechargeamount) {
        this.rechargeamount = rechargeamount;
    }

    public int getRechargetimes() {
        return rechargetimes;
    }

    public void setRechargetimes(int rechargetimes) {
        this.rechargetimes = rechargetimes;
    }

    public String getRechargemethod() {
        return rechargemethod;
    }

    public void setRechargemethod(String rechargemethod) {
        this.rechargemethod = rechargemethod;
    }

    public int getExchangetimes() {
        return exchangetimes;
    }

    public void setExchangetimes(int exchangetimes) {
        this.exchangetimes = exchangetimes;
    }

    public String getExchangeingots() {
        return exchangeingots;
    }

    public void setExchangeingots(String exchangeingots) {
        this.exchangeingots = exchangeingots;
    }

    public String getGameroom() {
        return gameroom;
    }

    public void setGameroom(String gameroom) {
        this.gameroom = gameroom;
    }

    public String getAccountremainingingots() {
        return accountremainingingots;
    }

    public void setAccountremainingingots(String accountremainingingots) {
        this.accountremainingingots = accountremainingingots;
    }

    public String getAccountremaininggold() {
        return accountremaininggold;
    }

    public void setAccountremaininggold(String accountremaininggold) {
        this.accountremaininggold = accountremaininggold;
    }

    public String getSaferemaininggold() {
        return saferemaininggold;
    }

    public void setSaferemaininggold(String saferemaininggold) {
        this.saferemaininggold = saferemaininggold;
    }

    public String getSaferemainingingot() {
        return saferemainingingot;
    }

    public void setSaferemainingingot(String saferemainingingot) {
        this.saferemainingingot = saferemainingingot;
    }
}
