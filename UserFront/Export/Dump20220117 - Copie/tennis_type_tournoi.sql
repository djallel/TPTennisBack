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
-- Table structure for table `type_tournoi`
--

DROP TABLE IF EXISTS `type_tournoi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type_tournoi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description_messieur` varchar(255) DEFAULT NULL,
  `tournoi_id` bigint(20) DEFAULT NULL,
  `billet_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2m9v60ecobaq0iviv9upb9nsr` (`billet_id`),
  KEY `FK8glf7v90frvtjg4ydfambpfg8` (`tournoi_id`),
  KEY `FK3pyr31nbcbjoithact2i53gxx` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_tournoi`
--

LOCK TABLES `type_tournoi` WRITE;
/*!40000 ALTER TABLE `type_tournoi` DISABLE KEYS */;
INSERT INTO `type_tournoi` VALUES (1,'Double messieurs',28,NULL,3),(2,'Simple messieurs',29,NULL,3),(3,'Simple messeieurs',33,NULL,3),(4,'Simple messeieurs',34,NULL,3),(5,'Simple messeieurs',35,NULL,3),(6,'Simple messeieurs',36,NULL,3),(7,'Simple messeieurs',37,NULL,3),(8,'Simple messeieurs',38,NULL,3),(9,'Simple messeieurs',39,NULL,3),(10,'Simple messeieurs',40,NULL,NULL),(11,'Simple messeieurs',41,NULL,NULL),(12,'Simple messeieurs',42,NULL,NULL),(13,'Simple messeieurs',43,NULL,NULL),(14,'Simple messeieurs',44,NULL,NULL),(15,'Double messeieurs',45,NULL,NULL),(16,'Simple messeieurs',46,NULL,3);
/*!40000 ALTER TABLE `type_tournoi` ENABLE KEYS */;
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
