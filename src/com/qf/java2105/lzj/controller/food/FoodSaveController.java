package com.qf.java2105.lzj.controller.food;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.qf.java2105.lzj.entity.ResultVO;
import com.qf.java2105.lzj.pojo.Food;
import com.qf.java2105.lzj.pojo.FoodType;
import com.qf.java2105.lzj.service.IFoodService;
import com.qf.java2105.lzj.service.IFoodTypeService;
import com.qf.java2105.lzj.service.impl.FoodServiceImpl;
import com.qf.java2105.lzj.service.impl.FoodTypeServiceImpl;
import com.qf.java2105.lzj.utils.UploadUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * 食品修改ui控制层
 * @Author lzj
 * @Date 2021/9/12
 */
@WebServlet("/food/save")
@MultipartConfig
public class FoodSaveController extends HttpServlet {
    private IFoodService foodService = new FoodServiceImpl();
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultVO<Food> foodResultVO = null;
        try {
            //调用文件上传工具类
            String imageUrl = UploadUtils.upload(request, "imageUrl", "/images/food/");
            //获取页面参数
            Map<String, String[]> parameterMap = request.getParameterMap();
            //创建实体
            Food food = new Food();
            //给图片地址参数赋值
            food.setFoodImage(imageUrl);
            //调用工具类
            BeanUtils.populate(food,parameterMap);
            //调用新增方法
            foodResultVO = foodService.save(food);
            if (foodResultVO.getSuccess()) {
                //去菜品列表页面
                response.sendRedirect(request.getContextPath() + "/food/search");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //失败
        response.getWriter().write("<script>alert(" + foodResultVO.getMessage() + ");</script>");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
