/*
 Navicat Premium Data Transfer

 Source Server         : MySQL 8.0
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:4306
 Source Schema         : std_ms

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 04/03/2026 16:40:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `cid` int NOT NULL AUTO_INCREMENT,
  `cname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `ccredit` int NULL DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, 'Java基础', 3);
INSERT INTO `course` VALUES (2, '数据结构', 6);
INSERT INTO `course` VALUES (3, '计算机网络', 3);
INSERT INTO `course` VALUES (4, '计算机组成原理', 4);
INSERT INTO `course` VALUES (5, '大作业实验上机', 3);

-- ----------------------------
-- Table structure for course_teacher
-- ----------------------------
DROP TABLE IF EXISTS `course_teacher`;
CREATE TABLE `course_teacher`  (
  `ctid` int NOT NULL AUTO_INCREMENT,
  `cid` int NULL DEFAULT NULL,
  `tid` int NULL DEFAULT NULL,
  `term` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`ctid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course_teacher
-- ----------------------------
INSERT INTO `course_teacher` VALUES (1, 2, 2, '25-春季学期');
INSERT INTO `course_teacher` VALUES (2, 1, 2, '25-春季学期');
INSERT INTO `course_teacher` VALUES (3, 4, 3, '25-春季学期');
INSERT INTO `course_teacher` VALUES (4, 3, 3, '25-春季学期');
INSERT INTO `course_teacher` VALUES (5, 5, 2, '25-春季学期');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `sid` int NOT NULL AUTO_INCREMENT,
  `sname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, 'suser1', '123456');
INSERT INTO `student` VALUES (2, 'suser2', '123456');
INSERT INTO `student` VALUES (3, 'suser3', '123456');
INSERT INTO `student` VALUES (4, 'suser4', '123456');
INSERT INTO `student` VALUES (5, 'suser4', '123456');
INSERT INTO `student` VALUES (6, 'suser6', '123456');
INSERT INTO `student` VALUES (7, 'suser7', '123456');
INSERT INTO `student` VALUES (8, 'suser8', '123456');
INSERT INTO `student` VALUES (9, 'suser8', '123456');
INSERT INTO `student` VALUES (10, 'suser10', '123456');
INSERT INTO `student` VALUES (11, 'suser11', '123456');
INSERT INTO `student` VALUES (12, 'suser12', '123456');
INSERT INTO `student` VALUES (13, 'suser13', '123456');
INSERT INTO `student` VALUES (14, 'suser14', '123456');
INSERT INTO `student` VALUES (15, 'suser15', '123456');
INSERT INTO `student` VALUES (16, 'super16', '123456');

-- ----------------------------
-- Table structure for student_course_teacher
-- ----------------------------
DROP TABLE IF EXISTS `student_course_teacher`;
CREATE TABLE `student_course_teacher`  (
  `sctid` int NOT NULL AUTO_INCREMENT,
  `sid` int NULL DEFAULT NULL,
  `cid` int NULL DEFAULT NULL,
  `tid` int NULL DEFAULT NULL,
  `grade` float NULL DEFAULT NULL,
  `term` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`sctid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_course_teacher
-- ----------------------------
INSERT INTO `student_course_teacher` VALUES (1, 2, 2, 2, 60, '25-春季学期');
INSERT INTO `student_course_teacher` VALUES (2, 2, 4, 3, 70, '25-春季学期');
INSERT INTO `student_course_teacher` VALUES (3, 2, 1, 2, 70, '25-春季学期');
INSERT INTO `student_course_teacher` VALUES (4, 4, 2, 2, 90, '25-春季学期');
INSERT INTO `student_course_teacher` VALUES (5, 4, 1, 2, 100, '25-春季学期');
INSERT INTO `student_course_teacher` VALUES (6, 4, 5, 3, NULL, '25-春季学期');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `tid` int NOT NULL AUTO_INCREMENT,
  `tname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`tid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, 'admin', 'admin');
INSERT INTO `teacher` VALUES (2, 'tuser2', '123');
INSERT INTO `teacher` VALUES (3, 'tuser3', '123');

SET FOREIGN_KEY_CHECKS = 1;
