package com.qf.java2105.lzj.controller.food;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.qf.java2105.lzj.constant.MessageConstant;
import com.qf.java2105.lzj.constant.ResponseMessageConstant;
import com.qf.java2105.lzj.controller.BaseServlet;
import com.qf.java2105.lzj.entity.ResultVO;
import com.qf.java2105.lzj.factory.BeanFactory;
import com.qf.java2105.lzj.pojo.Food;
import com.qf.java2105.lzj.pojo.FoodType;
import com.qf.java2105.lzj.service.IFoodService;
import com.qf.java2105.lzj.service.IFoodTypeService;
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
import java.util.List;
import java.util.Map;

/**
 * 食品控制层
 * @Author lzj
 * @Date 2021/9/12
 */
@WebServlet("/food")
@MultipartConfig
public class FoodController extends BaseServlet {
    private IFoodService foodService = (IFoodService) BeanFactory.getBean("foodService");
    private IFoodTypeService foodTypeService = (IFoodTypeService) BeanFactory.getBean("foodTypeService");

    /**
     * 模糊查询
     */
    public String search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //去值
        String keyword = request.getParameter("keyword");
        //调方法
        ResultVO<List<Food>> foodResultVO = foodService.findByName(keyword);

        //判断执行结果
        if (foodResultVO.getSuccess()) {
            //菜品名字回调
            request.setAttribute("keyword",keyword);
            request.setAttribute("foods",foodResultVO.getData());
            return ResponseMessageConstant.PREFIX_FORWARD+request.getContextPath() + "/backend/detail/food/food-list.jsp";
        }
        //失败
        return "<script>alert('" + foodResultVO.getMessage() + "');" +
                "window.location.href=\"/food?method=search\";</script>";
    }
    /**
     * 修改ui
     */
    public String updateUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            return ResponseMessageConstant.PREFIX_FORWARD+request.getContextPath() + "/backend/detail/food/food-update.jsp";
        }
        return "<script>alert('" + MessageConstant.FOOD_ID_CANNOT_BE_EMPTY + "');" +
                "window.location.href=\"/food?method=search\"</script>";

    }
    /**
     * 修改
     */
    public String update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ResultVO<Food> foodResultVO = null;
        try {
            //调用文件上传工具类
            String imageUrl = UploadUtils.upload(request, "imageUrl", "/images/food/");
            //取值
            Map<String, String[]> parameterMap = request.getParameterMap();
            //创建实体
            Food food = new Food();
            BeanUtils.populate(food,parameterMap);
            if (null != imageUrl && !"".equals(imageUrl)) {
                food.setFoodImage(imageUrl);
            }
            foodResultVO = foodService.update(food);
            if (foodResultVO.getSuccess()) {
                //去菜品列表页面
                return ResponseMessageConstant.PREFIX_REDIRECT+request.getContextPath() + "/food?method=search";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //失败
       return "<script>alert('" + foodResultVO.getMessage() + "');" +
               "window.location.href=\"/food?method=search\"</script>";
    }
    /**
     * 删除
     */
    public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultVO<Integer> foodResultVO = null;
        try {
            //取值
            String foodId = request.getParameter("foodId");
            if (!StringUtils.isEmpty(foodId)) {
                foodResultVO = foodService.deleteById(Integer.valueOf(foodId));
                //去菜品列表页面
                return ResponseMessageConstant.PREFIX_REDIRECT+request.getContextPath() + "/food?method=search";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //失败
       return "<script>alert('" + foodResultVO.getMessage() + "');" +
               "window.location.href=\"/food?method=search\"</script>";
    }
    /**
     * 新增
     */
    public String saveUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调方法
        //获取菜系数据
        ResultVO<List<FoodType>> foodTypeResultVO = foodTypeService.findByName("");
        request.setAttribute("types",foodTypeResultVO.getData());
        //去新增页面
        return ResponseMessageConstant.PREFIX_FORWARD + request.getContextPath() + "/backend/detail/food/food-save.jsp";
    }
    /**
     * 新增
     */
    public String save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
                return ResponseMessageConstant.PREFIX_REDIRECT+request.getContextPath() + "/food?method=search";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //失败
        return "<script>alert('" + foodResultVO.getMessage() + "');" +
                "window.location.href=\"/food?method=search\"</script>";
    }
    /**
     * 校验菜系名称
     */
    public String existsFoodName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String foodName = request.getParameter("foodName");
        if (!StringUtils.isEmpty(foodName)) {
            ResultVO resultVO = foodService.existsFoodName(foodName);
            return JSON.toJSONString(resultVO);
        }
        //菜系名为空
        return"<script>alert('" + MessageConstant.FOODTYPE_NAME_CANNOT_BE_EMPTY + "');" +
                "window.location.href=\"/food?method=search\"</script>";
    }

    /**
     * 根据id查询
     */
    public String findById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String foodId = request.getParameter("foodId");
        if (!StringUtils.isEmpty(foodId)) {
            ResultVO<Food> foodResultVO = foodService.findById(Integer.valueOf(foodId));
            request.setAttribute("foods",foodResultVO.getData());
            return ResponseMessageConstant.PREFIX_FORWARD + request.getContextPath() + "/front/detail/caixiangxi.jsp";
        }
        return "<script>alert('" + MessageConstant.FOOD_ID_CANNOT_BE_EMPTY + "');" +
                "window.location.href=\"/front/detail/caidan.jsp\"</script>";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
