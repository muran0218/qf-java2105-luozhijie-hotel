package com.qf.java2105.lzj.entity;

import java.util.List;

/**
 * 分页实体
 * @Author lzj
 * @Date 2021/9/14
 */
public class PageBean<T> {
    /**
     * 集合
     */
    private List<T> list;
    /**
     * 当前页
     */
    private Integer currentPage = 1;
    /**
     * 总页数
     */
    private Integer totalPages;
    /**
     *总条数
     */
    private Long countTotal;
    /**
     * 页数大小
     */
    private Integer pageSize;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        if(currentPage == null || currentPage <= 0) {
            this.currentPage = 1;
        } else {
            this.currentPage = currentPage;
        }
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages() {
        int count = this.countTotal.intValue();
        this.totalPages = count % this.pageSize == 0 ? count / this.pageSize : count/ this.pageSize + 1;
    }

    public Long getCountTotal() {
        return countTotal;
    }

    public void setCountTotal(Long countTotal) {
        this.countTotal = countTotal;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
