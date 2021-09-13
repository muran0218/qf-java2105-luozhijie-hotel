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
@WebServlet("/food/updateUI")
public class FoodUpdateUIController extends HttpServlet {
    private IFoodService foodService = new  FoodServiceImpl();
    private IFoodTypeService foodTypeService = new FoodTypeServiceImpl();
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //取值
        String foodId = request.getParameter("foodId");
        //调方法
        //获取菜系数据
        ResultVO<List<FoodType>> foodTypeResultVO = foodTypeService.findByName("");
        request.setAttribute("types",foodTypeResultVO.getData());

        //判断id是否为空
        if (!StringUtils.isEmpty(foodId)) {
            //获取菜品数据
            ResultVO<Food> foodResultVO = foodService.findById(Integer.valueOf(foodId));
            request.setAttribute("food",foodResultVO.getData());
            //转发到修改页面
            request.getRequestDispatcher(request.getContextPath() + "/backend/detail/food/food-update.jsp").forward(request, response);
        }else {
            response.getWriter().write("<script>alert(" + MessageConstant.FOOD_ID_CANNOT_BE_EMPTY + ");</script>");
        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
