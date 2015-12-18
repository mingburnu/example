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
-- Table structure for table `sellercontactinfo`
--

DROP TABLE IF EXISTS `sellercontactinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sellercontactinfo` (
  `contactInfoId` varchar(10) NOT NULL,
  `lastName` varchar(24) NOT NULL,
  `firstName` varchar(24) NOT NULL,
  `email` varchar(24) NOT NULL,
  PRIMARY KEY (`contactInfoId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sellercontactinfo`
--

LOCK TABLES `sellercontactinfo` WRITE;
/*!40000 ALTER TABLE `sellercontactinfo` DISABLE KEYS */;
INSERT INTO `sellercontactinfo` VALUES ('1','Brydon','Sean','abc@abc.xyz'),('10','Murray','Greg','abc@abc.xyz'),('100','Murray','Greg','abc@abc.xyz'),('101','Brydon','Sean','abc@abc.xyz'),('102','Singh','Inderjeet','abc@abc.xyz'),('11','Brydon','Sean','abc@abc.xyz'),('12','Singh','Inderjeet','abc@abc.xyz'),('13','Basler','Mark','abc@abc.xyz'),('14','Yoshida','Yutaka','abc@abc.xyz'),('15','Kangath','Smitha','abc@abc.xyz'),('16','Freeman','Larry','abc@abc.xyz'),('17','Kaul','Jeet','abc@abc.xyz'),('18','Burns','Ed','abc@abc.xyz'),('19','McClanahan','Craig','abc@abc.xyz'),('2','Singh','Inderjeet','abc@abc.xyz'),('20','Murray','Greg','abc@abc.xyz'),('21','Brydon','Sean','abc@abc.xyz'),('22','Singh','Inderjeet','abc@abc.xyz'),('23','Basler','Mark','abc@abc.xyz'),('24','Yoshida','Yutaka','abc@abc.xyz'),('25','Kangath','Smitha','abc@abc.xyz'),('26','Freeman','Larry','abc@abc.xyz'),('27','Kaul','Jeet','abc@abc.xyz'),('28','Burns','Ed','abc@abc.xyz'),('29','McClanahan','Craig','abc@abc.xyz'),('3','Basler','Mark','abc@abc.xyz'),('30','Murray','Greg','abc@abc.xyz'),('31','Brydon','Sean','abc@abc.xyz'),('32','Singh','Inderjeet','abc@abc.xyz'),('33','Basler','Mark','abc@abc.xyz'),('34','Yoshida','Yutaka','abc@abc.xyz'),('35','Kangath','Smitha','abc@abc.xyz'),('36','Freeman','Larry','abc@abc.xyz'),('37','Kaul','Jeet','abc@abc.xyz'),('38','Burns','Ed','abc@abc.xyz'),('39','McClanahan','Craig','abc@abc.xyz'),('4','Yoshida','Yutaka','abc@abc.xyz'),('40','Murray','Greg','abc@abc.xyz'),('41','Brydon','Sean','abc@abc.xyz'),('42','Singh','Inderjeet','abc@abc.xyz'),('43','Basler','Mark','abc@abc.xyz'),('44','Yoshida','Yutaka','abc@abc.xyz'),('45','Kangath','Smitha','abc@abc.xyz'),('46','Freeman','Larry','abc@abc.xyz'),('47','Kaul','Jeet','abc@abc.xyz'),('48','Burns','Ed','abc@abc.xyz'),('49','McClanahan','Craig','abc@abc.xyz'),('5','Kangath','Smitha','abc@abc.xyz'),('50','Murray','Greg','abc@abc.xyz'),('51','Brydon','Sean','abc@abc.xyz'),('52','Singh','Inderjeet','abc@abc.xyz'),('53','Basler','Mark','abc@abc.xyz'),('54','Yoshida','Yutaka','abc@abc.xyz'),('55','Kangath','Smitha','abc@abc.xyz'),('56','Freeman','Larry','abc@abc.xyz'),('57','Kaul','Jeet','abc@abc.xyz'),('58','Burns','Ed','abc@abc.xyz'),('59','McClanahan','Craig','abc@abc.xyz'),('6','Freeman','Larry','abc@abc.xyz'),('60','Murray','Greg','abc@abc.xyz'),('61','Brydon','Sean','abc@abc.xyz'),('62','Singh','Inderjeet','abc@abc.xyz'),('63','Basler','Mark','abc@abc.xyz'),('64','Yoshida','Yutaka','abc@abc.xyz'),('65','Kangath','Smitha','abc@abc.xyz'),('66','Freeman','Larry','abc@abc.xyz'),('67','Kaul','Jeet','abc@abc.xyz'),('68','Burns','Ed','abc@abc.xyz'),('69','McClanahan','Craig','abc@abc.xyz'),('7','Kaul','Jeet','abc@abc.xyz'),('70','Murray','Greg','abc@abc.xyz'),('71','Brydon','Sean','abc@abc.xyz'),('72','Singh','Inderjeet','abc@abc.xyz'),('73','Basler','Mark','abc@abc.xyz'),('74','Yoshida','Yutaka','abc@abc.xyz'),('75','Kangath','Smitha','abc@abc.xyz'),('76','Freeman','Larry','abc@abc.xyz'),('77','Kaul','Jeet','abc@abc.xyz'),('78','Burns','Ed','abc@abc.xyz'),('79','McClanahan','Craig','abc@abc.xyz'),('8','Burns','Ed','abc@abc.xyz'),('80','Murray','Greg','abc@abc.xyz'),('81','Brydon','Sean','abc@abc.xyz'),('82','Singh','Inderjeet','abc@abc.xyz'),('83','Basler','Mark','abc@abc.xyz'),('84','Yoshida','Yutaka','abc@abc.xyz'),('85','Kangath','Smitha','abc@abc.xyz'),('86','Freeman','Larry','abc@abc.xyz'),('87','Kaul','Jeet','abc@abc.xyz'),('88','Burns','Ed','abc@abc.xyz'),('89','McClanahan','Craig','abc@abc.xyz'),('9','McClanahan','Craig','abc@abc.xyz'),('90','Murray','Greg','abc@abc.xyz'),('91','Brydon','Sean','abc@abc.xyz'),('92','Singh','Inderjeet','abc@abc.xyz'),('93','Basler','Mark','abc@abc.xyz'),('94','Yoshida','Yutaka','abc@abc.xyz'),('95','Kangath','Smitha','abc@abc.xyz'),('96','Freeman','Larry','abc@abc.xyz'),('97','Kaul','Jeet','abc@abc.xyz'),('98','Burns','Ed','abc@abc.xyz'),('99','McClanahan','Craig','abc@abc.xyz');
/*!40000 ALTER TABLE `sellercontactinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-05-01 20:25:50
