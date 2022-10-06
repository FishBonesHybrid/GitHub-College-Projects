-- Vinicius Parzanini
-- 11/12/2021
-- BNB
-- K00263592

-- Paragraph Describing my System.
-- For this Database i created User as a whole to them differ client to the Host, The user has Login and Password
-- The host has hostID, userID, hostName, hostEmail and Accomodation ID, the Host can reply ONLY one in the rating and it is connected to the accomodation.
-- The accomodation has accomodationID, accType(entire_place, private_room, shared_room), accDesc(Cottage, Studio, Loft, B&B, House, Flat, Ville),
-- accPrice(price per night, price per week, price per month), These ones i did as ENUM and the rest are Bedrooms, Bathrooms, Country, City and price.
-- The other part is the Client, the table is with the clientID, clientName, clientEmail and userID. They can comment and give star once to the rating.
-- The rating has accomodationID, stars, comment, Reply, clientID and hostID. The last one Booking has clientID, accomodationID, numberOfGuests, checkinDate and checkOutDate.

-- Creating Database
CREATE DATABASE bnb;
USE bnb;
SHOW TABLES;

-- Implementing the design in MYSQL:
-- Creating tables
-- User Table
CREATE TABLE User(
	userID INT NOT NULL,
    login VARCHAR(255) DEFAULT NULL,
    password VARCHAR(255) DEFAULT NULL,
    CONSTRAINT us_pk PRIMARY KEY (userID)
    );

-- Client Table    
CREATE TABLE Client(
	clientID INT NOT NULL,
    clientName VARCHAR(255) NOT NULL,
    clientEmail VARCHAR(255) DEFAULT NULL,
    userID INT NOT NULL,
    CONSTRAINT cl_pk PRIMARY KEY (clientID),
    CONSTRAINT us_fk FOREIGN KEY (userID) REFERENCES User (userID)
    );
    
-- Host Table    
CREATE TABLE Host(
	hostID INT NOT NULL,
    userID INT NOT NULL,
    hostName VARCHAR(255) NOT NULL,
    hostEmail VARCHAR(255) DEFAULT NULL,
    accomodationID INT NOT NULL,
    CONSTRAINT hs_pk PRIMARY KEY(hostID),
    CONSTRAINT uss_fk FOREIGN KEY (userID) REFERENCES User (userID),
    CONSTRAINT acc_fk FOREIGN Key (accomodationID) REFERENCES Accomodation (accomodationID)
    );
    
-- Accomodation Table
CREATE TABLE Accomodation(
	accomodationID INT NOT NULL,
    accType ENUM('Entire Place','Private Room','Shared Room'),
    accDesc ENUM('Cottage','Studio','Loft','B&B','House','Flat','Ville'),
    accPrice ENUM('Price per night','Price per week','Price per month'),
    bedrooms SMALLINT NOT NULL,
    bathrooms SMALLINT NOT NULL,
    country VARCHAR(255),
    city VARCHAR(255),
    price INT,
    CONSTRAINT acc_pk PRIMARY KEY (accomodationID)
    );
    
-- Booking table
CREATE TABLE Booking(
	clientID INT,
    accomodationID INT,
    numberOfGuests INT,
    checkInDate DATE,
    checkOutDate DATE,
    CONSTRAINT cidb_fk FOREIGN KEY (clientID) REFERENCES Client (clientID),
    CONSTRAINT accb_fk FOREIGN KEY (accomodationID) REFERENCES Accomodation (accomodationID)
    );
    
-- Rating table
CREATE TABLE Rating(
	accomodationID INT NOT NULL,
	stars ENUM('1','2','3','4','5'),
    comment VARCHAR(255) DEFAULT NULL,
    reply VARCHAR(255) DEFAULT NULL,
    clientID INT DEFAULT NULL,
    hostID INT DEFAULT NULL,
    CONSTRAINT accr_fk FOREIGN KEY (accomodationID) REFERENCES Accomodation (accomodationID),
    CONSTRAINT cli_fk FOREIGN KEY (clientID) REFERENCES Client (clientID),
    CONSTRAINT hos_fk FOREIGN KEY (hostID) REFERENCES Host (hostID)
    );
    
-- Populating the Data 5 records each table
-- The user is going to be 10, 5 Host and 5 client

INSERT INTO User VALUES(1,'Sarah','Sarah1');
INSERT INTO User VALUES(2,'James','JJ123');
INSERT INTO User VALUES(3,'Ophelia','Ophis');
INSERT INTO User VALUES(4,'Marcelle','Mah123');
INSERT INTO User VALUES(5,'Mary','MaMa123');
INSERT INTO User VALUES(6,'Max','Max321');
INSERT INTO User VALUES(7,'Pascoal','Pas321');
INSERT INTO User VALUES(8,'Bob','bob1');
INSERT INTO User VALUES(9,'Carlos','Carlow');
INSERT INTO User VALUES(10,'Charles','charlis');

-- Client table
INSERT INTO Client VALUES(1,'Sarah','Sarah.s@gmail.com',1);
INSERT INTO Client VALUES(2,'James','jj.j@gmail.com',2);
INSERT INTO Client VALUES(3,'Mary','Mary.j@gmail.com',5);
INSERT INTO Client VALUES(4,'Pascoal','Pacoal@gmail.com',7);
INSERT INTO Client VALUES(5,'Charles','cchar.le@gmail.com',10);

-- Host Table Marcelle, Max, bob, carlos
INSERT INTO Host VALUES(1,3,'Ophelia','Ophe.lia@gmail.com',1);
INSERT INTO Host VALUES(2,4,'Marcelle','Maah@gmail.com',2);
INSERT INTO Host VALUES(3,6,'Max','Max@gmail.com',3);
INSERT INTO Host VALUES(4,8,'Bob','bob@gmail.com',4);
INSERT INTO Host VALUES(5,9,'Carlos','Carlito@gmail.com',5);

-- Accomodation table
INSERT INTO Accomodation VALUES(1,'Entire Place','House','Price per night',4,4,'Ireland','Limerick',225);
INSERT INTO Accomodation VALUES(2,'Private Room','Flat','Price per week',1,1,'Ireland','Limerick',89);
INSERT INTO Accomodation VALUES(3,'Shared Room','House','Price per month',2,2,'Ireland','Limerick',350);
INSERT INTO Accomodation VALUES(4,'Entire Place','Ville','Price per night',6,6,'Ireland','Green Palace',3000);
INSERT INTO Accomodation VALUES(5,'Shared Room','B&B','Price per night',3,3,'Ireland','Dubln',1800);

-- Booking table
INSERT INTO Booking VALUES(1,1,6,'2019-10-10','2019-10-19');
INSERT INTO Booking VALUES(2,2,1,'2019-09-01','2019-09-18');
INSERT INTO Booking VALUES(3,3,1,'2019-04-10','2019-10-10');
INSERT INTO Booking VALUES(4,4,12,'2019-08-10','2019-08-25');
INSERT INTO Booking VALUES(5,5,2,'2019-12-12','2019-12-13');

-- Rating table
INSERT INTO Rating VALUES(1,3,'Cute place','Thank you',1,1);
INSERT INTO Rating VALUES(2,4,'Amazing Stay, the food could be better','Thank you, We will hire another cook',2,2);
INSERT INTO Rating VALUES(3,5,'Awesome','Glad you liked it.',3,3);
INSERT INTO Rating VALUES(4,5,'Cannot wait to come back','We will be waiting for you :)',4,4);
INSERT INTO Rating VALUES(5,1,'Worst place ever, 1 star','Sorry that is Dublin, I cant do much.',5,5);

-- CREATING FOUR SQL Stored Procedures.
-- The first procedure is you enter the Client Id and it comes back the name and email of the Client
DELIMITER $$

CREATE PROCEDURE clientDetail(IN cID INT)
	BEGIN
		SELECT clientName, clientEmail FROM Client WHERE clientID = cID;
	END $$
$$

DELIMITER ; 

CALL clientDetail(1);
CALL clientDetail(3);

-- The second procedure you enter the HostID and it comes back the host name, accomodation type, country and city.

DELIMITER $$

CREATE PROCEDURE hostAco(IN hosID INT)
	BEGIN
		SELECT h.hostName,a.accType, a.country, a.city FROM Accomodation a JOIN Host h ON h.accomodationID = a.accomodationID WHERE hosID = h.hostID;
	END $$
$$

DELIMITER ;
DROP PROCEDURE hostAco;
CALL hostAco(2);

-- The third procedure is takes the clientID and returns the number of Guests, check in date and check out date

DELIMITER $$

CREATE PROCEDURE clientCheck(IN clieID INT, OUT clientN VARCHAR(255), OUT guests INT, OUT checkIn DATE, OUT checkOut DATE)
	BEGIN
		SELECT clientName INTO clientN FROM Client WHERE clieID = clientID;
		SELECT numberOfGuests INTO guests FROM Booking WHERE clieID = clientID;
        SELECT checkInDate INTO checkIn FROM Booking WHERE clieID = clientID;
        SELECT checkOutDate INTO checkOut FROM Booking WHERE clieID = clientID;
	END $$
$$

DELIMITER ;

CALL clientCheck(3, @clientN, @guests, @checkIn, @checkOUT);
SELECT @clientN, @guests, @checkIN, @checkOut;

-- Last Procedure, it is going to return how many accomodations in the site is less than 200, between 201 to 1000 and more than 1001. Doesn't matter if it is per day, week or month.

DELIMITER $$

CREATE PROCEDURE price(OUT less200 INT, OUT bet201to1000 INT, OUT over1001 INT)
	BEGIN
		SELECT COUNT(price) INTO less200 FROM Accomodation WHERE price < 200;
        SELECT COUNT(price) INTO bet201to1000 FROM Accomodation WHERE price > 1000 AND 200 < price;
        SELECT COUNT(price) INTO over1001 FROM Accomodation WHERE price < 1001;
	END $$
$$

DELIMITER ;
DROP PROCEDURE price;
CALL price(@less200, @bet201to1000, @over1001);
SELECT @less200, @bet201to1000, @over1001;

-- TRIGGERS
-- Update Trigger
-- The first trigger is a table that shows if the accomodation went up or down after a update.
-- Creating the table price diff
CREATE TABLE priceDif AS SELECT DISTINCT accomodationID, 0 as priceDiff FROM Accomodation;
DROP TABLE priceDif;

-- Trigger
DELIMITER //

CREATE TRIGGER update_priceDif AFTER UPDATE ON Accomodation
FOR EACH ROW
	BEGIN
		IF NEW.price IS NOT NULL THEN UPDATE priceDif
        SET priceDiff = priceDiff - OLD.price
        WHERE accomodationID = NEW.accomodationID;
        END IF;
        IF NEW.price IS NOT NULL THEN UPDATE priceDif
        SET priceDiff = priceDiff + NEW.price
        WHERE accomodationID = NEW.accomodationID;
        END IF;
	END //
    
delimiter ;

DROP TRIGGER update_priceDif;

-- Price going up (because it's Dublin, always go up).
UPDATE Accomodation SET price = 2000 WHERE city = 'Dubln';
UPDATE Accomodation SET price = 1800 WHERE city = 'Dubln';
SELECT * FROM Accomodation;
SELECT * FROM priceDif;


-- The second trigger is insert of a new accomodation to the priceDiff table

DELIMITER //

CREATE TRIGGER insert_priceDif AFTER INSERT ON Accomodation
FOR EACH ROW
BEGIN
	IF NEW.accomodationID IS NOT NULL THEN UPDATE priceDif
    SET priceDiff = priceDiff + NEW.price
    WHERE accomodationID = NEW.price;
    END IF;
END //

delimiter ;

DROP TRIGGER insert_priceDif;

-- Adding the table to the Accomodation
INSERT INTO Accomodation VALUES(6,'Entire Place','Cottage','Price per night',3,3,'UK','London',1200);
INSERT INTO Accomodation VALUES(7,'Entire Place','Cottage','Price per night',3,3,'UK','London',24200);
DELETE FROM Accomodation WHERE city = 'London';
SELECT * FROM priceDif;

-- The last one is delete trigger, the price diff is going to 0 when deleted.

DELIMITER //

CREATE TRIGGER delete_priceDif AFTER DELETE ON Accomodation
FOR EACH ROW
BEGIN
	if(OLD.accomodationID IS NOT NULL) THEN UPDATE priceDif
    SET priceDiff = priceDiff - OLD.price
    WHERE accomodationID = OLD.accomodationID;
    END IF;
end //

delimiter ;

DROP TRIGGER delete_priceDif;

-- Deleting Row.
DELETE FROM Accomodation WHERE city = 'London';
SHOW TRIGGERS;

-- User privileges.
-- Creating 3 different users
CREATE USER 'vini'@'localhost' Identified by 'p';
CREATE USER 'Paul'@'localhost' Identified by 'p';
CREATE USER 'Angela'@'localhost' Identified by 'p';

-- Granting one by one
GRANT INSERT ON bnb.* TO 'vini'@'localhost';
GRANT DELETE ON bnb.* TO 'Paul'@'localhost';
GRANT UPDATE ON bnb.* TO 'Angela'@'localhost';

SHOW GRANTS FOR 'vini'@'localhost';
SHOW GRANTS FOR 'Paul'@'localhost';
SHOW GRANTS FOR 'Angela'@'localhost';