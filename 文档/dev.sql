/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : dev

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 10/03/2021 09:57:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_cjgly
-- ----------------------------
DROP TABLE IF EXISTS `tb_cjgly`;
CREATE TABLE `tb_cjgly`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `zh` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mm` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_cjgly
-- ----------------------------
INSERT INTO `tb_cjgly` VALUES ('1', 'admin', 'admin', '超级管理员');

-- ----------------------------
-- Table structure for tb_ewm
-- ----------------------------
DROP TABLE IF EXISTS `tb_ewm`;
CREATE TABLE `tb_ewm`  (
  `ewmid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ewmsj` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`ewmid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_ewm
-- ----------------------------
INSERT INTO `tb_ewm` VALUES ('ewm001-ncp001-1', 'http://localhost:8080/ncpsy/info/product-info?ncpid=ncp001-1');
INSERT INTO `tb_ewm` VALUES ('ewm002-ncp002-1', 'http://localhost:8080/ncpsy/info/product-info?ncpid=ncp002-1');

-- ----------------------------
-- Table structure for tb_ncp
-- ----------------------------
DROP TABLE IF EXISTS `tb_ncp`;
CREATE TABLE `tb_ncp`  (
  `ncpid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ncpmc` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cd` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pz` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ccrq` date NULL DEFAULT NULL,
  `zzfs` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `qyid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ewmid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`ncpid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_ncp
-- ----------------------------
INSERT INTO `tb_ncp` VALUES ('ncp001-1', '苹果01', '烟台栖霞', '红富士', '2021-03-08', '土壤', '1', 'ewm001-ncp001-1');
INSERT INTO `tb_ncp` VALUES ('ncp002-1', '西红柿02', '广东大鹏', '圣女果', '2021-03-08', '水培育', '1', 'ewm002-ncp002-1');

-- ----------------------------
-- Table structure for tb_qy
-- ----------------------------
DROP TABLE IF EXISTS `tb_qy`;
CREATE TABLE `tb_qy`  (
  `qyid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `zh` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `mm` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `qymc` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dz` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fzr` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dh` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `yx` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bz` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`qyid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_qy
-- ----------------------------
INSERT INTO `tb_qy` VALUES ('1', 'user', 'user', '帅出天际企业', '北京', '大帅', '13566668888', '8290@qq.com', '蓬勃发展');

-- ----------------------------
-- Table structure for tb_syly
-- ----------------------------
DROP TABLE IF EXISTS `tb_syly`;
CREATE TABLE `tb_syly`  (
  `syid` varchar(222) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `syip` varchar(222) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sysj` date NULL DEFAULT NULL,
  `syncpid` varchar(222) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `syqyid` varchar(222) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_syly
-- ----------------------------
INSERT INTO `tb_syly` VALUES ('syly-20210309185812-1', '0:0:0:0:0:0:0:1', '2021-03-09', 'ncp001-1', '1');
INSERT INTO `tb_syly` VALUES ('syly-20210309185821-2', '0:0:0:0:0:0:0:1', '2021-03-09', 'ncp002-1', '1');
INSERT INTO `tb_syly` VALUES ('syly-20210309190346-3', '0:0:0:0:0:0:0:1', '2021-03-09', 'ncp002-1', '1');

SET FOREIGN_KEY_CHECKS = 1;
