package com.qf.java2105.lzj.dao.impl;

import com.qf.java2105.lzj.dao.IFoodDao;
import com.qf.java2105.lzj.pojo.Food;
import com.qf.java2105.lzj.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 食品持久层实现
 * @Author lzj
 * @Date 2021/9/12
 */
public class FoodDaoImpl implements IFoodDao {
    private QueryRunner queryRunner = null;
    @Override
    public List<Map<String, Object>> findByName(String foodName) throws SQLException {
        queryRunner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "SELECT f.food_id foodId,\n" +
                "                f.type_id typeId  ,\n" +
                "                f.food_name foodName,\n" +
                "                f.food_price foodPrice,\n" +
                "                f.food_mprice foodMprice,\n" +
                "                f.food_image foodImage,\n" +
                "                f.food_desc foodDesc,\n" +
                "                ft.type_name typeName\n" +
                "        FROM t_food f, t_food_type ft\n" +
                "        WHERE f.type_id = ft.type_id\n" +
                "        AND food_name LIKE ? AND f.is_delete = 0";
        return queryRunner.query(sql,new MapListHandler(),foodName);
    }

    @Override
    public Food findById(Integer foodId) throws SQLException {
        queryRunner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "SELECT\n" +
                "`food_id` foodId,\n" +
                "`type_id` typeId,\n" +
                "`food_name` foodName,\n" +
                "`food_price` foodPrice,\n" +
                "`food_mprice` foodMprice,\n" +
                "`food_image` foodImage,\n" +
                "`food_desc` foodDesc\n" +
                "FROM \n" +
                "`t_food`\n" +
                "WHERE\n" +
                "`food_id` = ?\n" +
                "AND\n" +
                "`is_delete` = 0";
        return queryRunner.query(sql,new BeanHandler<>(Food.class),foodId);
    }

    @Override
    public Integer save(Food food) throws SQLException {
        queryRunner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "INSERT INTO `t_food` (`type_id`,`food_name`,`food_price`,`food_mprice`,`food_image`,`food_desc`,`is_delete`)\n" +
                "VALUES (?,?,?,?,?,?,?)";
        return queryRunner.update(sql,food.getTypeId(),food.getFoodName(),food.getFoodPrice(),food.getFoodMprice(),
        food.getFoodImage(),food.getFoodDesc(),0);
    }

    @Override
    public Integer update(Food food) throws SQLException {
        queryRunner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "UPDATE `t_food` SET `type_id` = ? ,`food_name` = ? ,`food_price` = ? ," +
                "`food_mprice` = ? ,`food_image` = ? ,`food_desc` = ? \n" +
                "WHERE `food_id` = ?";
        return queryRunner.update(sql,food.getTypeId(),food.getFoodName(),food.getFoodPrice(),food.getFoodMprice(),
        food.getFoodImage(),food.getFoodDesc(),food.getFoodId());
    }

    @Override
    public Integer deleteById(Integer foodId) throws SQLException {
        queryRunner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "UPDATE `t_food` SET `is_delete` = 1 WHERE `food_id` = ?";
        return queryRunner.update(sql,foodId);
    }
}
