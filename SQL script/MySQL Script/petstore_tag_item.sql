CREATE DATABASE  IF NOT EXISTS `petstore` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `petstore`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: petstore
-- ------------------------------------------------------
-- Server version	5.5.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tag_item`
--

DROP TABLE IF EXISTS `tag_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tag_item` (
  `tagId` int(11) NOT NULL,
  `itemId` varchar(10) NOT NULL,
  UNIQUE KEY `tagId` (`tagId`,`itemId`),
  KEY `itemId` (`itemId`),
  CONSTRAINT `tag_item_ibfk_1` FOREIGN KEY (`itemId`) REFERENCES `item` (`itemId`),
  CONSTRAINT `tag_item_ibfk_2` FOREIGN KEY (`tagId`) REFERENCES `tag` (`tagId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag_item`
--

LOCK TABLES `tag_item` WRITE;
/*!40000 ALTER TABLE `tag_item` DISABLE KEYS */;
INSERT INTO `tag_item` VALUES (1,'1'),(2,'1'),(3,'1'),(3,'10'),(4,'10'),(5,'100'),(5,'101'),(5,'102'),(5,'103'),(5,'104'),(5,'105'),(5,'106'),(5,'107'),(5,'108'),(5,'109'),(4,'11'),(5,'110'),(5,'111'),(5,'112'),(5,'113'),(5,'114'),(5,'115'),(5,'116'),(5,'117'),(4,'12'),(4,'13'),(4,'14'),(4,'15'),(4,'16'),(4,'17'),(4,'18'),(4,'19'),(1,'2'),(2,'2'),(3,'2'),(4,'20'),(4,'21'),(4,'22'),(4,'23'),(4,'24'),(4,'25'),(4,'26'),(4,'27'),(5,'28'),(5,'29'),(1,'3'),(3,'3'),(1,'4'),(3,'4'),(6,'401'),(6,'402'),(6,'403'),(6,'404'),(7,'405'),(7,'406'),(7,'407'),(7,'408'),(7,'409'),(7,'410'),(7,'411'),(7,'412'),(7,'413'),(7,'414'),(8,'415'),(8,'416'),(8,'417'),(8,'418'),(1,'5'),(3,'5'),(3,'6'),(3,'7'),(3,'8'),(4,'8'),(3,'9'),(4,'9');
/*!40000 ALTER TABLE `tag_item` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-05-01 20:25:45
