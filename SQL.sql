-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: htttql
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Dumping data for table `chi_tiet_hoa_don_ban`
--

LOCK TABLES `chi_tiet_hoa_don_ban` WRITE;
/*!40000 ALTER TABLE `chi_tiet_hoa_don_ban` DISABLE KEYS */;
INSERT INTO `chi_tiet_hoa_don_ban` VALUES (1,5,1,1),(2,5,2,5),(3,5,3,4),(4,4,4,3),(5,3,5,7),(6,4,6,6),(7,7,7,23),(8,7,8,6),(9,2,9,12),(10,3,10,13),(11,10,11,23),(12,4,12,6),(13,5,13,18),(14,4,14,22),(15,5,15,14),(16,4,16,18),(17,1,17,11),(18,2,17,15),(19,3,17,16);
/*!40000 ALTER TABLE `chi_tiet_hoa_don_ban` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `chi_tiethdnhap`
--

LOCK TABLES `chi_tiethdnhap` WRITE;
/*!40000 ALTER TABLE `chi_tiethdnhap` DISABLE KEYS */;
INSERT INTO `chi_tiethdnhap` VALUES (1,25,200,1,1),(2,40,300,2,2),(3,100,200,3,2),(4,40,50,4,2),(5,25,200,5,2),(6,100,300,6,6),(7,100,50,7,6),(8,240,200,8,5),(9,25,50,9,7),(10,40,250,1,8),(11,240,200,2,7),(12,25,300,3,9),(13,100,250,4,7),(14,240,250,5,5);
/*!40000 ALTER TABLE `chi_tiethdnhap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `danh_muc_san_pham`
--

LOCK TABLES `danh_muc_san_pham` WRITE;
/*!40000 ALTER TABLE `danh_muc_san_pham` DISABLE KEYS */;
INSERT INTO `danh_muc_san_pham` VALUES (1,'có các sản phẩm iphone, samsung, oppo','Điện Thoại'),(2,'có các sản phẩm như Asus, Thinkpad, MIS','Laptop'),(3,'tai nghe rất êm phù hợp với mọi lứa tuổi','Airpost');
/*!40000 ALTER TABLE `danh_muc_san_pham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `hoa_don_ban`
--

LOCK TABLES `hoa_don_ban` WRITE;
/*!40000 ALTER TABLE `hoa_don_ban` DISABLE KEYS */;
INSERT INTO `hoa_don_ban` VALUES (1,0.15,'2023-04-25',200,'giao dịch thành công',12,1),(2,0.3,'2023-04-19',167,'giao dịch thành công',15,1),(3,0.2,'2023-05-03',120,'giao dịch thành công',14,1),(4,0.1,'2023-05-10',119,'giao dịch thành công',20,4),(5,0.1,'2023-05-04',340,'giao dịch thành công',17,4),(6,0.1,'2023-05-08',539,'giao dịch thành công',14,5),(7,0.1,'2023-04-28',27,'giao dịch thành công',16,6),(8,0.1,'2023-04-28',100,'giao dịch thất bại',13,8),(9,0.15,'2023-04-29',18,'giao dịch thành công',19,8),(10,0.15,'2023-05-03',290,'giao dịch thành công',21,8),(11,0.15,'2023-05-07',100,'giao dịch thành công',22,8),(12,0.15,'2023-05-10',56,'giao dịch thành công',15,8),(13,0.5,'2023-05-08',20,'giao dịch thành công',18,8),(14,0.3,'2023-05-09',25,'giao dịch thành công',19,8),(15,0.5,'2023-05-06',700,'giao dịch thành công',17,10),(16,0.2,'2023-05-05',180,'giao dịch thành công',20,10),(17,6,'2023-05-10',1515,'Done',12,1);
/*!40000 ALTER TABLE `hoa_don_ban` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `hoa_don_nhap`
--

LOCK TABLES `hoa_don_nhap` WRITE;
/*!40000 ALTER TABLE `hoa_don_nhap` DISABLE KEYS */;
INSERT INTO `hoa_don_nhap` VALUES (1,'2023-03-19',3500,'đã giao thành công',1,1),(2,'2023-03-19',2500,'đã giao thành công',1,4),(3,'2023-03-19',1600,'đã giao thành công',1,5),(4,'2023-03-19',7000,'đã giao thành công',1,2),(5,'2023-03-27',3600,'đã giao thành công',1,7),(6,'2023-03-27',6000,'đã giao thành công',2,6),(7,'2023-03-27',5500,'đã giao thành công',2,5),(8,'2023-03-27',1700,'đã giao thành công',2,8),(9,'2023-03-27',2600,'đã hủy đơn hàng',2,9),(10,'2023-04-09',8000,'đã giao thành công',3,5),(11,'2023-04-09',1700,'đã giao thành công',3,3),(12,'2023-04-09',8000,'đã hủy đơn hàng',3,1),(13,'2023-04-16',8900,'đã hủy đơn hàng',3,11),(14,'2023-04-16',7822,'đã hủy đơn hàng',4,13),(15,'2023-04-16',7823,'đã giao thành công',4,1),(16,'2023-05-03',3455,'đang giao',4,6),(17,'2023-05-03',2000,'đã giao thành công',4,17),(18,'2023-05-03',1000,'đang giao',5,20),(19,'2023-05-03',1500,'đang giao',5,2),(20,'2023-05-10',3200,'đang giao',5,5);
/*!40000 ALTER TABLE `hoa_don_nhap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `khach_hang`
--

LOCK TABLES `khach_hang` WRITE;
/*!40000 ALTER TABLE `khach_hang` DISABLE KEYS */;
INSERT INTO `khach_hang` VALUES (12,'3209 Ferndale Acres Drive','khaiozone@gmail.com',_binary '\0','1997-08-22','362-3825','Baranczyk, Kay'),(13,'502 Oak Street','khaiozone@gmail.com',_binary '','1997-08-22','362-3825','Trupke, Tim'),(14,'218 Nob Hill Lane','khaiozone@gmail.com',_binary '\0','1997-08-22','362-3825','Gustafson, Bob'),(15,'426 South Emery Street','khaiozone@gmail.com',_binary '','1997-08-22','362-3825','VanDenHoven, Bob'),(16,'502 Oak Street','khaiozone@gmail.com',_binary '\0','1997-08-22','362-3825','BenDixen, Lonnie'),(17,'426 South Emery Street','khaiozone@gmail.com',_binary '\0','1997-08-22','362-3825','Frank, Tim'),(18,'179 Gwynn Street','khaiozone@gmail.com',_binary '','1997-08-22','362-3825','Raboin, Chase'),(19,'3509 Grassy Plains Drive','khaiozone@gmail.com',_binary '','1997-08-22','362-3825','Halla, Al'),(20,'3078 Hawk Ridge Trail','khaiozone@gmail.com',_binary '\0','1997-08-22','362-3825','Rautmann, Orval'),(21,'1016 Highland Springs','khaiozone@gmail.com',_binary '\0','1997-08-22','362-3825','Knipp, Rosalind'),(22,'179 Gwynn Street','khaiozone@gmail.com',_binary '','1997-08-22','362-3825','Kline, Kent'),(23,'218 Nob Hill Lane','khaiozone@gmail.com',_binary '','1997-08-22','362-3825','Badura, Shannon');
/*!40000 ALTER TABLE `khach_hang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `luong_thang`
--

LOCK TABLES `luong_thang` WRITE;
/*!40000 ALTER TABLE `luong_thang` DISABLE KEYS */;
INSERT INTO `luong_thang` VALUES (1,2,3,200,2900,1),(2,3,3,400,4300,2),(3,4,3,300,5400,3),(4,1,3,50,1550,4),(5,0,3,50,350,5),(6,0,3,50,350,6),(7,0,4,400,800,7),(8,4,4,400,5600,8),(9,4,4,400,5600,9),(10,3,1,300,4000,10),(11,2,1,200,2700,11),(12,1,1,100,1400,12),(13,5,7,800,7500,13),(14,2,7,200,3300,14),(15,3,7,400,4700,15),(16,4,9,500,6200,16),(17,1,11,50,2350,17),(18,2,1,0,2500,18),(19,6,2,900,8300,19),(20,2,3,300,3000,20);
/*!40000 ALTER TABLE `luong_thang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ngay_cong`
--

LOCK TABLES `ngay_cong` WRITE;
/*!40000 ALTER TABLE `ngay_cong` DISABLE KEYS */;
INSERT INTO `ngay_cong` VALUES (1,'2023-04-16','2023-04-16',1,'2023-04-16',1),(2,'2023-04-16','2023-04-16',1.5,'2023-04-16',2),(3,'2023-04-16','2023-04-16',1,'2023-04-16',3),(4,'2023-04-16','2023-04-16',0.8,'2023-04-16',4),(5,'2023-05-10','2023-05-10',1.5,'2023-05-10',5),(6,'2023-05-10','2023-05-10',1.5,'2023-05-10',6),(7,'2023-05-10','2023-05-10',1.5,'2023-05-10',7),(8,'2023-05-10','2023-05-10',1.5,'2023-05-10',8),(9,'2023-05-10','2023-05-10',1.5,'2023-05-10',9),(10,'2023-05-10','2023-05-10',1.5,'2023-05-10',10);
/*!40000 ALTER TABLE `ngay_cong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `nha_cung_cap`
--

LOCK TABLES `nha_cung_cap` WRITE;
/*!40000 ALTER TABLE `nha_cung_cap` DISABLE KEYS */;
INSERT INTO `nha_cung_cap` VALUES (1,'Hà Nội','0274635563','A'),(2,'Quảng Ninh','0928889361','B'),(3,'Hưng Yên','0989876546','C'),(4,'Hà Nội','0181223785','D'),(5,'Nam Định','0989112324','E');
/*!40000 ALTER TABLE `nha_cung_cap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `nhan_vien`
--

LOCK TABLES `nhan_vien` WRITE;
/*!40000 ALTER TABLE `nhan_vien` DISABLE KEYS */;
INSERT INTO `nhan_vien` VALUES (1,NULL,'Hà Nội',_binary '','bhn8c95eb4e-89be-4a2c-9400-3a49a0d749fd.jpg','2001-08-11',NULL,'0888173892','Nguyễn Thành Long'),(2,NULL,'Hà Nội',_binary '\0','bhn4d661a11-71e2-4e72-abc0-44eeb331a2b4.jpg','2000-09-18',NULL,'0989826634','Nguyễn Minh Hằng'),(3,NULL,'Nam Định',_binary '\0','bhn84bbf236-d34d-46a3-9c1c-6f458be99aa7.jpg','2002-03-12',NULL,'0624384908','Nguyễn Thị Lan Anh'),(4,NULL,'Đà Nẵng',_binary '','bhn7b7961cf-b345-4df9-a22c-ccff10f29188.jpg','2002-07-16',NULL,'0725378491','Trần Phú Quý'),(5,NULL,'Hải Phòng',_binary '','bhn6e8926fc-6937-49a0-ba81-40ff0fb98b0d.jpg','2001-01-19',NULL,'0862734627','Nguyễn văn Trỗi'),(6,NULL,'Nha Trang',_binary '','bhnd63003cf-2125-4cda-a169-42bf443bb81e.jpg','2002-05-12',NULL,'0938466734','Phạm Văn Đồng'),(7,NULL,'Hà Nội',_binary '','bhn2781a73d-bade-4861-8f94-ad3fd7ce80fa.jpg','2000-05-18',NULL,'0162647839','Lê Minh Thắng'),(8,NULL,'Hà Nội',_binary '','bhnf2c457fa-9af7-435d-a499-5efa254b597f.jpg','2003-08-07',NULL,'0983334674','Bừi Trung Đức'),(9,NULL,'Hưng Yên',_binary '\0','bhn8e45a492-f0b0-453c-96b6-c70ce9daadd2.jpg','2005-01-29',NULL,'0572837711','Phạm Thị Hà'),(10,NULL,'Hà Nội',_binary '','bhnfea3bd00-2768-448a-bad2-b250b71dcc8f.jpg','2002-03-21',NULL,'0920027765','Ngô Minh Tiến'),(11,NULL,'Nam Định',_binary '','bhn937251ab-aef8-4828-9953-c1a3a4aef1e4.jpg','2002-05-27',NULL,'0001845387','Nguyễn Việt Anh'),(12,NULL,'Hưng Yên',_binary '','bhncfb44dde-1e7c-42a7-894c-e0d92e725652.jpg','2004-03-07',NULL,'0993885517','Ngô Bá Khá'),(13,NULL,'Hà Nội',_binary '','bhnbb17878f-456c-481c-ae3b-2e97f367590b.jpg','2001-03-17',NULL,'0026377739','Trần Đức Bo'),(14,NULL,'Hưng Yên',_binary '\0','bhn305da67f-4836-489f-b5a2-34c8cddce541.jpg','2002-04-13',NULL,'0888173892','Phạm Thị Lan Hương'),(15,NULL,'Hà Nội',_binary '','bhnc83d7da9-a12f-46c0-b63d-61f94a963bac.jpg','2002-07-17',NULL,'0883553179','Nguyễn Minh Cẩm'),(16,NULL,'Nam Định',_binary '','bhn9ecfad07-bb2d-4052-b176-0e92859cc17d.jpg','2003-03-04',NULL,'0835478213','Phạm Trung Trực'),(17,NULL,'Nha Trang',_binary '\0','bhn701d4f09-b753-44d3-8be0-b5bbec65dff4.jpg','2001-11-11',NULL,'0897776592','Nguyễn Thị Xuân'),(18,NULL,'Nam Định',_binary '','bhn6b8fb957-e4de-4730-bbc1-6cc96a4432d1.jpg','2001-08-11',NULL,'0986812731','Nguyễn Văn Mạnh'),(19,NULL,'Nam Định',_binary '','bhn63777b29-b683-4a27-9b02-7f936ccbce5a.jpg','2007-03-10',NULL,'0987992536','Bùi Huy Hiệu'),(20,NULL,'Bắc Giang',_binary '\0','bhnb099e6f8-23ef-4d11-bf9b-6c085539dce9.jpg','2001-06-09',NULL,'0901299823','Bùi Thị Duyên');
/*!40000 ALTER TABLE `nhan_vien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `san_pham`
--

LOCK TABLES `san_pham` WRITE;
/*!40000 ALTER TABLE `san_pham` DISABLE KEYS */;
INSERT INTO `san_pham` VALUES (1,_binary '',1200,'bhneb3cf8e2-620d-4150-9ce2-034848e7fac9.webp','Loại CPU	AMD Ryzen 7 4800H',50,'Asus gaming Rog Strix G15 ',2),(2,_binary '\0',1300,'bhn1baaafef-c1da-479c-aced-cde0a2b03ae7.jpg','Loại CPU	AMD Ryzen 7 4800H',40,'Laptop MSI Modern 14',2),(3,_binary '',1399,'bhn8cb0b5a2-0a1a-4ad2-a9e1-a1a918565548.jpg','Hệ điều hành - Operation System	Windows 10 Home bản quyền',35,'Asus TUF Gaming F15',2),(4,_binary '',999,'bhnfe42e072-60e1-4334-8b6e-5f01ad3fe037.jpg','CPU: 11th Intel® Core i7-1165G7  2.8 Ghz Upto 4.7GHz,  4Cores  8 Threads, Cache 12MB Vpro.',45,'Dell Latitude 7320',2),(5,_binary '\0',899,'bhnbe33fd8c-0db8-4efc-960b-62a3fff1a6bc.jpg','CPU. 8th Intel Core i5-8365U 1.6Ghz Upto 4.1 GHz,  4Cores  8 Threads, Cache 6MB Vpro',60,'Latitude 7220 Rugged',3),(6,_binary '\0',2000,'bhnc0cbed14-c61e-4e04-97fb-932d4f7658dd.webp','CPU: 11th I7 -11950H  2.6GHz up to 5.0GHz, 8 Cores 16 Threads , 24 MB Cache  Vpro',100,'hinkpad P15 Gen 2 ',2),(7,_binary '\0',1799,'bhncabaae2b-b41e-4545-b819-d21062180941.jpg','CPU: 1th core i7-11800H 2.3GHz, up to 4.6GHz, 8 Cores. 16 Threads 24MB Cache. Vpro.',20,'ThinkPad P1 Gen 4',2),(8,_binary '',1800,'bhn6b5cf2f0-7d27-477a-94c8-170713dbe828.jpg','CPU. 10th core i9-10885H 2.4GHz, up to 5.3GHz, 8Cores .16 Threads, Cache 16MB, vPro.',35,'ThinkPad P17 10th Gen',2),(9,_binary '\0',2300,'bhn09dac68d-a7f2-4401-b255-305497960ffe.jpg','CPU: 8th. Intel® Core i7 8665U  1.9Ghz Upto 4.8GHz. 4Cores .8 Threads, Cache 8MB.',28,'Thinkpad P43s',2),(10,_binary '',3000,'bhn6c82008f-c394-4c30-8e63-8a3a0f44ebea.jpg','CPU. 11th Intel Core i7 1195G7  2.9Ghz Upto 5.0GHz. 4Cores  8 Threads, Cache 12MB  Vpro..',78,'LG gram 15',2),(11,_binary '\0',60,'bhnf5160e59-d02e-41fa-9ba7-14ac35666f31.jpg','CPU: 10th core i7-10875H 2.3GHz  Upto 5.1GHz, 8 Cores 16Threads. 16MB Cache..',35,'Razer Blade Pro 17',3),(12,_binary '\0',20,'bhnf10d9373-719d-4df1-9068-36df5602e46b.jpg','CPU: 10th core i7-10875H 2.3GHz  Upto 5.1GHz, 8 Cores 16Threads. 16MB Cache..',49,'Razer Blade Pro 17 i7',3),(13,_binary '',40,'bhn75cef4e0-1d55-403a-8200-dd0fc1a81dee.jpg','CPU: 10th core i7 10750H 2.6GHz up to 5.0GHz. 6Cores  12Threads.  12MB Cache.',12,'Acer Predator Helios',2),(14,_binary '\0',399,'bhn1ef75f5e-4874-4655-8523-9230b4e4bace.jpg','Loại CPU	AMD Ryzen 7 4800H',60,' iPhone 12',1),(15,_binary '',279,'bhn7edb3248-d5dc-408f-85ac-3b859ce35bba.jpg','CPU. 11th Intel Core i7 1195G7  2.9Ghz Upto 5.0GHz. 4Cores  8 Threads, Cache 12MB  Vpro..',3,'Iphone11',1),(16,_binary '\0',299,'bhn835423e4-b550-48b2-86f3-160cb6c9ba25.png','CPU: 10th core i7-10875H 2.3GHz  Upto 5.1GHz, 8 Cores 16Threads. 16MB Cache..',26,'Iphone11 promax',1),(17,_binary '',300,'bhn094dbe1d-4927-402e-8024-f84ba752ec16.jpg','CPU. 10th core i9-10885H 2.4GHz, up to 5.3GHz, 8Cores .16 Threads, Cache 16MB, vPro.',40,'Iphone XS',1),(18,_binary '',480,'bhneb63bc3b-6670-4383-a684-009cddc561d4.jpg','CPU: 10th core i7-10875H 2.3GHz  Upto 5.1GHz, 8 Cores 16Threads. 16MB Cache..',200,'Iphone XS max',1),(19,_binary '',179,'bhne664afc6-6227-4171-adad-2b8fb745739a.jpg','2 Nano SIMHỗ trợ 5G',34,'xiaomi',1),(20,_binary '\0',200,'bhna7bb6e00-a2b2-4949-ae91-84cf686834cb.jpg','Super AMOLED Plus6.7\"Full HD+',28,'Xiaomi 11T',1),(21,_binary '',219,'bhn1421275e-c3be-42af-a271-d073e1303320.jpg','CPU: 10th core i7-10875H 2.3GHz  Upto 5.1GHz, 8 Cores 16Threads. 16MB Cache..',55,'Samsung Galaxy A73',1),(22,_binary '\0',300,'bhnc794d9c0-f16b-444a-a6da-6c0535b320dd.jpg','CPU: 10th core i7-10875H 2.3GHz  Upto 5.1GHz, 8 Cores 16Threads. 16MB Cache..',100,'Samsung Galaxy M53',1),(23,_binary '',180,'bhn9a15759f-03b4-4c22-83c6-c5a96bacf338.jpg','Vip',230,'OPPO Reno6',1),(24,_binary '\0',2600,'bhn1dfe4781-7fd8-456a-a274-9331701832ce.jpg','Tai nghe không dây được Apple thiết kế cho các thiết bị Apple',30,'Vertu',1),(25,_binary '',79,'bhnc18548e7-6ba2-4b0b-8378-756301afc71b.jpg','Dải tần đáp ứng: 50~20000Hz',70,'Airpod Pro',3),(26,_binary '\0',68,'bhn00ecc70e-d087-4571-84ef-db540f285708.jpg','Tần số: 18- 22000 Hz',80,'Maono AU-MH501',3),(27,_binary '\0',73,'bhn5b5fbc72-212d-4dcb-9f4c-bed1f1e24359.jpg','Tai nghe không dây được Apple thiết kế cho các thiết bị Apple',90,'AKG K92',3),(28,_binary '',29,'bhn58c76b2a-45cc-49c6-827c-633246520c02.jpg','Tai nghe không dây được Apple thiết kế cho các thiết bị Apple',110,'MARSHALL MINOR 3',3),(29,_binary '',37,'bhn12552d24-9c61-4872-b583-898cf15d0b33.jpg','Tai nghe không dây được Apple thiết kế cho các thiết bị Apple',15,'BLUETOOTH G11',3),(30,_binary '\0',98,'bhn01dff4cd-0cf5-4bb9-9c6e-a066aa3af7c7.jpg','cute',23,'Best-selling Cat Ear headphone Wireless Headsets With Mic',3),(31,_binary '',55,'bhn01dff4cd-0cf5-4bb9-9c6e-a066aa3af7c7.jpg','- Kích thước Driver: 50 mm',40,'DareU EH416 RGB',3);
/*!40000 ALTER TABLE `san_pham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tai_khoan`
--

LOCK TABLES `tai_khoan` WRITE;
/*!40000 ALTER TABLE `tai_khoan` DISABLE KEYS */;
INSERT INTO `tai_khoan` VALUES ('nhanvien1','1',_binary '',1),('nhanvien10','1',_binary '',10),('nhanvien11','1',_binary '',11),('nhanvien12','1',_binary '',12),('nhanvien13','1',_binary '',13),('nhanvien14','1',_binary '',14),('nhanvien15','1',_binary '',15),('nhanvien16','1',_binary '',16),('nhanvien17','1',_binary '',17),('nhanvien18','1',_binary '',18),('nhanvien19','1',_binary '',19),('nhanvien2','1',_binary '',2),('nhanvien20','1',_binary '',20),('nhanvien3','1',_binary '',3),('nhanvien4','1',_binary '',4),('nhanvien5','1',_binary '',5),('nhanvien6','1',_binary '',6),('nhanvien7','1',_binary '',7),('nhanvien8','1',_binary '',8),('nhanvien9','1',_binary '',9);
/*!40000 ALTER TABLE `tai_khoan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `thong_bao`
--

LOCK TABLES `thong_bao` WRITE;
/*!40000 ALTER TABLE `thong_bao` DISABLE KEYS */;
INSERT INTO `thong_bao` VALUES (1,'2023-02-14','giao dịch thành công',15),(2,'2023-03-17','hủy đơn hàng thành công',22),(3,'2022-12-29','tặng voucher cho khách hàng',14),(4,'2023-03-17','giao dịch thành công',16),(5,'2023-04-11','tặng voucher cho khách hàng',18),(6,'2023-05-01','tặng voucher cho khách hàng',19),(7,'2023-03-17','giao dịch thành công',23),(8,'2023-04-11','hủy đơn hàng thành công',12),(9,'2023-01-02','giao dịch thành công',12),(10,'2023-03-17','tặng voucher cho khách hàng',21),(11,'2023-03-15','tặng voucher cho khách hàng',13),(12,'2023-04-11','giao dịch thành công',15),(13,'2023-04-11','giao dịch thành công',20);
/*!40000 ALTER TABLE `thong_bao` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-10 19:12:23
