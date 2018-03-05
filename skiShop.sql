-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ski_oprema
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `brend`
--

DROP TABLE IF EXISTS `brend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `brend` (
  `brend_id` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(45) NOT NULL,
  PRIMARY KEY (`brend_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brend`
--

LOCK TABLES `brend` WRITE;
/*!40000 ALTER TABLE `brend` DISABLE KEYS */;
INSERT INTO `brend` VALUES (1,'HEAD'),(2,'BRIKO'),(3,'BLIZZARD');
/*!40000 ALTER TABLE `brend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kategorija`
--

DROP TABLE IF EXISTS `kategorija`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kategorija` (
  `kategorija_id` int(11) NOT NULL AUTO_INCREMENT,
  `kategorija` varchar(45) NOT NULL,
  PRIMARY KEY (`kategorija_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kategorija`
--

LOCK TABLES `kategorija` WRITE;
/*!40000 ALTER TABLE `kategorija` DISABLE KEYS */;
INSERT INTO `kategorija` VALUES (1,'Skije'),(2,'Snowboard'),(3,'Cipele'),(4,'Kacige'),(5,'Naocare'),(6,'Torbe'),(7,'Stapovi');
/*!40000 ALTER TABLE `kategorija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `korisnik`
--

DROP TABLE IF EXISTS `korisnik`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `korisnik` (
  `korisnik_id` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(45) NOT NULL,
  `prezime` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `sifra` varchar(45) NOT NULL,
  `adresa` varchar(45) NOT NULL,
  `grad` varchar(45) NOT NULL,
  `pravo` int(11) NOT NULL,
  PRIMARY KEY (`korisnik_id`),
  KEY `pravo_idx` (`pravo`),
  CONSTRAINT `pravo` FOREIGN KEY (`pravo`) REFERENCES `prava` (`prava_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `korisnik`
--

LOCK TABLES `korisnik` WRITE;
/*!40000 ALTER TABLE `korisnik` DISABLE KEYS */;
INSERT INTO `korisnik` VALUES (1,'Milan','Brkic','milanb@gmail.com','123abc','Kneza Danila 34','Beograd',1),(4,'Nenad','Djordjevic','nesa@gmail.com','nesa123','Bacvanska','Beograd',2),(5,'Milan','Zivkovic','zikaslika@hotmail.com','zikaslika','Brace Jerkovic','Beograd',2),(6,'Sebastian','Vettel','sebastian@gmail.com','sebaf1','Boulevard des Moulins','Monte Carlo',2);
/*!40000 ALTER TABLE `korisnik` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `porudzbina`
--

DROP TABLE IF EXISTS `porudzbina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `porudzbina` (
  `porudzbina_id` int(11) NOT NULL AUTO_INCREMENT,
  `korisnik_id` int(11) NOT NULL,
  `datum` date NOT NULL,
  PRIMARY KEY (`porudzbina_id`),
  KEY `korisnik_id_idx` (`korisnik_id`),
  CONSTRAINT `korisnik_id` FOREIGN KEY (`korisnik_id`) REFERENCES `korisnik` (`korisnik_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `porudzbina`
--

LOCK TABLES `porudzbina` WRITE;
/*!40000 ALTER TABLE `porudzbina` DISABLE KEYS */;
INSERT INTO `porudzbina` VALUES (1,4,'3917-08-05'),(2,4,'3917-08-05'),(3,4,'3917-08-05'),(4,4,'3917-08-05'),(5,4,'3917-08-05'),(6,4,'3917-08-05'),(7,4,'3917-08-05'),(8,4,'3917-08-05'),(9,4,'3917-08-05'),(10,4,'3917-08-05'),(11,4,'3917-08-05'),(12,4,'3917-08-05'),(13,4,'3917-08-05'),(14,4,'3917-08-05'),(15,4,'3917-08-05'),(16,4,'3917-08-05'),(17,4,'3917-08-05'),(18,4,'3917-08-05'),(19,4,'3917-08-05'),(20,4,'3917-08-05'),(21,4,'3917-08-05'),(22,4,'3917-08-05'),(23,4,'3917-08-05'),(24,4,'3917-08-05'),(25,4,'3917-08-05'),(26,4,'3917-08-05'),(27,1,'3917-08-05'),(28,6,'3917-08-05');
/*!40000 ALTER TABLE `porudzbina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prava`
--

DROP TABLE IF EXISTS `prava`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prava` (
  `prava_id` int(11) NOT NULL AUTO_INCREMENT,
  `naziv_prava` varchar(45) NOT NULL,
  PRIMARY KEY (`prava_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prava`
--

LOCK TABLES `prava` WRITE;
/*!40000 ALTER TABLE `prava` DISABLE KEYS */;
INSERT INTO `prava` VALUES (1,'Administrator'),(2,'Korisnik');
/*!40000 ALTER TABLE `prava` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proizvod`
--

DROP TABLE IF EXISTS `proizvod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proizvod` (
  `proizvod_id` int(11) NOT NULL AUTO_INCREMENT,
  `naziv_proizvoda` varchar(45) NOT NULL,
  `referencu_slike` varchar(45) NOT NULL,
  `cena` decimal(9,2) NOT NULL,
  `velicina` varchar(100) NOT NULL,
  `opis` varchar(500) NOT NULL,
  `brend_id` int(11) NOT NULL,
  `kategorija_id` int(11) NOT NULL,
  PRIMARY KEY (`proizvod_id`),
  KEY `brend_id_idx` (`brend_id`),
  KEY `kategorija_id_idx` (`kategorija_id`),
  CONSTRAINT `brend_id` FOREIGN KEY (`brend_id`) REFERENCES `brend` (`brend_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `kategorija_id` FOREIGN KEY (`kategorija_id`) REFERENCES `kategorija` (`kategorija_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proizvod`
--

LOCK TABLES `proizvod` WRITE;
/*!40000 ALTER TABLE `proizvod` DISABLE KEYS */;
INSERT INTO `proizvod` VALUES (1,'HEAD SUPERSHAPE IRALLY SW TFB','skije1.jpg',62662.00,'163cm','Supershape Rally je skija namenjena svim terenima. iSupershape Rally ima \"race\" jezgro, speedy race bazu, i Worldcup konstrukciju, KERS tehnologiju za akumulaciju snage i ERA 3.0 S tehnologiju. Sve u svemu, kakvi god uslovi bili ova skija to moze da podnese.',1,1),(2,'SUPERSHAPE I.SPEED SW TFB BK/YW','skije2.jpg',64562.00,'163cm','Supershape Speed je takmičarski orijentisana skija za napredne skijaše koji su uvek željni dodatne brzine. Sa super brzom bazom i Worldcup Sandwich konstrukcijom ostvarju se preciznost, agilnost i snage upravljanja Speed Rocker-a, sve to od Graphene materijala ovu brzu skiju čini jos laksom i upravljivijom.Brzina nikada nije bila ovako zabavna!',1,1),(3,'HEAD VECTOR EVO 120 BLACK/GREEN','cipele1.jpg',33112.00,'270 (42), 290 (45)','Vector Evo 120 je predviđen za  \"all season\" skijaše. Napravljena tako da može da vam doprinese vrhunski nivo udobnosti i preciznosti na različitim skijaškim terenima. Cipela je u potpunosti opremljena od oklopa, do sitnih detalja kao sto su mehanizam za ski šetnju, \"Easy Entry\" do Velcro moćnog kaiša od 40mm koji će vam dostaviti vrhunski osećaj pri vožnji ove cipele.',1,3),(4,'HEAD RAPTOR 12O RS WHITE','cipele2.jpg',31392.00,'290 (45)','Raptor 120 RS cipela koja dostavalja vrhunske performanse . Sve vezano za ovu cipelu ukazuje na brzinu, preciznost, do udobnosti HP Frame uloška koji vam obezbeđuje vrhunski stepen udobnosti. U zapremini od 1800cc vaše stopalo će držati četiri mikro podesive aluminijumske niskoprofilne Spine Tech kopče, a u gornjem delu Velcro traka od 40mm.',1,3),(5,'HEAD FIVE BOA 16/17','cipele3.jpg',22381.00,'280 (43) 285 (44) 290 (45) 295 (46)','FIVE BOA je jednostavna kako za obuvanje tako i za vožnju. Namenjena srednjim i naprednim. Karakteriše je srednja trvrdoća i nagib, udobnost ali i dobra reaktivnost. Perfect Fit Control uložak izvanredno fiksira stopalo, Ninja đon apsorbuje udarce i ima izvanredno prijanjanje a samim tim i kontrolu pokreta u vožnji, dok BOA Wrap Strap daje dodatnu pordšku zglobu i stopalu.',1,3),(6,'HEAD THREE WMN BOA 16/17','cipele4.jpg',21871.00,'245 (37) 250 (38) 255 (39) 260 (40) 265 (41)','The THREE WMN BOA je all-mountain cipela, ciija laka konstrukcija i vrhunski komfor daju dobre performanse vrhunsku vožnju.',1,3),(7,'HEAD G-FORCE','snow1.jpg',35216.00,'156cm','',1,2),(8,'HEAD RUSH','snow2.jpg',23554.00,'159cm, 159Wcm, 162cm, 162Wcm','Mekseg flexa Rush predstavlja idealnu podlogu i profil dakse sa kojom je zagarantovano napredovanje u vašoj voznji. Sa all mountain kapacitetima savršena je za otkivanje novih dimenizja snowboradinga.',1,2),(9,'HEAD STIVOT RACE PINK 15','kaciga1.jpg',14748.00,'XS, S','',1,4),(10,'HEAD STIVOT RACE BLACK 15','kaciga2.jpg',16248.00,'XS, S, L','',1,4),(11,'BRIKO STROMBOLI MATT/YELLOW FLUO','kaciga3.jpg',11512.00,'L','',2,4),(15,'BRIKO LAVA 600 MATT LIGHT BLUE','naocare1.jpg',5400.00,'Univerzalna','',2,5),(18,'HEAD GALACTIC FMR SPARELENS RED','naocare2.jpg',9342.00,'Univerzalna','GALACTIC FMR je nov model u HEAD liniji naočara.Srednje veličine sa duplim staklima koja vam obezbeđuju UV protekciju,Angi Fog,kao i dupla pena na ramu naočare će obezbediti odličnu udobnost pri nošenju. Galactis Fmr je kompatibilan sa svim modelima Head kaciga.',1,5),(19,'HEAD GALACTIC FS FMR WHITE/BLUE','naocare3.jpg',7905.00,'Univerzalna','GALACTIC FMR je nov model u HEAD liniji naočara.Srednje veličine sa duplim staklima koja vam obezbeđuju UV protekciju, Angi Fog, kao i dupla pena na ramu naočare će obezbediti odličnu udobnost pri nošenju. Galactis Fmr je kompatibilan sa svim modelima Head kaciga.',1,5),(20,'HEAD REBEL','torba1.jpg',16224.00,'76 x 38 x 40.6 cm','Zapremina 98L',1,6),(21,'HEAD DOUBLE SKI BAG','torba3.jpg',12624.00,'203 x 18 x 28 cm','Zapremina 103L',1,6),(22,'HEAD WOMENS BOOT BAG SHADOW','torba2.jpg',2824.00,'45 x 35 x 48 cm','Zapremina 32L',1,6),(23,'HEAD WOMEN SINGLE SKIBAG 170','torba4.jpg',3912.00,'165 x 25 x 15 cm','Zapremina 65L',1,6),(24,'HEAD CARBON PRESTIGE','stap1.jpg',7803.00,'120cm, 125cm, 130cm, 135cm','Carbon Prestige je lagan, brz, jak štap sa prefinjenim dizajnom namenjen vrhunskim skijašima.  Sa jezgrom napravljenim od vrhunskog materijala karbon, Carbide Flex vrhom i Race krpljom od 50mm osetićete pravu lakoću pri vožnji.',1,7),(25,'HEAD AIRFOLI BLACK NEON RED','stap2.jpg',5865.00,'120cm, 125cm, 130cm, 135cm','Head Airfoli je lagani aluminijumski štap koji je dostupan u pet različitih boja. Odličan rukohvat sa dobrim balansom, krpljom od 50mm i izdržljivim HM čeličnim vrhom štapa je svakako dobar izbor za sve nivoe skijaša.',1,7);
/*!40000 ALTER TABLE `proizvod` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stavka`
--

DROP TABLE IF EXISTS `stavka`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stavka` (
  `stavka_id` int(11) NOT NULL AUTO_INCREMENT,
  `proizvod_id` int(11) NOT NULL,
  `porudzbina_id` int(11) NOT NULL,
  `kolicina` int(11) NOT NULL,
  PRIMARY KEY (`stavka_id`),
  KEY `proizvod_id_idx` (`proizvod_id`),
  KEY `porudzbina_id_idx` (`porudzbina_id`),
  CONSTRAINT `porudzbina_id` FOREIGN KEY (`porudzbina_id`) REFERENCES `porudzbina` (`porudzbina_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `proizvod_id` FOREIGN KEY (`proizvod_id`) REFERENCES `proizvod` (`proizvod_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stavka`
--

LOCK TABLES `stavka` WRITE;
/*!40000 ALTER TABLE `stavka` DISABLE KEYS */;
INSERT INTO `stavka` VALUES (1,1,1,1),(2,1,2,1),(3,3,3,1),(4,8,4,1),(5,4,5,1),(6,1,6,1),(7,1,7,1),(8,3,8,1),(9,1,9,1),(10,3,10,1),(11,3,11,1),(12,1,12,1),(13,1,13,1),(14,1,14,1),(15,1,15,1),(16,1,16,1),(17,8,17,1),(18,8,18,1),(19,2,19,1),(20,8,20,1),(21,2,21,1),(22,2,22,1),(23,2,23,1),(24,2,24,1),(25,3,25,3),(26,1,26,2),(27,1,27,1),(28,2,28,1),(29,4,28,1),(30,10,28,1),(31,18,28,1),(32,24,28,1),(33,21,28,1);
/*!40000 ALTER TABLE `stavka` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-17 11:14:47
