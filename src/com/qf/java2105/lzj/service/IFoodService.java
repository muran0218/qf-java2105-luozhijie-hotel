package com.qf.java2105.lzj.service;

import com.qf.java2105.lzj.entity.ResultVO;
import com.qf.java2105.lzj.pojo.Food;

import java.util.List;

/**
 * 食品逻辑层
 * @Author lzj
 * @Date 2021/9/12
 */
public interface IFoodService {
    /**
     * 根据食品名查询
     * @param foodName 食品名
     * @return 结果
     */
    ResultVO<List<Food>> findByName(String foodName);

    /**
     * 根据菜系id查询
     * @param typeId 菜系id
     * @return 结果
     */
    ResultVO<List<Food>> findByTypeId(Integer typeId);

    /**
     * 根据ID
     * @param foodId 食品id
     * @return 结果
     */
    ResultVO<Food> findById(Integer foodId);

    /**
     * 新增
     * @param food 食品实体
     * @return 结果
     */
    ResultVO<Food> save(Food food);

    /**
     * 修改
     * @param food 实体
     * @return 结果
     */
    ResultVO<Food> update(Food food);

    /**
     * 删除
     * @param foodId id
     * @return 结果
     */
    ResultVO<Integer> deleteById(Integer foodId);

    /**
     * 校验是食品名称否存在
     * @param foodName 食品名称
     * @return 结果
     */
    ResultVO existsFoodName(String foodName);
}
