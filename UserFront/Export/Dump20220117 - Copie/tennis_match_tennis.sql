-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: Tennis
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
-- Table structure for table `match_tennis`
--

DROP TABLE IF EXISTS `match_tennis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `match_tennis` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `niveau` varchar(255) DEFAULT NULL,
  `billet_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbk80i5rprrhal9p7jam46h7bv` (`billet_id`),
  KEY `FK3ch6ng8k569avwrp2fgf37ejq` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=445 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `match_tennis`
--

LOCK TABLES `match_tennis` WRITE;
/*!40000 ALTER TABLE `match_tennis` DISABLE KEYS */;
INSERT INTO `match_tennis` VALUES (1,'Final',1,3),(2,'Qualification',50,3),(3,'Demi Final',51,3),(4,'Demi Final',4,3),(5,'Qualification',5,3),(6,'Qualification',6,3),(7,'Qualification',7,3),(8,'Qualification',8,3),(9,'Qualification',9,3),(10,'Qualification',10,3),(11,'Qualification',11,3),(12,'Qualification',12,3),(13,'Qualification',13,3),(14,'Qualification',14,3),(15,'Qualification',15,3),(16,'Qualification',16,3),(17,'Qualification',17,3),(18,'Qualification',18,3),(19,'Qualification',19,3),(20,'Qualification',20,3),(21,'Qualification',21,3),(22,'Qualification',22,3),(23,'Qualification',23,3),(24,'Qualification',24,3),(25,'Qualification',25,3),(26,'Qualification',26,3),(27,'Qualification',27,3),(28,'Qualification',28,3),(29,'Qualification',29,3),(30,'Qualification',30,3),(31,'Qualification',31,3),(32,'Qualification',32,3),(33,'Qualification',33,3),(34,'Qualification',34,3),(35,'Qualification',35,3),(36,'Qualification',36,3),(37,'Qualification',37,3),(38,'Qualification',38,3),(39,'Qualification',39,3),(40,'Qualification',40,3),(41,'Qualification',41,3),(42,'Qualification',42,3),(43,'Qualification',43,3),(44,'Qualification',44,3),(45,'Qualification',45,3),(46,'Qualification',46,3),(47,'Qualification',47,3),(48,'Qualification',48,3),(49,'Qualification',49,3),(50,'Qualification',2,3),(51,'Demi Final',3,3),(104,'Demi Final',4,3),(444,'Demi Final',51,3),(105,'Qualification',5,3),(106,'Qualification',6,3),(107,'Qualification',7,3),(108,'Qualification',8,3);
/*!40000 ALTER TABLE `match_tennis` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-17 10:05:33
