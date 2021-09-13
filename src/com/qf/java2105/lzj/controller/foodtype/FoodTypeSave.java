package com.qf.java2105.lzj.controller.foodtype;


import com.alibaba.druid.util.StringUtils;
import com.qf.java2105.lzj.entity.ResultVO;
import com.qf.java2105.lzj.pojo.FoodType;
import com.qf.java2105.lzj.service.IFoodTypeService;
import com.qf.java2105.lzj.service.impl.FoodTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 修改菜系控制层
 * @Author lzj
 * @Date 2021/9/12
 */
@WebServlet("/foodType/save")
public class FoodTypeSave extends HttpServlet {
    private IFoodTypeService foodTypeService = new FoodTypeServiceImpl();
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String typeName = request.getParameter("typeName");
        //判断id是否为空
        if (!StringUtils.isEmpty(typeName)) {
            FoodType foodType = new FoodType();
            foodType.setTypeName(typeName);
            foodType.setIsDelete(0);
            //调方法
            ResultVO<FoodType> foodTypeResultVO = foodTypeService.save(foodType);
            //判断dao层方法是否成功
            if (foodTypeResultVO.getSuccess()) {
                //成功去查询列表控制层
                request.getRequestDispatcher(request.getContextPath()+"/foodType/search").forward(request,response);
                return;
            }
            //失败
            response.getWriter().write("<script>alert(" + foodTypeResultVO.getMessage() + ");</script>");
        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
