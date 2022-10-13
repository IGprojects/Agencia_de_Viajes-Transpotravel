CREATE DATABASE  IF NOT EXISTS `transpotravelv2` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `transpotravelv2`;
-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: transpotravelv2
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `desplacament`
--

DROP TABLE IF EXISTS `desplacament`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `desplacament` (
  `idDesplacament` int NOT NULL AUTO_INCREMENT,
  `idpuntRecollida` int DEFAULT NULL,
  `dni` varchar(9) DEFAULT NULL,
  `iddistribuciovols` int DEFAULT NULL,
  `numequipatges` int DEFAULT NULL,
  `numplaces` int DEFAULT NULL,
  PRIMARY KEY (`idDesplacament`),
  KEY `dni` (`idpuntRecollida`),
  KEY `idDesti` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `desplacament`
--

LOCK TABLES `desplacament` WRITE;
/*!40000 ALTER TABLE `desplacament` DISABLE KEYS */;
INSERT INTO `desplacament` VALUES (34,NULL,'123',2,3,5),(35,NULL,'123',2,1,1),(36,NULL,'123',1,1,2),(37,NULL,'123',2,1,2);
/*!40000 ALTER TABLE `desplacament` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `distribuciovols`
--

DROP TABLE IF EXISTS `distribuciovols`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `distribuciovols` (
  `iddistribuciovols` int NOT NULL AUTO_INCREMENT,
  `idorigen` int DEFAULT NULL,
  `iddesti` int DEFAULT NULL,
  `preu` int DEFAULT NULL,
  `horaSortida` datetime DEFAULT NULL,
  `horaArribada` datetime DEFAULT NULL,
  `oferta` tinyint(1) DEFAULT NULL,
  `idPuntRecollida` int DEFAULT NULL,
  `descripcio` varchar(150) DEFAULT NULL,
  `estat` int DEFAULT NULL,
  `personas` int DEFAULT NULL,
  `pes` int DEFAULT NULL,
  PRIMARY KEY (`iddistribuciovols`),
  KEY `iddesti` (`iddesti`),
  KEY `idorigen` (`idorigen`),
  KEY `idPuntRecollida` (`idPuntRecollida`),
  KEY `estat` (`estat`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distribuciovols`
--

LOCK TABLES `distribuciovols` WRITE;
/*!40000 ALTER TABLE `distribuciovols` DISABLE KEYS */;
INSERT INTO `distribuciovols` VALUES (1,2,1,200,'2022-06-07 23:00:00','2022-06-16 22:00:00',1,2,'wdqwa',1,14,28),(2,2,1,45,'2022-06-07 23:00:00','2022-06-16 22:00:00',1,2,'wdqwa',1,12,2212);
/*!40000 ALTER TABLE `distribuciovols` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipatge`
--

DROP TABLE IF EXISTS `equipatge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipatge` (
  `idEquipatge` int NOT NULL AUTO_INCREMENT,
  `dni` varchar(9) DEFAULT NULL,
  `pes` varchar(5) DEFAULT NULL,
  `idEstat` int DEFAULT NULL,
  `idPunt` int DEFAULT NULL,
  `idDistrivuciovol` int DEFAULT NULL,
  `adrecaPerz` varchar(70) DEFAULT NULL,
  PRIMARY KEY (`idEquipatge`),
  KEY `dni` (`dni`),
  KEY `idDesti` (`pes`),
  KEY `idOrigen` (`idEstat`),
  KEY `idEstat` (`idDistrivuciovol`),
  KEY `idPunt` (`adrecaPerz`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipatge`
--

LOCK TABLES `equipatge` WRITE;
/*!40000 ALTER TABLE `equipatge` DISABLE KEYS */;
INSERT INTO `equipatge` VALUES (35,'123','1',1,3,2,NULL),(36,'123','2',1,2,2,NULL),(37,'123','2',1,2,2,NULL),(39,'123','2',1,2,1,NULL);
/*!40000 ALTER TABLE `equipatge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estat`
--

DROP TABLE IF EXISTS `estat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estat` (
  `idEstat` int NOT NULL,
  `descripcio` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idEstat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estat`
--

LOCK TABLES `estat` WRITE;
/*!40000 ALTER TABLE `estat` DISABLE KEYS */;
INSERT INTO `estat` VALUES (1,'En Espera'),(2,'En Vuelo'),(3,'En Reparto'),(4,'Ha Llegado');
/*!40000 ALTER TABLE `estat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `localitzacio`
--

DROP TABLE IF EXISTS `localitzacio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `localitzacio` (
  `idLocalitzacio` int NOT NULL AUTO_INCREMENT,
  `ciutat` varchar(15) DEFAULT NULL,
  `codiPostal` int DEFAULT NULL,
  `descripcio` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idLocalitzacio`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localitzacio`
--

LOCK TABLES `localitzacio` WRITE;
/*!40000 ALTER TABLE `localitzacio` DISABLE KEYS */;
INSERT INTO `localitzacio` VALUES (1,'Barcelona',12444,'dqwdq'),(2,'Palafrugell',17200,'ascsa'),(3,'Lisboa',17200,'afqw'),(4,'Londres',17200,'qwdwq');
/*!40000 ALTER TABLE `localitzacio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona` (
  `dni` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(15) DEFAULT NULL,
  `cognom1` varchar(20) DEFAULT NULL,
  `cognom2` varchar(20) DEFAULT NULL,
  `adreca` varchar(20) DEFAULT NULL,
  `contrasenya` varchar(45) DEFAULT NULL,
  `correu` varchar(40) DEFAULT NULL,
  `telefon` int DEFAULT NULL,
  `esGold` tinyint(1) DEFAULT NULL,
  `supervisor` tinyint(1) DEFAULT NULL,
  `repartidor` tinyint(1) DEFAULT NULL,
  `proveidor` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (123,'pepe','pol','poll','123','123','123',232121,0,0,0,0);
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puntrecollida`
--

DROP TABLE IF EXISTS `puntrecollida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `puntrecollida` (
  `idPunt` int NOT NULL AUTO_INCREMENT,
  `idLocalitzacio` int DEFAULT NULL,
  `adreca` varchar(20) DEFAULT NULL,
  `descripcio` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idPunt`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puntrecollida`
--

LOCK TABLES `puntrecollida` WRITE;
/*!40000 ALTER TABLE `puntrecollida` DISABLE KEYS */;
INSERT INTO `puntrecollida` VALUES (2,1,'zdqwdwqd','qwdwq'),(3,1,'efewf','efewf');
/*!40000 ALTER TABLE `puntrecollida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seguiment`
--

DROP TABLE IF EXISTS `seguiment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seguiment` (
  `idSeguiment` int NOT NULL AUTO_INCREMENT,
  `idEquipatge` int DEFAULT NULL,
  `idDesplacament` int DEFAULT NULL,
  `idEstat` int DEFAULT NULL,
  PRIMARY KEY (`idSeguiment`),
  KEY `idEquipatge` (`idEquipatge`),
  KEY `idDesplacament` (`idDesplacament`),
  KEY `idEstat` (`idEstat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seguiment`
--

LOCK TABLES `seguiment` WRITE;
/*!40000 ALTER TABLE `seguiment` DISABLE KEYS */;
/*!40000 ALTER TABLE `seguiment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-27 22:39:19
