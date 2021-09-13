package com.qf.java2105.lzj.controller.food;

import com.alibaba.druid.util.StringUtils;
import com.qf.java2105.lzj.entity.ResultVO;
import com.qf.java2105.lzj.pojo.Food;
import com.qf.java2105.lzj.service.IFoodService;
import com.qf.java2105.lzj.service.impl.FoodServiceImpl;
import com.qf.java2105.lzj.utils.UploadUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 食品修改ui控制层
 * @Author lzj
 * @Date 2021/9/12
 */
@WebServlet("/food/delete")
@MultipartConfig
public class FoodDeleteController extends HttpServlet {
    private IFoodService foodService = new FoodServiceImpl();
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultVO<Integer> foodResultVO = null;
        try {
            //取值
            String foodId = request.getParameter("foodId");
            if (!StringUtils.isEmpty(foodId)) {
                foodResultVO = foodService.deleteById(Integer.valueOf(foodId));
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
