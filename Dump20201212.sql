-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: cms
-- ------------------------------------------------------
-- Server version	5.7.32-log

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` enum('USER','ADMIN','HOTEL','DRIVER') NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'test_admin','123456','ADMIN'),(2,'test_hotel','123456','HOTEL'),(3,'test_driver','123456','DRIVER'),(4,'wjx','123456','USER'),(5,'whf','123456','USER');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `telephone` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `account_id_UNIQUE` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conference`
--

DROP TABLE IF EXISTS `conference`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `conference` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` char(9) NOT NULL,
  `user_id` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `name` varchar(45) NOT NULL,
  `detail` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `enroll_time` datetime NOT NULL,
  `invite_code` varchar(45) DEFAULT NULL,
  `hotel_id` int(11) DEFAULT NULL,
  `fleet_id` int(11) DEFAULT NULL,
  `progress` enum('ENROLLMENT','OWNER_CONFIRM','RESERVATION_CONFIRM','READY','ENDED') NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `number_UNIQUE` (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conference`
--

LOCK TABLES `conference` WRITE;
/*!40000 ALTER TABLE `conference` DISABLE KEYS */;
/*!40000 ALTER TABLE `conference` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conference_number`
--

DROP TABLE IF EXISTS `conference_number`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `conference_number` (
  `id` int(11) NOT NULL,
  `number` char(9) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `numer_UNIQUE` (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conference_number`
--

LOCK TABLES `conference_number` WRITE;
/*!40000 ALTER TABLE `conference_number` DISABLE KEYS */;
INSERT INTO `conference_number` VALUES (283,'100951478'),(519,'101990031'),(513,'102969961'),(344,'102995284'),(739,'104945235'),(234,'104973368'),(26,'106986689'),(663,'107964393'),(557,'107996733'),(634,'107996973'),(14,'10878596'),(615,'108901440'),(642,'108983546'),(306,'110774410'),(146,'110986418'),(185,'112914299'),(64,'113950857'),(194,'113953731'),(797,'114967874'),(382,'114992831'),(28,'116910168'),(53,'118909173'),(932,'11976600'),(257,'120963155'),(859,'120989709'),(538,'122913458'),(473,'122967026'),(475,'125935274'),(884,'126890856'),(308,'126994644'),(971,'127919026'),(837,'128946491'),(635,'128969485'),(58,'12963072'),(74,'12985418'),(738,'129976924'),(917,'129985894'),(787,'130968546'),(759,'130972794'),(923,'131877702'),(687,'133971949'),(826,'133993143'),(942,'134942294'),(457,'135983604'),(676,'135988410'),(80,'136999769'),(523,'137996547'),(651,'138981016'),(95,'13971835'),(212,'139937285'),(165,'139984551'),(548,'140977714'),(455,'141993281'),(491,'143946274'),(611,'143956860'),(284,'145994893'),(89,'148981654'),(680,'148985468'),(908,'150981312'),(899,'152917879'),(949,'153953878'),(627,'153961914'),(714,'153996187'),(365,'154991860'),(380,'155882025'),(905,'156981955'),(584,'157953048'),(898,'157977825'),(120,'158948829'),(896,'159996648'),(297,'160999163'),(293,'163979046'),(818,'163991193'),(122,'164988224'),(79,'164995564'),(561,'166985605'),(771,'167995918'),(68,'167996745'),(356,'168873415'),(777,'168990970'),(219,'16965860'),(953,'169976258'),(706,'170947054'),(361,'172928354'),(414,'172943962'),(686,'172985238'),(773,'174984711'),(843,'175965260'),(877,'176961463'),(891,'176979450'),(450,'176991919'),(358,'176992897'),(72,'176993537'),(989,'177946937'),(202,'177983520'),(321,'17932789'),(328,'180959844'),(728,'180979823'),(767,'181949631'),(673,'181993631'),(876,'181999783'),(375,'185996616'),(456,'186954167'),(141,'187931202'),(636,'188923771'),(821,'188975066'),(317,'18956972'),(387,'18972011'),(20,'189926935'),(259,'189981144'),(363,'189992860'),(10,'190926967'),(590,'190958352'),(131,'193965942'),(653,'193995748'),(309,'196994464'),(656,'198987571'),(624,'198997673'),(540,'19957966'),(703,'19982752'),(346,'200929680'),(152,'200936962'),(654,'201995069'),(119,'202959277'),(436,'202969407'),(221,'202974007'),(335,'203922564'),(791,'204975742'),(433,'204997377'),(742,'205951294'),(842,'207985060'),(304,'207996054'),(717,'210962719'),(331,'210995656'),(432,'212995270'),(327,'212996405'),(666,'214966520'),(765,'214978818'),(786,'214990008'),(232,'215870799'),(586,'215982318'),(101,'216940966'),(862,'217998798'),(504,'218989563'),(209,'220982547'),(903,'221918413'),(73,'223979647'),(468,'223990525'),(895,'224971134'),(248,'224995091'),(314,'224999509'),(268,'226984287'),(275,'228997085'),(750,'230985848'),(948,'232995951'),(798,'234977609'),(967,'237955469'),(303,'238982090'),(565,'238984151'),(643,'23929602'),(502,'23968009'),(588,'239985872'),(158,'241910144'),(6,'241972300'),(174,'243979265'),(154,'243991914'),(235,'244978465'),(758,'244997596'),(217,'245922798'),(799,'247991989'),(357,'247992590'),(522,'248983765'),(148,'249952142'),(81,'249990368'),(674,'250980854'),(801,'250984776'),(720,'251987260'),(156,'252965094'),(192,'253989832'),(626,'254963741'),(918,'254985844'),(934,'254986817'),(386,'255893667'),(865,'256973287'),(996,'257932978'),(46,'25983821'),(7,'259979370'),(854,'260912883'),(330,'260933431'),(924,'262926945'),(546,'262955881'),(986,'262978059'),(471,'262983216'),(112,'263960747'),(841,'264992384'),(881,'265981728'),(264,'267955321'),(709,'268899609'),(970,'26992426'),(470,'270950622'),(320,'271964640'),(727,'271990677'),(929,'273992862'),(587,'274976765'),(417,'277934909'),(241,'278942121'),(311,'278954579'),(982,'279970416'),(339,'279988451'),(688,'279989269'),(991,'279989971'),(928,'281964708'),(983,'283950892'),(200,'284930680'),(407,'284987453'),(501,'286924537'),(159,'2883011'),(566,'289983496'),(507,'290946201'),(104,'290995126'),(207,'291982314'),(684,'293997641'),(351,'294996730'),(336,'295906247'),(477,'296928031'),(695,'2977979'),(943,'297982310'),(426,'297987223'),(316,'2980883'),(897,'2993192'),(179,'300987358'),(753,'300991772'),(362,'301985096'),(914,'303979190'),(391,'303987903'),(269,'305951756'),(82,'307947839'),(237,'307954862'),(18,'307960815'),(412,'307981056'),(127,'307996471'),(184,'30924542'),(466,'30938829'),(776,'30984998'),(23,'309999852'),(662,'312942844'),(481,'312983099'),(707,'312986299'),(960,'313943417'),(225,'315964868'),(187,'315969203'),(177,'316918952'),(781,'316962694'),(430,'317947426'),(845,'317998346'),(153,'318942924'),(520,'319928071'),(618,'31997316'),(780,'319991260'),(701,'319994685'),(118,'320923789'),(60,'322978866'),(228,'322984054'),(833,'323871794'),(616,'324991549'),(512,'326915611'),(497,'327988730'),(768,'327997359'),(197,'328862794'),(296,'32975299'),(368,'329993259'),(737,'330933368'),(853,'330945584'),(941,'330974705'),(696,'333964823'),(252,'334952490'),(114,'334977389'),(718,'339967610'),(537,'342999517'),(525,'344987533'),(472,'345977151'),(608,'347973007'),(370,'348978820'),(916,'34979263'),(931,'34983218'),(778,'34989458'),(299,'349976612'),(813,'350988788'),(515,'352995236'),(964,'354990470'),(300,'355984375'),(329,'358911168'),(645,'35926730'),(625,'361952655'),(871,'361993170'),(31,'362878281'),(770,'362993467'),(30,'363938006'),(647,'364878429'),(551,'365963503'),(534,'365993301'),(796,'368970615'),(785,'368994336'),(460,'36902862'),(741,'36941912'),(454,'371941624'),(802,'372959053'),(385,'375854536'),(381,'375946040'),(102,'376868218'),(231,'377938256'),(858,'377994645'),(125,'378959247'),(144,'378994198'),(650,'378994680'),(75,'37959771'),(51,'379978936'),(59,'380933952'),(882,'380992822'),(138,'381962817'),(691,'383921256'),(186,'384962338'),(894,'384989666'),(805,'386972349'),(132,'386974247'),(573,'386977206'),(578,'386990452'),(621,'387962874'),(128,'387972862'),(324,'387988230'),(124,'38955541'),(86,'38974054'),(829,'38987092'),(572,'38990901'),(340,'390910087'),(747,'391969222'),(150,'393935668'),(360,'393957437'),(517,'393961514'),(623,'395995171'),(669,'396960238'),(438,'396965009'),(371,'3978732'),(605,'397998545'),(906,'399935876'),(96,'39997039'),(822,'3999805'),(389,'400957267'),(244,'401954367'),(399,'402891464'),(721,'402959180'),(863,'405943937'),(545,'408985470'),(637,'408997179'),(950,'40978871'),(719,'409952473'),(469,'410972892'),(22,'410994947'),(310,'411899032'),(19,'415879294'),(567,'415969638'),(267,'417916994'),(143,'418986096'),(54,'41954739'),(900,'419984734'),(419,'419992725'),(866,'41999888'),(875,'420979948'),(288,'421940021'),(893,'421996173'),(641,'422959704'),(1000,'422972048'),(52,'423965386'),(189,'423992717'),(281,'424944897'),(764,'424973593'),(168,'424980549'),(99,'426993046'),(204,'428997714'),(401,'429992365'),(873,'430927637'),(446,'430943676'),(478,'431960177'),(840,'433873474'),(664,'433991333'),(474,'433993687'),(532,'435969781'),(702,'435976010'),(630,'435983441'),(549,'436968105'),(424,'436986499'),(279,'438922459'),(439,'438982618'),(911,'438998642'),(348,'440971103'),(762,'441936209'),(562,'443933251'),(483,'446946212'),(874,'446992663'),(601,'446996604'),(121,'447964013'),(963,'449984414'),(67,'449985231'),(806,'449998568'),(410,'450990524'),(280,'451982081'),(388,'452954813'),(783,'453880684'),(145,'45935556'),(319,'460967043'),(812,'461982839'),(222,'463928492'),(892,'465977325'),(925,'465977842'),(496,'465986403'),(752,'465996993'),(521,'466915488'),(665,'466981267'),(421,'467999175'),(827,'468990002'),(966,'469999701'),(490,'472989916'),(90,'477963958'),(889,'478938966'),(803,'483994867'),(307,'485984101'),(113,'486970946'),(698,'489917952'),(861,'490969688'),(301,'491972505'),(178,'491979857'),(238,'491997416'),(844,'4948996'),(434,'494998371'),(265,'496960657'),(220,'496970654'),(681,'497954907'),(988,'497983879'),(372,'49915068'),(784,'49957573'),(41,'49978899'),(535,'499973487'),(711,'499977670'),(824,'501993097'),(126,'502986000'),(405,'502990633'),(341,'505973723'),(133,'505979992'),(322,'506996623'),(748,'506999195'),(205,'50986775'),(839,'511871859'),(495,'511974203'),(93,'512937129'),(461,'512951129'),(100,'513941516'),(554,'514984423'),(85,'515939127'),(734,'515958953'),(795,'516957546'),(425,'516977294'),(994,'518975315'),(660,'51957133'),(733,'51998172'),(65,'519981886'),(800,'520983469'),(760,'520997076'),(191,'521973740'),(137,'521978955'),(556,'522920441'),(214,'524918911'),(476,'524998776'),(823,'525933156'),(142,'525989306'),(332,'526977130'),(40,'526979219'),(250,'526985036'),(342,'526986202'),(617,'527993212'),(251,'528952567'),(286,'52989000'),(349,'52994507'),(945,'529958263'),(743,'530834837'),(979,'532943824'),(976,'532945556'),(42,'532969295'),(596,'532974193'),(974,'532996794'),(400,'534936243'),(946,'535999787'),(657,'536969792'),(397,'536994922'),(254,'537970979'),(975,'538983897'),(940,'538988672'),(413,'538991485'),(509,'539944695'),(670,'539998781'),(597,'540995709'),(640,'540996959'),(547,'543989399'),(215,'546989229'),(276,'546997666'),(811,'546998020'),(599,'546999454'),(978,'548936301'),(415,'548995937'),(8,'548996808'),(117,'54917080'),(927,'549989289'),(503,'550926059'),(282,'552944854'),(793,'552969196'),(715,'552970630'),(592,'554972013'),(638,'555983189'),(697,'557939888'),(437,'557945495'),(852,'558957051'),(135,'558998142'),(162,'559978775'),(294,'559987234'),(447,'560992540'),(850,'565901965'),(378,'566971950'),(63,'567982681'),(258,'56951016'),(482,'569923855'),(678,'569973980'),(937,'569995096'),(24,'570918184'),(451,'570957002'),(671,'570984954'),(256,'570988590'),(47,'571969649'),(84,'572965543'),(543,'575951796'),(902,'576987115'),(705,'577994663'),(585,'57994890'),(440,'579982834'),(990,'579999128'),(516,'580941593'),(958,'581982507'),(423,'581988367'),(518,'582983817'),(655,'582992795'),(919,'582993759'),(700,'583991372'),(763,'583994793'),(416,'58996359'),(972,'590915036'),(176,'590988855'),(836,'593972303'),(441,'596951408'),(675,'596973543'),(373,'5973760'),(732,'5975703'),(736,'597960286'),(103,'600948974'),(595,'601961655'),(338,'602931833'),(579,'604964151'),(173,'604993001'),(210,'604999378'),(243,'605968707'),(170,'606999623'),(403,'608933130'),(273,'608974390'),(835,'60980402'),(820,'609942804'),(589,'609976601'),(544,'612997984'),(49,'613979811'),(541,'614943610'),(804,'614995817'),(677,'615980647'),(161,'617942545'),(108,'617974975'),(17,'618952979'),(224,'620957360'),(245,'621960173'),(116,'621995325'),(558,'622986240'),(550,'622988016'),(291,'624911562'),(485,'624945558'),(111,'624995041'),(704,'625964224'),(83,'625972852'),(171,'625973446'),(498,'626979830'),(326,'626996970'),(619,'627991544'),(614,'628904513'),(746,'628984195'),(305,'628986308'),(343,'628997394'),(274,'62907788'),(828,'62995508'),(278,'629986935'),(922,'630990955'),(151,'633953131'),(44,'633984556'),(428,'636984503'),(448,'637992793'),(921,'638899345'),(879,'639971329'),(909,'639982763'),(1,'639985165'),(352,'63999485'),(583,'639997533'),(755,'642904086'),(263,'642987983'),(408,'643974694'),(938,'643991390'),(609,'644958769'),(939,'644959665'),(648,'644999080'),(157,'645964446'),(726,'645964791'),(298,'645988716'),(716,'647991025'),(180,'64977775'),(350,'64979777'),(985,'64989039'),(302,'650928598'),(849,'650989710'),(944,'654972460'),(832,'654975347'),(233,'656976178'),(115,'656997061'),(4,'657966646'),(860,'657980212'),(563,'658942317'),(915,'658995372'),(66,'662977041'),(809,'664990929'),(266,'665983466'),(539,'666915168'),(774,'666933305'),(155,'666974254'),(57,'667977113'),(29,'667982501'),(920,'668981212'),(761,'668983145'),(772,'668998418'),(980,'66952182'),(528,'671943094'),(792,'672899899'),(633,'674938763'),(409,'674942438'),(5,'675949539'),(997,'677984809'),(465,'677987270'),(745,'678996656'),(56,'679969277'),(724,'679976623'),(639,'67998252'),(444,'681987862'),(129,'683988106'),(169,'684936503'),(203,'687941766'),(981,'687998445'),(505,'690817397'),(659,'691995289'),(652,'692967423'),(411,'694973636'),(106,'695987755'),(500,'695997650'),(825,'695998518'),(999,'696978767'),(369,'6973958'),(147,'697987386'),(223,'697995033'),(887,'698956133'),(628,'698957497'),(529,'698967875'),(912,'698979930'),(506,'698990169'),(757,'698991270'),(987,'699976576'),(43,'701915148'),(603,'701953838'),(749,'701962662'),(172,'703851074'),(285,'703910610'),(489,'705966995'),(511,'705975575'),(689,'705988665'),(683,'706989083'),(593,'707970713'),(347,'70990749'),(699,'713843716'),(622,'713985701'),(751,'713985903'),(94,'714916190'),(581,'714989857'),(193,'715961239'),(92,'717964608'),(277,'717974995'),(620,'717986453'),(571,'718867363'),(435,'71918922'),(480,'71959540'),(851,'71984232'),(998,'719925610'),(188,'719980687'),(2,'721976692'),(730,'721985772'),(564,'722982886'),(779,'725975306'),(754,'726951665'),(98,'726984056'),(376,'726992351'),(229,'727944723'),(487,'72915501'),(323,'72932241'),(216,'729839523'),(452,'729999671'),(831,'730991496'),(270,'732948923'),(443,'732994940'),(249,'733930256'),(130,'734980812'),(345,'735927802'),(395,'736969208'),(211,'736995889'),(658,'739989612'),(888,'739993254'),(226,'740983671'),(725,'743991288'),(570,'745918866'),(69,'745974145'),(213,'746962168'),(494,'746995716'),(334,'747947208'),(935,'747995713'),(91,'747997723'),(729,'747998999'),(70,'753911095'),(576,'753991685'),(838,'753996501'),(110,'754980634'),(199,'755892269'),(196,'755986871'),(77,'756989328'),(847,'757994996'),(995,'759970839'),(992,'759971606'),(769,'759980753'),(524,'759993838'),(857,'761979197'),(218,'764949417'),(685,'764981608'),(109,'765987952'),(575,'765996961'),(667,'766951911'),(62,'766952264'),(463,'76991334'),(255,'770958073'),(493,'770981904'),(315,'771953798'),(810,'771995875'),(649,'772977575'),(957,'773907637'),(206,'773984814'),(445,'773999738'),(396,'774959968'),(33,'776920969'),(398,'777968261'),(9,'778948774'),(631,'779944316'),(35,'781988365'),(508,'781997555'),(731,'782983876'),(198,'7844480'),(374,'784897993'),(632,'786969020'),(672,'787970908'),(612,'787989475'),(163,'790995449'),(15,'791919248'),(45,'791984690'),(668,'791985866'),(577,'792982857'),(553,'794959424'),(782,'796973152'),(78,'796997342'),(904,'797990893'),(629,'79891419'),(604,'798998698'),(239,'802999892'),(559,'804990254'),(262,'805960351'),(420,'807951847'),(814,'807974646'),(913,'80946530'),(449,'80999274'),(692,'815937915'),(740,'816978853'),(364,'817951107'),(272,'81974702'),(708,'820939897'),(883,'820978215'),(789,'820984033'),(431,'820995503'),(247,'821841948'),(459,'821981313'),(325,'824825768'),(710,'826970552'),(514,'827923839'),(32,'82895075'),(870,'828999877'),(952,'82975675'),(933,'830959212'),(140,'836982446'),(492,'836991447'),(50,'837881689'),(965,'837936303'),(183,'838959069'),(287,'83993629'),(418,'839986207'),(510,'840958411'),(227,'840990549'),(959,'841948581'),(644,'841977058'),(819,'844974905'),(530,'844994252'),(181,'845890098'),(993,'847975570'),(560,'847997358'),(453,'848933993'),(422,'848978283'),(694,'84942188'),(379,'84978378'),(242,'851954567'),(37,'853945614'),(11,'853987196'),(533,'855964705'),(467,'856938972'),(973,'857992108'),(12,'858973033'),(230,'85978092'),(427,'859938092'),(107,'860968841'),(359,'860981695'),(969,'861973051'),(462,'862953937'),(55,'864889417'),(536,'864956518'),(766,'867974642'),(606,'867991672'),(984,'868957226'),(591,'86964078'),(25,'86985038'),(240,'86985803'),(123,'869877439'),(679,'870989126'),(34,'871971115'),(486,'871992705'),(97,'874949121'),(27,'874949318'),(977,'875993040'),(872,'875996408'),(712,'876968358'),(355,'878916601'),(602,'879891069'),(406,'879898079'),(527,'879990819'),(182,'879999117'),(175,'880817473'),(907,'880965505'),(890,'884959722'),(367,'884967500'),(723,'884987172'),(775,'884988337'),(105,'885989236'),(149,'886972800'),(936,'888942036'),(807,'888971902'),(337,'888983454'),(354,'88963438'),(930,'890982407'),(901,'890984090'),(312,'890987836'),(910,'893974163'),(134,'897988645'),(646,'897995911'),(600,'8980774'),(289,'898985624'),(693,'89957214'),(661,'89984307'),(36,'900966527'),(136,'901935530'),(926,'903979611'),(878,'903995912'),(88,'905941084'),(555,'906962239'),(886,'906987573'),(580,'908977933'),(353,'909879300'),(794,'912974338'),(488,'912992823'),(429,'914999524'),(236,'915987038'),(968,'915987669'),(846,'917947013'),(961,'917952825'),(383,'921919648'),(21,'928950226'),(582,'928999774'),(76,'929471'),(735,'92996722'),(868,'930994398'),(607,'931986827'),(867,'931996042'),(164,'931999344'),(38,'932894967'),(713,'932974690'),(190,'932995300'),(292,'934957822'),(167,'935979605'),(613,'937983628'),(208,'93951788'),(817,'940914295'),(682,'944992324'),(790,'945981761'),(947,'946920133'),(830,'946940324'),(484,'947998394'),(569,'948946539'),(290,'949930652'),(834,'94996796'),(744,'949985253'),(318,'950966801'),(856,'950990080'),(442,'950997343'),(13,'950999279'),(16,'951971220'),(788,'952962499'),(366,'952974761'),(756,'953968766'),(39,'954984653'),(568,'954986863'),(246,'958993109'),(295,'958993872'),(552,'958997777'),(808,'95974615'),(390,'959959299'),(954,'95996531'),(962,'960971321'),(869,'961888'),(139,'962910543'),(48,'962952951'),(402,'962989462'),(526,'962997130'),(392,'966987393'),(3,'966993916'),(880,'968988221'),(260,'96954676'),(955,'969942343'),(271,'973995195'),(531,'973998847'),(195,'976946715'),(404,'976955330'),(261,'976976095'),(542,'977978746'),(393,'977980268'),(574,'978941893'),(598,'979932057'),(458,'979972529'),(722,'979973500'),(377,'979986703'),(479,'980982873'),(71,'980986259'),(816,'980998621'),(384,'981952789'),(464,'982935319'),(815,'983896044'),(610,'983963469'),(956,'985984453'),(499,'986980404'),(253,'988888794'),(864,'988948701'),(690,'988997840'),(61,'989997975'),(885,'990975434'),(594,'990997305'),(201,'990999000'),(333,'992938381'),(87,'994945786'),(394,'994982301'),(166,'995985399'),(855,'996908593'),(951,'9978417'),(160,'997925074'),(848,'9979679'),(313,'998998750');
/*!40000 ALTER TABLE `conference_number` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `driver`
--

DROP TABLE IF EXISTS `driver`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `driver` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` int(11) NOT NULL,
  `fleet_id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `gender` enum('MALE','FEMALE') NOT NULL,
  `resident_id_number` varchar(45) NOT NULL,
  `telepone` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `account_id_UNIQUE` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver`
--

LOCK TABLES `driver` WRITE;
/*!40000 ALTER TABLE `driver` DISABLE KEYS */;
/*!40000 ALTER TABLE `driver` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `driver_reservation`
--

DROP TABLE IF EXISTS `driver_reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `driver_reservation` (
  `fleet_id` varchar(45) NOT NULL,
  `conference_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `reserve_time` datetime NOT NULL,
  `driver_check` tinyint(4) NOT NULL,
  `driver_id` int(11) DEFAULT NULL,
  `pickup_time` datetime DEFAULT NULL,
  `pickup_site` varchar(45) DEFAULT NULL,
  `car_number` varchar(45) DEFAULT NULL,
  `user_check` tinyint(4) NOT NULL,
  PRIMARY KEY (`fleet_id`,`conference_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver_reservation`
--

LOCK TABLES `driver_reservation` WRITE;
/*!40000 ALTER TABLE `driver_reservation` DISABLE KEYS */;
/*!40000 ALTER TABLE `driver_reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enrollment`
--

DROP TABLE IF EXISTS `enrollment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enrollment` (
  `user_id` int(11) NOT NULL,
  `conference_id` int(11) NOT NULL,
  `trip_number` varchar(45) NOT NULL,
  `arrive_time` datetime NOT NULL,
  `enroll_time` datetime NOT NULL,
  `stay_start` date NOT NULL,
  `stay_end` date NOT NULL,
  `stay_needs` varchar(45) DEFAULT NULL,
  `remark` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`,`conference_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enrollment`
--

LOCK TABLES `enrollment` WRITE;
/*!40000 ALTER TABLE `enrollment` DISABLE KEYS */;
/*!40000 ALTER TABLE `enrollment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fleet`
--

DROP TABLE IF EXISTS `fleet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fleet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `detail` varchar(45) NOT NULL,
  `telephone` varchar(45) NOT NULL,
  `driver_amount` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fleet`
--

LOCK TABLES `fleet` WRITE;
/*!40000 ALTER TABLE `fleet` DISABLE KEYS */;
/*!40000 ALTER TABLE `fleet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hotel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `detail` varchar(45) NOT NULL,
  `telephone` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `account_id_UNIQUE` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel_reservation`
--

DROP TABLE IF EXISTS `hotel_reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hotel_reservation` (
  `hotel_id` int(11) NOT NULL,
  `conference_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `reserve_time` datetime NOT NULL,
  `hotel_check` tinyint(4) NOT NULL,
  `checkin_time` datetime DEFAULT NULL,
  `room_number` varchar(45) DEFAULT NULL,
  `user_check` tinyint(4) NOT NULL,
  PRIMARY KEY (`hotel_id`,`conference_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel_reservation`
--

LOCK TABLES `hotel_reservation` WRITE;
/*!40000 ALTER TABLE `hotel_reservation` DISABLE KEYS */;
/*!40000 ALTER TABLE `hotel_reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sender_id` int(11) NOT NULL,
  `recipient_id` int(11) NOT NULL,
  `content` varchar(45) NOT NULL,
  `send_time` datetime NOT NULL,
  `read` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `gender` enum('MALE','FEMALE') NOT NULL,
  `birthday` date NOT NULL,
  `resident_id_number` varchar(45) NOT NULL,
  `telephone` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `workplace` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `account_id_UNIQUE` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,4,'汪建勋','MALE','2000-03-15','1234567891234','12345678900','1234@1234','ncu'),(2,5,'吴杭峰','MALE','2000-08-15','1234567891234','12345678900','123@1234','ncu');
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

-- Dump completed on 2020-12-12 10:16:58