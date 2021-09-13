package com.qf.java2105.lzj.constant;

/**
 * 消息常量接口
 * @Author lzj
 * @Date 2021/9/12
 */
public interface MessageConstant {

    String QUERY_FOODTYPE_LIST_SUCCESS = "查询菜系列表成功";
    String QUERY_FOODTYPE_LIST_FAIL = "查询菜系列表失败";
    String QUERY_FOODTYPE_SUCCESS = "查询菜系表成功";
    String QUERY_FOODTYPE_FAIL = "查询菜系失败";
    String FOODTYPE_ID_CANNOT_BE_EMPTY = "菜系id不能为空";
    String UPDATE_FOODTYPE_SUCCESS = "修改菜系表成功";
    String UPDATE_FOODTYPE_FAIL = "修改菜系失败";
    String DELETE_FOODTYPE_SUCCESS = "删除菜系表成功";
    String DELETE_FOODTYPE_FAIL = "删除菜系失败";
    String SAVE_FOODTYPE_SUCCESS = "新增菜系表成功";
    String SAVE_FOODTYPE_FAIL = "新增菜系失败";

    String QUERY_FOOD_LIST_SUCCESS = "查询菜品列表成功";
    String QUERY_FOOD_LIST_FAIL = "查询菜品列表失败";
    String FOOD_ID_CANNOT_BE_EMPTY = "菜品id不能为空";
    String SAVE_FOOD_SUCCESS = "新增菜品表成功";
    String SAVE_FOOD_FAIL = "新增菜品失败";
    String UPDATE_FOOD_SUCCESS = "修改菜品表成功";
    String UPDATE_FOOD_FAIL = "修改菜品失败";
    String DELETE_FOOD_SUCCESS = "删除菜品表成功";
    String DELETE_FOOD_FAIL = "删除菜品失败";
}
