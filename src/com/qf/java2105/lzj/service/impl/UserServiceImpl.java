package com.qf.java2105.lzj.service.impl;

import com.qf.java2105.lzj.constant.MessageConstant;
import com.qf.java2105.lzj.dao.IUser;
import com.qf.java2105.lzj.entity.ResultVO;
import com.qf.java2105.lzj.factory.BeanFactory;
import com.qf.java2105.lzj.pojo.User;
import com.qf.java2105.lzj.service.IUserService;

import java.sql.SQLException;

/**
 * @Author lzj
 * @Date 2021/9/14
 */
public class UserServiceImpl implements IUserService {
    private IUser userDao = (IUser) BeanFactory.getBean("userDao");
    @Override
    public ResultVO<User> login(String userName,String password) {
        try {
            //调方法
            User user = userDao.findByName(userName,password);
            if (null == user) {
               return ResultVO.error(MessageConstant.USER_NOT_FOUND_NO_REGISTER);
            }
            return ResultVO.ok(MessageConstant.LOGIN_SUCCESSFULLY,user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ResultVO.error(MessageConstant.THE_SERVER_IS_BUSY_TRY_AGAIN_LATER);
    }

    @Override
    public ResultVO register(User user) {
        try {
            //调方法
            Integer integer = userDao.addUser(user);
            if (integer > 0) {
                return ResultVO.ok(MessageConstant.USER_REGISTRATION_SUCCEEDED);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ResultVO.error(MessageConstant.USER_REGISTRATION_FAIL);
    }

    @Override
    public ResultVO existsUserName(String userName) {
        try {
            //调方法
            Integer integer = userDao.existsUserName(userName);
            if (integer == null) {
                return ResultVO.ok(MessageConstant.THE_USER_NAME_DOES_NOT_EXIST);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ResultVO.error(MessageConstant.THE_USERNAME_ALREADY_EXISTS_AND_IS_NOT_AVAILABLE);
    }
}
