/*
Navicat MySQL Data Transfer

Source Server         : music
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : enterprise

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2018-05-08 22:45:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(15) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) NOT NULL,
  `password` varchar(30) NOT NULL,
  `identity` int(2) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '北京阿里巴巴信息技术有限公司', '147258001', '1');
INSERT INTO `user` VALUES ('2', '支付宝（中国）信息技术有限公司', '147258002', '1');
INSERT INTO `user` VALUES ('3', '北京京东世纪贸易有限公司', '147258003', '1');
INSERT INTO `user` VALUES ('4', '上海精锐教育培训有限公司', '147258004', '1');
INSERT INTO `user` VALUES ('5', '国华生命科学研究院有限公司', '147258005', '1');
INSERT INTO `user` VALUES ('6', '深圳市新纶科技股份有限公司', '147258006', '1');
INSERT INTO `user` VALUES ('7', '新东网科技有限公司', '147258007', '1');
INSERT INTO `user` VALUES ('8', '金发科技股份有限公司', '147258008', '1');
INSERT INTO `user` VALUES ('9', '上海中晶科技有限公司', '147258009', '1');
INSERT INTO `user` VALUES ('10', '上海延华智能科技(集团)股份有限公司', '147258010', '1');
INSERT INTO `user` VALUES ('11', '北京华力创通科技股份有限公司', '147258011', '1');
