package com.qf.java2105.lzj.dao.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.qf.java2105.lzj.dao.IFoodTypeDao;
import com.qf.java2105.lzj.pojo.FoodType;
import com.qf.java2105.lzj.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * 菜系持久层实现类
 * @Author lzj
 * @Date 2021/9/12
 */
public class FoodTypeDaoImpl implements IFoodTypeDao {
    private QueryRunner queryRunner = null;
    @Override
    public List<FoodType> findByName(String keyword) throws SQLException {
        queryRunner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "select type_id typeId,type_name typeName from t_food_type where type_name like ? and is_delete = 0";
        return queryRunner.query(sql,new BeanListHandler<>(FoodType.class),keyword);
    }

    @Override
    public FoodType findById(Integer id) throws SQLException {
        queryRunner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "select type_id typeId,type_name typeName from t_food_type where type_id = ? and is_delete = 0";
        return queryRunner.query(sql,new BeanHandler<>(FoodType.class),id);
    }

    @Override
    public Integer updateById(FoodType foodType) throws SQLException {
        queryRunner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "UPDATE `t_food_type` SET `type_name` = ? WHERE `type_id` = ?";
        return queryRunner.update(sql,foodType.getTypeName(),foodType.getTypeId());
    }

    @Override
    public Integer deleteById(Integer typeId) throws SQLException {
        queryRunner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "UPDATE `t_food_type` SET `is_delete` = 1 WHERE `type_id` = ?";
        return queryRunner.update(sql,typeId);
    }

    @Override
    public Integer save(FoodType foodType) throws SQLException {
        queryRunner  = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "INSERT INTO `t_food_type` (`type_name`,`is_delete`) VALUES (?,?)";
        return queryRunner.update(sql,foodType.getTypeName(),foodType.getIsDelete());
    }

    @Override
    public Integer existsFoodName(String typeName) throws SQLException {
        queryRunner  = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "SELECT food_id FROM t_food WHERE food_name = ? limit 1";
        return queryRunner.query(sql,new ScalarHandler<>(),typeName);
    }

    @Override
    public List<FoodType> findAll() throws SQLException {
        queryRunner  = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "SELECT `type_id` typeId,`type_name` typeName,`is_delete` isDelete FROM `t_food_type` WHERE `is_delete` = 0";
        return queryRunner.query(sql,new BeanListHandler<>(FoodType.class));
    }


}
