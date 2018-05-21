/*
Navicat MySQL Data Transfer

Source Server         : music
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : enterprise

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2018-05-16 01:37:26
*/

SET FOREIGN_KEY_CHECKS=0;

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
-- Table structure for infomation
-- ----------------------------
DROP TABLE IF EXISTS `infomation`;
CREATE TABLE `infomation` (
  `title` varchar(100) NOT NULL DEFAULT '',
  `date` date NOT NULL,
  `header` text NOT NULL,
  `content` text NOT NULL,
  `digest` text NOT NULL,
  PRIMARY KEY (`title`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of infomation
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

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
INSERT INTO `user` VALUES ('12', '广东凯格网络科技有限公司', '147258012', '1');
DROP TRIGGER IF EXISTS `tri_infomation_filter
before`;
DELIMITER ;;
CREATE TRIGGER `tri_infomation_filter
before` BEFORE INSERT ON `infomation` FOR EACH ROW begin
		if (exists(select infomation.title from infomation where new.title=infomation.title))
        then
			delete from infomation where new.title=infomation.title;
		end if;
end
;;
DELIMITER ;
