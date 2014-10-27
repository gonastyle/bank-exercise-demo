/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : bank

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2014-10-13 20:49:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `aid` varchar(10) NOT NULL,
  `aname` varchar(10) NOT NULL,
  `apwd` char(6) NOT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('a001', '梅志胜', '123456');
INSERT INTO `admin` VALUES ('a002', '郭嘉璐', '123456');
INSERT INTO `admin` VALUES ('a003', '任我行', '123456');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` varchar(20) NOT NULL,
  `uname` varchar(10) NOT NULL,
  `upwd` char(6) NOT NULL,
  `umoney` double(11,2) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('111', '商店', '1234', '0.00');
INSERT INTO `user` VALUES ('1234', '读书', '1234', '0.00');
INSERT INTO `user` VALUES ('15001', '是滴', '1234', '0.00');
INSERT INTO `user` VALUES ('20111544', '内战', '1234', '34014.00');
INSERT INTO `user` VALUES ('2013', '???', '1234', '566.00');
INSERT INTO `user` VALUES ('622201', '华为', '1234', '4765.88');
INSERT INTO `user` VALUES ('622202', '中兴', '1234', '400.12');
INSERT INTO `user` VALUES ('622203', '米帝', '1234', '50000.00');
INSERT INTO `user` VALUES ('888', '?????', '1234', '0.00');
INSERT INTO `user` VALUES ('999', '????', '1234', '0.00');
INSERT INTO `user` VALUES ('9999', '大声道', '1234', '9000.00');
