CREATE TABLE Recipient (
	recipientID	INTEGER PRIMARY KEY AUTOINCREMENT,
	fullname VARCHAR (255)	NOT NULL,
	bloodType VARCHAR (3) NOT NULL,
    hospitalID INTEGER NOT NULL,
	FOREIGN KEY (hospitalID) REFERENCES Hospital(hospitalID)
);
INSERT INTO Recipient VALUES(5000, 'John Doe', 'AB+', 1013);
INSERT INTO Recipient VALUES(5025, 'Jane Doe', 'AB-', 1003);
INSERT INTO Recipient VALUES(5050, 'James Smith', 'B+', 1011);
INSERT INTO Recipient VALUES(5075, 'Maria Garcia', 'B-', 1009);
INSERT INTO Recipient VALUES(5100, 'Mary Smith', 'A+', 1006);
INSERT INTO Recipient VALUES(5125, 'Maria Rodriguez', 'A-', 1005);
INSERT INTO Recipient VALUES(5150, 'Michael Smith', 'O+', 1014);
INSERT INTO Recipient VALUES(5175, 'Michelle Hernandez', 'O-', 1002);
INSERT INTO Recipient VALUES(5200, 'Sarah Jones', 'AB-', 1007);
INSERT INTO Recipient VALUES(5225, 'Alex Jameson', 'A-', 1010);
INSERT INTO Recipient VALUES(5250, 'Robert Smith', 'O+', 1008);
