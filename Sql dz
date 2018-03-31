CREATE TABLE Salespeople(
    snum  INT,
    sname VARCHAR(30),
    city  VARCHAR(15),
    comm  DECIMAL(3,2));

CREATE TABLE Customers(
    cnum   INT,
    cname  VARCHAR(30),
    city   VARCHAR(15),
    rating INT,
    snum   INT);

CREATE TABLE Orders (
    onum  INT,
    odate DATE,
    amt   DECIMAL(14,2),
    snum  INT,
    cnum  INT);

delete from Salespeople;
INSERT INTO Salespeople(snum, sname, city, comm)
values(1001, 'Peel', 'London',    0.12);
INSERT INTO Salespeople(snum, sname, city, comm)
values(1002, 'Serres', 'San Jose',  0.13);
INSERT INTO Salespeople(snum, sname, city, comm)
values(1004, 'Motika', 'London', 0.11);
INSERT INTO Salespeople(snum, sname, city, comm)
values(1007, 'Rifkin', 'Barcelona', 0.15);
INSERT INTO Salespeople(snum, sname, city, comm)
values(1003, 'Axelrod', 'New York', 0.10);

delete from Customers;
insert into Customers(cnum, cname,city,rating, snum)
values(2001, 'Hoffman', 'London', 100, 1001);
insert into Customers(cnum, cname,city,rating, snum)
values(2002, 'Giovanni', 'Rome', 200, 1003);
insert into Customers(cnum, cname,city,rating, snum)
values(2003, 'Liu', 'San Jose', 200, 1002);
insert into Customers(cnum, cname,city,rating, snum)
values(2004, 'Grass', 'Berlin', 300, 1002);
insert into Customers(cnum, cname,city,rating, snum)
values(2006, 'Clemens', 'London', 100, 1001);
insert into Customers(cnum, cname,city,rating, snum)
values(2008, 'Cisneros', 'San Jose', 300, 1007);
insert into Customers(cnum, cname,city,rating, snum)
values(2007, 'Pereira', 'Rome', 100,1004);

delete from Orders;
insert into Orders(onum, amt, odate, cnum, snum)
values(3001, 18.69, '03.10.2015', 2008, 1007);
insert into Orders(onum, amt, odate, cnum, snum)
values(3003, 767.19, '03.10.2015', 2001, 1001);
insert into Orders(onum, amt, odate, cnum, snum)
values(3002, 1900.10, '03.10.2015', 2007, 1004);
insert into Orders(onum, amt, odate, cnum, snum)
values(3005, 5160.45, '03.10.2015', 2003, 1002);
insert into Orders(onum, amt, odate, cnum, snum)
values(3006, 1098.16, '03.10.2015', 2008, 1007);
insert into Orders(onum, amt, odate, cnum, snum)
values(3009, 1713.23, '04.10.2015', 2002, 1003);
insert into Orders(onum, amt, odate, cnum, snum)
values(3007, 75.75, '04.10.2015', 2004, 1002);
insert into Orders(onum, amt, odate, cnum, snum)
values(3008, 4723.00, '05.10.2015', 2006, 1001);
insert into Orders(onum, amt, odate, cnum, snum)
values(3010, 1309.95, '06.10.2015', 2004, 1002);
insert into Orders(onum, amt, odate, cnum, snum)
values(3011, 9891.88, '06.10.2015', 2006, 1001);
SELECT *FROM orders WHERE snum = 1001;
SELECT sname, comm FROM salespeople WHERE city = 'London';
SELECT cname, rating FROM customers WHERE rating > 150;
SELECT *FROM customers WHERE city <> 'Rome' AND rating <= 100;
SELECT *FROM salespeople WHERE city <> 'London' AND comm > 0.11;
SELECT *FROM salespeople WHERE city = 'London' AND comm <= 0.11 OR comm > 0.13;
