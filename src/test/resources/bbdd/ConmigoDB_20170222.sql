-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.1.21-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura para tabla conmigodb.event
CREATE TABLE IF NOT EXISTS `event` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) DEFAULT NULL,
  `DATE` datetime DEFAULT NULL,
  `PLACE` varchar(50) DEFAULT NULL,
  `TYPE` varchar(50) DEFAULT NULL,
  `CREATED_BY` bigint(20) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `LAST_MODIFIED_BY` bigint(20) DEFAULT NULL,
  `LAST_MODIFIED_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla conmigodb.event: ~0 rows (aproximadamente)
DELETE FROM `event`;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` (`ID`, `NAME`, `DATE`, `PLACE`, `TYPE`, `CREATED_BY`, `CREATED_DATE`, `LAST_MODIFIED_BY`, `LAST_MODIFIED_DATE`) VALUES
	(1, 'Gran pelicula', '2017-02-28 12:27:00', NULL, NULL, 0, NULL, NULL, NULL),
	(2, 'Gran pelicula', '2017-02-22 12:20:00', 'Cine de Bormujos', 'event.type.cinema', 0, '2017-02-21 15:46:13', 6, '2017-02-21 15:46:13'),
	(3, 'Gran pelicula 3', '2017-02-22 13:12:00', 'Cine de Bormujos', 'event.type.cinema', 6, '2017-02-22 13:13:08', 6, '2017-02-22 13:13:08'),
	(4, 'Gran pelicula 4', '2017-02-22 13:13:00', 'Cine de Bormujos', 'event.type.cinema', 6, '2017-02-22 13:14:24', 6, '2017-02-22 13:14:24'),
	(5, 'Gran pelicula 5', '2017-02-22 13:14:00', 'Cine de Bormujos', 'event.type.cinema', 6, '2017-02-22 13:15:53', 6, '2017-02-22 13:15:53'),
	(6, 'Gran pelicula 6', '2017-02-22 13:31:00', 'Cine de Bormujos', 'event.type.cinema', 6, '2017-02-22 13:31:45', 6, '2017-02-22 13:31:45');
/*!40000 ALTER TABLE `event` ENABLE KEYS */;


-- Volcando estructura para tabla conmigodb.role
CREATE TABLE IF NOT EXISTS `role` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) DEFAULT NULL,
  `DESCRIPTION` varchar(50) DEFAULT NULL,
  `CREATED_BY` bigint(20) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `LAST_MODIFIED_BY` bigint(20) DEFAULT NULL,
  `LAST_MODIFIED_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla conmigodb.role: ~2 rows (aproximadamente)
DELETE FROM `role`;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`ID`, `NAME`, `DESCRIPTION`, `CREATED_BY`, `CREATED_DATE`, `LAST_MODIFIED_BY`, `LAST_MODIFIED_DATE`) VALUES
	(1, 'ROLE_ADMIN', 'ROL_ADMIN', 0, '2017-02-22 08:18:41', 0, '2017-02-22 08:18:43'),
	(2, 'ROLE_USER', 'ROLE_USER', 0, '2017-02-22 08:19:03', NULL, NULL);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;


-- Volcando estructura para tabla conmigodb.user
CREATE TABLE IF NOT EXISTS `user` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) DEFAULT NULL,
  `FIRST_NAME` varchar(50) DEFAULT NULL,
  `LAST_NAME` varchar(50) DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `USERNAME` varchar(50) DEFAULT NULL,
  `PASSWORD` varchar(100) DEFAULT NULL,
  `ENABLE` tinyint(1) DEFAULT '1',
  `CREATED_BY` bigint(20) NOT NULL,
  `CREATED_DATE` date NOT NULL,
  `LAST_MODIFIED_BY` bigint(20) DEFAULT NULL,
  `LAST_MODIFIED_DATE` date DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `EMAIL` (`EMAIL`),
  KEY `USER_IDX` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='Tabla de Usuarios';

-- Volcando datos para la tabla conmigodb.user: ~4 rows (aproximadamente)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`ID`, `NAME`, `FIRST_NAME`, `LAST_NAME`, `EMAIL`, `USERNAME`, `PASSWORD`, `ENABLE`, `CREATED_BY`, `CREATED_DATE`, `LAST_MODIFIED_BY`, `LAST_MODIFIED_DATE`) VALUES
	(6, 'Usuario Prueba 1', 'Usuario', 'Prueba 1', 'usuarioPrueba1@usuario.es', 'usuarioPrueba1@usuario.es', '$2a$10$1qPncyzzUrqfuC5swqkxGuMKAv3RGJI/u7QmSi7Ota7OxtFe7Y.AG', 1, 0, '2017-02-20', NULL, NULL),
	(11, 'Mariela Bc', 'Mariela', 'Bc', 'marielabc2000@yahoo.es', 'marielabc2000@yahoo.es', '$2a$10$H0J2B5ikhrjLzf2.D1oEteDyFn9WRHJI5y3BxD5rRbcqoCpMG63fy', 1, 0, '2017-02-22', 0, '2017-02-22'),
	(14, NULL, NULL, NULL, 'usuarioPrueba6@usuario.es', NULL, '$2a$10$BLI4EN8LvWkooHO1RKKrE.hOwRSjSbmKY6S0RJ2GCt8ZZRdkrVouK', 1, 0, '2017-02-22', 0, '2017-02-22'),
	(15, NULL, NULL, NULL, 'usuarioPrueba7@usuario.es', NULL, '$2a$10$/LY6h7vJeq8jXm9kEoHsuuZbgReuIIWtATKXnY4dJOuTiNfZhQbeW', 1, 0, '2017-02-22', 0, '2017-02-22'),
	(16, NULL, NULL, NULL, 'usuarioPrueba8@usuario.es', NULL, '$2a$10$CBHk38KmD3FRcT3LXnj7AOFjH6.2A9riVEan2iDXOX0dS4LpCbmXq', 1, 0, '2017-02-22', 0, '2017-02-22');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


-- Volcando estructura para tabla conmigodb.userconnection
CREATE TABLE IF NOT EXISTS `userconnection` (
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

-- Volcando datos para la tabla conmigodb.userconnection: ~0 rows (aproximadamente)
DELETE FROM `userconnection`;
/*!40000 ALTER TABLE `userconnection` DISABLE KEYS */;
INSERT INTO `userconnection` (`userId`, `providerId`, `providerUserId`, `rank`, `displayName`, `profileUrl`, `imageUrl`, `accessToken`, `secret`, `refreshToken`, `expireTime`) VALUES
	('marielabc2000@yahoo.es', 'facebook', '1034874999990727', 1, 'Mariela Bc', 'https://www.facebook.com/app_scoped_user_id/1034874999990727/', 'https://graph.facebook.com/v2.5/1034874999990727/picture', 'EAARl3NDzX3sBAIJr2LFD5d9ZBubRrB1QA7KLWZC0fiKQiLZACvqT3kWlhfjVGf0I6BJ62BQbqDy6j0UP1H9DyrHPASMXDLTqZCu0s1tETPDH6IKrO8lnZAJ8mGU7MHfv6Jbc0N7RLqlEi1GkR3BmIZBZCjsHu7md7QZD', NULL, NULL, 1492933441275);
/*!40000 ALTER TABLE `userconnection` ENABLE KEYS */;


-- Volcando estructura para tabla conmigodb.user_event
CREATE TABLE IF NOT EXISTS `user_event` (
  `USER` bigint(20) NOT NULL,
  `EVENT` bigint(20) NOT NULL,
  PRIMARY KEY (`USER`,`EVENT`),
  KEY `USER_EVENT_FK_EVENT` (`EVENT`),
  CONSTRAINT `USER_EVENT_FK_EVENT` FOREIGN KEY (`EVENT`) REFERENCES `event` (`ID`) ON DELETE CASCADE,
  CONSTRAINT `USER_EVENT_FK_USER` FOREIGN KEY (`USER`) REFERENCES `user` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla conmigodb.user_event: ~0 rows (aproximadamente)
DELETE FROM `user_event`;
/*!40000 ALTER TABLE `user_event` DISABLE KEYS */;
INSERT INTO `user_event` (`USER`, `EVENT`) VALUES
	(6, 6);
/*!40000 ALTER TABLE `user_event` ENABLE KEYS */;


-- Volcando estructura para tabla conmigodb.user_role
CREATE TABLE IF NOT EXISTS `user_role` (
  `USER` bigint(20) NOT NULL,
  `ROLE` bigint(20) NOT NULL,
  PRIMARY KEY (`USER`,`ROLE`),
  KEY `USER_ROLE_FK_ROLE` (`ROLE`),
  CONSTRAINT `USER_ROLE_FK_ROLE` FOREIGN KEY (`ROLE`) REFERENCES `role` (`ID`) ON DELETE CASCADE,
  CONSTRAINT `USER_ROLE_FK_USER` FOREIGN KEY (`USER`) REFERENCES `user` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla conmigodb.user_role: ~4 rows (aproximadamente)
DELETE FROM `user_role`;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` (`USER`, `ROLE`) VALUES
	(6, 2),
	(11, 2),
	(14, 2),
	(15, 2),
	(16, 2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
