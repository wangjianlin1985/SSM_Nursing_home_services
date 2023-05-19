/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50620
Source Host           : localhost:3306
Source Database       : nursing

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2019-04-10 20:45:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_evaluation`
-- ----------------------------
DROP TABLE IF EXISTS `t_evaluation`;
CREATE TABLE `t_evaluation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `old_id` int(11) DEFAULT NULL,
  `gardener_id` int(11) DEFAULT NULL,
  `begin_time` varchar(100) DEFAULT NULL,
  `end_time` varchar(100) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `old_name` varchar(100) DEFAULT NULL,
  `old_identity` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='园丁评价';

-- ----------------------------
-- Records of t_evaluation
-- ----------------------------
INSERT INTO `t_evaluation` VALUES ('1', '1', '1', '2019-04-07 04:11:01', '2019-04-07 05:01:49', '1', '1232', '123');
INSERT INTO `t_evaluation` VALUES ('2', '1', '2', '2019-04-07 04:13:30', '2019-04-07 05:02:27', '3', '1232', '123');
INSERT INTO `t_evaluation` VALUES ('3', '1', '1', '2019-04-07 05:12:58', null, null, '1232', '123');

-- ----------------------------
-- Table structure for `t_gardener`
-- ----------------------------
DROP TABLE IF EXISTS `t_gardener`;
CREATE TABLE `t_gardener` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gardener_name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `gardener_sex` varchar(100) DEFAULT NULL COMMENT '性别',
  `gardener_identity` varchar(100) DEFAULT NULL COMMENT '身份证',
  `gardener_age` varchar(100) DEFAULT NULL COMMENT '年龄',
  `gardener_status` int(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='园丁';

-- ----------------------------
-- Records of t_gardener
-- ----------------------------
INSERT INTO `t_gardener` VALUES ('1', '123122', '男', '123123', '123123', '2');
INSERT INTO `t_gardener` VALUES ('2', '123', '女', '123', '123', '1');

-- ----------------------------
-- Table structure for `t_guardian`
-- ----------------------------
DROP TABLE IF EXISTS `t_guardian`;
CREATE TABLE `t_guardian` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `guardian_name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `guardian_sex` varchar(100) DEFAULT NULL COMMENT '性别',
  `guardian_identity` varchar(100) DEFAULT NULL COMMENT '身份证',
  `guardian_phone` varchar(100) DEFAULT NULL COMMENT '电话',
  `guardian_relation` varchar(100) DEFAULT NULL COMMENT '关系',
  `create_time` varchar(100) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='监护人';

-- ----------------------------
-- Records of t_guardian
-- ----------------------------
INSERT INTO `t_guardian` VALUES ('1', 'ee3', '男', '234', '234', '234', '2019-04-07 03:04:51');
INSERT INTO `t_guardian` VALUES ('2', '5rr', '男', '123', '123', '123', '2019-04-07 03:05:06');

-- ----------------------------
-- Table structure for `t_login`
-- ----------------------------
DROP TABLE IF EXISTS `t_login`;
CREATE TABLE `t_login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `role` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='登录信息';

-- ----------------------------
-- Records of t_login
-- ----------------------------
INSERT INTO `t_login` VALUES ('1', 'admin', '123456', '1');

-- ----------------------------
-- Table structure for `t_old`
-- ----------------------------
DROP TABLE IF EXISTS `t_old`;
CREATE TABLE `t_old` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `old_name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `old_sex` varchar(100) DEFAULT NULL COMMENT '性别',
  `old_identity` varchar(100) DEFAULT NULL COMMENT '身份证',
  `old_age` varchar(100) DEFAULT NULL COMMENT '年龄',
  `health_status` int(11) DEFAULT NULL COMMENT '健康状况',
  `create_time` varchar(100) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT=' 老人信息';

-- ----------------------------
-- Records of t_old
-- ----------------------------
INSERT INTO `t_old` VALUES ('1', '1232', '男', '123', '123', '3', '2019-04-07 03:02:59');
INSERT INTO `t_old` VALUES ('2', '3245', '男', '123', '123', '1', '2019-04-07 03:04:22');
INSERT INTO `t_old` VALUES ('3', '5765', '女', '234', '234', '3', '2019-04-07 03:04:37');
INSERT INTO `t_old` VALUES ('4', '123', '男', '123', '123', '2', '2019-04-07 03:16:03');
INSERT INTO `t_old` VALUES ('5', '12333333', '男', '123', '123', '4', '2019-04-07 03:16:24');

-- ----------------------------
-- Table structure for `t_old_details`
-- ----------------------------
DROP TABLE IF EXISTS `t_old_details`;
CREATE TABLE `t_old_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `details` varchar(200) DEFAULT NULL,
  `create_time` varchar(100) DEFAULT NULL,
  `gardener_id` int(11) DEFAULT NULL,
  `gardener_name` varchar(100) DEFAULT NULL,
  `health_status` int(11) DEFAULT NULL,
  `old_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='老人详情';

-- ----------------------------
-- Records of t_old_details
-- ----------------------------
INSERT INTO `t_old_details` VALUES ('10', '很好', '2019-04-07 04:11:01', '1', '123122', '3', '1');
INSERT INTO `t_old_details` VALUES ('11', '1231', '2019-04-07 04:13:30', '2', '123', '4', '1');
INSERT INTO `t_old_details` VALUES ('12', '威尔翁热无', '2019-04-07 05:12:58', '1', '123122', '3', '1');

-- ----------------------------
-- Table structure for `t_old_guardian`
-- ----------------------------
DROP TABLE IF EXISTS `t_old_guardian`;
CREATE TABLE `t_old_guardian` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `old_id` int(11) DEFAULT NULL,
  `guardian_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='老人，监护';

-- ----------------------------
-- Records of t_old_guardian
-- ----------------------------
INSERT INTO `t_old_guardian` VALUES ('1', '2', '1');
INSERT INTO `t_old_guardian` VALUES ('2', '1', '1');
INSERT INTO `t_old_guardian` VALUES ('3', '3', '1');
INSERT INTO `t_old_guardian` VALUES ('4', '2', '2');
INSERT INTO `t_old_guardian` VALUES ('5', '1', null);
