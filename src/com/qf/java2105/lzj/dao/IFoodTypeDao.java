package com.qf.java2105.lzj.dao;

import com.qf.java2105.lzj.pojo.FoodType;

import java.sql.SQLException;
import java.util.List;

/**
 * 菜系持久层
 * @Author lzj
 * @Date 2021/9/12
 */
public interface IFoodTypeDao {
    /**
     * 根据菜系名称查询
     * @param keyword 菜系名称
     * @return list
     */
    List<FoodType> findByName(String keyword) throws SQLException;

    /**
     * 根据id查询
     * @param id id
     * @return 实体
     */
    FoodType findById(Integer id) throws SQLException;

    /**
     * 根据id修改菜系名称
     * @param foodType 菜系实体
     * @return 结果
     */
    Integer updateById(FoodType foodType) throws SQLException;

    /**
     * 根据id删除
     * @param typeId id
     * @return 结果
     */
    Integer deleteById(Integer typeId) throws SQLException;

    /**
     * 新增数据
     * @param foodType 菜系实体
     * @return 结果
     */
    Integer save(FoodType foodType) throws SQLException;

    /**
     * 验证菜系名称是否存在
     * @param typeName 菜系名
     * @return 结果
     */
    Integer existsFoodName(String typeName) throws SQLException;

}
