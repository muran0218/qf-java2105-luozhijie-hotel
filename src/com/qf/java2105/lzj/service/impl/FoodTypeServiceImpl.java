package com.qf.java2105.lzj.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.qf.java2105.lzj.constant.MessageConstant;
import com.qf.java2105.lzj.dao.IFoodTypeDao;
import com.qf.java2105.lzj.dao.impl.FoodTypeDaoImpl;
import com.qf.java2105.lzj.entity.ResultVO;
import com.qf.java2105.lzj.pojo.FoodType;
import com.qf.java2105.lzj.service.IFoodTypeService;
import com.qf.java2105.lzj.utils.JdbcUtil;
import jdk.nashorn.internal.scripts.JD;

import java.sql.SQLException;
import java.util.List;

/**
 * 菜系逻辑层实现类
 * @Author lzj
 * @Date 2021/9/12
 */
public class FoodTypeServiceImpl implements IFoodTypeService {
    private IFoodTypeDao dao = new FoodTypeDaoImpl();
    @Override
    public ResultVO<List<FoodType>> findByName(String keyword) {
        try {
            //判断菜系名称是否为空
            if (StringUtils.isEmpty(keyword)) {
                keyword ="%%";
            }else {
                keyword = "%"+keyword+"%";
            }
            //调用查询方法
            List<FoodType> foodTypeList = dao.findByName(keyword);
            return ResultVO.ok(MessageConstant.QUERY_FOODTYPE_LIST_SUCCESS,foodTypeList);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResultVO.error(MessageConstant.QUERY_FOODTYPE_LIST_FAIL);
        }
    }

    @Override
    public ResultVO<FoodType> findById(Integer id) {
        try {
            //调方法
            FoodType foodType = dao.findById(id);
            return ResultVO.ok(MessageConstant.QUERY_FOODTYPE_SUCCESS,foodType);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResultVO.error(MessageConstant.QUERY_FOODTYPE_FAIL);
        }
    }

    @Override
    public ResultVO<FoodType> updateById(FoodType foodType) {
        try {
            JdbcUtil.begin();
            //调方法
            Integer integer = dao.updateById(foodType);
            if (integer > 0) {
                JdbcUtil.commit();
                return ResultVO.ok(MessageConstant.UPDATE_FOODTYPE_SUCCESS);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JdbcUtil.rollback();
            return ResultVO.error(MessageConstant.UPDATE_FOODTYPE_FAIL);
        }
        return null;
    }

    @Override
    public ResultVO<Integer> deleteById(Integer typeId) {
        try {
            JdbcUtil.begin();
            //调方法
            Integer integer = dao.deleteById(typeId);
            if (integer > 0) {
                JdbcUtil.commit();
                return ResultVO.ok(MessageConstant.DELETE_FOODTYPE_SUCCESS);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JdbcUtil.rollback();
            return ResultVO.error(MessageConstant.DELETE_FOODTYPE_FAIL);
        }

        return null;
    }

    @Override
    public ResultVO<FoodType> save(FoodType foodType) {
        try {
            JdbcUtil.begin();
            //调方法
            Integer integer = dao.save(foodType);
            if (integer > 0) {
                JdbcUtil.commit();
                return ResultVO.ok(MessageConstant.SAVE_FOODTYPE_SUCCESS);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JdbcUtil.rollback();
            return ResultVO.error(MessageConstant.SAVE_FOODTYPE_FAIL);
        }
        return null;
    }
}
