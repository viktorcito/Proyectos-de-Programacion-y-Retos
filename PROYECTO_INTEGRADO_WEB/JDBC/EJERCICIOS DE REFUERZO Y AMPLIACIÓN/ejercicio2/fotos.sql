DROP DATABASE IF EXISTS fotos;
CREATE DATABASE fotos CHARACTER SET utf8mb4;
USE fotos;
-- DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `login` varchar(50) NOT NULL,
  `pwd` varchar(50) NOT NULL,
  `email` varchar(50) UNIQUE NOT NULL,
  `fecha` DATE DEFAULT NULL,
  `foto` longblob DEFAULT NULL,
  PRIMARY KEY (`login`)
);

-- insertamos un usuario de prueba
LOCK TABLES `usuarios` WRITE;
INSERT INTO `usuarios` VALUES ('usr1','pwd1','prueba@gmail.es','2023-05-04',null);
UNLOCK TABLES;
