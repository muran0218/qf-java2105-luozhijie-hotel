package com.qf.java2105.lzj.pojo;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * 订单实体
 * @Author lzj
 * @Date 2021/9/11
 */
public class Order implements Serializable {
    /**
     * 订单id
     */
    private Integer orderId;
    /**
     * 餐桌id
     */
    private Integer tableId;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 订单数量
     */
    private Integer totalNum;
    /**
     * 订单总金额
     */
    private BigDecimal orderTotalPrice;
    /**
     * 下单时间
     */
    private Date orderCreateTime;
    /**
     * 订单状态
     */
    private Integer orderStatus;

    public Order() {
    }

    public Order(Integer orderId, Integer tableId, Integer userId, Integer totalNum, BigDecimal orderTotalPrice, Date orderCreateTime, Integer orderStatus) {
        this.orderId = orderId;
        this.tableId = tableId;
        this.userId = userId;
        this.totalNum = totalNum;
        this.orderTotalPrice = orderTotalPrice;
        this.orderCreateTime = orderCreateTime;
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", tableId=" + tableId +
                ", userId=" + userId +
                ", totalNum=" + totalNum +
                ", orderTotalPrice=" + orderTotalPrice +
                ", orderCreateTime=" + orderCreateTime +
                ", orderStatus=" + orderStatus +
                '}';
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public BigDecimal getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(BigDecimal orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public Date getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }
}
