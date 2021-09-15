package com.qf.java2105.lzj.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * 用户实体
 * @Author lzj
 * @Date 2021/9/11
 */
public class User implements Serializable {
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 是否管理员
     */
    private Integer isAdmin;
    /**
     * 电话
     */
    private String phone;
    /**
     * 性别
     */
    private Integer gender;
    /**
     * 用户状态
     */
    private Integer userStatus;
    /**
     * 创建时间
     */
    private Date userCreateTime;
    /**
     * 修改时间
     */
    private Date userUpdateTime;
    /**
     * 是否删除
     */
    private Integer isDelete;
    /**
     * 是否会员
     */
    private Integer isMember;
    /**
     * 账户余额
     */
    private BigDecimal balance;

    public User() {
    }

    public User(String userName, String password, Integer gender, Integer isMember) {
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.isMember = isMember;
    }

    public User(Integer userId, String userName, String password, String nickName, Integer isAdmin, String phone, Integer gender, Integer userStatus, Date userCreateTime, Date userUpdateTime, Integer isDelete, Integer isMember, BigDecimal balance) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.nickName = nickName;
        this.isAdmin = isAdmin;
        this.phone = phone;
        this.gender = gender;
        this.userStatus = userStatus;
        this.userCreateTime = userCreateTime;
        this.userUpdateTime = userUpdateTime;
        this.isDelete = isDelete;
        this.isMember = isMember;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", nickName='" + nickName + '\'' +
                ", isAdmin=" + isAdmin +
                ", phone='" + phone + '\'' +
                ", gender=" + gender +
                ", userStatus=" + userStatus +
                ", userCreateTime=" + userCreateTime +
                ", userUpdateTime=" + userUpdateTime +
                ", isDelete=" + isDelete +
                ", isMember=" + isMember +
                ", balance=" + balance +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Date getUserCreateTime() {
        return userCreateTime;
    }

    public void setUserCreateTime(Date userCreateTime) {
        this.userCreateTime = userCreateTime;
    }

    public Date getUserUpdateTime() {
        return userUpdateTime;
    }

    public void setUserUpdateTime(Date userUpdateTime) {
        this.userUpdateTime = userUpdateTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getIsMember() {
        return isMember;
    }

    public void setIsMember(Integer isMember) {
        this.isMember = isMember;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
