package com.qf.java2105.lzj.service;

import com.qf.java2105.lzj.entity.ResultVO;
import com.qf.java2105.lzj.pojo.FoodType;

import java.util.List;

/**
 * 菜系逻辑层
 * @Author lzj
 * @Date 2021/9/12
 */
public interface IFoodTypeService {
    /**
     * 根据菜系名称查询所有或者模糊查询
     * @param keyword 菜系名称
     * @return 结果
     */
    ResultVO<List<FoodType>> findByName(String keyword);

    /**
     * 根据id查询
     * @param id 菜系id
     * @return 结果
     */
    ResultVO<FoodType> findById(Integer id);

    /**
     * 根据id修改菜系名称
     * @param foodType 菜系实体
     * @return 结果
     */
    ResultVO<FoodType> updateById(FoodType foodType);

    /**
     * 根据id删除
     * @param typeId 菜系id
     * @return 结果
     */
    ResultVO<Integer> deleteById(Integer typeId);

    /**
     * 新增
     * @param foodType 菜系实体
     * @return 结果
     */
    ResultVO<FoodType> save(FoodType foodType);

    /**
     * 验证菜系名是否存在
     * @param typeName 菜系名
     * @return 结果
     */
    ResultVO existsFoodName(String typeName);
}
