package com.qf.java2105.lzj.dao.impl;

import com.qf.java2105.lzj.dao.IUser;
import com.qf.java2105.lzj.pojo.User;
import com.qf.java2105.lzj.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

/**
 * 用户控制层实现
 * @Author lzj
 * @Date 2021/9/14
 */
public class UserDaoImpl implements IUser {
    private QueryRunner queryRunner = null;
    @Override
    public User findByName(String userName,String password) throws SQLException {
        queryRunner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "SELECT \n" +
                "`user_id` userId,\n" +
                "`username` userName,\n" +
                "`password`,\n" +
                "`nick_name` nickName,\n" +
                "`is_admin` isAdmin,\n" +
                "`phone`,\n" +
                "`gender`,\n" +
                "`user_status` userStatus,\n" +
                "`user_create_time` userCreateTime,\n" +
                "`user_update_time` userUpdateTime,\n" +
                "`is_delete` isDelete,\n" +
                "`is_member` isMember,\n" +
                "`balance`\n" +
                "FROM\n" +
                "`t_user`\n" +
                "WHERE \n" +
                "`username` = ? AND `password` = ? AND `is_delete` = 0";
        return queryRunner.query(sql,new BeanHandler<>(User.class),userName,password);
    }

    @Override
    public Integer addUser(User user) throws SQLException {
        queryRunner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "INSERT INTO `t_user` (`username`,`password`,`is_admin`,`gender`)\n" +
                "VALUES (?,?,?,?)";
        return queryRunner.update(sql,user.getUserName(),user.getPassword(),user.getIsAdmin(),user.getGender());
    }

    @Override
    public Integer existsUserName(String userName) throws SQLException {
        queryRunner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "SELECT `user_id` FROM `t_user` WHERE `username` = ?";
        return queryRunner.query(sql,new ScalarHandler<>(),userName);
    }
}
