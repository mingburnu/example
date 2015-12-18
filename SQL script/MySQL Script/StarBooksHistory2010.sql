/*
SQLyog Community v8.32 
MySQL - 5.1.41-3ubuntu12.3 : Database - StarBooksHistory
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`StarBooksHistory` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `StarBooksHistory`;

/*Table structure for table `Author` */

DROP TABLE IF EXISTS `Author`;

CREATE TABLE `Author` (
  `authorId` int(11) NOT NULL AUTO_INCREMENT,
  `authorName` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`authorId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `Author` */

/*Table structure for table `Book` */

DROP TABLE IF EXISTS `Book`;

CREATE TABLE `Book` (
  `bookId` int(11) NOT NULL AUTO_INCREMENT,
  `isbn` varchar(10) NOT NULL DEFAULT '',
  `title` varchar(100) NOT NULL DEFAULT '',
  `releaseDate` datetime DEFAULT NULL,
  `listPrice` decimal(6,2) DEFAULT NULL,
  `pubId` varchar(2) NOT NULL DEFAULT '',
  `coverImage` longblob,
  PRIMARY KEY (`bookId`),
  KEY `pubId` (`pubId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `Book` */

/*Table structure for table `BookAuthor` */

DROP TABLE IF EXISTS `BookAuthor`;

CREATE TABLE `BookAuthor` (
  `bkId` int(11) NOT NULL DEFAULT '0',
  `arId` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`bkId`,`arId`),
  KEY `arId` (`arId`),
  CONSTRAINT `BookAuthor_ibfk_1` FOREIGN KEY (`arId`) REFERENCES `Author` (`authorId`),
  CONSTRAINT `BookAuthor_ibfk_2` FOREIGN KEY (`bkId`) REFERENCES `Book` (`bookId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `BookAuthor` */

/*Table structure for table `Publisher` */

DROP TABLE IF EXISTS `Publisher`;

CREATE TABLE `Publisher` (
  `publisherId` varchar(2) NOT NULL DEFAULT '',
  `publisherName` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`publisherId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `Publisher` */

/*Table structure for table `PublisherNoPK` */

DROP TABLE IF EXISTS `PublisherNoPK`;

CREATE TABLE `PublisherNoPK` (
  `publisherId` varchar(2) NOT NULL DEFAULT '',
  `publisherName` varchar(50) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `PublisherNoPK` */

/*Table structure for table `Reader` */

DROP TABLE IF EXISTS `Reader`;

CREATE TABLE `Reader` (
  `name` varchar(50) NOT NULL,
  `readerId` varchar(10) NOT NULL,
  `birthday` date DEFAULT NULL,
  `married` tinyint(1) DEFAULT '0',
  `maxAllowed` int(3) NOT NULL,
  `email` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`readerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `Reader` */

/* Procedure structure for procedure `books_of_a_publisher` */

/*!50003 DROP PROCEDURE IF EXISTS  `books_of_a_publisher` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `books_of_a_publisher`(IN pPublisherId VARCHAR(2))
BEGIN
  SELECT * FROM Book WHERE Book.pubId = pPublisherId;
END */$$
DELIMITER ;

/* Procedure structure for procedure `delete_reader` */

/*!50003 DROP PROCEDURE IF EXISTS  `delete_reader` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_reader`(IN rReaderId VARCHAR(10))
BEGIN
  DELETE FROM Reader WHERE readerId = rReaderId;
END */$$
DELIMITER ;

/* Procedure structure for procedure `find_all_readers` */

/*!50003 DROP PROCEDURE IF EXISTS  `find_all_readers` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `find_all_readers`()
BEGIN
  SELECT * FROM Reader;
END */$$
DELIMITER ;

/* Procedure structure for procedure `find_reader` */

/*!50003 DROP PROCEDURE IF EXISTS  `find_reader` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `find_reader`(IN rReaderId VARCHAR(10))
BEGIN
  SELECT * FROM Reader WHERE readerId = rReaderId;
END */$$
DELIMITER ;

/* Procedure structure for procedure `insert_reader` */

/*!50003 DROP PROCEDURE IF EXISTS  `insert_reader` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_reader`(IN rName VARCHAR(50), IN rReaderId VARCHAR(10), IN rBirthday DATE, IN rMarried TINYINT(1), IN rMaxAllowed INT(3), IN rEmail VARCHAR(50))
BEGIN
  INSERT INTO Reader VALUES (rName, rReaderId, rBirthday, rMarried, rMaxAllowed, rEmail);
END */$$
DELIMITER ;

/* Procedure structure for procedure `update_reader` */

/*!50003 DROP PROCEDURE IF EXISTS  `update_reader` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `update_reader`(IN rName VARCHAR(50), IN rReaderId VARCHAR(10), IN rBirthday DATE, IN rMarried TINYINT(1), IN rMaxAllowed INT(3), IN rEmail VARCHAR(50))
BEGIN
  UPDATE Reader SET NAME = rName, birthday = rBirthday, married = rMarried, maxAllowed = rMaxAllowed, email = rEmail WHERE readerId = rReaderId;
END */$$
DELIMITER ;

/*Table structure for table `BooksWithPublisherName` */

DROP TABLE IF EXISTS `BooksWithPublisherName`;

/*!50001 DROP VIEW IF EXISTS `BooksWithPublisherName` */;
/*!50001 DROP TABLE IF EXISTS `BooksWithPublisherName` */;

/*!50001 CREATE TABLE  `BooksWithPublisherName`(
 `isbn` varchar(10) ,
 `title` varchar(100) ,
 `releaseDate` datetime ,
 `listPrice` decimal(6,2) ,
 `coverImage` longblob ,
 `publisherName` varchar(50) 
)*/;

/*View structure for view BooksWithPublisherName */

/*!50001 DROP TABLE IF EXISTS `BooksWithPublisherName` */;
/*!50001 DROP VIEW IF EXISTS `BooksWithPublisherName` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `BooksWithPublisherName` AS select `Book`.`isbn` AS `isbn`,`Book`.`title` AS `title`,`Book`.`releaseDate` AS `releaseDate`,`Book`.`listPrice` AS `listPrice`,`Book`.`coverImage` AS `coverImage`,`Publisher`.`publisherName` AS `publisherName` from (`Book` join `Publisher` on((`Book`.`pubId` = `Publisher`.`publisherId`))) */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
