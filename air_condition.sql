/*
Navicat MySQL Data Transfer

Source Server         : 123.207.114.170
Source Server Version : 50554
Source Host           : 123.207.114.170:3306
Source Database       : air_condition

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2017-04-09 14:14:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for equipment
-- ----------------------------
DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eqname` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `eqtype` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `eqbuytime` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of equipment
-- ----------------------------
INSERT INTO `equipment` VALUES ('1', '中央空调主机', '博克BKLS-865.1L', '2016-03-01 09:19:48', '1');
INSERT INTO `equipment` VALUES ('2', '冷却塔1', 'DBNL', '2017-04-08 09:20:45', '1');
INSERT INTO `equipment` VALUES ('3', '冷却塔2', 'DBNL', '2017-01-01 10:09:31', '1');
INSERT INTO `equipment` VALUES ('4', '冷冻水泵1', 'IS100-80-160', '2016-01-09 10:10:13', '1');
INSERT INTO `equipment` VALUES ('5', '冷冻水泵2', 'IS100-80-160', '2016-11-01 10:11:00', '1');
INSERT INTO `equipment` VALUES ('6', '冷却泵1', 'ISG125-160', '2017-01-01 10:11:58', '1');
INSERT INTO `equipment` VALUES ('7', '冷却泵2', 'ISG125-160', '2016-12-01 10:13:16', '1');
INSERT INTO `equipment` VALUES ('8', '风机盘管', '格力RE#002', '2017-04-01 10:14:17', '1');
INSERT INTO `equipment` VALUES ('9', '空气处理机', '格力CRP221', '2017-01-01 10:15:07', '1');

-- ----------------------------
-- Table structure for equipment_data
-- ----------------------------
DROP TABLE IF EXISTS `equipment_data`;
CREATE TABLE `equipment_data` (
  `eqid` int(11) DEFAULT NULL,
  `eqname` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `eqparm` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `eqvalue` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `eqstate` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `recordtime` datetime DEFAULT NULL,
  `version` varchar(255) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of equipment_data
-- ----------------------------

-- ----------------------------
-- Table structure for equipment_repair
-- ----------------------------
DROP TABLE IF EXISTS `equipment_repair`;
CREATE TABLE `equipment_repair` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eqid` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `repairtime` datetime DEFAULT NULL,
  `desc` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of equipment_repair
-- ----------------------------
INSERT INTO `equipment_repair` VALUES ('1', '1', '2', '2017-02-08 09:33:42', '温度过高');
INSERT INTO `equipment_repair` VALUES ('2', '1', '2', '2017-04-04 09:33:57', '设备短路');

-- ----------------------------
-- Table structure for event_inform
-- ----------------------------
DROP TABLE IF EXISTS `event_inform`;
CREATE TABLE `event_inform` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eqid` int(11) DEFAULT NULL,
  `eqname` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `informtime` datetime DEFAULT NULL,
  `grade` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `desc` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of event_inform
-- ----------------------------
INSERT INTO `event_inform` VALUES ('1', '2', '冷却塔1', '2017-04-09 13:48:01', '一级', '温度太高', '0');
INSERT INTO `event_inform` VALUES ('2', '4', '冷冻水泵1', '2017-04-09 14:03:00', '一级', '温度太高', '0');
INSERT INTO `event_inform` VALUES ('3', '3', '冷却塔2', '2017-04-09 14:04:00', '二级', '温度太高', '1');
INSERT INTO `event_inform` VALUES ('4', '3', '冷却塔2', '2017-04-09 14:05:00', '二级', '功率过大', '1');
INSERT INTO `event_inform` VALUES ('5', '2', '冷却塔1', '2017-04-09 14:06:00', '二级', '温度太高', '0');
INSERT INTO `event_inform` VALUES ('6', '4', '冷冻水泵1', '2017-04-09 14:07:01', '一级', '温度太高', '1');
INSERT INTO `event_inform` VALUES ('7', '7', '冷却泵2', '2017-04-09 14:08:00', '一级', '功率过大', '0');
INSERT INTO `event_inform` VALUES ('8', '4', '冷冻水泵1', '2017-04-09 14:09:00', '一级', '温度太高', '0');
INSERT INTO `event_inform` VALUES ('9', '2', '冷却塔1', '2017-04-09 14:10:00', '二级', '温度太高', '0');
INSERT INTO `event_inform` VALUES ('10', '1', '中央空调主机', '2017-04-09 14:11:00', '一级', '温度太高', '1');

-- ----------------------------
-- Table structure for limit
-- ----------------------------
DROP TABLE IF EXISTS `limit`;
CREATE TABLE `limit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `limitname` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `limitcode` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `limitdesc` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of limit
-- ----------------------------
INSERT INTO `limit` VALUES ('1', null, 'MR001', '管理系统用户', '1');
INSERT INTO `limit` VALUES ('2', null, 'MR002', '管理云平台用户', '1');
INSERT INTO `limit` VALUES ('3', null, 'MR101', '管理设备列表', '1');
INSERT INTO `limit` VALUES ('4', null, 'MR102', '管理设备列表', '1');
INSERT INTO `limit` VALUES ('5', null, 'MR103', '添加设备监控项', '1');
INSERT INTO `limit` VALUES ('6', null, 'MR104', '管理监控阀值', '1');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `roledesc` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '系统管理员', '管理整个系统运行', '1');
INSERT INTO `role` VALUES ('2', '系统维护人员', '维护系统各个功能组件', '1');
INSERT INTO `role` VALUES ('3', '客户管理员', '客户管理员账号', '1');
INSERT INTO `role` VALUES ('4', '客户用户', '客户监控账号', '1');

-- ----------------------------
-- Table structure for role_limit
-- ----------------------------
DROP TABLE IF EXISTS `role_limit`;
CREATE TABLE `role_limit` (
  `roleid` int(11) DEFAULT NULL,
  `limitid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of role_limit
-- ----------------------------
INSERT INTO `role_limit` VALUES ('1', '1');
INSERT INTO `role_limit` VALUES ('1', '2');
INSERT INTO `role_limit` VALUES ('1', '3');
INSERT INTO `role_limit` VALUES ('1', '4');
INSERT INTO `role_limit` VALUES ('1', '5');
INSERT INTO `role_limit` VALUES ('1', '6');
INSERT INTO `role_limit` VALUES ('2', '3');
INSERT INTO `role_limit` VALUES ('2', '4');
INSERT INTO `role_limit` VALUES ('2', '5');
INSERT INTO `role_limit` VALUES ('3', '3');
INSERT INTO `role_limit` VALUES ('3', '4');
INSERT INTO `role_limit` VALUES ('3', '5');
INSERT INTO `role_limit` VALUES ('4', '3');
INSERT INTO `role_limit` VALUES ('4', '4');
INSERT INTO `role_limit` VALUES ('4', '5');

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `room_num` int(11) NOT NULL AUTO_INCREMENT,
  `temp` varchar(255) DEFAULT NULL,
  `humidity` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `air_speed` double DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `realname` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '986732056', '1213456', 'yangchun', '986732056@qq.com', '1', '1');
INSERT INTO `user` VALUES ('2', 'admin', '123456', '张三', 'abc@sina.com', '1', '1');
INSERT INTO `user` VALUES ('3', 'system', '123456', '李四', 'bbc@sina.com', '1', '1');
INSERT INTO `user` VALUES ('4', 'op', '123456', '王五', 'ccd@sina.com', '2', '1');

-- ----------------------------
-- Table structure for warning_config
-- ----------------------------
DROP TABLE IF EXISTS `warning_config`;
CREATE TABLE `warning_config` (
  `eqid` int(11) DEFAULT NULL,
  `warning_temp` bigint(20) DEFAULT NULL,
  `warning_power` bigint(20) DEFAULT NULL,
  `inform_user` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of warning_config
-- ----------------------------
INSERT INTO `warning_config` VALUES ('1', '80', '1000', '1', '1');
INSERT INTO `warning_config` VALUES ('2', '50', '500', '1', '1');
INSERT INTO `warning_config` VALUES ('3', '0', '0', '1', '1');
INSERT INTO `warning_config` VALUES ('4', '0', '0', '1', '1');
INSERT INTO `warning_config` VALUES ('5', '0', '0', '1', '1');
INSERT INTO `warning_config` VALUES ('6', '0', '0', '1', '1');
INSERT INTO `warning_config` VALUES ('7', '0', '0', '1', '1');
INSERT INTO `warning_config` VALUES ('8', '0', '0', '1', '1');
INSERT INTO `warning_config` VALUES ('9', '0', '0', '1', '1');
DROP TRIGGER IF EXISTS `warning_config`;
DELIMITER ;;
CREATE TRIGGER `warning_config` AFTER INSERT ON `equipment` FOR EACH ROW insert into warning_config values((select max(id) from equipment) ,0,0,1,1)
;;
DELIMITER ;
