package com.qf.java2105.lzj.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.qf.java2105.lzj.constant.MessageConstant;
import com.qf.java2105.lzj.dao.IFoodDao;
import com.qf.java2105.lzj.dao.impl.FoodDaoImpl;
import com.qf.java2105.lzj.entity.ResultVO;
import com.qf.java2105.lzj.factory.BeanFactory;
import com.qf.java2105.lzj.pojo.Food;
import com.qf.java2105.lzj.pojo.FoodType;
import com.qf.java2105.lzj.service.IFoodService;
import com.qf.java2105.lzj.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 食品逻辑层实现
 * @Author lzj
 * @Date 2021/9/12
 */
public class FoodServiceImpl implements IFoodService {
    private IFoodDao foodDao = (IFoodDao) BeanFactory.getBean("foodDao");
    @Override
    public ResultVO<List<Food>> findByName(String foodName) {
        try {
            //判断食品名称是否为空
            if (StringUtils.isEmpty(foodName)) {
                foodName = "%%";
            }else{
                foodName = "%" + foodName + "%";
            }
            //调方法
            List<Map<String, Object>> foodMap = foodDao.findByName(foodName);
            //创建list集合
            List<Food> foodList = new ArrayList<>();
            //遍历map集合
            for (Map<String, Object> map : foodMap) {
                //获取数据
                Integer foodId = (Integer) map.get("foodId");
                Integer typeId = (Integer) map.get("typeId");
                String foodNames = (String) map.get("foodName");
                BigDecimal foodPrice = (BigDecimal) map.get("foodPrice");
                BigDecimal foodMprice = (BigDecimal) map.get("foodMprice");
                String foodImage = (String) map.get("foodImage");
                String foodDesc = (String) map.get("foodDesc");
                String typeName = (String) map.get("typeName");

                FoodType foodType = new FoodType(typeId, typeName);

                Food food = new Food(foodId, typeId, foodNames, foodPrice, foodMprice, foodImage, foodDesc);
                food.setFoodType(foodType);

                foodList.add(food);
            }
            return ResultVO.ok(MessageConstant.QUERY_FOOD_LIST_SUCCESS,foodList);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResultVO.error(MessageConstant.QUERY_FOOD_LIST_FAIL);
        }
    }

    @Override
    public ResultVO<Food> findById(Integer foodId) {
        try {
            //调方法
            Food food = foodDao.findById(foodId);
            return ResultVO.ok(MessageConstant.QUERY_FOOD_LIST_SUCCESS,food);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResultVO.error(MessageConstant.QUERY_FOOD_LIST_FAIL);
        }
    }

    @Override
    public ResultVO<Food> save(Food food) {
        try {
            JdbcUtil.begin();
            //调方法
            Integer integer = foodDao.save(food);
            if (integer > 0) {
                JdbcUtil.commit();
               return ResultVO.ok(MessageConstant.SAVE_FOOD_SUCCESS);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JdbcUtil.rollback();
            return ResultVO.error(MessageConstant.SAVE_FOOD_FAIL);
        }
        return null;
    }

    @Override
    public ResultVO<Food> update(Food food) {
        try {
            JdbcUtil.begin();
            //调方法
            Integer integer = foodDao.update(food);
            if (integer > 0 ) {
                return  ResultVO.ok(MessageConstant.UPDATE_FOOD_SUCCESS);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return ResultVO.error(MessageConstant.UPDATE_FOOD_FAIL);
        }
        return null;
    }

    @Override
    public ResultVO<Integer> deleteById(Integer foodId) {
        try {
            JdbcUtil.begin();
            Integer integer = foodDao.deleteById(foodId);
            if (integer > 0) {
                return  ResultVO.ok(MessageConstant.DELETE_FOOD_SUCCESS);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return  ResultVO.error(MessageConstant.DELETE_FOOD_FAIL);
        }
        return null;
    }

    @Override
    public ResultVO existsFoodName(String foodName) {
        Integer integer = null;
        try {
            integer = foodDao.existsFoodName(foodName);
            if (integer == null) {
                ResultVO.ok(MessageConstant.FOOD_NAME_NOT_FOUND_AVAILABLE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ResultVO.error(MessageConstant.THE_NAME_OF_THE_FOOD_EXISTS_AND_IS_NOT_AVAILABLE);
    }
}
