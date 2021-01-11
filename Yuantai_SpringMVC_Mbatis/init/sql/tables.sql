/*
SQLyog 企业版 - MySQL GUI v7.14 
MySQL - 5.6.16-log : Database - 
*********************************************************************
*/

/*表结构插入*/
DROP TABLE IF EXISTS `counry_code`;

CREATE TABLE `counry_code` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `country` varchar(256) DEFAULT NULL COMMENT '国家',
  `code` varchar(64) DEFAULT NULL COMMENT '代码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Table structure for table `u_role` */
DROP TABLE IF EXISTS `service_mode`;

CREATE TABLE `service_mode` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `servicemode` varchar(256) DEFAULT NULL COMMENT '服务方式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `Logistics_mode`;

CREATE TABLE `Logistics_mode` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Logistics` varchar(256) DEFAULT NULL COMMENT '物流方式',
  `servicemode` varchar(256) DEFAULT NULL COMMENT '服务方式',  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Table structure for table `u_role_permission` */

DROP TABLE IF EXISTS `postage_calc_mode`;

CREATE TABLE `postage_calc_mode` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `countrycode` varchar(64) DEFAULT NULL COMMENT '国家编码',
  `servicemode` varchar(256) DEFAULT NULL COMMENT '服务方式',    
  `Logistics` varchar(256) DEFAULT NULL COMMENT '物流方式',  
  `calculation` varchar(256) DEFAULT NULL COMMENT '计算方法',  

  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `postage_value`;
CREATE TABLE `postage_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `weight` bigint(20) DEFAULT NULL COMMENT '重量',    
  `countrycode` varchar(64) DEFAULT NULL COMMENT '国家编码',
  `servicemode` varchar(256) DEFAULT NULL COMMENT '服务方式',    
  `Logistics` varchar(256) DEFAULT NULL COMMENT '物流方式',  
  `calculation` varchar(256) DEFAULT NULL COMMENT '邮费值',  

  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

