# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.6.38)
# Database: api_vue
# Generation Time: 2018-11-29 06:43:28 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table api_interface
# ------------------------------------------------------------

DROP TABLE IF EXISTS `api_interface`;

create table `api_interface`(
  `id` int primary key auto_increment,
  `interface_project_id` int not null comment '外键，项目id',
  `interface_name` varchar(20) not null comment '接口名称',
  `interface_use` varchar(50) not null comment '接口用途',
  `interface_type` int(1) default 1 comment '请求方式',
  `interface_url` varchar(255) not null comment '接口地址',
  `interface_params` text default null comment '接口参数(json)字符串',
  `interface_json` text not null comment '接口返回结果(json字符串)',
  `interface_note` varchar(255) comment '接口备注',
  `created_at` mediumtext,
  `updated_at` mediumtext,
  `status` int(1) default 1,
  foreign key (`interface_project_id`) references `api_project`(`id`)
)comment = '接口表';



# Dump of table api_project
# ------------------------------------------------------------

DROP TABLE IF EXISTS `api_project`;

CREATE TABLE `api_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL COMMENT '项目名称',
  `info` text NOT NULL COMMENT '项目简介',
  `user_id` int(11) NOT NULL COMMENT '创建者编号',
  `created_at` mediumtext,
  `updated_at` mediumtext,
  `status` int(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `api_project_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `api_users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目信息表';

LOCK TABLES `api_project` WRITE;
/*!40000 ALTER TABLE `api_project` DISABLE KEYS */;

INSERT INTO `api_project` (`id`, `name`, `info`, `user_id`, `created_at`, `updated_at`, `status`)
VALUES
	(1,'1321312321','hahahahha',1,'1543200283141','1543200283141',1),
	(2,'1321312321','hahahahha',1,'1543200389036','1543200389036',1),
	(3,'1321312321','hahahahha',1,'1543200454805','1543200454805',1),
	(4,'1321312321','hahahahha',1,'1543200571380','1543200571381',1),
	(5,'1321312321','hahahahha',1,'1543200769629','1543200769629',1),
	(6,'阿里巴巴的淘宝','阿里旗下最牛逼的网站',1,'1543200887502','1543200887502',1),
	(7,'就是这么尿性','怎么了，我骄傲了吗？',1,'1543201044734','1543201044734',1),
	(8,'ali','alililili',1,'1543201095175','1543201095175',1),
	(9,'fafdsa','fdsafdsafdsa',1,'1543279925504','1543279925504',1);

/*!40000 ALTER TABLE `api_project` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table api_users
# ------------------------------------------------------------

DROP TABLE IF EXISTS `api_users`;

CREATE TABLE `api_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户账号',
  `password` varchar(64) NOT NULL COMMENT '用户密码',
  `nickname` varchar(20) NOT NULL COMMENT '用户昵称',
  `token` varchar(64) DEFAULT NULL COMMENT '用户标示',
  `created_at` mediumtext,
  `updated_at` mediumtext,
  `status` int(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';

LOCK TABLES `api_users` WRITE;
/*!40000 ALTER TABLE `api_users` DISABLE KEYS */;

INSERT INTO `api_users` (`id`, `username`, `password`, `nickname`, `token`, `created_at`, `updated_at`, `status`)
VALUES
	(1,'aileshang0226@163.com','846e6e9c4e43735ca04c6af632ce565e','jack','59c9672dc5abd181f2aa650ca62c94c8',NULL,NULL,1);

/*!40000 ALTER TABLE `api_users` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
