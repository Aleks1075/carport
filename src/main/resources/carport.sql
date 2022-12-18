CREATE DATABASE  IF NOT EXISTS `carport` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `carport`;
-- MySQL dump 10.13  Distrib 8.0.28, for macos11 (x86_64)
--
-- Host: localhost    Database: carport
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `bom`
--

DROP TABLE IF EXISTS `bom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bom` (
                       `bom_id` int NOT NULL AUTO_INCREMENT,
                       `order_id` int NOT NULL,
                       `material_id` int NOT NULL,
                       `definition` varchar(45) NOT NULL,
                       `description` varchar(90) NOT NULL,
                       `unit` varchar(45) NOT NULL,
                       `length` int NOT NULL,
                       `price` double NOT NULL,
                       `quantity` int NOT NULL,
                       PRIMARY KEY (`bom_id`),
                       KEY `fk_table1_material1_idx` (`material_id`),
                       KEY `fk_table1_order1_idx` (`order_id`),
                       CONSTRAINT `fk_table1_material1` FOREIGN KEY (`material_id`) REFERENCES `material` (`material_id`),
                       CONSTRAINT `fk_table1_order1` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=685 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bom`
--

LOCK TABLES `bom` WRITE;
/*!40000 ALTER TABLE `bom` DISABLE KEYS */;
INSERT INTO `bom` VALUES (19,1,11,'Stolpe nedgraves 90 cm. i jord','97x97 mm. trykimp. Stolpe','Stk',300,571.08,4),(20,1,9,'Remme i sider, sædles ned i stolper','45x195 mm. spærtræ ubh.','Stk',600,685.5600000000001,2),(21,1,10,'Spær, monteres på rem','45x195 mm. spærtræ ubh.','Stk',240,1028.52,9),(22,1,5,'Understernbrædder til for og bag ende','25x200 mm. trykimp. Brædt','Stk',120,222.16,4),(23,1,6,'Understernbrædder til sider','25x200 mm. trykimp. Brædt','Stk',540,555.5,2),(24,1,7,'Oversternbrædder til forenden','25x125 mm. trykimp. Brædt','Stk',120,43.3,2),(25,1,8,'Oversternbrædder til siderne','25x125 mm. trykimp. Brædt','Stk',540,216.6,2),(26,1,12,'Vandbrædt på stern i sider','19x100 mm. trykimp. Brædt','Stk',540,83,2),(27,1,13,'Vandbrædt på stern i forenden','19x100 mm. trykimp. Brædt','Stk',120,16.8,2),(28,1,14,'Tagplader monteres på spær','Plastmo Ecolite blåtonet','Stk',600,1017,3),(29,1,15,'Skruer til tagplader','Plastmo bundskruer 200 stk.','Pakke',0,858,2),(30,1,16,'Til vindkryds på spær','Hulbånd 1x20 mm. 10 mtr.','Rulle',0,698,2),(31,1,17,'Til montering af spær på rem','Universal 190 mm. højre','Stk',0,224.54999999999995,9),(32,1,18,'Til montering af spær på rem','Universal 190 mm. venstre','Stk',0,224.54999999999995,9),(33,1,19,'Til montering af stern og vandbrædt','4.5x60 mm. skruer 200 stk.','Pakke',0,94.95,1),(34,1,20,'Til montering af universalbeslag og hulbånd','4.0x50 mm. beslagskruer 250 stk.','Pakke',0,734.8499999999999,3),(35,1,21,'Til montering af rem på stolper','bræddebolt 10x120 mm.','Stk',0,207.59999999999997,8),(36,1,22,'Til montering af rem på stolper','firkantskiver 40x40x11 mm.','Stk',0,70.24,8),(109,6,11,'Stolpe nedgraves 90 cm. i jord','97x97 mm. trykimp. Stolpe','Stk',300,571.08,4),(110,6,9,'Remme i sider, sædles ned i stolper','45x195 mm. spærtræ ubh.','Stk',600,685.5600000000001,2),(111,6,10,'Spær, monteres på rem','45x195 mm. spærtræ ubh.','Stk',240,1028.52,9),(112,6,5,'Understernbrædder til for og bag ende','25x200 mm. trykimp. Brædt','Stk',120,222.16,4),(113,6,6,'Understernbrædder til sider','25x200 mm. trykimp. Brædt','Stk',540,555.5,2),(114,6,7,'Oversternbrædder til forenden','25x125 mm. trykimp. Brædt','Stk',120,43.3,2),(115,6,8,'Oversternbrædder til siderne','25x125 mm. trykimp. Brædt','Stk',540,216.6,2),(116,6,12,'Vandbrædt på stern i sider','19x100 mm. trykimp. Brædt','Stk',540,83,2),(117,6,13,'Vandbrædt på stern i forenden','19x100 mm. trykimp. Brædt','Stk',120,16.8,2),(118,6,14,'Tagplader monteres på spær','Plastmo Ecolite blåtonet','Stk',600,1017,3),(119,6,15,'Skruer til tagplader','Plastmo bundskruer 200 stk.','Pakke',0,858,2),(120,6,16,'Til vindkryds på spær','Hulbånd 1x20 mm. 10 mtr.','Rulle',0,698,2),(121,6,17,'Til montering af spær på rem','Universal 190 mm. højre','Stk',0,224.54999999999995,9),(122,6,18,'Til montering af spær på rem','Universal 190 mm. venstre','Stk',0,224.54999999999995,9),(123,6,19,'Til montering af stern og vandbrædt','4.5x60 mm. skruer 200 stk.','Pakke',0,94.95,1),(124,6,20,'Til montering af universalbeslag og hulbånd','4.0x50 mm. beslagskruer 250 stk.','Pakke',0,734.8499999999999,3),(125,6,21,'Til montering af rem på stolper','bræddebolt 10x120 mm.','Stk',0,207.59999999999997,8),(126,6,22,'Til montering af rem på stolper','firkantskiver 40x40x11 mm.','Stk',0,70.24,8),(127,7,11,'Stolpe nedgraves 90 cm. i jord','97x97 mm. trykimp. Stolpe','Stk',300,571.08,4),(128,7,9,'Remme i sider, sædles ned i stolper','45x195 mm. spærtræ ubh.','Stk',600,685.5600000000001,2),(129,7,10,'Spær, monteres på rem','45x195 mm. spærtræ ubh.','Stk',240,1028.52,9),(130,7,5,'Understernbrædder til for og bag ende','25x200 mm. trykimp. Brædt','Stk',120,222.16,4),(131,7,6,'Understernbrædder til sider','25x200 mm. trykimp. Brædt','Stk',540,555.5,2),(132,7,7,'Oversternbrædder til forenden','25x125 mm. trykimp. Brædt','Stk',120,43.3,2),(133,7,8,'Oversternbrædder til siderne','25x125 mm. trykimp. Brædt','Stk',540,216.6,2),(134,7,12,'Vandbrædt på stern i sider','19x100 mm. trykimp. Brædt','Stk',540,83,2),(135,7,13,'Vandbrædt på stern i forenden','19x100 mm. trykimp. Brædt','Stk',120,16.8,2),(136,7,14,'Tagplader monteres på spær','Plastmo Ecolite blåtonet','Stk',600,1017,3),(137,7,15,'Skruer til tagplader','Plastmo bundskruer 200 stk.','Pakke',0,858,2),(138,7,16,'Til vindkryds på spær','Hulbånd 1x20 mm. 10 mtr.','Rulle',0,698,2),(139,7,17,'Til montering af spær på rem','Universal 190 mm. højre','Stk',0,224.54999999999995,9),(140,7,18,'Til montering af spær på rem','Universal 190 mm. venstre','Stk',0,224.54999999999995,9),(141,7,19,'Til montering af stern og vandbrædt','4.5x60 mm. skruer 200 stk.','Pakke',0,94.95,1),(142,7,20,'Til montering af universalbeslag og hulbånd','4.0x50 mm. beslagskruer 250 stk.','Pakke',0,734.8499999999999,3),(143,7,21,'Til montering af rem på stolper','bræddebolt 10x120 mm.','Stk',0,207.59999999999997,8),(144,7,22,'Til montering af rem på stolper','firkantskiver 40x40x11 mm.','Stk',0,70.24,8),(145,8,11,'Stolpe nedgraves 90 cm. i jord','97x97 mm. trykimp. Stolpe','Stk',300,571.08,4),(146,8,9,'Remme i sider, sædles ned i stolper','45x195 mm. spærtræ ubh.','Stk',600,685.5600000000001,2),(147,8,10,'Spær, monteres på rem','45x195 mm. spærtræ ubh.','Stk',240,1028.52,9),(148,8,5,'Understernbrædder til for og bag ende','25x200 mm. trykimp. Brædt','Stk',120,222.16,4),(149,8,6,'Understernbrædder til sider','25x200 mm. trykimp. Brædt','Stk',540,555.5,2),(150,8,7,'Oversternbrædder til forenden','25x125 mm. trykimp. Brædt','Stk',120,43.3,2),(151,8,8,'Oversternbrædder til siderne','25x125 mm. trykimp. Brædt','Stk',540,216.6,2),(152,8,12,'Vandbrædt på stern i sider','19x100 mm. trykimp. Brædt','Stk',540,83,2),(153,8,13,'Vandbrædt på stern i forenden','19x100 mm. trykimp. Brædt','Stk',120,16.8,2),(154,8,14,'Tagplader monteres på spær','Plastmo Ecolite blåtonet','Stk',600,1017,3),(155,8,15,'Skruer til tagplader','Plastmo bundskruer 200 stk.','Pakke',0,858,2),(156,8,16,'Til vindkryds på spær','Hulbånd 1x20 mm. 10 mtr.','Rulle',0,698,2),(157,8,17,'Til montering af spær på rem','Universal 190 mm. højre','Stk',0,224.54999999999995,9),(158,8,18,'Til montering af spær på rem','Universal 190 mm. venstre','Stk',0,224.54999999999995,9),(159,8,19,'Til montering af stern og vandbrædt','4.5x60 mm. skruer 200 stk.','Pakke',0,94.95,1),(160,8,20,'Til montering af universalbeslag og hulbånd','4.0x50 mm. beslagskruer 250 stk.','Pakke',0,734.8499999999999,3),(161,8,21,'Til montering af rem på stolper','bræddebolt 10x120 mm.','Stk',0,207.59999999999997,8),(162,8,22,'Til montering af rem på stolper','firkantskiver 40x40x11 mm.','Stk',0,70.24,8),(199,11,11,'Stolpe nedgraves 90 cm. i jord','97x97 mm. trykimp. Stolpe','Stk',300,571.08,4),(200,11,9,'Remme i sider, sædles ned i stolper','45x195 mm. spærtræ ubh.','Stk',600,685.5600000000001,2),(201,11,10,'Spær, monteres på rem','45x195 mm. spærtræ ubh.','Stk',240,1028.52,9),(202,11,5,'Understernbrædder til for og bag ende','25x200 mm. trykimp. Brædt','Stk',120,222.16,4),(203,11,6,'Understernbrædder til sider','25x200 mm. trykimp. Brædt','Stk',540,555.5,2),(204,11,7,'Oversternbrædder til forenden','25x125 mm. trykimp. Brædt','Stk',120,43.3,2),(205,11,8,'Oversternbrædder til siderne','25x125 mm. trykimp. Brædt','Stk',540,216.6,2),(206,11,12,'Vandbrædt på stern i sider','19x100 mm. trykimp. Brædt','Stk',540,83,2),(207,11,13,'Vandbrædt på stern i forenden','19x100 mm. trykimp. Brædt','Stk',120,16.8,2),(208,11,14,'Tagplader monteres på spær','Plastmo Ecolite blåtonet','Stk',600,1017,3),(209,11,15,'Skruer til tagplader','Plastmo bundskruer 200 stk.','Pakke',0,858,2),(210,11,16,'Til vindkryds på spær','Hulbånd 1x20 mm. 10 mtr.','Rulle',0,698,2),(211,11,17,'Til montering af spær på rem','Universal 190 mm. højre','Stk',0,224.54999999999995,9),(212,11,18,'Til montering af spær på rem','Universal 190 mm. venstre','Stk',0,224.54999999999995,9),(213,11,19,'Til montering af stern og vandbrædt','4.5x60 mm. skruer 200 stk.','Pakke',0,94.95,1),(214,11,20,'Til montering af universalbeslag og hulbånd','4.0x50 mm. beslagskruer 250 stk.','Pakke',0,734.8499999999999,3),(215,11,21,'Til montering af rem på stolper','bræddebolt 10x120 mm.','Stk',0,207.59999999999997,8),(216,11,22,'Til montering af rem på stolper','firkantskiver 40x40x11 mm.','Stk',0,70.24,8),(253,14,11,'Stolpe nedgraves 90 cm. i jord','97x97 mm. trykimp. Stolpe','Stk',300,571.08,4),(254,14,9,'Remme i sider, sædles ned i stolper','45x195 mm. spærtræ ubh.','Stk',600,685.5600000000001,2),(255,14,10,'Spær, monteres på rem','45x195 mm. spærtræ ubh.','Stk',240,1028.52,9),(256,14,5,'Understernbrædder til for og bag ende','25x200 mm. trykimp. Brædt','Stk',120,222.16,4),(257,14,6,'Understernbrædder til sider','25x200 mm. trykimp. Brædt','Stk',540,555.5,2),(258,14,7,'Oversternbrædder til forenden','25x125 mm. trykimp. Brædt','Stk',120,43.3,2),(259,14,8,'Oversternbrædder til siderne','25x125 mm. trykimp. Brædt','Stk',540,216.6,2),(260,14,12,'Vandbrædt på stern i sider','19x100 mm. trykimp. Brædt','Stk',540,83,2),(261,14,13,'Vandbrædt på stern i forenden','19x100 mm. trykimp. Brædt','Stk',120,16.8,2),(262,14,14,'Tagplader monteres på spær','Plastmo Ecolite blåtonet','Stk',600,1017,3),(263,14,15,'Skruer til tagplader','Plastmo bundskruer 200 stk.','Pakke',0,858,2),(264,14,16,'Til vindkryds på spær','Hulbånd 1x20 mm. 10 mtr.','Rulle',0,698,2),(265,14,17,'Til montering af spær på rem','Universal 190 mm. højre','Stk',0,224.54999999999995,9),(266,14,18,'Til montering af spær på rem','Universal 190 mm. venstre','Stk',0,224.54999999999995,9),(267,14,19,'Til montering af stern og vandbrædt','4.5x60 mm. skruer 200 stk.','Pakke',0,94.95,1),(268,14,20,'Til montering af universalbeslag og hulbånd','4.0x50 mm. beslagskruer 250 stk.','Pakke',0,734.8499999999999,3),(269,14,21,'Til montering af rem på stolper','bræddebolt 10x120 mm.','Stk',0,207.59999999999997,8),(270,14,22,'Til montering af rem på stolper','firkantskiver 40x40x11 mm.','Stk',0,70.24,8),(271,15,11,'Stolpe nedgraves 90 cm. i jord','97x97 mm. trykimp. Stolpe','Stk',300,571.08,4),(272,15,9,'Remme i sider, sædles ned i stolper','45x195 mm. spærtræ ubh.','Stk',600,685.5600000000001,2),(273,15,10,'Spær, monteres på rem','45x195 mm. spærtræ ubh.','Stk',240,1028.52,9),(274,15,5,'Understernbrædder til for og bag ende','25x200 mm. trykimp. Brædt','Stk',120,222.16,4),(275,15,6,'Understernbrædder til sider','25x200 mm. trykimp. Brædt','Stk',540,555.5,2),(276,15,7,'Oversternbrædder til forenden','25x125 mm. trykimp. Brædt','Stk',120,43.3,2),(277,15,8,'Oversternbrædder til siderne','25x125 mm. trykimp. Brædt','Stk',540,216.6,2),(278,15,12,'Vandbrædt på stern i sider','19x100 mm. trykimp. Brædt','Stk',540,83,2),(279,15,13,'Vandbrædt på stern i forenden','19x100 mm. trykimp. Brædt','Stk',120,16.8,2),(280,15,14,'Tagplader monteres på spær','Plastmo Ecolite blåtonet','Stk',600,1017,3),(281,15,15,'Skruer til tagplader','Plastmo bundskruer 200 stk.','Pakke',0,858,2),(282,15,16,'Til vindkryds på spær','Hulbånd 1x20 mm. 10 mtr.','Rulle',0,698,2),(283,15,17,'Til montering af spær på rem','Universal 190 mm. højre','Stk',0,224.54999999999995,9),(284,15,18,'Til montering af spær på rem','Universal 190 mm. venstre','Stk',0,224.54999999999995,9),(285,15,19,'Til montering af stern og vandbrædt','4.5x60 mm. skruer 200 stk.','Pakke',0,94.95,1),(286,15,20,'Til montering af universalbeslag og hulbånd','4.0x50 mm. beslagskruer 250 stk.','Pakke',0,734.8499999999999,3),(287,15,21,'Til montering af rem på stolper','bræddebolt 10x120 mm.','Stk',0,207.59999999999997,8),(288,15,22,'Til montering af rem på stolper','firkantskiver 40x40x11 mm.','Stk',0,70.24,8),(469,26,11,'Stolpe nedgraves 90 cm. i jord','97x97 mm. trykimp. Stolpe','Stk',300,571.08,4),(470,26,9,'Remme i sider, sædles ned i stolper','45x195 mm. spærtræ ubh.','Stk',600,685.5600000000001,2),(471,26,10,'Spær, monteres på rem','45x195 mm. spærtræ ubh.','Stk',420,2742.7200000000003,12),(472,26,5,'Understernbrædder til for og bag ende','25x200 mm. trykimp. Brædt','Stk',210,444.32,4),(473,26,6,'Understernbrædder til sider','25x200 mm. trykimp. Brædt','Stk',540,555.5,2),(474,26,7,'Oversternbrædder til forenden','25x125 mm. trykimp. Brædt','Stk',210,86.6,2),(475,26,8,'Oversternbrædder til siderne','25x125 mm. trykimp. Brædt','Stk',540,216.6,2),(476,26,12,'Vandbrædt på stern i sider','19x100 mm. trykimp. Brædt','Stk',540,83,2),(477,26,13,'Vandbrædt på stern i forenden','19x100 mm. trykimp. Brædt','Stk',210,33.6,2),(478,26,14,'Tagplader monteres på spær','Plastmo Ecolite blåtonet','Stk',600,1356,4),(479,26,15,'Skruer til tagplader','Plastmo bundskruer 200 stk.','Pakke',0,858,2),(480,26,16,'Til vindkryds på spær','Hulbånd 1x20 mm. 10 mtr.','Rulle',0,698,2),(481,26,17,'Til montering af spær på rem','Universal 190 mm. højre','Stk',0,299.3999999999999,12),(482,26,18,'Til montering af spær på rem','Universal 190 mm. venstre','Stk',0,299.3999999999999,12),(483,26,19,'Til montering af stern og vandbrædt','4.5x60 mm. skruer 200 stk.','Pakke',0,94.95,1),(484,26,20,'Til montering af universalbeslag og hulbånd','4.0x50 mm. beslagskruer 250 stk.','Pakke',0,734.8499999999999,3),(485,26,21,'Til montering af rem på stolper','bræddebolt 10x120 mm.','Stk',0,207.59999999999997,8),(486,26,22,'Til montering af rem på stolper','firkantskiver 40x40x11 mm.','Stk',0,70.24,8),(487,27,11,'Stolpe nedgraves 90 cm. i jord','97x97 mm. trykimp. Stolpe','Stk',300,571.08,4),(488,27,9,'Remme i sider, sædles ned i stolper','45x195 mm. spærtræ ubh.','Stk',600,685.5600000000001,2),(489,27,10,'Spær, monteres på rem','45x195 mm. spærtræ ubh.','Stk',240,685.6800000000001,6),(490,27,5,'Understernbrædder til for og bag ende','25x200 mm. trykimp. Brædt','Stk',120,222.16,4),(491,27,6,'Understernbrædder til sider','25x200 mm. trykimp. Brædt','Stk',540,555.5,2),(492,27,7,'Oversternbrædder til forenden','25x125 mm. trykimp. Brædt','Stk',120,43.3,2),(493,27,8,'Oversternbrædder til siderne','25x125 mm. trykimp. Brædt','Stk',540,216.6,2),(494,27,12,'Vandbrædt på stern i sider','19x100 mm. trykimp. Brædt','Stk',540,83,2),(495,27,13,'Vandbrædt på stern i forenden','19x100 mm. trykimp. Brædt','Stk',120,16.8,2),(496,27,14,'Tagplader monteres på spær','Plastmo Ecolite blåtonet','Stk',600,1017,3),(497,27,15,'Skruer til tagplader','Plastmo bundskruer 200 stk.','Pakke',0,858,2),(498,27,16,'Til vindkryds på spær','Hulbånd 1x20 mm. 10 mtr.','Rulle',0,698,2),(499,27,17,'Til montering af spær på rem','Universal 190 mm. højre','Stk',0,149.7,6),(500,27,18,'Til montering af spær på rem','Universal 190 mm. venstre','Stk',0,149.7,6),(501,27,19,'Til montering af stern og vandbrædt','4.5x60 mm. skruer 200 stk.','Pakke',0,94.95,1),(502,27,20,'Til montering af universalbeslag og hulbånd','4.0x50 mm. beslagskruer 250 stk.','Pakke',0,734.8499999999999,3),(503,27,21,'Til montering af rem på stolper','bræddebolt 10x120 mm.','Stk',0,207.59999999999997,8),(504,27,22,'Til montering af rem på stolper','firkantskiver 40x40x11 mm.','Stk',0,70.24,8),(523,29,11,'Stolpe nedgraves 90 cm. i jord','97x97 mm. trykimp. Stolpe','Stk',300,571.08,4),(524,29,9,'Remme i sider, sædles ned i stolper','45x195 mm. spærtræ ubh.','Stk',600,685.5600000000001,2),(525,29,10,'Spær, monteres på rem','45x195 mm. spærtræ ubh.','Stk',240,1371.3600000000001,12),(526,29,5,'Understernbrædder til for og bag ende','25x200 mm. trykimp. Brædt','Stk',120,222.16,4),(527,29,6,'Understernbrædder til sider','25x200 mm. trykimp. Brædt','Stk',540,555.5,2),(528,29,7,'Oversternbrædder til forenden','25x125 mm. trykimp. Brædt','Stk',120,43.3,2),(529,29,8,'Oversternbrædder til siderne','25x125 mm. trykimp. Brædt','Stk',540,216.6,2),(530,29,12,'Vandbrædt på stern i sider','19x100 mm. trykimp. Brædt','Stk',540,83,2),(531,29,13,'Vandbrædt på stern i forenden','19x100 mm. trykimp. Brædt','Stk',120,16.8,2),(532,29,14,'Tagplader monteres på spær','Plastmo Ecolite blåtonet','Stk',600,1017,3),(533,29,15,'Skruer til tagplader','Plastmo bundskruer 200 stk.','Pakke',0,858,2),(534,29,16,'Til vindkryds på spær','Hulbånd 1x20 mm. 10 mtr.','Rulle',0,698,2),(535,29,17,'Til montering af spær på rem','Universal 190 mm. højre','Stk',0,299.3999999999999,12),(536,29,18,'Til montering af spær på rem','Universal 190 mm. venstre','Stk',0,299.3999999999999,12),(537,29,19,'Til montering af stern og vandbrædt','4.5x60 mm. skruer 200 stk.','Pakke',0,94.95,1),(538,29,20,'Til montering af universalbeslag og hulbånd','4.0x50 mm. beslagskruer 250 stk.','Pakke',0,734.8499999999999,3),(539,29,21,'Til montering af rem på stolper','bræddebolt 10x120 mm.','Stk',0,207.59999999999997,8),(540,29,22,'Til montering af rem på stolper','firkantskiver 40x40x11 mm.','Stk',0,70.24,8),(667,37,11,'Stolpe nedgraves 90 cm. i jord','97x97 mm. trykimp. Stolpe','Stk',300,571.08,4),(668,37,9,'Remme i sider, sædles ned i stolper','45x195 mm. spærtræ ubh.','Stk',600,685.5600000000001,2),(669,37,10,'Spær, monteres på rem','45x195 mm. spærtræ ubh.','Stk',240,1028.52,9),(670,37,5,'Understernbrædder til for og bag ende','25x200 mm. trykimp. Brædt','Stk',120,222.16,4),(671,37,6,'Understernbrædder til sider','25x200 mm. trykimp. Brædt','Stk',540,555.5,2),(672,37,7,'Oversternbrædder til forenden','25x125 mm. trykimp. Brædt','Stk',120,43.3,2),(673,37,8,'Oversternbrædder til siderne','25x125 mm. trykimp. Brædt','Stk',540,216.6,2),(674,37,12,'Vandbrædt på stern i sider','19x100 mm. trykimp. Brædt','Stk',540,83,2),(675,37,13,'Vandbrædt på stern i forenden','19x100 mm. trykimp. Brædt','Stk',120,16.8,2),(676,37,14,'Tagplader monteres på spær','Plastmo Ecolite blåtonet','Stk',600,1017,3),(677,37,15,'Skruer til tagplader','Plastmo bundskruer 200 stk.','Pakke',0,858,2),(678,37,16,'Til vindkryds på spær','Hulbånd 1x20 mm. 10 mtr.','Rulle',0,698,2),(679,37,17,'Til montering af spær på rem','Universal 190 mm. højre','Stk',0,224.54999999999995,9),(680,37,18,'Til montering af spær på rem','Universal 190 mm. venstre','Stk',0,224.54999999999995,9),(681,37,19,'Til montering af stern og vandbrædt','4.5x60 mm. skruer 200 stk.','Pakke',0,94.95,1),(682,37,20,'Til montering af universalbeslag og hulbånd','4.0x50 mm. beslagskruer 250 stk.','Pakke',0,734.8499999999999,3),(683,37,21,'Til montering af rem på stolper','bræddebolt 10x120 mm.','Stk',0,207.59999999999997,8),(684,37,22,'Til montering af rem på stolper','firkantskiver 40x40x11 mm.','Stk',0,70.24,8);
/*!40000 ALTER TABLE `bom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `material` (
                            `material_id` int NOT NULL AUTO_INCREMENT,
                            `description` varchar(90) NOT NULL,
                            `type` varchar(45) NOT NULL,
                            `unit` varchar(45) NOT NULL,
                            `unit_price` double NOT NULL,
                            PRIMARY KEY (`material_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
INSERT INTO `material` VALUES (5,'25x200 mm. trykimp. Brædt','træ & tagplader','Stk',55.54),(6,'25x200 mm. trykimp. Brædt','træ & tagplader','Stk',55.55),(7,'25x125 mm. trykimp. Brædt','træ & tagplader','Stk',21.65),(8,'25x125 mm. trykimp. Brædt','træ & tagplader','Stk',21.66),(9,'45x195 mm. spærtræ ubh.','træ & tagplader','Stk',57.13),(10,'45x195 mm. spærtræ ubh.','træ & tagplader','Stk',57.14),(11,'97x97 mm. trykimp. Stolpe','træ & tagplader','Stk',47.59),(12,'19x100 mm. trykimp. Brædt','træ & tagplader','Stk',8.3),(13,'19x100 mm. trykimp. Brædt','træ & tagplader','Stk',8.4),(14,'Plastmo Ecolite blåtonet','træ & tagplader','Stk',339),(15,'Plastmo bundskruer 200 stk.','beslag & skruer','Pakke',429),(16,'Hulbånd 1x20 mm. 10 mtr.','beslag & skruer','Rulle',349),(17,'Universal 190 mm. højre','beslag & skruer','Stk',24.95),(18,'Universal 190 mm. venstre','beslag & skruer','Stk',24.95),(19,'4.5x60 mm. skruer 200 stk.','beslag & skruer','Pakke',94.95),(20,'4.0x50 mm. beslagskruer 250 stk.','beslag & skruer','Pakke',244.95),(21,'bræddebolt 10x120 mm.','beslag & skruer','Stk',25.95),(22,'firkantskiver 40x40x11 mm.','beslag & skruer','Stk',8.78);
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
                         `order_id` int NOT NULL AUTO_INCREMENT,
                         `username` varchar(45) NOT NULL,
                         `order_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         `carport_length` int NOT NULL,
                         `carport_width` int NOT NULL,
                         `order_status` varchar(45) NOT NULL,
                         `price` double NOT NULL,
                         PRIMARY KEY (`order_id`),
                         KEY `fk_order_user1_idx` (`username`),
                         CONSTRAINT `fk_order_user1` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (1,'Aleks','2022-12-12 00:16:39',390,240,'Afventer',7552.26),(6,'Kornelija','2022-12-12 00:47:10',420,240,'Afventer',7552.26),(7,'Kornelija','2022-12-12 00:53:24',420,240,'Afventer',7552.26),(8,'Kornelija','2022-12-12 07:22:33',420,240,'Afventer',7552.26),(11,'Kornelija','2022-12-12 14:28:41',420,240,'Godkendt',7552.26),(14,'Aleks','2022-12-14 10:01:59',420,240,'Arkiveret',7552.26),(15,'Aleks','2022-12-14 11:00:53',420,240,'Afvist',7552.26),(26,'Aleks','2022-12-15 19:32:08',600,420,'Arkiveret',10037.420000000002),(27,'Aleks','2022-12-16 08:53:43',240,240,'Arkiveret',7059.719999999999),(29,'Aleks','2022-12-17 23:27:58',570,240,'Betalt',8044.799999999999),(37,'Aleks','2022-12-18 11:39:56',420,240,'Afventer',7552.26);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `postal_code`
--

DROP TABLE IF EXISTS `postal_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `postal_code` (
                               `post_code_id` int NOT NULL,
                               `name` varchar(45) NOT NULL,
                               PRIMARY KEY (`post_code_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `postal_code`
--

LOCK TABLES `postal_code` WRITE;
/*!40000 ALTER TABLE `postal_code` DISABLE KEYS */;
INSERT INTO `postal_code` VALUES (2300,'Amager'),(2500,'Valby');
/*!40000 ALTER TABLE `postal_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
                        `username` varchar(45) NOT NULL,
                        `email` varchar(45) NOT NULL,
                        `password` varchar(45) NOT NULL,
                        `address` varchar(45) NOT NULL,
                        `role` varchar(45) NOT NULL DEFAULT 'customer',
                        `postcode` int NOT NULL,
                        `phone_number` int NOT NULL,
                        PRIMARY KEY (`username`),
                        KEY `fk_user_postal_code_idx` (`postcode`),
                        CONSTRAINT `fk_user_postal_code` FOREIGN KEY (`postcode`) REFERENCES `postal_code` (`post_code_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('Aleks','ab@cph.dk','1234','Kollegie 1','Customer',2500,93601903),('Kornelija','kb@cph.dk','1234','Kollegie 4','Customer',2500,33445566),('Louise','lg@fog.dk','1234','Firskovvej 20','Admin',2500,39393939),('Miso','mb@cph.dk','1234','Kollegie 3','Customer',2500,33445566),('Pelle','pd@fog.dk','1234','Kollegie 2','Customer',2300,44556677);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-18 22:35:35
