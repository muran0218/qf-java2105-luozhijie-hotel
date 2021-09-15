package com.qf.java2105.lzj.constant;

/**
 * 消息常量接口
 * @Author lzj
 * @Date 2021/9/12
 */
public interface MessageConstant {

    String THE_SERVER_IS_BUSY_TRY_AGAIN_LATER = "服务器正忙，稍后重试！";

    String QUERY_FOODTYPE_LIST_SUCCESS = "查询菜系列表成功";
    String QUERY_FOODTYPE_LIST_FAIL = "查询菜系列表失败";
    String QUERY_FOODTYPE_SUCCESS = "查询菜系表成功";
    String QUERY_FOODTYPE_FAIL = "查询菜系失败";
    String FOODTYPE_ID_CANNOT_BE_EMPTY = "菜系id不能为空";
    String FOODTYPE_NAME_CANNOT_BE_EMPTY = "菜系名称不能为空";
    String CUISINE_NAME_NOT_FOUND_AVAILABLE = "菜系名不存在，可用！";
    String THE_NAME_OF_THE_CUISINE_EXISTS_AND_IS_NOT_AVAILABLE = "菜系名存在，不可用！";
    String UPDATE_FOODTYPE_SUCCESS = "修改菜系表成功";
    String UPDATE_FOODTYPE_FAIL = "修改菜系失败";
    String DELETE_FOODTYPE_SUCCESS = "删除菜系表成功";
    String DELETE_FOODTYPE_FAIL = "删除菜系失败";
    String FAILED_TO_DELETE_DISHES_BECAUSE_ASSOCIATED_DISHES_EXIST = "存在关联菜品,删除菜系失败!";
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
    String FOOD_NAME_NOT_FOUND_AVAILABLE = "菜品名不存在，可用！";
    String THE_NAME_OF_THE_FOOD_EXISTS_AND_IS_NOT_AVAILABLE = "菜品名存在，不可用！";

    String PAGING_SUCCESS = "分页成功！";
    String PAGING_FAILURE = "分页失败！";

    String USER_NOT_FOUND_NO_REGISTER = "用户不存在，请先注册！";
    String LOGIN_SUCCESSFULLY = "登录成功！";
    String USER_REGISTRATION_SUCCEEDED = "用户注册成功！";
    String USER_REGISTRATION_FAIL = "用户注册失败！";
    String THE_USER_NAME_CANNOT_BE_EMPTY = "用户名不能为空!";
    String THE_PASSWORD_CANNOT_BE_EMPTY = "密码不能为空!";
    String PASSWORD_MISMATCH = "密码不相等！";
    String THE_USERNAME_ALREADY_EXISTS_AND_IS_NOT_AVAILABLE = "用户名已存在，不可用！";
    String THE_USER_NAME_DOES_NOT_EXIST = "用户名不存在，可用！";
}
