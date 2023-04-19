CREATE TABLE Hospital (
	hospitalID	INTEGER	NOT NULL,
	hospitalName VARCHAR (255)NOT NULL,
	clinicalDept VARCHAR (255)	NOT NULL,
	phoneNumber INTEGER,
    locationID INTEGER NOT NULL,
	PRIMARY KEY (hospitalID),
	FOREIGN KEY (locationID) REFERENCES BloodBank(locationID)
);
INSERT INTO Hospital VALUES(1001,'Toronto General','Cardiology',6471234567,319);
INSERT INTO Hospital VALUES(1002,'Toronto General','Emergency',6471234567,456);
INSERT INTO Hospital VALUES(1003,'Toronto General','Pediatrics',6471234567,234);
INSERT INTO Hospital VALUES(1004,'Womens College','Emergency',9054567890,456);
INSERT INTO Hospital VALUES(1005,'Womens College','Gynecology',9054567890,319);
INSERT INTO Hospital VALUES(1006,'Sunnybrook Medical','Pediatrics',2899119119,187);
INSERT INTO Hospital VALUES(1007,'St Michaels','Gynecology',4371234567,234);
INSERT INTO Hospital VALUES(1008,'St Michaels','Gen. Surgery',4371234567,187);
INSERT INTO Hospital VALUES(1009,'St Michaels','Neurology',4371234567,319);
INSERT INTO Hospital VALUES(1010,'St Michaels','Emergency',4371234567,456);
INSERT INTO Hospital VALUES(1011,'Mt Sinai','Neurology',4164567890,234);
INSERT INTO Hospital VALUES(1012,'Mt Sinai','Orthopedics',4164567890,187);
INSERT INTO Hospital VALUES(1013,'Mt Sinai','Cardiology',4164567890,319);
INSERT INTO Hospital VALUES(1014,'Mt Sinai','Emergency',4164567890,456);
