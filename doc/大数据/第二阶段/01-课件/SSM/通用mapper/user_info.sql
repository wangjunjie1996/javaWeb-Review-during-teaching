/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50555
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50555
File Encoding         : 65001

Date: 2018-09-14 17:00:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(32) NOT NULL COMMENT '用户名称',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `sex` char(1) DEFAULT '男' COMMENT '性别',
  `address` varchar(256) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('5', 'jack', '2018-09-01', '女', '洛杉矶');
INSERT INTO `user_info` VALUES ('7', '张三', '2018-09-01', '男', '上海');
INSERT INTO `user_info` VALUES ('10', '张三1', '2018-09-14', '男', '北京');
INSERT INTO `user_info` VALUES ('11', '张三21', '2018-09-08', '男', '山东济宁');
INSERT INTO `user_info` VALUES ('12', '张三231', '2018-09-02', '男', '山东青岛');
INSERT INTO `user_info` VALUES ('13', 'rose', '2018-09-08', '女', '伦敦');
INSERT INTO `user_info` VALUES ('14', '张三21', '2018-08-31', '男', '山东济宁');
INSERT INTO `user_info` VALUES ('15', 'dd', null, '男', '山东济宁');
