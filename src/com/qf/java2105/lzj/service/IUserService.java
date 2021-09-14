package com.qf.java2105.lzj.service;

import com.qf.java2105.lzj.entity.ResultVO;
import com.qf.java2105.lzj.pojo.User;

/**
 * 用户逻辑层
 * @Author lzj
 * @Date 2021/9/14
 */
public interface IUserService {
    /**
     * 登录
     * @param userName 用户名
     * @return 结果
     */
    ResultVO<User> login(String userName,String password);

    /**
     * 注册
     * @param user 用户实体
     * @return 结果
     */
    ResultVO register(User user);

    /**
     * 校验用户名
     * @param userName 用户名
     * @return 结果
     */
    ResultVO existsUserName(String userName);
}
