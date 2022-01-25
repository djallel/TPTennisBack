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
-- Table structure for table `emplacement`
--

DROP TABLE IF EXISTS `emplacement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emplacement` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) DEFAULT NULL,
  `billet_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKf5o3y7vdw0v8uqkxif22av2ie` (`billet_id`),
  KEY `FKd6ty18l9ahde53nm2i7psgoel` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=52 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emplacement`
--

LOCK TABLES `emplacement` WRITE;
/*!40000 ALTER TABLE `emplacement` DISABLE KEYS */;
INSERT INTO `emplacement` VALUES (1,'Court Central',51,3),(2,'Court Annexe',50,3),(3,'Court Annexe',49,3),(4,'Court Annexe',48,3),(5,'Court Annexe',47,3),(6,'Court Annexe',46,3),(7,'Court Annexe',45,3),(8,'Court Annexe',44,3),(9,'Court Annexe',43,3),(10,'Court Annexe',42,3),(11,'Court Annexe',41,3),(12,'Court Annexe',40,3),(13,'Court Annexe',39,3),(14,'Court Annexe',38,3),(15,'Court Annexe',37,3),(16,'Court Annexe',36,3),(17,'Court Annexe',35,3),(18,'Court Annexe',34,3),(19,'Court Annexe',33,3),(20,'Court Annexe',32,3),(21,'Court Annexe',31,3),(22,'Court Annexe',30,3),(23,'Court Annexe',29,3),(24,'Court Annexe',28,3),(25,'Court Annexe',27,3),(26,'Court Annexe',26,3),(27,'Court Annexe',25,3),(28,'Court Annexe',24,3),(29,'Court Annexe',23,3),(30,'Court Annexe',22,3),(31,'Court Annexe',21,3),(32,'Court Annexe',20,3),(33,'Court Annexe',19,3),(34,'Court Annexe',18,3),(35,'Court Annexe',17,3),(36,'Court Annexe',16,3),(37,'Court Annexe',15,3),(38,'Court Annexe',14,3),(39,'Court Annexe',13,3),(40,'Court Annexe',12,3),(41,'Court Annexe',11,3),(42,'Court Annexe',10,3),(43,'Court Annexe',9,3),(44,'Court Annexe',8,3),(45,'Court Annexe',7,3),(46,'Court Annexe',6,3),(47,'Court Annexe',5,3),(48,'Court Annexe',4,3),(49,'Court Annexe',3,3),(50,'Court Annexe',2,3),(51,'Court Annexe',1,3);
/*!40000 ALTER TABLE `emplacement` ENABLE KEYS */;
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
