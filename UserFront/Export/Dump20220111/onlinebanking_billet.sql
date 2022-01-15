-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: onlinebanking
-- ------------------------------------------------------
-- Server version	5.7.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `billet`
--

DROP TABLE IF EXISTS `billet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `billet` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `journee_du` date DEFAULT NULL,
  `prix_billet` decimal(19,2) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `nbreplace` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKp9kdvx3cimr4gbv2knv4brjoy` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=52 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billet`
--

LOCK TABLES `billet` WRITE;
/*!40000 ALTER TABLE `billet` DISABLE KEYS */;
INSERT INTO `billet` VALUES (1,'2022-01-04',44.00,3,'11'),(2,'2022-01-04',44.00,3,'11'),(3,'2022-01-04',44.00,3,'111'),(4,'2022-01-04',17088.00,3,'1'),(5,'2022-01-04',2145.00,3,'1'),(6,'2022-01-04',44.00,3,'1'),(7,'2022-01-04',564654.00,3,'1'),(8,'2022-01-07',4344.00,3,'1'),(9,'2022-01-09',2337.00,3,'1'),(10,'2022-01-09',2037.00,3,'1'),(11,'2022-01-09',5454.00,3,'121'),(12,'2022-01-09',21.00,3,'21'),(13,'2022-01-09',444.00,3,'21'),(14,'2022-01-09',55.00,3,'212'),(15,'2022-01-09',44.00,3,'1'),(16,'2022-01-09',44.00,3,'1'),(17,'2022-01-09',55.00,3,'21'),(18,'2022-01-09',44.00,3,'1'),(19,'2022-01-09',55.00,3,'21'),(20,'2022-01-09',55.00,3,'21'),(21,'2022-01-09',44.00,3,'21'),(22,'2022-01-09',55.00,3,'21'),(24,'2022-01-10',66.00,3,'21'),(25,'2022-01-10',33.00,3,'21'),(26,'2022-01-10',44.00,3,'21'),(27,'2022-01-10',66.00,3,'21'),(28,'2022-01-10',11.00,3,'1'),(29,'2022-01-10',44.00,3,'21'),(30,'2022-01-10',44.00,3,'21'),(31,'2022-01-10',44.00,3,'1'),(32,'2022-01-10',44.00,3,'21'),(33,'2022-01-10',55.00,3,'21'),(34,'2022-01-10',11.00,3,'21'),(35,'2022-01-10',11.00,3,'21'),(36,'2022-01-10',1.00,3,'21'),(37,'2022-01-10',21.00,3,'21'),(38,'2022-01-10',44.00,3,'21'),(39,'2022-01-10',2.00,3,'21'),(40,'2022-01-10',44.00,3,'212'),(41,'2022-01-10',55.00,3,'21'),(42,'2022-01-10',33.00,3,'1'),(43,'2022-01-10',2.00,3,'21'),(44,'2022-01-10',4.00,3,'21'),(45,'2022-01-10',4.00,3,'88'),(46,'2022-01-10',111.00,3,'99'),(47,'2022-01-10',6.00,3,'77'),(48,'2022-01-10',4.00,3,'4'),(49,'2022-01-10',44.00,3,'4'),(50,'2022-01-10',4.00,3,'4'),(51,'2022-01-10',4.00,3,'4');
/*!40000 ALTER TABLE `billet` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-11 12:21:53