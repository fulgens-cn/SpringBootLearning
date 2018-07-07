/*
 Navicat Premium Data Transfer

 Source Server         : @localhost
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : test_db

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 07/07/2018 14:04:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(64) NOT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '用户密码',
  `birthday` date DEFAULT NULL COMMENT '用户生日',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
BEGIN;
INSERT INTO `tb_user` VALUES (1, 'aaa', '123456', '1994-08-10');
INSERT INTO `tb_user` VALUES (2, 'bbb', '123456', '1996-07-25');
INSERT INTO `tb_user` VALUES (3, 'ccc', '123456', '2000-05-01');
INSERT INTO `tb_user` VALUES (4, 'ddd', '123456', '1997-05-10');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
