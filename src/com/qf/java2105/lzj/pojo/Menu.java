package com.qf.java2105.lzj.pojo;

import java.io.Serializable;

/**
 * 导航栏菜单实体
 * @Author lzj
 * @Date 2021/9/11
 */
public class Menu implements Serializable {
    /**
     * 菜单id
     */
    private Integer menuId;
    /**
     * 菜单名
     */
    private String menuName;
    /**
     *菜单地址
     */
    private String menuUrl;

    public Menu() {
    }

    public Menu(Integer menuId, String menuName, String menuUrl) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuUrl = menuUrl;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                '}';
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }
}
