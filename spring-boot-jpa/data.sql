/*
 Navicat Premium Data Transfer

 Source Server         : @localhost
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 01/09/2018 23:20:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_dept
-- ----------------------------
DROP TABLE IF EXISTS `tb_dept`;
CREATE TABLE `tb_dept` (
  `id` varchar(255) NOT NULL,
  `dept_name` varchar(64) NOT NULL,
  `created_by` varchar(64) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(64) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_i7323sbu3kmthg15db4m4rju3` (`dept_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_dept
-- ----------------------------
BEGIN;
INSERT INTO `tb_dept` VALUES ('0a4fe7234fff42afad34f6a06a8e1821', '人事部', NULL, NULL, NULL, NULL);
INSERT INTO `tb_dept` VALUES ('197f914721b0409cb00449ec4d110aa4', '技术部', NULL, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for tb_emp
-- ----------------------------
DROP TABLE IF EXISTS `tb_emp`;
CREATE TABLE `tb_emp` (
  `id` varchar(255) NOT NULL,
  `dept_id` varchar(255) DEFAULT NULL,
  `emp_job` varchar(64) DEFAULT NULL,
  `emp_name` varchar(64) NOT NULL,
  `created_by` varchar(64) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(64) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsk73xnghro3mrnvyht23veef7` (`dept_id`),
  CONSTRAINT `FKsk73xnghro3mrnvyht23veef7` FOREIGN KEY (`dept_id`) REFERENCES `tb_dept` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_emp
-- ----------------------------
BEGIN;
INSERT INTO `tb_emp` VALUES ('93fce66c1ef340fa866d5bd389de3d79', '0a4fe7234fff42afad34f6a06a8e1821', 'hr', 'jack', NULL, NULL, NULL, NULL);
INSERT INTO `tb_emp` VALUES ('d152ea0a5f594f6ba00dca7e4c1cb486', '197f914721b0409cb00449ec4d110aa4', 'java开发', 'tom', NULL, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `id` varchar(255) NOT NULL,
  `role_name` varchar(64) NOT NULL,
  `created_by` varchar(64) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(64) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_c9lijtmr0x68iu1vxftbu2u33` (`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
BEGIN;
INSERT INTO `tb_role` VALUES ('40289f0c657ba62601657ba65b140000', 'ROLE_USER', NULL, NULL, NULL, NULL);
INSERT INTO `tb_role` VALUES ('b17a4072008e402c8e5998b3a359eac1', 'ROLE_ADMIN', NULL, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` varchar(255) NOT NULL,
  `email` varchar(64) DEFAULT NULL,
  `password` varchar(64) NOT NULL,
  `username` varchar(64) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_4wv83hfajry5tdoamn8wsqa6x` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
BEGIN;
INSERT INTO `tb_user` VALUES ('40289f0c65674a930165674d54940000', 'abc@gmail.com', '123456789', 'hello123', NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES ('40289f0c6571c90c016571c9d4d00000', 'fulgens@gmail.com', '123456789', 'fulgens', NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES ('40289f0c657ba62601657ba65b140000', 'qaz123@gmail.com', '123456789', 'qaz123456', 'admin', '2018-08-27 21:50:25', 'admin', '2018-08-27 21:50:25');
COMMIT;

-- ----------------------------
-- Table structure for tb_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE `tb_user_role` (
  `user_id` varchar(255) NOT NULL,
  `role_id` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKea2ootw6b6bb0xt3ptl28bymv` (`role_id`),
  CONSTRAINT `FK7vn3h53d0tqdimm8cp45gc0kl` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`id`),
  CONSTRAINT `FKea2ootw6b6bb0xt3ptl28bymv` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

SET FOREIGN_KEY_CHECKS = 1;
