package com.qf.java2105.lzj.dao;

import com.qf.java2105.lzj.pojo.User;

import java.sql.SQLException;

/**
 * 用户数控制层
 * @Author lzj
 * @Date 2021/9/14
 */
public interface IUser {
    /**
     * 登录
     * @param userName 用户名
      @param password 密码
     * @return 实体
     */
    User findByName(String userName,String password) throws SQLException;

    /**
     * 注册
     * @param userName 用户名
     * @param password 密码
     * @param isAdmin 管理员
     * @param gender 性别
     * @return 实体
     */
    Integer addUser(User user) throws SQLException;

    /**
     * 校验用户名
     * @param userName
     * @return
     */
    Integer existsUserName(String userName) throws SQLException;
}
