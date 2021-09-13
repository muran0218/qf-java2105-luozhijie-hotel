package com.qf.java2105.lzj.controller.food;

import com.qf.java2105.lzj.entity.ResultVO;
import com.qf.java2105.lzj.pojo.Food;
import com.qf.java2105.lzj.service.IFoodService;
import com.qf.java2105.lzj.service.impl.FoodServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 食品控制层
 * @Author lzj
 * @Date 2021/9/12
 */
@WebServlet("/food/search")
public class FoodController extends HttpServlet {
    private IFoodService foodService = new  FoodServiceImpl();
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //去值
        String keyword = request.getParameter("keyword");
        //调方法
        ResultVO<List<Food>> foodResultVO = foodService.findByName(keyword);

        //判断执行结果
        if (foodResultVO.getSuccess()) {
            //菜品名字回调
            request.setAttribute("keyword",keyword);
            request.setAttribute("foods",foodResultVO.getData());
            request.getRequestDispatcher(request.getContextPath() + "/backend/detail/food/food-list.jsp").forward(request, response);
        }
        //失败
        response.getWriter().write("<script>alert(" + foodResultVO.getMessage() + ");</script>");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
