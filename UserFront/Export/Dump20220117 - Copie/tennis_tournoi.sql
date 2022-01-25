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
  `nbr_inscrit` varchar(255) DEFAULT NULL,
  `nbr_tour` varchar(255) DEFAULT NULL,
  `nbre_joueurs_max` varchar(255) DEFAULT NULL,
  `nom_tournoi` varchar(255) DEFAULT NULL,
  `billet_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `date_debut_tournoi` datetime DEFAULT NULL,
  `date_fin_tournoi` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhcxortt5e2lfinuhpp2hyb360` (`billet_id`),
  KEY `FKefutp082fgb6sylq53ie254qd` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=56 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tournoi`
--

LOCK TABLES `tournoi` WRITE;
/*!40000 ALTER TABLE `tournoi` DISABLE KEYS */;
INSERT INTO `tournoi` VALUES (1,'1','1','1','nom tournoi1',1,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(30,'30','30','30','nom tournoi1',30,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(35,'35','35','35','nom tournoi1',35,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(34,'34','34','34','nom tournoi1',34,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(36,'36','36','36','nom tournoi1',36,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(7,'7','7','7','nom tournoi1',7,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(8,'8','8','8','nom tournoi1',8,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(9,'9','9','9','nom tournoi1',9,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(10,'10','10','10','nom tournoi1',10,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(11,'11','11','11','nom tournoi1',11,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(12,'12','12','12','nom tournoi1',12,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(13,'13','13','13','nom tournoi1',13,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(14,'14','14','14','nom tournoi1',14,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(15,'15','15','15','nom tournoi1',15,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(16,'16','16','16','nom tournoi1',16,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(17,'17','17','17','nom tournoi1',17,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(18,'18','18','18','nom tournoi1',18,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(19,'19','19','19','nom tournoi1',19,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(20,'20','20','20','nom tournoi1',20,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(21,'21','21','21','nom tournoi1',21,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(22,'22','22','22','nom tournoi1',22,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(23,'23','23','23','nom tournoi1',23,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(24,'24','24','24','nom tournoi1',24,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(25,'25','25','25','nom tournoi1',25,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(26,'26','26','26','nom tournoi1',26,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(27,'27','27','27','nom tournoi1',27,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(28,'28','28','28','nom tournoi1',28,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(29,'29','29','29','nom tournoi1',29,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(31,'31','31','31','nom tournoi1',31,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(32,'32','32','32','nom tournoi1',32,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(33,'33','33','33','nom tournoi1',33,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(37,'37','37','37','nom tournoi1',37,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(38,'38','38','38','nom tournoi1',38,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(39,'39','39','39','nom tournoi1',39,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(40,'40','40','40','nom tournoi1',40,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(41,'41','41','41','nom tournoi1',41,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(42,'42','42','42','nom tournoi1',42,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(43,'43','43','43','nom tournoi1',43,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(44,'44','44','44','nom tournoi1',44,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(45,'45','45','45','nom tournoi1',45,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(46,'46','46','46','nom tournoi1',46,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(47,'47','47','47','nom tournoi1',47,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(48,'48','48','48','nom tournoi1',48,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(49,'49','49','49','nom tournoi1',49,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(50,'50','50','50','nom tournoi1',50,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(51,'51','51','51','nom tournoi1',51,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(2,'2','2','2','nom tournoi1',2,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(3,'3','3','3','nom tournoi1',3,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(4,'4','4','4','nom tournoi1',4,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(5,'5','5','5','nom tournoi1',5,3,'2022-01-16 00:00:00','2022-01-01 00:00:00'),(6,'6','6','6','nom tournoi1',6,3,'2022-01-16 00:00:00','2022-01-01 00:00:00');
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

-- Dump completed on 2022-01-17 10:05:34
