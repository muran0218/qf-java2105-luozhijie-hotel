package com.qf.java2105.lzj.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单详情实体
 * @Author lzj
 * @Date 2021/9/11
 */
public class OrderDetail implements Serializable {
    /**
     * 订单详情id
     */
    private Integer orderDetailId;
    /**
     * 订单id
     */
    private Integer orderId;
    /**
     * 食品id
     */
    private Integer foodId;
    /**
     * 菜数量
     */
    private Integer num;
    /**
     * 小计
     */
    private BigDecimal foodTotalPrice;

    public OrderDetail() {
    }

    public OrderDetail(Integer orderDetailId, Integer orderId, Integer foodId, Integer num, BigDecimal foodTotalPrice) {
        this.orderDetailId = orderDetailId;
        this.orderId = orderId;
        this.foodId = foodId;
        this.num = num;
        this.foodTotalPrice = foodTotalPrice;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderDetailId=" + orderDetailId +
                ", orderId=" + orderId +
                ", foodId=" + foodId +
                ", num=" + num +
                ", foodTotalPrice=" + foodTotalPrice +
                '}';
    }

    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BigDecimal getFoodTotalPrice() {
        return foodTotalPrice;
    }

    public void setFoodTotalPrice(BigDecimal foodTotalPrice) {
        this.foodTotalPrice = foodTotalPrice;
    }
}
