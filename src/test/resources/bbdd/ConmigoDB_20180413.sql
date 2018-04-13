CREATE DATABASE  IF NOT EXISTS `conmigodb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `conmigodb`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: conmigodb
-- ------------------------------------------------------
-- Server version	5.7.21

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
-- Table structure for table `combo`
--

DROP TABLE IF EXISTS `combo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `combo` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) DEFAULT NULL,
  `VALUE` varchar(50) DEFAULT NULL,
  `TYPE` varchar(50) DEFAULT NULL,
  `CREATED_BY` bigint(20) NOT NULL,
  `CREATED_DATE` date NOT NULL,
  `LAST_MODIFIED_BY` bigint(20) DEFAULT NULL,
  `LAST_MODIFIED_DATE` date DEFAULT NULL,
  `ENABLE` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`ID`),
  KEY `COMBO_IDX` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='Tabla de Combos';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `combo`
--

LOCK TABLES `combo` WRITE;
/*!40000 ALTER TABLE `combo` DISABLE KEYS */;
INSERT INTO `combo` VALUES (1,'FEMENINO','F','GENDER',0,'2017-02-22',0,'2017-02-22',1),(2,'MASCULINO','M','GENDER',0,'2017-02-22',0,'2017-02-22',1);
/*!40000 ALTER TABLE `combo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) DEFAULT NULL,
  `DATE` datetime DEFAULT NULL,
  `PLACE` varchar(50) DEFAULT NULL,
  `TYPE` varchar(50) DEFAULT NULL,
  `PROVINCE` bigint(20) DEFAULT NULL,
  `CREATED_BY` bigint(20) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `LAST_MODIFIED_BY` bigint(20) DEFAULT NULL,
  `LAST_MODIFIED_DATE` datetime DEFAULT NULL,
  `ENABLE` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`ID`),
  KEY `EVENT_PROVINCE_FK_idx` (`PROVINCE`),
  CONSTRAINT `EVENT_PROVINCE_FK` FOREIGN KEY (`PROVINCE`) REFERENCES `province` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (1,'Gran pelicula','2017-02-28 12:27:00',NULL,NULL,NULL,0,NULL,NULL,NULL,1),(2,'Gran pelicula','2017-02-22 12:20:00','Cine de Bormujos','event.type.cinema',NULL,0,'2017-02-21 15:46:13',6,'2017-02-21 15:46:13',1),(3,'Gran pelicula 3','2017-02-22 13:12:00','Cine de Bormujos','event.type.cinema',NULL,6,'2017-02-22 13:13:08',6,'2017-02-22 13:13:08',1),(4,'Gran pelicula 4','2017-02-22 13:13:00','Cine de Bormujos','event.type.cinema',NULL,6,'2017-02-22 13:14:24',6,'2017-02-22 13:14:24',1),(5,'Gran pelicula 5','2017-02-22 13:14:00','Cine de Bormujos','event.type.cinema',NULL,6,'2017-02-22 13:15:53',6,'2017-02-22 13:15:53',1),(6,'Gran pelicula 6','2017-02-22 13:31:00','Cine de Bormujos','event.type.cinema',NULL,6,'2017-02-22 13:31:45',6,'2017-02-22 13:31:45',1),(7,'nombre',NULL,'lugar','event.type.cinema',NULL,6,'2018-04-10 18:46:23',6,'2018-04-10 18:46:23',1),(8,'nombre dos',NULL,'lugar','event.type.concert',NULL,6,'2018-04-10 18:47:50',6,'2018-04-10 18:47:50',1),(9,'datetime',NULL,'','-',NULL,6,'2018-04-10 18:55:12',6,'2018-04-10 18:55:12',1),(10,'name','2009-10-19 15:20:00','lugar','event.type.cinema',NULL,6,'2018-04-10 19:02:46',6,'2018-04-10 19:02:46',1),(11,'Evento eterno','2100-09-15 15:30:00','bormuji','event.type.concert',NULL,6,'2018-04-10 21:03:25',6,'2018-04-10 21:03:25',1);
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `province`
--

DROP TABLE IF EXISTS `province`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `province` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `PROVINCIA` varchar(50) DEFAULT NULL,
  `CREATED_BY` bigint(20) NOT NULL,
  `CREATED_DATE` date NOT NULL,
  `LAST_MODIFIED_BY` bigint(20) DEFAULT NULL,
  `LAST_MODIFIED_DATE` date DEFAULT NULL,
  `ENABLE` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`ID`),
  KEY `IDX_PROVINCIA` (`PROVINCIA`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8 COMMENT='Tabla de Provincias';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `province`
--

LOCK TABLES `province` WRITE;
/*!40000 ALTER TABLE `province` DISABLE KEYS */;
INSERT INTO `province` VALUES (1,'Álava',0,'2017-02-22',NULL,NULL,1),(2,'Albacete',0,'2017-02-22',NULL,NULL,1),(3,'Alicante',0,'2017-02-22',NULL,NULL,1),(4,'Almería',0,'2017-02-22',NULL,NULL,1),(5,'Ávila',0,'2017-02-22',NULL,NULL,1),(6,'Badajoz',0,'2017-02-22',NULL,NULL,1),(7,'Illes Balears',0,'2017-02-22',NULL,NULL,1),(8,'Barcelona',0,'2017-02-22',NULL,NULL,1),(9,'Burgos',0,'2017-02-22',NULL,NULL,1),(10,'Cáceres',0,'2017-02-22',NULL,NULL,1),(11,'Cádiz',0,'2017-02-22',NULL,NULL,1),(12,'Castellón',0,'2017-02-22',NULL,NULL,1),(13,'Ciudad Real',0,'2017-02-22',NULL,NULL,1),(14,'Córdoba',0,'2017-02-22',NULL,NULL,1),(15,'A Coruña',0,'2017-02-22',NULL,NULL,1),(16,'Cuenca',0,'2017-02-22',NULL,NULL,1),(17,'Girona',0,'2017-02-22',NULL,NULL,1),(18,'Granada',0,'2017-02-22',NULL,NULL,1),(19,'Guadalajara',0,'2017-02-22',NULL,NULL,1),(20,'Guipúzcoa',0,'2017-02-22',NULL,NULL,1),(21,'Huelva',0,'2017-02-22',NULL,NULL,1),(22,'Huesca',0,'2017-02-22',NULL,NULL,1),(23,'Jaén',0,'2017-02-22',NULL,NULL,1),(24,'León',0,'2017-02-22',NULL,NULL,1),(25,'Lleida',0,'2017-02-22',NULL,NULL,1),(26,'La Rioja',0,'2017-02-22',NULL,NULL,1),(27,'Lugo',0,'2017-02-22',NULL,NULL,1),(28,'Madrid',0,'2017-02-22',NULL,NULL,1),(29,'Málaga',0,'2017-02-22',NULL,NULL,1),(30,'Murcia',0,'2017-02-22',NULL,NULL,1),(31,'Navarra',0,'2017-02-22',NULL,NULL,1),(32,'Ourense',0,'2017-02-22',NULL,NULL,1),(33,'Asturias',0,'2017-02-22',NULL,NULL,1),(34,'Palencia',0,'2017-02-22',NULL,NULL,1),(35,'Las Palmas',0,'2017-02-22',NULL,NULL,1),(36,'Pontevedra',0,'2017-02-22',NULL,NULL,1),(37,'Salamanca',0,'2017-02-22',NULL,NULL,1),(38,'Santa Cruz de Tenerife',0,'2017-02-22',NULL,NULL,1),(39,'Cantabria',0,'2017-02-22',NULL,NULL,1),(40,'Segovia',0,'2017-02-22',NULL,NULL,1),(41,'Sevilla',0,'2017-02-22',NULL,NULL,1),(42,'Soria',0,'2017-02-22',NULL,NULL,1),(43,'Tarragona',0,'2017-02-22',NULL,NULL,1),(44,'Teruel',0,'2017-02-22',NULL,NULL,1),(45,'Toledo',0,'2017-02-22',NULL,NULL,1),(46,'Valencia',0,'2017-02-22',NULL,NULL,1),(47,'Valladolid',0,'2017-02-22',NULL,NULL,1),(48,'Vizcaya',0,'2017-02-22',NULL,NULL,1),(49,'Zamora',0,'2017-02-22',NULL,NULL,1),(50,'Zaragoza',0,'2017-02-22',NULL,NULL,1),(51,'Ceuta',0,'2017-02-22',NULL,NULL,1),(52,'Melilla',0,'2017-02-22',NULL,NULL,1);
/*!40000 ALTER TABLE `province` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) DEFAULT NULL,
  `DESCRIPTION` varchar(50) DEFAULT NULL,
  `CREATED_BY` bigint(20) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `LAST_MODIFIED_BY` bigint(20) DEFAULT NULL,
  `LAST_MODIFIED_DATE` datetime DEFAULT NULL,
  `ENABLE` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN','ROL_ADMIN',0,'2017-02-22 08:18:41',0,'2017-02-22 08:18:43',1),(2,'ROLE_USER','ROLE_USER',0,'2017-02-22 08:19:03',NULL,NULL,1);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(50) DEFAULT NULL,
  `LAST_NAME` varchar(50) DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `USERNAME` varchar(50) DEFAULT NULL,
  `PASSWORD` varchar(100) DEFAULT NULL,
  `BIRTHDATE` date DEFAULT NULL,
  `TOWN` varchar(50) DEFAULT NULL,
  `GENDER` varchar(1) DEFAULT NULL,
  `PROVINCE` bigint(20) DEFAULT NULL,
  `CREATED_BY` bigint(20) NOT NULL,
  `CREATED_DATE` date NOT NULL,
  `LAST_MODIFIED_BY` bigint(20) DEFAULT NULL,
  `LAST_MODIFIED_DATE` date DEFAULT NULL,
  `ENABLE` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `EMAIL` (`EMAIL`),
  KEY `USER_IDX` (`ID`),
  KEY `USER_PROV_FK_idx` (`PROVINCE`),
  CONSTRAINT `USER_PROV_FK` FOREIGN KEY (`PROVINCE`) REFERENCES `province` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='Tabla de Usuarios';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (6,'Usuario1','Prueba 11','usuarioPrueba1@correo.es','usuarioPrueba1@correo.es','$2a$10$3DEDHjK7yfmViwM3gIQDL.OgXOmImwfrlDMAbHZBOREiWrKcxdI7u','1980-07-25','','M',9,0,'2017-02-20',6,'2018-04-12',1),(11,'Mariela','Bc','marielabc2000@yahoo.es','marielabc2000@yahoo.es','$2a$10$H0J2B5ikhrjLzf2.D1oEteDyFn9WRHJI5y3BxD5rRbcqoCpMG63fy',NULL,NULL,NULL,NULL,0,'2017-02-22',0,'2017-02-22',1),(14,NULL,NULL,'usuarioPrueba6@usuario.es',NULL,'$2a$10$BLI4EN8LvWkooHO1RKKrE.hOwRSjSbmKY6S0RJ2GCt8ZZRdkrVouK',NULL,NULL,NULL,NULL,0,'2017-02-22',0,'2017-02-22',1),(15,NULL,NULL,'usuarioPrueba7@usuario.es',NULL,'$2a$10$/LY6h7vJeq8jXm9kEoHsuuZbgReuIIWtATKXnY4dJOuTiNfZhQbeW',NULL,NULL,NULL,NULL,0,'2017-02-22',0,'2017-02-22',1),(16,NULL,NULL,'usuarioPrueba8@usuario.es',NULL,'$2a$10$CBHk38KmD3FRcT3LXnj7AOFjH6.2A9riVEan2iDXOX0dS4LpCbmXq',NULL,NULL,NULL,NULL,0,'2017-02-22',0,'2017-02-22',1),(17,'arioPeba2','usuarioPrueba2Ap','usuarioPrueba1@usario.es','usuarioPrueba2Uname','$2a$10$3V4uBBvdzr1QvAY2/aVXBerEnh3FNHP8M6bHe.NHrkztrp6RWjPR.',NULL,'','-',NULL,0,'2018-03-24',17,'2018-04-09',1),(18,NULL,NULL,'asdf',NULL,'$2a$10$fpPRYJYmySuEbBU9E4YQBehv5fzFxAJkvZUOG8rYpUHCDy4YHaZRC',NULL,NULL,NULL,NULL,0,'2018-03-25',0,'2018-03-25',1),(19,'ab4','ab15','usuarioPrueba4@correo.es','ab261','$2a$10$89p1i.gGXguXsy9NZlDnxupJBjkpQphrAX1OB71gOa6g3xJ1F9NLS','2010-10-16','ab37','M',2,0,'2018-03-25',19,'2018-04-12',1),(26,'','','usuario@correo.es','usuario','$2a$10$89p1i.gGXguXsy9NZlDnxupJBjkpQphrAX1OB71gOa6g3xJ1F9NLS',NULL,'','-',NULL,0,'2018-04-12',26,'2018-04-12',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_event`
--

DROP TABLE IF EXISTS `user_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_event` (
  `USER` bigint(20) NOT NULL,
  `EVENT` bigint(20) NOT NULL,
  PRIMARY KEY (`USER`,`EVENT`),
  KEY `USER_EVENT_FK_EVENT` (`EVENT`),
  CONSTRAINT `USER_EVENT_FK_EVENT` FOREIGN KEY (`EVENT`) REFERENCES `event` (`ID`) ON DELETE CASCADE,
  CONSTRAINT `USER_EVENT_FK_USER` FOREIGN KEY (`USER`) REFERENCES `user` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_event`
--

LOCK TABLES `user_event` WRITE;
/*!40000 ALTER TABLE `user_event` DISABLE KEYS */;
INSERT INTO `user_event` VALUES (6,1),(17,2),(6,3),(6,6),(6,11);
/*!40000 ALTER TABLE `user_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `USER` bigint(20) NOT NULL,
  `ROLE` bigint(20) NOT NULL,
  PRIMARY KEY (`USER`,`ROLE`),
  KEY `USER_ROLE_FK_ROLE` (`ROLE`),
  CONSTRAINT `USER_ROLE_FK_ROLE` FOREIGN KEY (`ROLE`) REFERENCES `role` (`ID`) ON DELETE CASCADE,
  CONSTRAINT `USER_ROLE_FK_USER` FOREIGN KEY (`USER`) REFERENCES `user` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (6,2),(11,2),(14,2),(15,2),(16,2),(17,2),(18,2),(19,2),(26,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userconnection`
--

DROP TABLE IF EXISTS `userconnection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userconnection` (
  `userId` varchar(255) NOT NULL,
  `providerId` varchar(255) NOT NULL,
  `providerUserId` varchar(255) NOT NULL,
  `rank` int(11) NOT NULL,
  `displayName` varchar(255) DEFAULT NULL,
  `profileUrl` varchar(512) DEFAULT NULL,
  `imageUrl` varchar(512) DEFAULT NULL,
  `accessToken` varchar(1024) NOT NULL,
  `secret` varchar(255) DEFAULT NULL,
  `refreshToken` varchar(255) DEFAULT NULL,
  `expireTime` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`userId`,`providerId`,`providerUserId`),
  UNIQUE KEY `UserConnectionRank` (`userId`,`providerId`,`rank`),
  CONSTRAINT `USER_CONNECTION_FK_USERNAME` FOREIGN KEY (`userId`) REFERENCES `user` (`EMAIL`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userconnection`
--

LOCK TABLES `userconnection` WRITE;
/*!40000 ALTER TABLE `userconnection` DISABLE KEYS */;
INSERT INTO `userconnection` VALUES ('marielabc2000@yahoo.es','facebook','1034874999990727',1,'Mariela Bc','https://www.facebook.com/app_scoped_user_id/1034874999990727/','https://graph.facebook.com/v2.5/1034874999990727/picture','EAARl3NDzX3sBAIJr2LFD5d9ZBubRrB1QA7KLWZC0fiKQiLZACvqT3kWlhfjVGf0I6BJ62BQbqDy6j0UP1H9DyrHPASMXDLTqZCu0s1tETPDH6IKrO8lnZAJ8mGU7MHfv6Jbc0N7RLqlEi1GkR3BmIZBZCjsHu7md7QZD',NULL,NULL,1492933441275);
/*!40000 ALTER TABLE `userconnection` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-13  7:26:41
