/*
SQLyog 企业版 - MySQL GUI v7.14 
MySQL - 5.6.16-log : Database - i_wenyiba_com
*********************************************************************
*/

/*所有的表数据插入*/

/*Data for the table `u_permission` */

insert  into `counry_code`(`id`,`country`,`code`) values 
(1,'俄罗斯','RU'),
(2,'以色列','IL');


insert  into `service_mode`(`id`,`servicemode`) values 
(1,'平邮'),
(2,'挂号');

insert  into `Logistics_mode`(`id`,`Logistics`,`servicemode`) values 
(1,'燕文航空挂号小包-普货','挂号'),
(2,'燕文航空挂号小包-特货','挂号'),
(3,'燕文专线追踪小包-普货','挂号'),
(4,'燕文专线追踪小包-特货','挂号'),
(5,'递四方-华南-小包挂号','挂号'),
(6,'递四方-S小包挂号','挂号');


insert  into `postage_calc_mode`(`id`,`countrycode`,`servicemode`,`Logistics`,`calculation`) values 
(1,'RU','挂号','燕文航空挂号小包-普货','x>2000?x/1000*82.528+104.192:x/1000*61.896+17.538'),
(2,'RU','挂号','燕文航空挂号小包-特货','x>2000?x/1000*75.823+72.212:x/1000*84.076+30.948'),
(3,'RU','挂号','燕文专线追踪小包-普货','x>50?x/1000*141.845+9.285:50/1000*140.8457+9.285'),
(4,'RU','挂号','燕邮宝挂号-特货','x/1000*58.286+17.538'),
(5,'RU','挂号','燕特快-普货','x/1000*74.276+70.149'),
(6,'RU','挂号','燕特快-特货','x/1000*72.728+70.149'),
(7,'IL','挂号','燕文航空挂号小包-普货','x>2000?x/1000*82.528+104.192:x/1000*61.896+17.538'),
(8,'IL','挂号','燕文航空挂号小包-特货','x/1000*94.392+25.79'),
(9,'IL','挂号','燕文专线追踪小包-普货','x>50?x/1000*140.814+23.72:50/1000*140.814+23.727'),
(10,'IL','挂号','燕文专线追踪小包-特货','x>50?x/1000*140.814+23.727:50/1000*140.814+23.727'),
(11,'IL','挂号','递四方-华南-小包挂号','x>300?x/1000*72.109+20.581:(x>150?x/1000*73.739+20.044:x/1000*73.739+20.044)'),
(12,'IL','挂号','递四方-S小包挂号','x/1000*95.63+25.584'),
(13,'IL','平邮','递四方-S小包挂水电费号','x/1000*95.63+25.584'),
(14,'IL','平邮','递四方','x/1000*95.63+25.584');




/*Data for the table `u_role` */

insert  into `u_role`(`id`,`name`,`type`) values (1,'系统管理员','888888'),(3,'权限角色','100003'),(4,'用户中心','100002');

/*Data for the table `u_role_permission` */

insert  into `u_role_permission`(`rid`,`pid`) values (4,8),(4,9),(4,10),(4,11),(4,12),(3,4),(3,6),(3,7),(3,13),(3,14),(3,15),(3,16),(3,17),(3,18),(3,19),(3,20),(3,21),(3,22),(3,23),(3,24),(3,25),(3,26),
(1,4),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,17),(1,18),(1,19),(1,20),(1,21),(1,22),(1,23),(1,24),(1,25),(1,26);

/*Data for the table `u_user` */

insert  into `u_user`(`id`,`nickname`,`email`,`pswd`,`create_time`,`last_login_time`,`status`) values (1,'管理员','admin','57eb72e6b78a87a12d46a7f5e9315138','2016-06-16 11:15:33','2016-06-16 11:24:10',1),(11,'soso','8446666@qq.com','d57ffbe486910dd5b26d0167d034f9ad','2016-05-26 20:50:54','2016-06-16 11:24:35',1),(12,'8446666','8446666','4afdc875a67a55528c224ce088be2ab8','2016-05-27 22:34:19','2016-06-15 17:03:16',1);

/*Data for the table `u_user_role` */

insert  into `u_user_role`(`uid`,`rid`) values (12,4),(11,3),(11,4),(1,1);


