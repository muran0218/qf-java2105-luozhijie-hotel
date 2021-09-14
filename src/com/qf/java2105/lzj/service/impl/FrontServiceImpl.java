package com.qf.java2105.lzj.service.impl;

import com.qf.java2105.lzj.constant.MessageConstant;
import com.qf.java2105.lzj.dao.IFoodDao;
import com.qf.java2105.lzj.entity.PageBean;
import com.qf.java2105.lzj.entity.ResultVO;
import com.qf.java2105.lzj.factory.BeanFactory;
import com.qf.java2105.lzj.pojo.Food;
import com.qf.java2105.lzj.service.IFrontService;

import java.sql.SQLException;
import java.util.List;

/**
 * 前台逻辑层实现
 * @Author lzj
 * @Date 2021/9/14
 */
public class FrontServiceImpl implements IFrontService {
    private IFoodDao foodDao = (IFoodDao) BeanFactory.getBean("foodDao");

    /**
     * 分页方法
     * @param currentPage 当前页
     * @param pageSize  一页多少条
     * @return
     */
    @Override
    public ResultVO<PageBean<Food>> findByPageAndCondition(Integer currentPage, Integer pageSize,Integer typeId ,String foodName) {
        try {
            //创建分页实体
            PageBean<Food> pageBean = new PageBean<>();
            //设置参数
            //设置当前页数
            pageBean.setCurrentPage(currentPage);
            //设置每页显示的条数
            pageBean.setPageSize(pageSize);
            //取得当前页数
            Integer start = (pageBean.getCurrentPage() - 1) * pageBean.getPageSize();
            //获取当前每页的显示条数
            Integer size = pageBean.getPageSize();

            //获取分页集合
            List<Food> foodList = foodDao.findByPageAndCondition(start, size,typeId,foodName);
            //获得总数
            Long count = foodDao.countByCondition(typeId,foodName);

            //设置总数
            pageBean.setCountTotal(count);
            //设置总页数
            pageBean.setTotalPages();
            //设置分页集合
            pageBean.setList(foodList);

            return ResultVO.ok(MessageConstant.PAGING_SUCCESS,pageBean);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ResultVO.error(MessageConstant.PAGING_FAILURE);
    }
}
