package com.qf.java2105.lzj.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 字符过滤器
 * @Author lzj
 * @Date 2021/9/12
 */
@WebFilter("/*")
public class CharserFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //只需要对动态资源进行乱码设置就好了
        String uri = request.getRequestURI();
        if(uri.endsWith(".html") || uri.endsWith(".js") || uri.endsWith(".css") ) {
            chain.doFilter(request, response);
            return;
        }

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
