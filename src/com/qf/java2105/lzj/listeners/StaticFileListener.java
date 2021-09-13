package com.qf.java2105.lzj.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 静态文件监听器
 * @Author lzj
 * @Date 2021/9/12
 */
@WebListener
public class StaticFileListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("backend_detail_path",servletContext.getContextPath() + "/backend/detail");
        servletContext.setAttribute("front_detail_path", servletContext.getContextPath() + "/front/detail");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
