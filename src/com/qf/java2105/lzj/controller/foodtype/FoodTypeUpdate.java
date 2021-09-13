package com.qf.java2105.lzj.controller.foodtype;


import com.alibaba.druid.util.StringUtils;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.qf.java2105.lzj.entity.ResultVO;
import com.qf.java2105.lzj.pojo.FoodType;
import com.qf.java2105.lzj.service.IFoodTypeService;
import com.qf.java2105.lzj.service.impl.FoodTypeServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 修改菜系控制层
 * @Author lzj
 * @Date 2021/9/12
 */
@WebServlet("/foodType/update")
public class FoodTypeUpdate extends HttpServlet {
    private IFoodTypeService foodTypeService = new FoodTypeServiceImpl();
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ResultVO<FoodType> foodTypeResultVO = null;
        try {
            //获取前台参数
            Map<String, String[]> parameterMap = request.getParameterMap();
            FoodType foodType = new FoodType();
            BeanUtils.populate(foodType,parameterMap);
            //掉方法
            foodTypeResultVO = foodTypeService.updateById(foodType);
            if (foodTypeResultVO.getSuccess()) {
                //修改成功，去查询列表控制层
                request.getRequestDispatcher(request.getContextPath()+"/foodType/search").forward(request,response);
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //修改失败
        response.getWriter().write("<script>alert(" + foodTypeResultVO.getMessage() + ");</script>");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
