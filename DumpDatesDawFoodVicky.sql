CREATE DATABASE  IF NOT EXISTS `dawfood` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `dawfood`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: dawfood
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `detalle_ticket`
--

DROP TABLE IF EXISTS `detalle_ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_ticket` (
  `id_producto` int NOT NULL,
  `id_ticket` int NOT NULL,
  `cantidad_producto` int NOT NULL,
  PRIMARY KEY (`id_producto`,`id_ticket`),
  KEY `fk_detalle_ticket` (`id_ticket`),
  CONSTRAINT `fk_detalle_producto` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`),
  CONSTRAINT `fk_detalle_ticket` FOREIGN KEY (`id_ticket`) REFERENCES `tickets` (`id_ticket`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_ticket`
--

LOCK TABLES `detalle_ticket` WRITE;
/*!40000 ALTER TABLE `detalle_ticket` DISABLE KEYS */;
INSERT INTO `detalle_ticket` VALUES (1,930,2),(3,970,1),(3,971,1),(5,904,3),(8,905,2),(9,926,0),(9,928,0),(11,944,1),(11,948,1),(11,951,1),(11,965,1),(11,967,1),(12,902,2),(12,950,1),(13,959,1),(13,964,1),(14,929,4),(14,961,1),(14,969,1),(15,927,1),(15,945,1),(15,960,1),(16,937,1),(17,946,1),(18,903,1),(19,902,50),(19,905,-50),(19,968,1),(20,901,1),(20,947,1),(21,966,1),(21,971,1),(25,944,1),(25,957,2),(25,962,1),(27,942,2),(27,954,1),(27,959,1),(27,963,1),(28,949,1),(28,952,1),(28,953,1),(28,955,1),(28,958,1),(32,971,1),(33,940,1),(35,935,1),(36,937,1),(36,943,1),(37,932,1),(37,939,1),(37,944,1),(38,934,1),(38,941,1),(39,933,2),(39,936,1),(39,938,1),(40,956,1),(41,927,1);
/*!40000 ALTER TABLE `detalle_ticket` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `comprobarstock` BEFORE INSERT ON `detalle_ticket` FOR EACH ROW BEGIN
     DECLARE stock_disponible INT;

    SELECT stock_producto INTO stock_disponible
    FROM productos
    WHERE id_producto = NEW.id_producto;

	IF stock_disponible < NEW.cantidad_producto THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Error. No hay suficiente stock del producto';
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `reducirStock` AFTER INSERT ON `detalle_ticket` FOR EACH ROW BEGIN
    
    UPDATE productos
    SET stock_producto = stock_producto - NEW.cantidad_producto
    WHERE id_producto = NEW.id_producto;
    
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `id_producto` int NOT NULL AUTO_INCREMENT,
  `nombre_producto` varchar(30) NOT NULL,
  `precio_producto` double NOT NULL,
  `iva_producto` int NOT NULL,
  `stock_producto` int NOT NULL,
  `id_tipo` int NOT NULL,
  `descripcion_producto` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_producto`),
  KEY `fk_producto_tipo` (`id_tipo`),
  CONSTRAINT `fk_producto_tipo` FOREIGN KEY (`id_tipo`) REFERENCES `tipos_productos` (`id_tipo`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'Hamburguesa simple',9.99,10,118,602,'Hamburguesa de ternera con ketchup y mostaza'),(2,'Hamburguesa con queso',10.99,10,85,602,'Hamburguesa de ternera simple con queso ketchup y mostaza'),(3,'Hamburguesa dobleCheddar',12.99,10,69,602,'Hamburguesa doble de ternera con doble queso cheddar ketchup y mostaza'),(4,'Hamburguesa Halal',8.99,10,21,602,'Hamburguesa de ternera Halal sin condimentos'),(5,'Hamburguesa CrispyChicken',11.99,10,87,602,'Hamburguesa de pollo rebozado en crujiente de cereal con lechuga tomate y mayonesa'),(6,'Hamburguesa pollopollo',15.99,10,142,602,'Hamburguesa de Pollo a la Plancha con lechuga tomate y mayonesa'),(7,'Hamburguesa Completa',12.99,10,165,602,'Hamburguesa de ternera simple con queso lechuga tomate keptuch y mostaza'),(8,'Hamburguesa Vegetariana',15.99,10,132,602,'Hamburguesa de toffu con keptuch y mostaza'),(9,'Hamburguesa Egg',16.99,10,97,602,'Hamburguesa de ternera doble con huevo queso lechuga tomate keptuch y mostaza'),(10,'Hamburguesa Roll',14.99,10,12,602,'Hamburguesa CrispyChicken cortada a la mitad y puesta en un torta de trigo con lechuga y mayonesa'),(11,'Patatas Gajo',2.99,10,125,600,'Patatas gajos sazonadas'),(12,'Aros de Cebolla Crispy',4.5,10,89,620,'Aros de cebolla crujientes con salsa especial'),(13,'Ensalada César',6.75,10,58,603,'Ensalada con pollo a la parrilla queso parmesano y aderezo César'),(14,'Patatas Clásicas',3.25,10,74,600,'Patatas fritas clásicas acompañadas de ketchup'),(15,'Nachos Supreme',7.99,10,47,620,'Nachos cubiertos de queso jalapeños carne de res guacamole y crema agria'),(16,'Ensalada de Frutas Frescas',5.5,10,69,603,'Selección de frutas frescas de temporada con aderezo de miel'),(17,'Patatas Bravas',3.99,10,99,600,'Patatas fritas acompañadas de salsa brava y alioli'),(18,'Palitos de Mozzarella',6.25,10,45,620,'Palitos de queso mozzarella empanado con salsa marinara'),(19,'Ensalada Caprese',8.25,10,54,603,'Ensalada de tomate mozzarella fresca albahaca y vinagreta balsámica'),(20,'Papas Finas',2.75,10,119,600,'Papas fritas muy finas y crujientes con sal'),(21,'Pepsi',1.99,21,98,607,'Refresco de cola marca Pepsi'),(22,'Cerveza sin',1.99,21,100,609,'Cerveza sin alcohol 0,0%'),(23,'Cerveza',2,21,100,609,'Cerveza basica'),(24,'Kas',1.99,21,100,610,'Kas de Naranja'),(25,'Pepsi Max',1.99,21,96,610,'Pepsi zero zero'),(26,'Nestea',1.99,21,100,610,'Nestea Clásica'),(27,'Kas Max',2.35,21,95,610,'Kas de Naranja sin azúcar'),(28,'Aquarade Max',1.99,21,95,610,'Bebida isotónica zero'),(29,'Cerveza DawFood',1.99,21,100,609,'Cerveza original con doble lúpulo'),(30,'Agua Mineral',0.99,10,150,610,'Agua mineral natural'),(31,'Mochi',4.99,10,120,605,'Pastel Helado Japonés'),(32,'CafeConHelado',2.99,10,96,612,'Helado Americano'),(33,'McDawFlurry',3.99,10,77,612,'Helado con leche'),(34,'Cono Chocolate-Nata',1.99,10,127,612,'Helado de cono con mucho chocolate'),(35,'Yogur con toppin',2.99,10,56,612,'Yogur helado natural'),(36,'Tarta de queso',7.99,10,23,605,'Tarta de queso con mermelada de fresa'),(37,'Brownie de Chocolate',5.5,10,82,605,'Brownie de chocolate con nueces'),(38,'Pastel de Zanahoria',6.75,10,68,605,'Pastel de zanahoria con crema de queso'),(39,'Gelatina de Frutas',3.25,10,106,605,'Gelatina de frutas variadas'),(40,'Helado de Vainilla',2.25,10,149,612,'Helado clásico de vainilla'),(41,'Tequeño',2.55,10,99,620,' bastón de queso envuelto por una tira de masa de harina de trigo frita u horneada con mantequilla y huevo');
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tickets`
--

DROP TABLE IF EXISTS `tickets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tickets` (
  `id_ticket` int NOT NULL AUTO_INCREMENT,
  `fecha_ticket` date NOT NULL,
  `hora_ticket` time DEFAULT NULL,
  `subtotal_producto` decimal(5,2) NOT NULL,
  `total_ticket` decimal(5,2) NOT NULL,
  `cod_transaccion` int NOT NULL,
  `id_tpv` int NOT NULL,
  PRIMARY KEY (`id_ticket`),
  KEY `fk_tpv_ticket` (`id_tpv`),
  CONSTRAINT `fk_tpv_ticket` FOREIGN KEY (`id_tpv`) REFERENCES `tpv` (`id_tpv`)
) ENGINE=InnoDB AUTO_INCREMENT=972 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tickets`
--

LOCK TABLES `tickets` WRITE;
/*!40000 ALTER TABLE `tickets` DISABLE KEYS */;
INSERT INTO `tickets` VALUES (901,'2024-01-20','00:00:00',8.45,9.99,123456,154),(902,'2024-02-24','00:00:00',17.45,24.43,4654654,187),(903,'2024-02-25','00:00:00',22.48,24.43,7589584,187),(904,'2024-02-25','00:00:00',74.55,83.49,9574812,111),(905,'2024-02-26','00:00:00',52.78,60.16,7845246,154),(906,'2024-06-17','07:45:12',0.00,0.00,9071094,154),(907,'2024-06-17','07:51:15',0.00,0.00,42898786,154),(908,'2024-06-17','07:55:00',0.00,0.00,84253519,154),(909,'2024-06-17','08:02:08',0.00,0.00,55584745,154),(910,'2024-06-17','17:37:28',0.00,0.00,72323182,154),(911,'2024-06-17','17:59:33',0.00,0.00,11878459,154),(912,'2024-06-17','18:01:12',0.00,0.00,13990426,154),(913,'2024-06-17','18:02:37',0.00,0.00,82974795,154),(914,'2024-06-17','18:08:43',0.00,0.00,20696162,154),(915,'2024-06-17','18:10:34',0.00,0.00,29246028,154),(916,'2024-06-17','18:12:07',0.00,0.00,61757288,154),(917,'2024-06-17','19:12:02',0.00,0.00,4883177,154),(918,'2024-06-17','19:21:22',0.00,0.00,28272882,154),(919,'2024-06-17','19:26:35',0.00,0.00,6355432,154),(920,'2024-06-17','19:28:45',0.00,0.00,81155811,154),(921,'2024-06-17','19:30:38',0.00,0.00,76394938,154),(922,'2024-06-17','20:25:08',0.00,0.00,29552985,154),(923,'2024-06-17','20:30:04',0.00,0.00,51633718,154),(924,'2024-06-17','20:32:20',0.00,0.00,4984194,154),(925,'2024-06-17','20:41:50',0.00,0.00,27213781,154),(926,'2024-06-17','20:43:39',0.00,0.00,44351936,154),(927,'2024-06-17','20:46:19',0.00,0.00,81135146,154),(928,'2024-06-17','20:47:28',0.00,0.00,54742946,154),(929,'2024-06-17','20:48:35',0.00,0.00,62082690,154),(930,'2024-06-17','21:00:03',0.00,0.00,82233305,154),(931,'2024-06-17','21:23:49',0.00,0.00,11937525,154),(932,'2024-06-17','21:39:59',0.00,0.00,5288922,154),(933,'2024-06-17','21:42:23',0.00,0.00,66123114,154),(934,'2024-06-17','21:46:24',0.00,0.00,79619690,154),(935,'2024-06-17','21:57:32',0.00,0.00,85115761,154),(936,'2024-06-17','22:00:50',0.00,0.00,58365843,154),(937,'2024-06-17','22:21:03',0.00,0.00,70897175,154),(938,'2024-06-17','22:44:34',0.00,0.00,36081113,154),(939,'2024-06-17','22:48:30',0.00,0.00,17924206,154),(940,'2024-06-17','22:51:08',0.00,0.00,13334236,154),(941,'2024-06-17','22:54:12',0.00,0.00,45492717,154),(942,'2024-06-17','22:59:04',0.00,0.00,92871838,154),(943,'2024-06-17','23:00:59',0.00,0.00,37079179,154),(944,'2024-06-18','00:45:04',0.00,0.00,89346429,154),(945,'2024-06-18','01:08:10',0.00,0.00,98138936,154),(946,'2024-06-18','02:01:53',0.00,0.00,22671802,154),(947,'2024-06-18','02:21:43',0.00,0.00,76228068,154),(948,'2024-06-18','09:59:42',0.00,0.00,28110536,154),(949,'2024-06-18','10:03:26',0.00,0.00,89457408,154),(950,'2024-06-18','10:10:01',0.00,0.00,40998258,154),(951,'2024-06-18','10:11:01',0.00,0.00,48541279,154),(952,'2024-06-18','10:14:52',0.00,0.00,70365243,154),(953,'2024-06-18','10:15:50',0.00,0.00,31500987,154),(954,'2024-06-18','10:17:57',0.00,0.00,78256805,154),(955,'2024-06-18','10:21:24',0.00,0.00,20995163,154),(956,'2024-06-18','10:23:17',0.00,0.00,59956207,154),(957,'2024-06-18','10:24:44',0.00,0.00,56550608,154),(958,'2024-06-18','10:29:17',0.00,0.00,96220153,154),(959,'2024-06-18','10:37:05',0.00,0.00,47608077,154),(960,'2024-06-18','10:43:50',0.00,0.00,60905938,154),(961,'2024-06-18','10:47:57',0.00,0.00,48025209,154),(962,'2024-06-18','10:54:58',0.00,0.00,77374061,154),(963,'2024-06-18','10:56:22',0.00,0.00,82881139,154),(964,'2024-06-18','10:58:35',0.00,0.00,27819022,154),(965,'2024-06-18','11:06:36',2.99,3.29,25821859,154),(966,'2024-06-18','11:20:58',1.99,2.41,47055562,154),(967,'2024-06-19','20:03:26',2.99,3.29,28155524,154),(968,'2024-06-19','20:04:00',8.25,9.08,54868152,154),(969,'2024-06-19','20:07:47',3.25,3.58,79059874,154),(970,'2024-06-19','20:08:54',12.99,14.29,39462958,154),(971,'2024-06-19','20:09:39',17.97,19.99,387674,154);
/*!40000 ALTER TABLE `tickets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos_productos`
--

DROP TABLE IF EXISTS `tipos_productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipos_productos` (
  `id_tipo` int NOT NULL,
  `nombre_subcategoria` varchar(30) DEFAULT NULL,
  `categoria` enum('comida','bebida','postre') NOT NULL,
  PRIMARY KEY (`id_tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos_productos`
--

LOCK TABLES `tipos_productos` WRITE;
/*!40000 ALTER TABLE `tipos_productos` DISABLE KEYS */;
INSERT INTO `tipos_productos` VALUES (600,'Patatas fritas','comida'),(602,'Hamburguesa','comida'),(603,'Ensaladas','comida'),(605,'Postre Caseros','postre'),(607,'Azucaradas','bebida'),(608,'SinAzucar','bebida'),(609,'Cervezas','bebida'),(610,'Agua','bebida'),(612,'Helados','postre'),(620,'Complementos','comida');
/*!40000 ALTER TABLE `tipos_productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tpv`
--

DROP TABLE IF EXISTS `tpv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tpv` (
  `id_tpv` int NOT NULL AUTO_INCREMENT,
  `ciudad` varchar(25) NOT NULL,
  `tpv_fecha` date NOT NULL,
  `tpv_hora` time NOT NULL,
  PRIMARY KEY (`id_tpv`)
) ENGINE=InnoDB AUTO_INCREMENT=188 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tpv`
--

LOCK TABLES `tpv` WRITE;
/*!40000 ALTER TABLE `tpv` DISABLE KEYS */;
INSERT INTO `tpv` VALUES (111,'Málaga','2024-05-26','00:21:24'),(154,'Estepona','2024-05-26','00:21:24'),(187,'Madrid','2024-05-26','00:21:24');
/*!40000 ALTER TABLE `tpv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'dawfood'
--

--
-- Dumping routines for database 'dawfood'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-19 22:31:25
