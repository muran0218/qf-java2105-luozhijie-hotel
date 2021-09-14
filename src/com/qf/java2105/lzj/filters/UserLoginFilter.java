package com.qf.java2105.lzj.filters;

import com.qf.java2105.lzj.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**backend
 * @Author lzj
 * @Date 2021/9/14
 */
@WebFilter("/*")
public class UserLoginFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //向下转型
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //获取uri
        String uri = request.getRequestURI();
        //静态资源放行
        if (uri.endsWith(".html") || uri.contains("/user") || uri.contains("/createCode") || uri.contains("/login.jsp") || uri.contains("/register.jsp")) {
            chain.doFilter(request,response);
            return;
        }
        //获取user
        User user = (User) request.getSession().getAttribute("user");
        if (null != user) {
            chain.doFilter(request,response);
        }else{
            response.sendRedirect(request.getContextPath() + "/front/detail/user/login.jsp");
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
