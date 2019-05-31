DROP TABLE IF EXISTS `computer`;

CREATE TABLE `computer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `branch` varchar(30) DEFAULT NULL,
  `department` varchar(100) DEFAULT NULL,
  `tuandui` varchar(30) DEFAULT NULL,
  `assect` varchar(30) DEFAULT NULL,
  `computer_name` varchar(30) DEFAULT NULL,
  `computer_serial` varchar(30) DEFAULT NULL,
  `computer_model` varchar(100) DEFAULT NULL,
  `computer_type` varchar(30) DEFAULT NULL,
  `connect_type` varchar(30) DEFAULT NULL,
  `start_date` varchar(30) DEFAULT NULL,
  `use_status` varchar(10) DEFAULT NULL,
  `useage` varchar(100) DEFAULT NULL,
  `useage_comment` varchar(100) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1910 DEFAULT CHARSET=utf8mb4;


insert  into `computer`(`id`,`branch`,`department`,`tuandui`,`assect`,`computer_name`,`computer_serial`,`computer_model`,`computer_type`,`connect_type`,`start_date`,`use_status`,`useage`,`useage_comment`,`create_time`) values 
(1,'深圳嘉宾支行','','','1124376','B012901026','SA11744098','ThinkCentre M6100t','台式机','内网PC','2011/10/27','闲置','后台生产终端','','2018-08-21 16:15:20'),
(2,'深圳嘉宾支行','','','1136952','B043469N010','SA13208140','ThinkCentre M6100t','台式机','内网PC','2012/6/26','闲置','后台生产终端','','2018-08-21 16:15:20'),
(3,'深圳嘉宾支行','','','1150252','','SA14103399','ThinkCentre M4350t','台式机','内网PC','2012/10/27','拟打销','Office办公','无法开机','2018-08-21 16:15:20'),
(4,'深圳嘉宾支行','','','1141942','','SA15485972','ThinkCentre M4350t','台式机','内网PC','2012/8/28','拟打销','Office办公','无法开机','2018-08-21 16:15:20')