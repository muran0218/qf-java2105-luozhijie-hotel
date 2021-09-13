package com.qf.java2105.lzj.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 食品实体
 * @Author lzj
 * @Date 2021/9/11
 */
public class Food implements Serializable {
    /**
     * 食品id
     */
    private Integer foodId;
    /**
     * 食品类型id
     */
    private Integer typeId;
    /**
     * 食品名称
     */
    private String foodName;
    /**
     * 食品价格
     */
    private BigDecimal foodPrice;
    /**
     * 会员价格
     */
    private BigDecimal foodMprice;
    /**
     * 图片
     */
    private String foodImage;
    /**
     * 介绍
     */
    private String foodDesc;

    /**
     * 是否删除
     */
    private Integer isDelete;
    /**
     * 菜系实体
     */
    private FoodType foodType;

    public Food() {
    }

    public Food(Integer foodId, Integer typeId, String foodName, BigDecimal foodPrice, BigDecimal foodMprice, String foodImage, String foodDesc) {
        this.foodId = foodId;
        this.typeId = typeId;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodMprice = foodMprice;
        this.foodImage = foodImage;
        this.foodDesc = foodDesc;
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodId=" + foodId +
                ", typeId=" + typeId +
                ", foodName='" + foodName + '\'' +
                ", foodPrice=" + foodPrice +
                ", foodMprice=" + foodMprice +
                ", foodImage='" + foodImage + '\'' +
                ", foodDesc='" + foodDesc + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public BigDecimal getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(BigDecimal foodPrice) {
        this.foodPrice = foodPrice;
    }

    public BigDecimal getFoodMprice() {
        return foodMprice;
    }

    public void setFoodMprice(BigDecimal foodMprice) {
        this.foodMprice = foodMprice;
    }

    public String getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(String foodImage) {
        this.foodImage = foodImage;
    }

    public String getFoodDesc() {
        return foodDesc;
    }

    public void setFoodDesc(String foodDesc) {
        this.foodDesc = foodDesc;
    }
}
