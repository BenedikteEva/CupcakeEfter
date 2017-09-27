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
	`order_id` int (11) NOT NULL AUTO_INCREMENT, 
    `cupcake_id` int (5), 
    `quantity` int(5),
	`priceprcc`int (4), 
    `total_price`int (4),
    primary key (order_id,cupcake_id), foreign key (order_id) references orderlist(order_id),
	foreign key (cupcake_id) references cupcakelist(cupcake_id)); 

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