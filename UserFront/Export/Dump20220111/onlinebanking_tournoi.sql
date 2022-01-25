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
-- Table structure for table `tournoi`
--

DROP TABLE IF EXISTS `tournoi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tournoi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_debut_tournoi` tinyblob,
  `date_fin_tournoi` tinyblob,
  `nbr_inscrit` varchar(255) DEFAULT NULL,
  `nbr_tour` varchar(255) DEFAULT NULL,
  `nbre_joueurs_max` varchar(255) DEFAULT NULL,
  `nom_tournoi` varchar(255) DEFAULT NULL,
  `billet_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhcxortt5e2lfinuhpp2hyb360` (`billet_id`),
  KEY `FKefutp082fgb6sylq53ie254qd` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tournoi`
--

LOCK TABLES `tournoi` WRITE;
/*!40000 ALTER TABLE `tournoi` DISABLE KEYS */;
INSERT INTO `tournoi` VALUES (1,NULL,NULL,'2','2','2','nom tournoi1',1,3),(3,NULL,NULL,NULL,NULL,NULL,'nom tournoi1',NULL,3),(4,NULL,NULL,NULL,NULL,NULL,'nom tournoi1',NULL,3),(5,NULL,NULL,NULL,NULL,NULL,'nom tournoi1',24,3),(6,NULL,NULL,NULL,NULL,NULL,'nom tournoi1',25,3),(7,NULL,NULL,NULL,NULL,NULL,'nom tournoi1',26,3),(8,NULL,NULL,NULL,NULL,NULL,'nom tournoi1',27,3),(9,NULL,NULL,NULL,NULL,NULL,'nom tournoi1',28,3),(10,NULL,NULL,NULL,NULL,NULL,'nom tournoi1',29,3),(11,NULL,NULL,NULL,NULL,NULL,'nom tournoi1',30,3),(12,NULL,NULL,NULL,NULL,NULL,'nom tournoi1',34,3),(13,NULL,NULL,NULL,NULL,NULL,'nom tournoi1',35,3),(14,NULL,NULL,NULL,NULL,NULL,'nom tournoi1',36,3),(15,NULL,NULL,NULL,NULL,NULL,'nom tournoi1',37,3),(16,NULL,NULL,NULL,NULL,NULL,'nom tournoi1',38,3),(17,NULL,NULL,NULL,NULL,NULL,'nom tournoi1',39,3),(18,NULL,NULL,NULL,NULL,NULL,'nom tournoi1',40,3),(19,NULL,NULL,NULL,NULL,NULL,'nom tournoi1',41,3),(20,NULL,NULL,NULL,NULL,NULL,'nom tournoi1',42,3),(21,NULL,NULL,NULL,NULL,NULL,'nom tournoi1',43,3),(22,NULL,NULL,NULL,NULL,NULL,'nom tournoi1',44,3),(23,NULL,NULL,NULL,NULL,NULL,'nom tournoi1',45,3),(24,NULL,NULL,NULL,NULL,NULL,'nom tournoi1',46,3),(25,NULL,NULL,NULL,NULL,NULL,'nom tournoi1',47,3),(26,NULL,NULL,NULL,NULL,NULL,'nom tournoi1',48,3),(27,NULL,NULL,NULL,NULL,NULL,'nom tournoi1',49,3),(28,NULL,NULL,NULL,NULL,NULL,'nom tournoi1',50,3),(29,NULL,NULL,NULL,NULL,NULL,'nom tournoi51',51,3);
/*!40000 ALTER TABLE `tournoi` ENABLE KEYS */;
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
