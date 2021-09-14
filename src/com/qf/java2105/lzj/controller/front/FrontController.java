package com.qf.java2105.lzj.controller.front;

import com.alibaba.druid.util.StringUtils;
import com.qf.java2105.lzj.constant.MessageConstant;
import com.qf.java2105.lzj.constant.ResponseMessageConstant;
import com.qf.java2105.lzj.controller.BaseServlet;
import com.qf.java2105.lzj.entity.PageBean;
import com.qf.java2105.lzj.entity.ResultVO;
import com.qf.java2105.lzj.factory.BeanFactory;
import com.qf.java2105.lzj.pojo.Food;
import com.qf.java2105.lzj.service.IFrontService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author lzj
 * @Date 2021/9/14
 */
@WebServlet("/front")
public class FrontController extends BaseServlet {
    private IFrontService frontService = (IFrontService) BeanFactory.getBean("frontService");

    public String findByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取当前页数
        String currentPage = request.getParameter("currentPage");
        //判断当前页数
        if ( null == currentPage || "".equals(currentPage.trim())) {
            currentPage = "1";
        }

        //菜系id
        String typeIdStr = request.getParameter("typeId");
        Integer typeId = 0 ;
        if (!StringUtils.isEmpty(typeIdStr)) {
            typeId = Integer.valueOf(typeIdStr);
        }

        //获取菜品名称
        String foodName = request.getParameter("foodName");
        if (!StringUtils.isEmpty(foodName)) {
            foodName = "%"+ foodName +"%";
        }else {
            foodName = "%%";
        }

        //执行方法
        ResultVO<PageBean<Food>> FrontResultVO = frontService.findByPageAndCondition(Integer.valueOf(currentPage), 6, typeId, foodName);
        //回显参数
        request.setAttribute("PageBean",FrontResultVO.getData());
        //回显菜系id
        request.setAttribute("typeId",typeId);
        //回显食物名称
        request.setAttribute("foodName",foodName.replaceAll("%",""));

        return ResponseMessageConstant.PREFIX_FORWARD + request.getContextPath() + "front/detail/caidan.jsp";
    }


}