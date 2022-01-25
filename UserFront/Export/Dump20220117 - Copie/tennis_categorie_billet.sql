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
-- Table structure for table `categorie_billet`
--

DROP TABLE IF EXISTS `categorie_billet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorie_billet` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `categorie_billet_enum_string` varchar(255) DEFAULT NULL,
  `billet_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4opgodmbt4890s7m4rijvwpc9` (`billet_id`),
  KEY `FKneunxaid7ej6qtuqwcuu5u067` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=52 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorie_billet`
--

LOCK TABLES `categorie_billet` WRITE;
/*!40000 ALTER TABLE `categorie_billet` DISABLE KEYS */;
INSERT INTO `categorie_billet` VALUES (1,'Billet grand public licencié',1,3),(2,'Billet grand public licencié',2,3),(3,'Billet grand public licencié',3,3),(4,'Billet grand public licencié',4,3),(5,'Billet grand public licencié',5,3),(6,'Billet grand public licencié',6,3),(7,'Billet grand public licencié',7,3),(8,'Billet grand public licencié',8,3),(9,'Billet grand public licencié',9,3),(10,'Billet big match licencié',10,3),(11,'Billet grand public licencié',11,3),(12,'Billet grand public licencié',12,3),(13,'Billet big match non licencié',13,3),(14,'Billet grand public non licencié',14,3),(15,'Billet grand public licencié',15,3),(16,'Billet grand public licencié',16,3),(17,'Billet grand public licencié',17,3),(18,'Billet grand public licencié',18,3),(19,'Billet grand public licencié',19,3),(20,'Billet grand public licencié',20,3),(21,'Billet grand public licencié',21,3),(22,'Billet grand public licencié',22,3),(23,'Billet grand public licencié',23,3),(24,'Billet grand public non licencié',24,3),(25,'Billet grand public licencié',25,3),(26,'Billet grand public licencié',26,3),(27,'Billet grand public non licencié',27,3),(28,'Billet grand public licencié',28,3),(29,'Billet grand public licencié',29,3),(30,'Billet grand public licencié',30,3),(31,'Billet grand public licencié',31,3),(32,'Billet grand public licencié',32,3),(33,'Billet grand public licencié',33,3),(34,'Billet grand public non licencié',34,3),(35,'Billet big match licencié',35,3),(36,'Billet grand public licencié',36,3),(37,'Billet grand public licencié',37,3),(38,'Billet big match licencié',38,3),(39,'Billet grand public licencié',39,3),(40,'Billet grand public non licencié',40,3),(41,'Billet grand public licencié',41,3),(42,'Billet grand public licencié',42,3),(43,'Billet grand public licencié',43,3),(44,'Billet big match licencié',44,3),(45,'Billet big match licencié',45,3),(46,'Billet grand public licencié',46,3),(47,'Billet big match licencié',47,3),(48,'Billet big match licencié',48,3),(49,'Billet grand public non licencié',49,3),(50,'Billet big match non licencié',50,3),(51,'Billet big match licencié',51,3);
/*!40000 ALTER TABLE `categorie_billet` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-17 10:05:35
