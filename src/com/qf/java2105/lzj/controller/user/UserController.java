package com.qf.java2105.lzj.controller.user;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.qf.java2105.lzj.constant.MessageConstant;
import com.qf.java2105.lzj.constant.ResponseMessageConstant;
import com.qf.java2105.lzj.controller.BaseServlet;
import com.qf.java2105.lzj.entity.ResultVO;
import com.qf.java2105.lzj.factory.BeanFactory;
import com.qf.java2105.lzj.pojo.User;
import com.qf.java2105.lzj.service.IUserService;
import com.qf.java2105.lzj.utils.MD5Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author lzj
 * @Date 2021/9/14
 */
@WebServlet("/user")
public class UserController extends BaseServlet {
    private IUserService userService = (IUserService) BeanFactory.getBean("userService");

    public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //判断验证码
        String valCode = request.getParameter("valCode");
        //获取生成的验证码
        String code = (String) request.getSession().getAttribute("code");

        //先判断验证码
        if(null == valCode || valCode.trim().length() == 0){
            System.out.println("验证码不能为空");
            return ResponseMessageConstant.PREFIX_REDIRECT + request.getContextPath() + "/front/detail/user/login.jsp";
        }
        //不相等
        if (!valCode.equalsIgnoreCase(code)) {
            System.out.println("验证码错误！");
            return ResponseMessageConstant.PREFIX_REDIRECT + request.getContextPath() + "/front/detail/user/login.jsp";
        }

        //获取页面参数
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        if (StringUtils.isEmpty(userName.trim())) {
            return "<script>alert('" + MessageConstant.THE_USER_NAME_CANNOT_BE_EMPTY + "');" +
                    "window.location.href=\"/front/detail/user/login.jsp\"</script>";
        }
        if (StringUtils.isEmpty(password.trim())) {
            return "<script>alert('" + MessageConstant.THE_PASSWORD_CANNOT_BE_EMPTY + "');" +
                    "window.location.href=\"/front/detail/user/login.jsp\"</script>";
        }
        String pwd = MD5Utils.md5(password);
        //调登录方法
        ResultVO<User> userResultVO = userService.login(userName,pwd);
        request.getSession().setAttribute("user",userResultVO.getData());
        //判断是否是管理员
        if (userResultVO.getData().getIsAdmin() == 1) {
            //是管理跳后台
            return ResponseMessageConstant.PREFIX_FORWARD + request.getContextPath() + "/backend/index.jsp";
        }else {
            //不是管理员 取前台
            return ResponseMessageConstant.PREFIX_FORWARD + request.getContextPath() + "/front/index.jsp";
        }
    }

    public String reg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取页面的值
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String rwd = request.getParameter("rwd");
        String isMember = request.getParameter("isMember");
        String gender = request.getParameter("inlineRadioOptions");

        //判断
        if (StringUtils.isEmpty(userName.trim())) {
            return "<script>alert('" + MessageConstant.THE_USER_NAME_CANNOT_BE_EMPTY + "');" +
                    "window.location.href=\"/front/detail/user/register.jsp\"</script>";
        }
        if (StringUtils.isEmpty(password.trim())) {
            return "<script>alert('" + MessageConstant.THE_PASSWORD_CANNOT_BE_EMPTY + "');" +
                    "window.location.href=\"/front/detail/user/register.jsp\"</script>";
        }
        //判断密码是否相等
        if (!password.equals(rwd.trim())) {
            return "<script>alert('" + MessageConstant.PASSWORD_MISMATCH + "');" +
                    "window.location.href=\"/front/detail/user/register.jsp\"</script>";
        }
        String pwd = MD5Utils.md5(password);
        //创建用户实体
        User user = new User(userName,pwd, Integer.valueOf(gender), Integer.valueOf(isMember));
        //调用方法
        ResultVO resultVO = userService.register(user);
        return ResponseMessageConstant.PREFIX_FORWARD + request.getContextPath() + "/front/detail/user/login.jsp";
    }

    public String existsUserName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        //判断
        if (StringUtils.isEmpty(userName.trim())) {
            return "<script>alert('" + MessageConstant.THE_USER_NAME_CANNOT_BE_EMPTY + "');" +
                    "window.location.href=\"/front/detail/user/register.jsp\"</script>";
        }
        //调方法
        ResultVO resultVO = userService.existsUserName(userName);
        return JSON.toJSONString(resultVO);
    }
}