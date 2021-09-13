package com.qf.java2105.lzj.controller.foodtype;


import com.alibaba.druid.util.StringUtils;
import com.qf.java2105.lzj.constant.MessageConstant;
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
 * 修改菜系ui控制层
 * @Author lzj
 * @Date 2021/9/12
 */
@WebServlet("/foodType/updateUI")
public class FoodTypeUpdateUI extends HttpServlet {
    private IFoodTypeService foodTypeService = new FoodTypeServiceImpl();
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        //判断是否为空
        if (!StringUtils.isEmpty(id)) {
            //不为空
            ResultVO<FoodType> foodTypeResultVO = foodTypeService.findById(Integer.valueOf(id));
            request.setAttribute("foodTypeById",foodTypeResultVO.getData());
            request.getRequestDispatcher(request.getContextPath()+"/backend/detail/foodtype/foodtype-update.jsp").forward(request,response);
        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
