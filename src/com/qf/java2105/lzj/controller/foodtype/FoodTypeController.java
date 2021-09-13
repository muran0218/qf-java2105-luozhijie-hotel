package com.qf.java2105.lzj.controller.foodtype;

import com.qf.java2105.lzj.entity.ResultVO;
import com.qf.java2105.lzj.pojo.FoodType;
import com.qf.java2105.lzj.service.IFoodTypeService;
import com.qf.java2105.lzj.service.impl.FoodTypeServiceImpl;
import com.sun.org.apache.bcel.internal.generic.NEW;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 菜品类控制层
 * @Author lzj
 * @Date 2021/9/12
 */
@WebServlet("/foodType/search")
public class FoodTypeController extends HttpServlet {
    private IFoodTypeService foodTypeService = new FoodTypeServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //取值
        String keyword = request.getParameter("keyword");
        //调用方法
        ResultVO<List<FoodType>> listResultVO = foodTypeService.findByName(keyword);
        //回显
        request.setAttribute("keyword",keyword == null ? "" : keyword );
        request.setAttribute("foodTypes",listResultVO.getData());
        request.getRequestDispatcher(request.getContextPath()+"/backend/detail/foodtype/foodtype-list.jsp").forward(request,response);
        System.out.println(request.getContextPath());
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
