package com.fengjin.entity;

public class UserEntity extends BaseEntity {
    /**
     * 用户编号
     */
    public int id;

    /**
     * 平台id(为以后区分渠道使用)
     */
    public int pid;

    /**
     * 用户姓名
     */
    public String userName;

    /**
     * 手机号码
     */
    public String phone;

    /**
     * 微信唯一标识
     */
    public String unionId;

    /**
     * 头像
     */
    public String avatar;

    /**
     * 用户昵称
     */
    public String nickname;

    /**
     * 会员等级 1 普通会员
     */
    public short vipLevel;

    /**
     * vip结束时间
     */
    public Object vipEndTime;

    /**
     * 元宝
     */
    public long ingot;

    /**
     * 剩余金币
     */
    public long golds;

    /**
     * 用户总金币（u_golds + 银行的金币）
     */
    public long totalGold;

    /**
     * 状态编号(1: 正常, 0: 冻结 )
     */
    public short state;
    public String loginToken;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public short getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(short vipLevel) {
        this.vipLevel = vipLevel;
    }

    public Object getVipEndTime() {
        return vipEndTime;
    }

    public void setVipEndTime(Object vipEndTime) {
        this.vipEndTime = vipEndTime;
    }

    public long getIngot() {
        return ingot;
    }

    public void setIngot(long ingot) {
        this.ingot = ingot;
    }

    public long getGolds() {
        return golds;
    }

    public void setGolds(long golds) {
        this.golds = golds;
    }

    public long getTotalGold() {
        return totalGold;
    }

    public void setTotalGold(long totalGold) {
        this.totalGold = totalGold;
    }

    public short getState() {
        return state;
    }

    public void setState(short state) {
        this.state = state;
    }

    public String getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }
}
