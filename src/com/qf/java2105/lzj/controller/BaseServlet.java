package com.qf.java2105.lzj.controller;

import com.qf.java2105.lzj.constant.MessageConstant;
import com.qf.java2105.lzj.constant.RequestMethodConstant;
import com.qf.java2105.lzj.constant.ResponseMessageConstant;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 处理请求方法的控制器
 * @Author lzj
 * @Date 2021/9/13
 */
@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {

    /**
     * 处理请求的方法
     * @param req 网页请求
     * @param res 服务器响应
     * @throws ServletException 异常
     * @throws IOException 异常
     */
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        try {
            //向下转型
            HttpServletRequest request = (HttpServletRequest) req;
            HttpServletResponse response = (HttpServletResponse) res;

            //获取页面传国来的方法
            String methodName = request.getParameter(RequestMethodConstant.METHOD);
            //通过反射获取方法
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //反射调用目标方法
            Object result = method.invoke(this, request, response);
            //判断result类型 并且执行相应的方法
            if (result instanceof String) {
                //   forward:/food/food-list.jsp
                //   redirect:/food?method=search
                String info = (String) result;
                //获取url
                //从 ：号 +1 的位置开始截取 得到  /food/food-list.jsp
                String url = info.substring(info.indexOf(ResponseMessageConstant.TAG)+1);
                //判断是否是转发
                if (info.startsWith(ResponseMessageConstant.PREFIX_FORWARD)) {
                    request.getRequestDispatcher(url).forward(request, response);
                } else if (info.startsWith(ResponseMessageConstant.PREFIX_REDIRECT)) {
                    //重定向
                    response.sendRedirect(url);
                }else {
                    response.getWriter().write(info);
                }
            }else {
                response.getWriter().write(MessageConstant.THE_SERVER_IS_BUSY_TRY_AGAIN_LATER);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
