package com.qf.java2105.lzj.dao;

import com.qf.java2105.lzj.pojo.Food;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 食品持久层
 * @Author lzj
 * @Date 2021/9/12
 */
public interface IFoodDao {
    /**
     * 根据名字查询
     * @param foodName 食品名
     * @return list
     */
    List<Map<String,Object>> findByName(String foodName) throws SQLException;

    /**
     * 根据菜系id查询
     * @param typeId 菜系id
     * @return 结果
     */
    List<Food> findByTypeId(Integer typeId) throws SQLException;
    /**
     * 根据id查询
     * @param foodId 食品id
     * @return food实体
     */
    Food findById(Integer foodId) throws SQLException;

    /**
     * 新增
     * @param food 食品实体
     * @return 结果
     */
    Integer save(Food food) throws SQLException;

    /**
     * 修改
     * @param food 实体
     * @return 结果
     */
    Integer update(Food food) throws SQLException;

    /**
     * 删除
     * @param foodId id
     * @return 结果
     */
    Integer deleteById(Integer foodId) throws SQLException;

    /**
     * 校验食品名称
     * @param foodName 食品名称
     * @return 结果
     */
    Integer existsFoodName(String foodName) throws SQLException;

    /**
     * 分页
     * @param currentPage 当前页数
     * @param pageSize 每页显示多少条
     * @param typeId 查询条件 菜系id
     * @param foodName 查询条件 菜品名称
     * @return 集合
     * @throws SQLException 异常
     */
    List<Food> findByPageAndCondition(Integer currentPage , Integer pageSize ,Integer typeId ,String foodName) throws SQLException;

    /**
     * 统计食品总数
     * @param typeId 查询条件 菜系id
     * @param foodName 查询条件 菜品名称
     * @return 结果
     * @throws SQLException 异常
     */
    Long countByCondition(Integer typeId ,String foodName) throws SQLException;
}
