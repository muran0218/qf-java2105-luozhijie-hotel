package com.qf.java2105.lzj.controller.food;

import com.alibaba.druid.util.StringUtils;
import com.qf.java2105.lzj.constant.MessageConstant;
import com.qf.java2105.lzj.entity.ResultVO;
import com.qf.java2105.lzj.pojo.Food;
import com.qf.java2105.lzj.pojo.FoodType;
import com.qf.java2105.lzj.service.IFoodService;
import com.qf.java2105.lzj.service.IFoodTypeService;
import com.qf.java2105.lzj.service.impl.FoodServiceImpl;
import com.qf.java2105.lzj.service.impl.FoodTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 食品修改ui控制层
 * @Author lzj
 * @Date 2021/9/12
 */
@WebServlet("/food/saveUI")
public class FoodSaveUIController extends HttpServlet {
    private IFoodTypeService foodTypeService = new FoodTypeServiceImpl();
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调方法
        //获取菜系数据
        ResultVO<List<FoodType>> foodTypeResultVO = foodTypeService.findByName("");
        request.setAttribute("types",foodTypeResultVO.getData());
        //去新增页面
        request.getRequestDispatcher(request.getContextPath() + "/backend/detail/food/food-save.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
