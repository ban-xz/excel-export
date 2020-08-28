/*
 Navicat Premium Data Transfer

 Source Server         : mysql8
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 28/08/2020 10:16:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
  `real_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `phone` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系电话',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  `locked` bit(1) NULL DEFAULT NULL COMMENT '状态',
  `deleted` tinyint(1) NULL DEFAULT NULL COMMENT '是否注销',
  `creator` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_user_name`(`user_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'adm3', '张三', '18985964586', 'nini@11.com', b'0', 0, 'admin1', '2020-07-31 16:23:38', '2020-07-31 16:23:38');
INSERT INTO `user` VALUES (14, 'admin', '张三', '18985964586', 'nini@11.com', b'0', 0, 'user', '2020-07-29 14:08:31', '2020-07-29 14:08:31');
INSERT INTO `user` VALUES (15, 'zy', '张三', '18985964586', 'nini@11.com', b'0', 0, 'zy', '2020-07-29 17:33:05', '2020-07-29 17:33:05');
INSERT INTO `user` VALUES (16, 'ywj', '张三', '18985964586', 'nini@11.com', b'0', 0, 'ywj', '2020-07-29 19:03:33', '2020-07-29 19:03:33');
INSERT INTO `user` VALUES (17, 'zgq', '张三', '18985964586', 'nini@11.com', b'0', 0, 'zgq', '2020-07-30 09:46:26', '2020-07-30 09:46:26');

SET FOREIGN_KEY_CHECKS = 1;
