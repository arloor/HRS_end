-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2017-01-02 21:15:11
-- 服务器版本: 5.5.53-0ubuntu0.14.04.1
-- PHP 版本: 5.5.9-1ubuntu4.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `hotelSystem`
--

-- --------------------------------------------------------

--
-- 表的结构 `creditChange`
--

CREATE TABLE IF NOT EXISTS `creditChange` (
  `memberID` varchar(16) NOT NULL,
  `change` double(12,2) DEFAULT NULL,
  `Time` datetime NOT NULL,
  `CreditChangeType` int(11) DEFAULT NULL,
  `OrderID` int(14) NOT NULL,
  `numCredit` double(12,2) DEFAULT NULL,
  PRIMARY KEY (`Time`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `creditChange`
--

INSERT INTO `creditChange` (`memberID`, `change`, `Time`, `CreditChangeType`, `OrderID`, `numCredit`) VALUES
('customer', 100.00, '2017-01-01 16:47:11', 0, -1, 100.00),
('customer2', 100.00, '2017-01-01 16:51:43', 0, -1, 100.00),
('arloor', -298.41, '2017-01-02 16:09:29', 3, 101231934, -198.41),
('arloor', 100.00, '2017-01-01 21:40:59', 0, -1, 100.00),
('arloor', 149.21, '2017-01-02 16:27:15', 5, 101231934, -49.20),
('arloor', 100000.00, '2017-01-02 16:33:19', 2, -1, 99950.80),
('arloor', -765.00, '2017-01-02 16:34:27', -1, 102163416, 99185.80),
('arloor', 221.85, '2017-01-02 15:57:54', 1, 102163547, 99407.65);

-- --------------------------------------------------------

--
-- 表的结构 `hotelBirthdayPromotion`
--

CREATE TABLE IF NOT EXISTS `hotelBirthdayPromotion` (
  `hotelName` varchar(20) NOT NULL,
  `discount` double(3,2) NOT NULL,
  PRIMARY KEY (`hotelName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `hotelBirthdayPromotion`
--

INSERT INTO `hotelBirthdayPromotion` (`hotelName`, `discount`) VALUES
('南京中心大酒店', 0.94),
('桔子水晶酒店（南京新街口店）', 0.98);

-- --------------------------------------------------------

--
-- 表的结构 `hotelCompanyPromotion`
--

CREATE TABLE IF NOT EXISTS `hotelCompanyPromotion` (
  `hotelName` varchar(20) NOT NULL,
  `discount` double(3,2) NOT NULL,
  PRIMARY KEY (`hotelName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `hotelCompanyPromotion`
--

INSERT INTO `hotelCompanyPromotion` (`hotelName`, `discount`) VALUES
('南京中心大酒店', 0.95),
('桔子水晶酒店（南京新街口店）', 0.92);

-- --------------------------------------------------------

--
-- 表的结构 `hotelInfo`
--

CREATE TABLE IF NOT EXISTS `hotelInfo` (
  `hotelName` varchar(20) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `city` set('南京','北京','上海') CHARACTER SET utf8 NOT NULL DEFAULT '',
  `businessCircle` set('新街口地区','夫子庙地区','仙林学府区','江宁开发区','虹桥地区','外滩地区','人民广场地区','浦东新国际博览中心','天安门地区','中关村','国贸地区','三里屯商业区') CHARACTER SET utf8 NOT NULL DEFAULT '',
  `address` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `introduction` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `facility` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `starLevel` set('1','2','3','4','5') CHARACTER SET utf8 NOT NULL DEFAULT '',
  `cooperCompany` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `score` double(2,1) NOT NULL DEFAULT '4.0',
  PRIMARY KEY (`hotelName`),
  KEY `酒店名称` (`hotelName`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=armscii8;

--
-- 转存表中的数据 `hotelInfo`
--

INSERT INTO `hotelInfo` (`hotelName`, `city`, `businessCircle`, `address`, `introduction`, `facility`, `starLevel`, `cooperCompany`, `score`) VALUES
('南京中心大酒店', '南京', '新街口地区', '中山路75号', '南京中心大酒店位于鼓楼区中山路，而且周围也有中华民国高级将领俱乐部、李宗仁先生官邸等多个景点，外出游玩方便。', '这里有室内游泳池、按摩室、桑拿浴室、健身室、茶室、棋牌室等丰富的休闲娱乐设施。这里是召开会议的理想场所，配备先进的会议设施，并可提供完善的会议服务。', '5', '苏宁易购;万达集团;美的集团', 4.9),
('南京古南都饭店', '南京', '新街口地区', '广州路208号', '南京古南都饭店位于南京市的中心地带——新街口地区，与江苏省五台山体育中心隔街相，是一家豪华商务饭店。饭店附近集中了南京大学、南京师范大学、河海大学等全国著名高等学府及多家金融商贸以及南京市儿童医院，省人民医院、省中医院等医疗机构；周边餐饮、娱乐、休闲及健身场所林立。饭店地理位置优越，人文气氛浓郁；交通便利，闹中取静。', '室外游泳池、健身室；会议厅、行李寄存', '5', '万达集团;网易', 4.8),
('南京新地酒店', '南京', '仙林学府区', '仙林大学城学典路6号', '南京新地酒店，是由拥有苏州香格里拉酒店、沈阳万豪酒店及南京河西标志性建筑-新地中心大厦的着名地产企业新地集团按照国家五星级酒店标准投资兴建。\r\n　　酒店地处仙林大学城，位于南京邮电大学南侧，与金鹰奥莱城隔湖相望，毗邻栖霞区政务中心，地铁2号线仙林中心站近在咫尺,并可直达南京国际博览中心（圆通站）。', '这里是召开会议的理想场所，配备先进的会议设施，并可提供完善的会议服务。', '4', '腾讯;网易', 4.5),
('桔子水晶酒店（南京新街口店）', '南京', '新街口地区', '中山南路三元巷5号', '桔子水晶酒店（南京新街口店）位于南京秦淮区新街口三元巷，地处繁华的商业中心，紧邻地铁一号线，邻近夫子庙、1912街区、总统府等景点，周边医疗、金融、餐饮、休闲配套资源一应俱全，宾客出行便捷。', '停车场；无烟楼层', '4', '万达集团', 4.0),
('南京英尊假日酒店', '南京', '仙林学府区', '仙林大道168号', '南京英尊假日酒店位于南大仙林校区正对面，校园文化气息浓厚，紧邻南京中医药大学、仙林南外、南京邮电大学、金鹰奥莱城。\n　　南京英尊假日酒店房内设施完善，装修现代，住宿环境舒适，服务态度周到，努力为宾客营造温馨、干净、宁静的休息环境。南京英尊假日酒店位于南大仙林校区正对面，校园文化气息浓厚，紧邻南京中医药大学、仙林南外、南京邮电大学、金鹰奥莱城。南京英尊假日酒店房内设施完善，装修现代，住宿环境舒适，服务态度周到，努力为宾客营造温馨、干净、宁静的休息环境。', '免费停车场；行李寄存', '3', '万达集团;美的集团', 4.0),
('南京金丝利喜来登酒店', '南京', '新街口地区', '汉中路169号', '南京金丝利喜来登酒店位于南京金融商贸中心、被誉为“中华第一商圈”的新街口，周边餐饮、休闲、娱乐场所齐全距；离地铁汉中门近在咫尺，乘地铁即可直达南京火车站和南京火车南站。若需游历古都金陵的名胜古迹，毗邻酒店的汉中门城堡、朝天宫和夫子庙都将是您的绝佳选择。', '免费停车场；中餐厅；西餐厅', '5', '美的集团', 4.0),
('南京苏宁环球套房饭店', '南京', '新街口地区', ' 广州路188号', '南京苏宁环球套房饭店是一家全套房豪华商务型酒店，座落于广州路中心地带，交通便利，步行至地铁一号线珠江路站仅9分钟，地理位置优越。紧邻河海大学、南京大学、南京师范大学等全国著名高等学府和北京西路各省级机关，周边还有江苏省人民医院、南京儿童医院等多家大型医疗机构，酒店附近还有先锋书店旗舰店、ELLEN’S酒吧、宝莱纳啤酒花园等著名特色店。', ' 南京苏宁环球套房饭店的精致客房均配有有线、无线两种宽带连接方式，进店当天提供水果、欢迎饮品以及开胃小吃。极具欧式皇家气派高达16米的卢浮宫宴会厅，配有先进的LED大屏及音响设施可举办容纳200余人的大型宴会、会议。同时饭店的香榭咖啡厅、御尚厅以及塞纳多功能厅能满足您对各类美食挑剔的要求。二十八层的室内泳池，让您仿佛畅游碧波蓝天之中；全进口的健身器材，定能解除您一天的工作疲劳；其他康乐设施有健身房、乒乓球室、桑拿中心、棋牌室等，是您休闲、购物、休息的理想下榻居所。', '5', '苏宁易购', 4.0),
('南京黄埔大酒店', '南京', '新街口地区', '黄埔路2-2号', '南京黄埔大酒店位于中山东路、黄埔路交汇处，东临紫金山，环境优雅，梧桐成荫；毗邻沪宁、环城高速，交通便利；临近明故宫遗址，南京博物馆，总统府，1912街区，军区总院， 休闲、娱乐生活便利。', '南京黄埔大酒店配备现代化设备会议室、多功能厅，另设有台球室、棋牌室、健身房、KTV包间、桑拿、保健按摩等高档休闲娱乐设施，是您匆忙旅途中的温馨驿站。', '5', '腾讯', 4.0),
('南京汉府饭店', '南京', '新街口地区', '长江路262号', '南京汉府饭店位于南京地标地区——长江路民国文化一条街，毗邻南京最繁华的商业圈——新街口；距离火车站、十里秦淮、湖南路只有10余分钟车程。', '南京汉府饭店是一座具有7层典型民国风格的建筑，升级后的汉府饭店客房装饰温馨典雅，宽敞舒适，设施设备一应俱全。拥有满足各消费层次的舒适客房百余间，装潢大方优雅，设施一应俱全，为您提供一个安逸、舒适的私密休憩空间。酒店还设有各类餐饮包间20个、无立柱宴会厅1个，能够满足不同消费者的需求，此外，还拥有5个配有同声传译系统的会议室。另外，游泳池、美容中心、健身房、风情酒吧、休闲茶吧等娱乐场所，让客人在繁忙的工作之余放松身心，让您在尽情享受悠闲、自在的假期。', '4', '网易', 4.0),
('南京金鹰珠江壹号国际酒店 ', '南京', '新街口地区', '珠江路1号', '南京金鹰珠江壹号国际酒店地处南京新街口商圈内，傲居城市中轴中山路与珠江路黄金交汇点、城市CBD正中央，位于省市政府两大政务中心聚集地。', '客房内均配有大屏幕液晶电视、卫星电视频道、高速宽带接入、落地观景玻璃窗、一流的卫浴设备与卧具等。各楼层的小型会议室满足你商务需要；西餐厅为你提供正宗西餐和东南亚美食，可容纳120位宾客同时就餐；酒廊提供中外饮品与西式糕点，配有WIFI覆盖。', '4', '万达集团', 4.0);

-- --------------------------------------------------------

--
-- 表的结构 `hotelMultiRoomsPromotion`
--

CREATE TABLE IF NOT EXISTS `hotelMultiRoomsPromotion` (
  `hotelName` varchar(20) NOT NULL,
  `roomNum` int(4) NOT NULL,
  `discount` double(3,2) NOT NULL,
  PRIMARY KEY (`hotelName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `hotelMultiRoomsPromotion`
--

INSERT INTO `hotelMultiRoomsPromotion` (`hotelName`, `roomNum`, `discount`) VALUES
('南京中心大酒店', 3, 0.93),
('桔子水晶酒店（南京新街口店）', 4, 0.90);

-- --------------------------------------------------------

--
-- 表的结构 `hotelSpecialTimePromotion`
--

CREATE TABLE IF NOT EXISTS `hotelSpecialTimePromotion` (
  `hotelName` varchar(20) NOT NULL,
  `startDate` datetime NOT NULL,
  `endDate` datetime NOT NULL,
  `discount` double(3,2) NOT NULL,
  PRIMARY KEY (`hotelName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `hotelSpecialTimePromotion`
--

INSERT INTO `hotelSpecialTimePromotion` (`hotelName`, `startDate`, `endDate`, `discount`) VALUES
('南京中心大酒店', '2016-12-08 00:00:00', '2017-01-31 00:00:00', 0.92),
('桔子水晶酒店（南京新街口店）', '2016-11-11 00:00:00', '2016-11-12 00:00:00', 0.95);

-- --------------------------------------------------------

--
-- 表的结构 `hotelWorker`
--

CREATE TABLE IF NOT EXISTS `hotelWorker` (
  `hotelName` varchar(20) NOT NULL,
  `username` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  `phoneNumber` varchar(11) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `hotelWorker`
--

INSERT INTO `hotelWorker` (`hotelName`, `username`, `password`, `phoneNumber`) VALUES
('南京英尊假日酒店', 'phulbu75', '654321', '15050586168'),
('桔子水晶酒店（南京新街口店）', 'phulbu74', '654321', '15050586166'),
('南京中心大酒店', 'phulbu76', '654321', '12345678910'),
('南京金丝利喜来登酒店', 'phulbu73', '654321', '15050586166'),
('南京苏宁环球套房饭店', 'phulbu72', '654321', '15050586166'),
('南京黄埔大酒店', 'phulbu71', '654321', '15050586166'),
('南京汉府饭店', 'phulbu70', '654321', '15050586166'),
('南京金鹰珠江壹号国际酒店', 'phulbu7?', '654321', '15050586166');

-- --------------------------------------------------------

--
-- 表的结构 `member`
--

CREATE TABLE IF NOT EXISTS `member` (
  `userName` varchar(16) CHARACTER SET utf8 NOT NULL,
  `password` varchar(16) CHARACTER SET utf8 NOT NULL,
  `phone` char(11) CHARACTER SET utf8 NOT NULL,
  `customerType` set('company','personal') CHARACTER SET utf8 NOT NULL DEFAULT '',
  `customerName` varchar(6) CHARACTER SET utf8 NOT NULL,
  `uniqueInfo` text CHARACTER SET utf8 NOT NULL,
  `email` varchar(25) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`userName`),
  UNIQUE KEY `userName` (`userName`)
) ENGINE=MyISAM DEFAULT CHARSET=armscii8;

--
-- 转存表中的数据 `member`
--

INSERT INTO `member` (`userName`, `password`, `phone`, `customerType`, `customerName`, `uniqueInfo`, `email`) VALUES
('arloor', 'fukhhu', '18762832143', 'personal', 'arloor', '2002-01-10', 'tsnki@qq.com'),
('customer', 'drtshjbu', '11111111111', 'personal', 'ddd', '2017-01-01', '244513267@qq.com'),
('customer2', '654', '12345678900', 'personal', 'aaa', '2016-01-21', '12345@qq.com');

-- --------------------------------------------------------

--
-- 表的结构 `orderInfo`
--

CREATE TABLE IF NOT EXISTS `orderInfo` (
  `orderID` char(14) NOT NULL,
  `memberID` varchar(16) NOT NULL,
  `hotel` varchar(16) NOT NULL,
  `status` set('未执行','已执行','异常','已撤销') NOT NULL DEFAULT '未执行',
  `roomID` set('标准间','大床房','单人间','豪华间','商务间') NOT NULL DEFAULT '',
  `roomNum` int(2) NOT NULL,
  `peopleNum` int(2) NOT NULL,
  `hasChild` set('yes','no') NOT NULL DEFAULT '',
  `lastCheckinTime` datetime DEFAULT NULL,
  `checkinTime` datetime NOT NULL DEFAULT '1970-01-01 00:00:01',
  `lastCheckoutTime` datetime DEFAULT NULL,
  `checkoutTime` datetime DEFAULT '1970-01-01 00:00:01',
  `price` decimal(10,2) DEFAULT NULL,
  `charge` decimal(10,2) DEFAULT NULL,
  `cancelTime` datetime DEFAULT '1970-01-01 00:00:01',
  `pingfen` int(11) DEFAULT NULL,
  `pingjia` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`orderID`),
  KEY `会员` (`memberID`),
  KEY `房间类型` (`roomID`),
  KEY `酒店` (`hotel`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `orderInfo`
--

INSERT INTO `orderInfo` (`orderID`, `memberID`, `hotel`, `status`, `roomID`, `roomNum`, `peopleNum`, `hasChild`, `lastCheckinTime`, `checkinTime`, `lastCheckoutTime`, `checkoutTime`, `price`, `charge`, `cancelTime`, `pingfen`, `pingjia`) VALUES
('101231934', 'arloor', '南京英尊假日酒店', '已撤销', '标准间', 1, 2, 'yes', '2017-01-01 14:00:00', '1970-01-01 00:00:01', '2017-01-02 12:00:00', '1970-01-01 00:00:01', 350.00, 298.41, '2017-01-02 16:27:15', NULL, NULL),
('102163323', 'arloor', '桔子水晶酒店（南京新街口店）', '未执行', '标准间', 4, 1, 'yes', '2017-01-03 14:00:00', '1970-01-01 00:00:01', '2017-01-04 12:00:00', '1970-01-01 00:00:01', 1200.00, 1080.00, '1970-01-01 00:00:01', NULL, NULL),
('102163416', 'arloor', '桔子水晶酒店（南京新街口店）', '已撤销', '大床房', 5, 4, 'no', '2017-01-02 16:00:00', '1970-01-01 00:00:01', '2017-01-03 12:00:00', '1970-01-01 00:00:01', 2000.00, 1530.00, '2017-01-02 16:34:27', NULL, NULL),
('102163547', 'arloor', '南京英尊假日酒店', '已执行', '单人间', 1, 1, 'yes', '2017-01-04 18:00:00', '2017-01-02 15:57:54', '2017-01-05 12:00:00', '1970-01-01 00:00:01', 300.00, 221.85, '1970-01-01 00:00:01', NULL, NULL),
('101214722', 'arloor', '南京英尊假日酒店', '已执行', '单人间', 3, 4, 'yes', '2017-01-04 16:00:00', '2017-01-01 21:48:36', '2017-01-05 12:00:00', '2017-01-01 21:48:46', 900.00, 783.00, '1970-01-01 00:00:01', NULL, NULL);

-- --------------------------------------------------------

--
-- 表的结构 `room`
--

CREATE TABLE IF NOT EXISTS `room` (
  `hotelName` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `roomType` set('单人间','标准间','商务间','豪华间','大床房') CHARACTER SET utf8 NOT NULL DEFAULT '',
  `roomNum` int(4) NOT NULL,
  `price` double(6,2) NOT NULL,
  PRIMARY KEY (`hotelName`,`roomType`),
  KEY `roomID` (`hotelName`),
  KEY `酒店名` (`roomType`)
) ENGINE=MyISAM DEFAULT CHARSET=armscii8;

--
-- 转存表中的数据 `room`
--

INSERT INTO `room` (`hotelName`, `roomType`, `roomNum`, `price`) VALUES
('南京中心大酒店', '标准间', 100, 600.00),
('南京中心大酒店', '豪华间', 50, 1500.00),
('南京中心大酒店', '商务间', 110, 800.00),
('南京中心大酒店', '单人间', 12, 120.00),
('南京中心大酒店', '大床房', 80, 700.00),
('南京英尊假日酒店', '标准间', 200, 350.00),
('南京英尊假日酒店', '商务间', 150, 600.00),
('南京英尊假日酒店', '单人间', 100, 300.00),
('桔子水晶酒店（南京新街口店）', '标准间', 30, 300.00),
('桔子水晶酒店（南京新街口店）', '商务间', 40, 400.00),
('桔子水晶酒店（南京新街口店）', '大床房', 20, 400.00),
('南京金丝利喜来登酒店', '单人间', 20, 250.00),
('南京金丝利喜来登酒店', '标准间', 20, 300.00),
('南京金丝利喜来登酒店', '商务间', 30, 450.00),
('南京金丝利喜来登酒店', '豪华间', 40, 550.00),
('南京金丝利喜来登酒店', '大床房', 20, 500.00),
('南京苏宁环球套房饭店', '单人间', 30, 220.00),
('南京苏宁环球套房饭店', '标准间', 40, 250.00),
('南京苏宁环球套房饭店', '商务间', 20, 300.00),
('南京苏宁环球套房饭店', '豪华间', 40, 600.00),
('南京苏宁环球套房饭店', '大床房', 50, 500.00),
('南京黄埔大酒店', '单人间', 50, 150.00),
('南京黄埔大酒店', '标准间', 60, 200.00),
('南京黄埔大酒店', '商务间', 70, 300.00),
('南京黄埔大酒店', '豪华间', 30, 400.00),
('南京黄埔大酒店', '大床房', 60, 360.00),
('南京汉府饭店', '单人间', 30, 200.00),
('南京汉府饭店', '标准间', 40, 300.00),
('南京汉府饭店', '商务间', 40, 400.00),
('南京汉府饭店', '豪华间', 50, 600.00),
('南京汉府饭店', '大床房', 60, 500.00),
('南京金鹰珠江壹号国际酒店', '单人间', 30, 300.00),
('南京金鹰珠江壹号国际酒店', '标准间', 40, 400.00);

-- --------------------------------------------------------

--
-- 表的结构 `webCirclePromotion`
--

CREATE TABLE IF NOT EXISTS `webCirclePromotion` (
  `businessCircle` set('新街口地区','夫子庙地区','仙林学府区','江宁开发区','虹桥地区','外滩地区','人民广场地区','浦东新国际博览中心','天安门地区','中关村','国贸地区','三里屯商业区') NOT NULL DEFAULT '',
  `discount` double(3,2) NOT NULL,
  PRIMARY KEY (`businessCircle`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `webCirclePromotion`
--

INSERT INTO `webCirclePromotion` (`businessCircle`, `discount`) VALUES
('仙林学府区', 0.87),
('新街口地区', 0.96),
('夫子庙地区', 0.95),
('虹桥地区', 0.90),
('江宁开发区', 0.85);

-- --------------------------------------------------------

--
-- 表的结构 `webLevelPromotion`
--

CREATE TABLE IF NOT EXISTS `webLevelPromotion` (
  `level` int(1) NOT NULL,
  `credit` double(12,2) NOT NULL,
  `discount` double(3,2) NOT NULL,
  PRIMARY KEY (`level`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `webLevelPromotion`
--

INSERT INTO `webLevelPromotion` (`level`, `credit`, `discount`) VALUES
(1, 500.00, 0.98),
(2, 1000.00, 0.96),
(3, 1500.00, 0.94),
(4, 2000.00, 0.92),
(5, 2500.00, 0.90),
(6, 3000.00, 0.85);

-- --------------------------------------------------------

--
-- 表的结构 `webManager`
--

CREATE TABLE IF NOT EXISTS `webManager` (
  `username` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  `phoneNumber` varchar(11) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `webManager`
--

INSERT INTO `webManager` (`username`, `password`, `phoneNumber`) VALUES
('jfif`bu', '654321', '15050586170');

-- --------------------------------------------------------

--
-- 表的结构 `webSalesMan`
--

CREATE TABLE IF NOT EXISTS `webSalesMan` (
  `username` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  `phoneNumber` varchar(11) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `webSalesMan`
--

INSERT INTO `webSalesMan` (`username`, `password`, `phoneNumber`) VALUES
('tfkbtJfi76', '654321', '15050586188'),
('tfkbtJfi74', '654321', '15050586182'),
('tfkbtJfi75', '654321', '15050586181');

-- --------------------------------------------------------

--
-- 表的结构 `webSpecialTimePromotion`
--

CREATE TABLE IF NOT EXISTS `webSpecialTimePromotion` (
  `type` varchar(255) NOT NULL,
  `startDate` datetime NOT NULL,
  `endDate` datetime NOT NULL,
  `discount` double(3,2) NOT NULL,
  PRIMARY KEY (`type`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `webSpecialTimePromotion`
--

INSERT INTO `webSpecialTimePromotion` (`type`, `startDate`, `endDate`, `discount`) VALUES
('web', '2016-12-08 00:00:00', '2017-01-31 23:59:59', 0.96);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
