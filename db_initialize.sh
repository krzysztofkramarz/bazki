#!/bin/bash

echo 'DROP TABLE IF EXISTS CLIENTS;
CREATE TABLE CLIENTS
(
ID int primary key not null,
FullName VARCHAR(255) NOT NULL, 
Adress VARCHAR(255) NOT NULL, 
Movies_Rented TEXT NOT NULL, 
Salutation VARCHAR(255) NOT NULL, 
Category TEXT NOT NULL
);
INSERT INTO CLIENTS VALUES(1,'Krzychu Graba', 'Zapolska 110 31-355 Kraków', 'Lord Of The Rings Return of the King, Star Wars A New Hope', 'Mr.', 'Fantasy, Sci-fi');
INSERT INTO CLIENTS VALUES(2,'Bartek Wukabepe', 'Bazodanowa 112 31-355 Kraków', 'Star Wars Phantom Manace', 'Mr.', 'Sci-fi');
' > db.sql
cat db.sql | xclip -selection c
