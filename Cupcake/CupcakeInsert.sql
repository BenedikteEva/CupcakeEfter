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
	(2, 'admin@admin.dk', 'admin', 1, 'admin', 100);

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
    

commit;