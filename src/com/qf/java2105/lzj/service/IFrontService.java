package com.qf.java2105.lzj.service;

import com.qf.java2105.lzj.entity.PageBean;
import com.qf.java2105.lzj.entity.ResultVO;
import com.qf.java2105.lzj.pojo.Food;


/**
 * 前台页面逻辑层
 * @Author lzj
 * @Date 2021/9/14
 */
public interface IFrontService {
    /**
     * 点单分页
     * @param currentPage 当前页
     * @param pageSize  一页多少条
     * @return 结果
     */
    ResultVO<PageBean<Food>> findByPageAndCondition(Integer currentPage , Integer pageSize,Integer typeId ,String foodName);
}
