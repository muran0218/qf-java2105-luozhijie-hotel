/*
SQLyog Ultimate v12.4.3 (64 bit)
MySQL - 5.7.25-log : Database - java2105_hotel
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`java2105_hotel` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `java2105_hotel`;

/*Table structure for table `t_dinner_table` */

DROP TABLE IF EXISTS `t_dinner_table`;

CREATE TABLE `t_dinner_table` (
  `table_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '餐桌ID',
  `table_name` varchar(20) NOT NULL COMMENT '餐桌名称',
  `table_status` tinyint(4) NOT NULL COMMENT '状态(是否预定) 0:否 1:是',
  `reservation_time` datetime DEFAULT NULL COMMENT '预定时间',
  PRIMARY KEY (`table_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='餐桌表';

/*Data for the table `t_dinner_table` */

/*Table structure for table `t_food` */

DROP TABLE IF EXISTS `t_food`;

CREATE TABLE `t_food` (
  `food_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜品ID',
  `type_id` int(11) DEFAULT NULL COMMENT '菜系ID',
  `food_name` varchar(20) NOT NULL COMMENT '菜品名称',
  `food_price` decimal(8,2) NOT NULL COMMENT '价格',
  `food_mprice` decimal(8,2) NOT NULL COMMENT '会员价格',
  `food_image` varchar(200) NOT NULL COMMENT '图片',
  `food_desc` longtext COMMENT '简介',
  `is_delete` int(11) DEFAULT '0',
  PRIMARY KEY (`food_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='菜品表';

/*Data for the table `t_food` */

insert  into `t_food`(`food_id`,`type_id`,`food_name`,`food_price`,`food_mprice`,`food_image`,`food_desc`,`is_delete`) values 
(1,16,'白灼虾',50.00,45.88,'/images/food/3993a07fd6dd4790acdfa7b7702da467.jpg','小母牛拿别针',0),
(2,2,'辣子鸡',45.00,39.88,'/images/food/4f90f487876e45fdbebf013c4f4c563d.jpg','小公牛哭小母牛',0),
(3,2,'爆炒牛肚',60.00,55.88,'/images/food/f1f38bf6def7463bb1f846bb37ae1a45.jpg','小母牛坐火箭',0),
(4,2,'回锅肉',40.00,35.88,'/images/food/259acc1aa84642b1bef142c1ba0e262c.jpg','小母牛翻跟头',0),
(5,16,'佛跳墙',188.88,158.88,'/images/food/508acadf4716430c88080f79f971f98d.jpg','小母牛倒立',0),
(7,16,'白切鸡',38.00,30.88,'/images/food/250e5814aedf4e8887fa11de31c3354f.jpg','小母牛开摩托',0),
(8,2,'荷兰豆',38.88,28.88,'/images/food/b02cffa7db0c429089c3f28bdc60cd54.jpg','小母牛他妈给小母牛开门',0),
(9,1,'青椒鸡丁',58.88,48.88,'/images/food/e14349c0024a4057ab100c057798083d.jpg','小母牛追公牛',0),
(10,2,'酸菜鱼',48.88,38.88,'/images/food/05cb41006e164938baa5d33690db78f6.jpg','一头母牛和十头公牛',0),
(11,2,'荷兰豆1',111.00,111.00,'/images/food/fbb5399a108a470f88b34e5f1086efb0.jpg','111',1),
(12,2,'佛跳墙1',111.00,111.89,'/images/food/063e443b8512461d9b2e0476c1666842.jpg','111',1);

/*Table structure for table `t_food_type` */

DROP TABLE IF EXISTS `t_food_type`;

CREATE TABLE `t_food_type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜系ID',
  `type_name` varchar(20) NOT NULL COMMENT '菜系名称',
  `is_delete` int(11) DEFAULT '0' COMMENT '是否删除 0:未删除 1:已删除',
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='菜系表';

/*Data for the table `t_food_type` */

insert  into `t_food_type`(`type_id`,`type_name`,`is_delete`) values 
(1,'湘菜1',0),
(2,'湘菜',0),
(3,'川菜',0),
(4,'杭邦菜',0),
(11,'东北菜',0),
(16,'粤菜',0),
(17,'安徽菜',1),
(18,'浏阳菜',0),
(19,'韩货料理',0),
(20,'日本菜',0),
(21,'浙江菜',1),
(22,'美国菜',1),
(23,'浏阳菜1',1),
(24,'湘菜2',0);

/*Table structure for table `t_menu` */

DROP TABLE IF EXISTS `t_menu`;

CREATE TABLE `t_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(10) NOT NULL COMMENT '菜单名称',
  `menu_url` varchar(30) NOT NULL COMMENT '菜单URL',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='这是一个菜单表';

/*Data for the table `t_menu` */

insert  into `t_menu`(`menu_id`,`menu_name`,`menu_url`) values 
(1,'菜系管理','/foodtype/search'),
(2,'餐桌管理','/dinnertable/search');

/*Table structure for table `t_order` */

DROP TABLE IF EXISTS `t_order`;

CREATE TABLE `t_order` (
  `order_id` varchar(30) NOT NULL COMMENT '订单ID',
  `table_id` int(11) DEFAULT NULL COMMENT '餐桌ID',
  `user_id` int(11) DEFAULT NULL COMMENT '主键',
  `total_num` int(11) NOT NULL COMMENT '总数量',
  `order_total_price` decimal(20,2) NOT NULL COMMENT '订单总金额',
  `order_create_time` datetime NOT NULL COMMENT '下单时间',
  `order_status` tinyint(4) NOT NULL COMMENT '状态',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

/*Data for the table `t_order` */

/*Table structure for table `t_order_detail` */

DROP TABLE IF EXISTS `t_order_detail`;

CREATE TABLE `t_order_detail` (
  `order_detail_id` varchar(30) NOT NULL COMMENT '详情ID',
  `order_id` varchar(30) DEFAULT NULL COMMENT '订单ID',
  `food_id` int(11) DEFAULT NULL COMMENT '菜品ID',
  `num` int(11) DEFAULT NULL COMMENT '菜数量',
  `food_total_price` decimal(20,2) DEFAULT NULL COMMENT '小计',
  PRIMARY KEY (`order_detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单详情实体';

/*Data for the table `t_order_detail` */

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `nick_name` varchar(20) DEFAULT NULL COMMENT '昵称',
  `is_admin` tinyint(4) DEFAULT '0' COMMENT '是否管理员 0:否  1:是',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机',
  `gender` tinyint(4) NOT NULL COMMENT '性别 0:保密 1:男 2:女',
  `user_status` tinyint(4) DEFAULT '1' COMMENT '状态(是否激活) 0:否 1:是',
  `user_create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `user_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_delete` tinyint(4) DEFAULT '0' COMMENT '是否删除',
  `is_member` tinyint(4) NOT NULL COMMENT '是否会员 0:否 1:是',
  `balance` decimal(20,2) DEFAULT NULL COMMENT '账户余额',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='这是一个用户表';

/*Data for the table `t_user` */

insert  into `t_user`(`user_id`,`username`,`password`,`nick_name`,`is_admin`,`phone`,`gender`,`user_status`,`user_create_time`,`user_update_time`,`is_delete`,`is_member`,`balance`) values 
(10,'admin','202cb962ac59075b964b07152d234b70',NULL,1,NULL,1,1,NULL,NULL,0,0,NULL),
(15,'lzj','202cb962ac59075b964b07152d234b70',NULL,0,NULL,1,1,NULL,NULL,0,1,NULL),
(16,'lzj1','202cb962ac59075b964b07152d234b70',NULL,0,NULL,0,1,NULL,NULL,0,1,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
