package com.qf.java2105.lzj.pojo;

import java.io.Serializable;

/**
 * 食品类型实体
 * @Author lzj
 * @Date 2021/9/11
 */
public class FoodType implements Serializable {
    /**
     * 菜系ID
     */
    private Integer typeId;

    /**
     * 菜系名称
     */
    private String typeName;
    /**
     * 是否删除
     */
    private Integer isDelete;

    public FoodType() {
    }

    public FoodType(Integer typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "FoodType{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
