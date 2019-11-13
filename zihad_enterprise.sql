/*
MySQL Data Transfer
Source Host: localhost
Source Database: zihad_enterprise
Target Host: localhost
Target Database: zihad_enterprise
Date: 2/11/2017 5:23:58 PM
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for company_info
-- ----------------------------
DROP TABLE IF EXISTS `company_info`;
CREATE TABLE `company_info` (
  `company_name` varchar(50) NOT NULL,
  `email` varchar(30) DEFAULT NULL,
  `website` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`company_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for emp_payment
-- ----------------------------
DROP TABLE IF EXISTS `emp_payment`;
CREATE TABLE `emp_payment` (
  `payment_id` int(10) NOT NULL AUTO_INCREMENT,
  `emp_id` int(10) DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `pay_date` varchar(30) DEFAULT NULL,
  `payment_month` varchar(30) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`payment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for employee_info
-- ----------------------------
DROP TABLE IF EXISTS `employee_info`;
CREATE TABLE `employee_info` (
  `emp_id` int(10) NOT NULL AUTO_INCREMENT,
  `emp_firstname` varchar(20) DEFAULT NULL,
  `emp_lastname` varchar(20) DEFAULT NULL,
  `phn_num` varchar(15) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for product_info
-- ----------------------------
DROP TABLE IF EXISTS `product_info`;
CREATE TABLE `product_info` (
  `product_id` int(10) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(50) DEFAULT NULL,
  `company_name` varchar(50) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `FK1` (`company_name`),
  CONSTRAINT `FK1` FOREIGN KEY (`company_name`) REFERENCES `company_info` (`company_name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for stock
-- ----------------------------
DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock` (
  `product_id` int(10) NOT NULL,
  `unit_price` double DEFAULT NULL,
  `sell_price` double DEFAULT NULL,
  `quantity` int(10) DEFAULT NULL,
  `total_cost` double DEFAULT NULL,
  `in_date` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `company_info` VALUES ('A1 Polimar', 'a1@gmail.com', 'a1.com');
INSERT INTO `company_info` VALUES ('aaa', 'aaa@gmail.com', 'www.aaa.com');
INSERT INTO `company_info` VALUES ('abr', 'abc@gmail.com', 'acb.com');
INSERT INTO `company_info` VALUES ('ACI', 'aci123@gmail.com', 'aci.info');
INSERT INTO `company_info` VALUES ('Bengol', 'bengol@gmail.com', 'www.bengol.com');
INSERT INTO `company_info` VALUES ('RAK', 'rak@gamil.com', 'rak.com');
INSERT INTO `emp_payment` VALUES ('11', '1', '10000', '10/02/2017', 'January', 'Yes');
INSERT INTO `emp_payment` VALUES ('12', '2', '8000', '10/02/2017', 'February', 'Yes');
INSERT INTO `employee_info` VALUES ('1', 'rayhan', 'mahmud', '11111111', 'ggggggggg');
INSERT INTO `employee_info` VALUES ('2', 'mahnud', 'rayhan', '156', 'fddfdg');
INSERT INTO `employee_info` VALUES ('3', '', '', '', '');
INSERT INTO `product_info` VALUES ('2', 'fg', 'ACI', 'jhgj');
INSERT INTO `product_info` VALUES ('3', 'Pipe GI', 'A1 Polimar', '6\'');
INSERT INTO `product_info` VALUES ('5', 'TTT', 'ACI', '15\'');
INSERT INTO `product_info` VALUES ('6', 'tt', 'ACI', '12\'');
INSERT INTO `product_info` VALUES ('7', 'Mirror', 'ACI', 'Nice');
INSERT INTO `product_info` VALUES ('8', 'Tank', 'RAK', '1200 litter');
INSERT INTO `product_info` VALUES ('9', 'pipe', 'abr', 'asd');
INSERT INTO `stock` VALUES ('1', '100', '465.465', '50', '293632.84', '09/02/2017');
INSERT INTO `stock` VALUES ('2', '100', '150', '22', '500', '24/02/2017');
INSERT INTO `stock` VALUES ('6', '456', '500', '45', '20520', '09/02/2017');
INSERT INTO `stock` VALUES ('7', '1200', '1450', '20', '24000', '15/02/2017');
INSERT INTO `stock` VALUES ('8', '100', '120', '50', '3000', '17/02/2017');
INSERT INTO `stock` VALUES ('9', '10', '20', '100', '1000', '04/02/2017');
