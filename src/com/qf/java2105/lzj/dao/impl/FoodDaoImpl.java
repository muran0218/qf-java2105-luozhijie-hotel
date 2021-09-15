package com.qf.java2105.lzj.dao.impl;

import com.qf.java2105.lzj.dao.IFoodDao;
import com.qf.java2105.lzj.pojo.Food;
import com.qf.java2105.lzj.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
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
    public List<Food> findByTypeId(Integer typeId) throws SQLException {
        queryRunner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "SELECT t.`food_id` FROM `t_food` t,`t_food_type` tf " +
                "WHERE  t.`type_id` = tf.`type_id` AND  t.`type_id` = ?";
        return queryRunner.query(sql,new BeanListHandler<>(Food.class),typeId);
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

    @Override
    public Integer existsFoodName(String foodName) throws SQLException {
        queryRunner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "SELECT food_id FROM t_food WHERE food_name = ? limit 1";
        return queryRunner.query(sql, new ScalarHandler<>(), foodName);
    }

    @Override
    public List<Food> findByPageAndCondition(Integer currentPage, Integer pageSize ,Integer typeId ,String foodName) throws SQLException {
        //创建一个集合放参数
        List<Object> params = new ArrayList<>();
        queryRunner = new QueryRunner(JdbcUtil.getDataSource());
        //创建一个可变的数组
        StringBuffer sql = new StringBuffer("SELECT\n" +
                                        "  food_id foodId,\n" +
                                        "  type_id typeId,\n" +
                                        "  food_name foodName,\n" +
                                        "  food_price foodPrice,\n" +
                                        "  food_mprice foodMprice,\n" +
                                        "  food_image foodImage,\n" +
                                        "  food_desc foodDesc\n" +
                                        "FROM t_food \n" +
                                        "where 1=1 ");
        //食品名称绝对不为空 直接追加
        sql = sql.append(" and food_name like ? ");
        params.add(foodName);
        //判断菜系id是否为空
        if (0 != typeId) {
            sql = sql.append(" and type_id = ? ");
            params.add(typeId);
        }
        sql.append(" and is_delete = 0 ");
        //追加分页
        sql = sql.append(" limit ?,? ");
        params.add(currentPage);
        params.add(pageSize);
        return queryRunner.query(sql.toString(),new BeanListHandler<>(Food.class),params.toArray());
    }

    @Override
    public Long countByCondition(Integer typeId ,String foodName) throws SQLException {
        //创建一个集合放参数
        List<Object> params = new ArrayList<>();
        queryRunner = new QueryRunner(JdbcUtil.getDataSource());
        //创建一个可变的数组
        StringBuffer sql = new StringBuffer("SELECT COUNT(1) FROM t_food where 1=1 ");
        //食品名称不能为空直接追加
        sql = sql.append(" and food_name like ? ");
        params.add(foodName);
        //判断菜系id
        if (0 != typeId) {
            sql = sql.append(" and type_id = ? ");
            params.add(typeId);
        }
        sql.append(" and is_delete = 0 ");
        return queryRunner.query(sql.toString(), new ScalarHandler<>(),params.toArray());
    }
}
