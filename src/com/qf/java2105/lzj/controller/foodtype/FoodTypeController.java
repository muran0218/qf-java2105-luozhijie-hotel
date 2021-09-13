package com.qf.java2105.lzj.controller.foodtype;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.qf.java2105.lzj.constant.MessageConstant;
import com.qf.java2105.lzj.constant.ResponseMessageConstant;
import com.qf.java2105.lzj.controller.BaseServlet;
import com.qf.java2105.lzj.entity.ResultVO;
import com.qf.java2105.lzj.factory.BeanFactory;
import com.qf.java2105.lzj.pojo.FoodType;
import com.qf.java2105.lzj.service.IFoodTypeService;
import com.qf.java2105.lzj.service.impl.FoodTypeServiceImpl;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 菜品类控制层
 * @Author lzj
 * @Date 2021/9/12
 */
@WebServlet("/foodType")
public class FoodTypeController extends BaseServlet {
    private IFoodTypeService foodTypeService = (IFoodTypeService) BeanFactory.getBean("foodTypeService");

    /**
     * 模糊查询
     */
    public String search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //取值
        String keyword = request.getParameter("keyword");
        //调用方法
        ResultVO<List<FoodType>> listResultVO = foodTypeService.findByName(keyword);
        //回显
        request.setAttribute("keyword",keyword == null ? "" : keyword );
        request.setAttribute("foodTypes",listResultVO.getData());
        return ResponseMessageConstant.PREFIX_FORWARD+ request.getContextPath()+"/backend/detail/foodtype/foodtype-list.jsp";
    }
    /**
     * 修改ui
     */
    public String updateUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ResultVO<FoodType> foodTypeResultVO = null;
        //判断是否为空
        if (!StringUtils.isEmpty(id)) {
            //不为空
            foodTypeResultVO = foodTypeService.findById(Integer.valueOf(id));
            request.setAttribute("foodTypeById",foodTypeResultVO.getData());
            return ResponseMessageConstant.PREFIX_FORWARD+ request.getContextPath()+"/backend/detail/foodtype/foodtype-update.jsp";
        }
        return "<script>alert(" + MessageConstant.FOODTYPE_ID_CANNOT_BE_EMPTY + ");</script>";

    }

    /**
     * 修改
     */
    public String update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
                return ResponseMessageConstant.PREFIX_REDIRECT+ request.getContextPath()+"/foodType?method=search";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //修改失败
        return"<script>alert(" + foodTypeResultVO.getMessage() + ");</script>";
    }

    /**
     * 删除
     */
    public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String typeId = request.getParameter("typeId");
        //判断id是否为空
        if (!StringUtils.isEmpty(typeId)) {
            //调方法
            ResultVO<Integer> foodTypeResultVO = foodTypeService.deleteById(Integer.valueOf(typeId));
            //判断dao层方法是否成功
            if (foodTypeResultVO.getSuccess()) {
                //成功去查询列表控制层
                return ResponseMessageConstant.PREFIX_REDIRECT+request.getContextPath()+"/foodType?method=search";
            }
            //失败
            return"<script>alert(" + foodTypeResultVO.getMessage() + ");</script>";
        }
        //id为空
        return"<script>alert(" + MessageConstant.FOODTYPE_ID_CANNOT_BE_EMPTY + ");</script>";
    }
    /**
     * 新增
     */
    public String save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String typeName = request.getParameter("typeName");
        //判断菜系名是否为空
        if (!StringUtils.isEmpty(typeName)) {
            FoodType foodType = new FoodType();
            foodType.setTypeName(typeName);
            foodType.setIsDelete(0);
            //调方法
            ResultVO<FoodType> foodTypeResultVO = foodTypeService.save(foodType);
            //判断dao层方法是否成功
            if (foodTypeResultVO.getSuccess()) {
                //成功去查询列表控制层
                return ResponseMessageConstant.PREFIX_FORWARD+request.getContextPath()+"/foodType?method=search";
            }
            //失败
            return"<script>alert(" + foodTypeResultVO.getMessage() + ");</script>";
        }
        //菜系名为空
        return"<script>alert(" + MessageConstant.FOODTYPE_NAME_CANNOT_BE_EMPTY + ");</script>";
    }
    /**
     * 校验菜系名称
     */
    public String existsTypeName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String typeName = request.getParameter("typeName");
        if (!StringUtils.isEmpty(typeName)) {
            ResultVO resultVO = foodTypeService.existsFoodName(typeName);
            return JSON.toJSONString(resultVO);
        }
        //菜系名为空
        return"<script>alert(" + MessageConstant.FOODTYPE_NAME_CANNOT_BE_EMPTY + ");</script>";
    }
}
