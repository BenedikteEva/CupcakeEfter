/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */; -- 0 er true, 1 = false
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE `cupcakeefter`;

use cupcakeefter;

-- Create table userlist
drop table if exists `userlist`;
create table `userlist` (
	`user_id` int(11) NOT NULL AUTO_INCREMENT,
	`email`varchar(100) NOT NULL, 
    `password`varchar(100) NOT NULL,  
    `admin_status`boolean, 
	`username` varchar(45) NOT NULL,
    `balance`double (10,2) default 100, 
	primary key (user_id));

-- Create table toppinglist
drop table if exists `toppinglist`;
create table `toppinglist` (
	`top_id` int(11) NOT NULL AUTO_INCREMENT, 
    `topname` varchar(45), 
    `top_price`double (10,2), 
primary key (top_id));

-- Create table bottomlist
drop table if exists `bottomlist`;
create table `bottomlist` (
	`bot_id` int(11) NOT NULL AUTO_INCREMENT, 
	`bottomname` varchar(45), 
    `bot_price`double (10,2), 
primary key (bot_id));

 -- Create tabel orderlist
drop table if exists `orderlist`;
create table `orderlist`(
	`order_id`int (11) ,
    `user_id`int (11), 
   `received`datetime,   
primary key (order_id), foreign key (user_id) references `userlist`(user_id));

-- Create tabel lineitem
drop table if exists `lineitem`;
create table `lineitem`(
  `lineitem_id` INT(11) NOT NULL auto_increment,
  `order_id` INT(11) NOT NULL,
  `top_id` int(11),
  `bot_id` int(11),
  `ccname` VARCHAR(50),
  `quantity` INT(5) ,
  `prisprcc` double(5,2) ,
  `totalprice` double(9,2) ,
  PRIMARY KEY (lineitem_id), foreign key (order_id) references `orderlist`(order_id),
  foreign key (top_id) references `toppinglist`(top_id),
  foreign key (bot_id) references `bottomlist`(bot_id));

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Demo data

-- Demo user data
INSERT INTO userlist VALUES -- user_is, email, password, admin_status, username, balance
	(1, 'test@test.test', 'test', 0, 'test', 100); -- 0 == false

INSERT INTO userlist VALUES
	(2, 'admin@admin.dk', 'admin', 1, 'admin', 100);

INSERT INTO userlist VALUES
	(3, 'bent@test.dk', 'bent', 0, 'Bent', 100);
    
INSERT INTO userlist VALUES
	(4, 'sanne@test.dk', 'sanne', 0, 'Sanne', 100);
    
INSERT INTO userlist VALUES
	(5, 'rikke@test.dk', 'rikke', 0, 'Rikke', 200);

-- Demo bottomlist
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

-- Demo toppinglist    
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
    
-- Demo data til orderlist
INSERT INTO orderlist VALUES -- order_id, user_id, recieved
	(1, 3);
    
INSERT INTO orderlist VALUES
	(2, 4);   
    
INSERT INTO orderlist VALUES
	(3, 5); 
    
INSERT INTO orderlist VALUES
	(4, 3);
    
-- Demo data til lineitem
INSERT INTO lineitem values -- linitem_id, order_id,top_id, bot_id, ccname, quantity, priceprcc, totalprice  
	(1, 1, 8, 5, 'Lemon with Almond', 1, 15, 15);

INSERT INTO lineitem values  
	(2, 2, 5, 5, 'Strawberry with Almond', 2, 13, 26);

INSERT INTO lineitem values  
	(3, 3, 5, 5, 'Strawberry with Almond', 2, 13, 26);
    
INSERT INTO lineitem values  
	(4, 3, 1, 4, 'Chocolate with Pistacio', 3, 11, 33);
    
INSERT INTO lineitem values  
	(5, 4, 7, 1, 'Orange with Chocolate', 2, 13, 26);
    select * from lineitem;
    select * from orderlist;
    select * from userlist;
   
    
 
commit;