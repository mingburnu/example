/*
SQLyog Community v8.32 
MySQL - 5.1.41-3ubuntu12.3 : Database - StarBooks
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`cb_starbookscdb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `cb_starbookscdb`;

/*Table structure for table `Publisher` */

DROP TABLE IF EXISTS `Publisher`;

CREATE TABLE `Publisher` (
  `publisherId` varchar(2) NOT NULL DEFAULT '',
  `publisherName` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`publisherId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `Publisher` */

insert  into `Publisher`(`publisherId`,`publisherName`) values ('AW','Addison-Wesley Professional'),('MP','Manning Publications'),('OA','O\'Reilly & Associates'),('PH','Prentice Hall PTR'),('WL','Wiley'),('WP','Wrox Press');

