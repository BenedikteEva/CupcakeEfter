/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */; -- 0 er true, 1 = false
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE `cupcake`;

use cupcake;

drop table if exists `userlist`;
create table `userlist` (
	`user_id` int(11) NOT NULL AUTO_INCREMENT,
	`email`varchar(100) NOT NULL, 
    `password`varchar(100) NOT NULL,  
    `admin_status`boolean, 
	`username` varchar(45) NOT NULL,
    `balance`double (10,2) default 100, 
	primary key (user_id));

drop table if exists `toppinglist`;
create table `toppinglist` (
	`top_id` int(11) NOT NULL AUTO_INCREMENT, 
    `topname` varchar(45), 
    `top_price`double (10,2), 
primary key (top_id));

drop table if exists `bottomlist`;
create table `bottomlist` (
	`bot_id` int(11) NOT NULL AUTO_INCREMENT, 
	`bottomname` varchar(45), 
    `bot_price`double (10,2), 
primary key (bot_id));

drop table if exists `cupcakelist`;
create table `cupcakelist`( 
	`cupcake_id` int (5) NOT NULL AUTO_INCREMENT, 
    `cupcakename` varchar(45), 
    `cupcakeprice` double(10,2),
	`top_id`int (11), 
    `bot_id`int (11),
 primary key (cupcake_id), foreign key (top_id) references toppinglist(top_id), 
 foreign key (bot_id) references bottomlist(bot_id)) ;

 
 -- Jeg lægger også lige en userttabel ind da der er to typer users
 
drop table if exists `orderlist`;
create table `orderlist`(
	`order_id`int (11) NOT NULL AUTO_INCREMENT, 
    `user_id`int (11), 
    `received`datetime,   
primary key (order_id),  
foreign key (user_id) references userlist(user_id));

drop table if exists `odetail`;
create table `odetail`(
	`order_id` int (11) , 
    `cupcake_id` int (5), 
    `quantity` int(5),
	`priceprcc`int (4), 
    `total_price`int (4),
    primary key (order_id,cupcake_id), foreign key (order_id) references orderlist(order_id),
	foreign key (cupcake_id) references cupcakelist(cupcake_id)); 
    
    -- har added walthers lineitem tabel
    
  CREATE TABLE IF NOT EXISTS `lineitem` (
  `ccname` VARCHAR(50),
  `quantity` INT(5) ,
  `prisprcc` double(5,2) ,
  `totalprice` double(9,2) ,
  `order_id` INT(11),
  `lineitem_id` INT(11) NOT NULL auto_increment,
  PRIMARY KEY (`lineitem_id`),
    FOREIGN KEY (`order_id`)
    REFERENCES orderlist (`order_id`));


-- drop table if exists `adminList`;
-- create table `adminList` ( 
-- 	`admin_id` int (11) NOT NULL AUTO_INCREMENT, 
--    `adminUser` varchar(45) NOT NULL, 
--    `adminPassword`varchar (100) NOT NULL,
--    `adminEmail`varchar(100) NOT NULL,
--    primary key (admin_id));

-- admin boolean is whether the user is admin or not 0 == false

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;


INSERT INTO bottomlist VALUES
	(1,'Chocolate',5.00);
INSERT INTO bottomlist VALUES
	(2, 'Vanilla',5.00);
INSERT INTO bottomlist VALUES
	(3, 'Nutmeg', 5.00);
INSERT INTO bottomlist VALUES
	(4, 'Pistacio', 6.00);
INSERT INTO bottomlist VALUES
	(5, 'Almond', 7.00);
    
INSERT INTO toppinglist VALUES
	(1, 'Chocolate', 5.00);
INSERT INTO toppinglist VALUES
	(2, 'Blueberry', 5.00);
INSERT INTO toppinglist VALUES
	(3, 'Rasberry', 5.00);
INSERT INTO toppinglist VALUES
	(4, 'Crispy', 6.00);
INSERT INTO toppinglist VALUES
	(5, 'Strawberry', 6.00);
INSERT INTO toppinglist VALUES
	(6, 'Rum/Raisin', 7.00);
INSERT INTO toppinglist VALUES
	(7, 'Orange', 8.00);
INSERT INTO toppinglist VALUES
	(8, 'Lemon', 8.00);
INSERT INTO toppinglist VALUES
	(9, 'Blue cheese', 9.00);
    
INSERT INTO userlist VALUES
	(1, 'test@test.test', 'test', 0, 'test', 100); -- 0 == false

INSERT INTO userlist VALUES
	(6, 'admin@admin.dk', 'admin', true, 'admin', 100);

-- INSERT INTO adminList VALUES
-- 	(1, 'admin', 'admin','test@test.test');

-- Demo data

INSERT INTO userlist VALUES
	(3, 'bent@test.dk', 'bent', 0, 'Bent', 100);
    
INSERT INTO userlist VALUES
	(4, 'sanne@test.dk', 'sanne', 0, 'Sanne', 100);
    
INSERT INTO userlist VALUES
	(5, 'rikke@test.dk', 'rikke', 0, 'Rikke', 200);
    


INSERT INTO orderlist VALUES
	(1, 3, '2017-9-9');
    
INSERT INTO orderlist VALUES
	(2, 4, '2017-9-12');   
    
INSERT INTO orderlist VALUES
	(3, 5, '2017-8-10'); 
    
INSERT INTO cupcakelist VALUES
 	(1, 'ChocolateVanilla', 10.00, 1, 2);
    
INSERT INTO cupcakelist VALUES
 	(2, 'BlueBerryAlmond', 12.00, 2, 5);
    
INSERT INTO cupcakelist VALUES
 	(3, 'Blue Cheese Almond', 16.00, 9, 5);
    
INSERT INTO odetail VALUES
	(1, 1, 2, 10, 20);
    
INSERT INTO odetail VALUES
	(2, 2, 1, 12, 12);
    
INSERT INTO odetail VALUES
	(3, 3, 10, 16, 160);
    


alter table orderlist add `confirmation` blob;

select * from lineitem;



commit;