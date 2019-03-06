/*
 Navicat Premium Data Transfer

 Source Server         : bysj
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : GraduateManage

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 06/03/2019 10:10:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for company_info
-- ----------------------------
DROP TABLE IF EXISTS `company_info`;
CREATE TABLE `company_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `com_name` varchar(30) NOT NULL,
  `com_person` varchar(50) DEFAULT NULL,
  `com_phone` varchar(11) DEFAULT NULL,
  `com_email` varchar(20) DEFAULT NULL,
  `com_code` varchar(50) DEFAULT NULL COMMENT '组织机构代码',
  `com_addre` varchar(30) DEFAULT NULL,
  `com_note` varchar(100) DEFAULT NULL COMMENT '备注',
	`com_user_id` int(11) DEFAULT NULL COMMENT '关联user表id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for student_info
-- ----------------------------
DROP TABLE IF EXISTS `student_info`;
CREATE TABLE `student_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '关联user表id',
  `name` varchar(50) DEFAULT NULL,
  `id_num` varchar(20) DEFAULT NULL COMMENT '身份证',
  `gender` tinyint(2) DEFAULT NULL,
  `nation` varchar(255)  DEFAULT NULL COMMENT '民族',
  `institude` tinyint(255) DEFAULT NULL COMMENT '学院',
  `profession` tinyint(255) DEFAULT NULL COMMENT '专业',
  `education` tinyint(255) DEFAULT NULL COMMENT '学历（0:本科 1:研究生）',
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `user_type` tinyint(2) DEFAULT NULL COMMENT '用户类型（0:管理员 1:学生 2:公司）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
