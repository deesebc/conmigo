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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla conmigodb.event: ~1 rows (aproximadamente)
DELETE FROM `event`;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` (`ID`, `NAME`, `DATE`, `PLACE`, `TYPE`, `CREATED_BY`, `CREATED_DATE`, `LAST_MODIFIED_BY`, `LAST_MODIFIED_DATE`) VALUES
	(1, 'Gran pelicula', '2017-02-28 12:27:00', NULL, NULL, 0, NULL, NULL, NULL),
	(2, 'Gran pelicula', '2017-02-22 12:20:00', 'Cine de Bormujos', 'event.type.cinema', 0, '2017-02-21 15:46:13', 6, '2017-02-21 15:46:13');
/*!40000 ALTER TABLE `event` ENABLE KEYS */;


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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='Tabla de Usuarios';

-- Volcando datos para la tabla conmigodb.user: ~4 rows (aproximadamente)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`ID`, `NAME`, `FIRST_NAME`, `LAST_NAME`, `EMAIL`, `USERNAME`, `PASSWORD`, `ENABLE`, `CREATED_BY`, `CREATED_DATE`, `LAST_MODIFIED_BY`, `LAST_MODIFIED_DATE`) VALUES
	(5, 'Mariela Bc', 'Mariela', 'Bc', 'marielabc2000@yahoo.es', 'marielabc2000@yahoo.es', 'wHcj1XggAR7iqucmS', 1, 0, '2017-02-20', NULL, '2017-02-20'),
	(6, 'Usuario Prueba 1', 'Usuario', 'Prueba 1', 'usuarioPrueba1@usuario.es', 'usuarioPrueba1@usuario.es', '$2a$10$1qPncyzzUrqfuC5swqkxGuMKAv3RGJI/u7QmSi7Ota7OxtFe7Y.AG', 1, 0, '2017-02-20', NULL, NULL),
	(9, NULL, NULL, NULL, 'usuarioPrueba2@usuario.es', NULL, 'usuarioPrueba2', 0, 0, '2017-02-20', NULL, NULL),
	(10, NULL, NULL, NULL, 'usuarioPrueba3@usuario.es', NULL, 'usuarioPrueba3', 0, 0, '2017-02-20', NULL, NULL);
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
  UNIQUE KEY `UserConnectionRank` (`userId`,`providerId`,`rank`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla conmigodb.userconnection: ~0 rows (aproximadamente)
DELETE FROM `userconnection`;
/*!40000 ALTER TABLE `userconnection` DISABLE KEYS */;
INSERT INTO `userconnection` (`userId`, `providerId`, `providerUserId`, `rank`, `displayName`, `profileUrl`, `imageUrl`, `accessToken`, `secret`, `refreshToken`, `expireTime`) VALUES
	('marielabc2000@yahoo.es', 'facebook', '1034874999990727', 1, 'Mariela Bc', 'https://www.facebook.com/app_scoped_user_id/1034874999990727/', 'https://graph.facebook.com/v2.5/1034874999990727/picture', 'EAARl3NDzX3sBAA4oBKy6Nn9DC0Lgj512m7oxohdnKqrTe1CayIEswyElR8GuaGz7S7P7soAwGpJyrL2iDJYwUaEOk1sVx4pe4A2loV9jnSJOeLkjqviAZCZCghrjNO3w80o2gktdZAxX8CcdRTFnZB6mewEAEAQZD', NULL, NULL, 1492688180462);
/*!40000 ALTER TABLE `userconnection` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
