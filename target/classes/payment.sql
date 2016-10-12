/*
MySQL Data Transfer
Source Host: localhost
Source Database: payment
Target Host: localhost
Target Database: payment
Date: 10/8/2016 2:28:00 PM
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for account_logs
-- ----------------------------
DROP TABLE IF EXISTS `account_logs`;
CREATE TABLE `account_logs` (
  `ID` int(10) DEFAULT NULL,
  `USER_ID` int(10) DEFAULT NULL,
  `ACCT_ID` int(10) DEFAULT NULL,
  `POST_TIME` datetime DEFAULT NULL,
  `DESCRIPTION` varchar(128) DEFAULT NULL,
  `TYPE` varchar(20) DEFAULT NULL,
  `STATUS` varchar(16) DEFAULT NULL,
  `AMOUNT` double(20,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for easy_pay_account
-- ----------------------------
DROP TABLE IF EXISTS `easy_pay_account`;
CREATE TABLE `easy_pay_account` (
  `ID` int(10) DEFAULT NULL,
  `BALANCE` double(20,2) DEFAULT NULL,
  `USER_ID` int(10) DEFAULT NULL,
  `ACCT_NO` varchar(24) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for lottery
-- ----------------------------
DROP TABLE IF EXISTS `lottery`;
CREATE TABLE `lottery` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `CREATER_ID` int(10) DEFAULT NULL,
  `BET_AMOUNT` double(20,2) DEFAULT NULL,
  `TOTAL_AMOUNT` double(20,2) DEFAULT NULL,
  `END_DATETIME` datetime DEFAULT NULL,
  `WINNER_ID` int(10) DEFAULT NULL,
  `STATUS` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for lottery_users
-- ----------------------------
DROP TABLE IF EXISTS `lottery_users`;
CREATE TABLE `lottery_users` (
  `ID` int(10) DEFAULT NULL,
  `USER_ID` int(10) DEFAULT NULL,
  `AMOUNT` double(20,2) DEFAULT NULL,
  `LOTTERY_ID` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for system_bank_account
-- ----------------------------
DROP TABLE IF EXISTS `system_bank_account`;
CREATE TABLE `system_bank_account` (
  `ID` int(10) DEFAULT NULL,
  `BALANCE` double(20,2) DEFAULT NULL,
  `USER_ID` int(10) DEFAULT NULL,
  `ACCT_NO` varchar(24) DEFAULT NULL,
  `BANK_NAME` varchar(128) DEFAULT NULL,
  `SWIFT_CODE` varchar(20) DEFAULT NULL,
  `COUNTRY` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for transactions
-- ----------------------------
DROP TABLE IF EXISTS `transactions`;
CREATE TABLE `transactions` (
  `ID` int(10) DEFAULT NULL,
  `BALANCE` double(20,2) DEFAULT NULL,
  `USER_ID` int(10) DEFAULT NULL,
  `FROM_ACCT_ID` int(10) DEFAULT NULL,
  `POST_TIME` datetime DEFAULT NULL,
  `DESCRIPTION` varchar(128) DEFAULT NULL,
  `TYPE` varchar(20) DEFAULT NULL,
  `STATUS` varchar(16) DEFAULT NULL,
  `AMOUNT` double(20,2) DEFAULT NULL,
  `TO_ACCOUNT_ID` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(255) DEFAULT NULL,
  `LAST_NAME` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(64) DEFAULT NULL,
  `PHONE` varchar(20) DEFAULT NULL,
  `PASSWORD` varchar(64) DEFAULT NULL,
  `SALT` varchar(64) DEFAULT NULL,
  `CREATED_AT` datetime DEFAULT NULL,
  `UPDATED_AT` datetime DEFAULT NULL,
  `DELETED_AT` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for user_bank_account
-- ----------------------------
DROP TABLE IF EXISTS `user_bank_account`;
CREATE TABLE `user_bank_account` (
  `ID` int(10) DEFAULT NULL,
  `BALANCE` double(20,2) DEFAULT NULL,
  `USER_ID` int(10) DEFAULT NULL,
  `ACCT_NO` varchar(24) DEFAULT NULL,
  `BANK_NAME` varchar(128) DEFAULT NULL,
  `SWIFT_CODE` varchar(20) DEFAULT NULL,
  `COUNTRY` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for user_relations
-- ----------------------------
DROP TABLE IF EXISTS `user_relations`;
CREATE TABLE `user_relations` (
  `user1_id` int(10) NOT NULL,
  `user2_id` int(10) NOT NULL,
  `relaction_type` varchar(16) NOT NULL,
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'Was', 'San', 'ss@ss.com', '15033443322', '2332', '34', '2016-10-05 14:04:41', null, null);
