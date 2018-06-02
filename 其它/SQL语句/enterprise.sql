/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : enterprise

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2018-06-02 11:31:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `commentId` int(11) NOT NULL AUTO_INCREMENT,
  `entId` varchar(255) NOT NULL,
  `commentType` int(11) NOT NULL,
  `Id` int(11) NOT NULL,
  `commentDate` datetime NOT NULL,
  `commentContent` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`commentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for demand
-- ----------------------------
DROP TABLE IF EXISTS `demand`;
CREATE TABLE `demand` (
  `entId` varchar(30) NOT NULL,
  `demandId` int(11) NOT NULL AUTO_INCREMENT,
  `demandType` varchar(40) NOT NULL,
  `demandTitle` varchar(100) NOT NULL,
  `demandDigest` text NOT NULL,
  `demandContent` text NOT NULL,
  `demandDate` date NOT NULL,
  PRIMARY KEY (`demandId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of demand
-- ----------------------------

-- ----------------------------
-- Table structure for demand_admin
-- ----------------------------
DROP TABLE IF EXISTS `demand_admin`;
CREATE TABLE `demand_admin` (
  `entId` varchar(30) NOT NULL,
  `demandId` int(11) NOT NULL AUTO_INCREMENT,
  `demandType` varchar(40) NOT NULL,
  `demandTitle` varchar(100) NOT NULL,
  `demandDigest` text NOT NULL,
  `demandContent` text NOT NULL,
  `demandDate` date NOT NULL,
  PRIMARY KEY (`demandId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of demand_admin
-- ----------------------------

-- ----------------------------
-- Table structure for enterpriseinf
-- ----------------------------
DROP TABLE IF EXISTS `enterpriseinf`;
CREATE TABLE `enterpriseinf` (
  `entId` varchar(30) NOT NULL,
  `entName` varchar(100) NOT NULL,
  `entPerson` varchar(10) NOT NULL,
  `entCategory` varchar(20) NOT NULL,
  `entBrief` text NOT NULL,
  `entIntroduction` text NOT NULL,
  `entAddress` text NOT NULL,
  `entSize` varchar(30) NOT NULL,
  `entPhone` varchar(20) NOT NULL,
  `entPassword` varchar(25) NOT NULL,
  `entIdentity` int(1) NOT NULL,
  `entWebsize` varchar(50) NOT NULL,
  `entDate` date NOT NULL,
  PRIMARY KEY (`entId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of enterpriseinf
-- ----------------------------
INSERT INTO `enterpriseinf` VALUES ('daiyuancheng@xdf.cn', '新东方教育科技集团有限公司', '俞敏洪', '教育', '新东方教育科技集团有限公司于2001-08-02在海淀分局登记成立。法定代表人俞敏洪，公司经营范围包括技术开发、技术咨询、技术服务、技术转让；教育咨询等。', '新东方，全名北京新东方教育科技（集团）有限公司，总部位于北京市海淀区中关村，是规模大的综合性教育集团，同时也是教育培训集团。公司业务包括外语培训、中小学基础教育、学前教育、在线教育、出国咨询、图书出版等各个领域。除新东方外，旗下还有优能中学教育、泡泡少儿教育、前途出国咨询、迅程在线教育、大愚文化出版、满天星亲子教育、同文高考复读等子品牌。公司于2006年在美国纽约证券交易所上市，是中国大陆第一家在美国上市的教育机构。新东方教育科技集团由1993年11月16日成立的北京新东方学校发展壮大而来，集团以培训为核心，拥有满天星幼儿园、泡泡少儿教育、优能中学教育、基础英语培训、大学英语及考研培训、出国考试培训、多语种培训等多个培训体系，同时在基础教育、职业教育、教育研发、出国咨询、文化产业等方面取得了骄人的成绩。作为中国著名私立教育机构，新东方教育科技集团于2006年9月7日在美国纽约证券交易所成功上市。截止2014年5月，新东方已经在全国50座城市设立了56所学校、31家书店以及703家学习中心。自成立以来，新东方累计面授学员2000万人次。', '北京市海淀区海淀中街6号9层', '2000万人以上', '010-60908000', 'xindognfang', '1', 'www.xdf.cn', '2001-08-02');

-- ----------------------------
-- Table structure for industrydata
-- ----------------------------
DROP TABLE IF EXISTS `industrydata`;
CREATE TABLE `industrydata` (
  `indType` varchar(40) NOT NULL,
  `indTitle` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `indDate` date NOT NULL,
  `indContent` text NOT NULL,
  `indDigest` text NOT NULL,
  PRIMARY KEY (`indTitle`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of industrydata
-- ----------------------------

-- ----------------------------
-- Table structure for information
-- ----------------------------
DROP TABLE IF EXISTS `information`;
CREATE TABLE `information` (
  `infType` varchar(40) NOT NULL,
  `infTitle` varchar(100) NOT NULL,
  `infDate` date NOT NULL,
  `infContent` text NOT NULL,
  `infDigest` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`infTitle`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of information
-- ----------------------------

-- ----------------------------
-- Table structure for provide
-- ----------------------------
DROP TABLE IF EXISTS `provide`;
CREATE TABLE `provide` (
  `entId` varchar(30) NOT NULL,
  `proId` int(11) NOT NULL AUTO_INCREMENT,
  `proType` varchar(40) NOT NULL,
  `proTitle` varchar(100) NOT NULL,
  `proDigest` text NOT NULL,
  `proContent` text NOT NULL,
  `proDate` date NOT NULL,
  PRIMARY KEY (`proId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of provide
-- ----------------------------

-- ----------------------------
-- Table structure for provide_admin
-- ----------------------------
DROP TABLE IF EXISTS `provide_admin`;
CREATE TABLE `provide_admin` (
  `entId` varchar(30) NOT NULL,
  `proId` int(11) NOT NULL AUTO_INCREMENT,
  `proType` varchar(40) NOT NULL,
  `proTitle` varchar(100) NOT NULL,
  `proDigest` text NOT NULL,
  `proContent` text NOT NULL,
  `proDate` date NOT NULL,
  PRIMARY KEY (`proId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of provide_admin
-- ----------------------------

-- ----------------------------
-- Table structure for register
-- ----------------------------
DROP TABLE IF EXISTS `register`;
CREATE TABLE `register` (
  `entId` varchar(30) NOT NULL,
  `entName` varchar(100) NOT NULL,
  `entPerson` varchar(10) NOT NULL,
  `entCategory` varchar(20) NOT NULL,
  `entBrief` text NOT NULL,
  `entIntroduction` text NOT NULL,
  `entAddress` text NOT NULL,
  `entSize` varchar(30) NOT NULL,
  `entPhone` varchar(20) NOT NULL,
  `entPassword` varchar(25) NOT NULL,
  `entIdentity` int(1) NOT NULL,
  `entWebsize` varchar(50) NOT NULL,
  `entDate` date NOT NULL,
  PRIMARY KEY (`entId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of register
-- ----------------------------
