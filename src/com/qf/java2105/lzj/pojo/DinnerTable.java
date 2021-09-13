package com.qf.java2105.lzj.pojo;

import java.io.Serializable;
import java.sql.Date;

/**
 * 餐桌实体
 * @Author lzj
 * @Date 2021/9/11
 */
public class DinnerTable implements Serializable {
    /**
     * ID
     */
    private Integer tableId;
    /**
     * 餐桌名称
     */
    private String tableName;
    /**
     * 餐桌状态
     */
    private Integer tableStatus;
    /**
     * 预定时间
     */
    private Date reservationTime;

    public DinnerTable() {
    }

    public DinnerTable(Integer tableId, String tableName, Integer tableStatus, Date reservationTime) {
        this.tableId = tableId;
        this.tableName = tableName;
        this.tableStatus = tableStatus;
        this.reservationTime = reservationTime;
    }

    @Override
    public String toString() {
        return "DinnerTable{" +
                "tableId=" + tableId +
                ", tableName='" + tableName + '\'' +
                ", tableStatus=" + tableStatus +
                ", reservationTime=" + reservationTime +
                '}';
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Integer getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(Integer tableStatus) {
        this.tableStatus = tableStatus;
    }

    public Date getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(Date reservationTime) {
        this.reservationTime = reservationTime;
    }
}
