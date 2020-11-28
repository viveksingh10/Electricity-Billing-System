CREATE DATABASE ElectricityBillingSystem;
USE ElectricityBillingSystem;
CREATE TABLE user (
meterId INT(5) NOT NULL PRIMARY KEY,
name VARCHAR(20),
username VARCHAR(20) NOT NULL,
password VARCHAR(20) NOT NULL,
email VARCHAR(50),
gender VARCHAR(1),
adharCard VARCHAR(100),
billAmount DECIMAL(10,2)
);

INSERT INTO user VALUES(100,"Vivek Singh","vivek10","passmeVivek","cutie1@gmail.com","M","dummy","0.0"),
(101,"Vatsal Gupta","vatsal10","passmeVatsal","cutie2@gmail.com","M","dummy","0.0"),
(102,"Utkarsh Bateria","utkarsh10","passmeUtkarsh","cutie3@gmail.com","M","dummy","0.0"),
(103,"Vanshika agarwal","vanshika10","passmeVanshika","cutie4@gmail.com","F","dummy","0.0");



CREATE TABLE feedback(
meterId INT(5) NOT NULL PRIMARY KEY,
type VARCHAR(255),
remark VARCHAR(255),
status VARCHAR(255),
);

CREATE TABLE newPayments(
meterId INT(5) NOT NULL ,
amount DECIMAL(10,2)
);

CREATE TABLE approvedPayments(
meterId INT(5) NOT NULL ,
amount DECIMAL(10,2)
);


CREATE TABLE admin (
name VARCHAR(20),
username VARCHAR(20) NOT NULL,
password VARCHAR(20) NOT NULL,
email VARCHAR(50)
);

INSERT INTO admin VALUES("Vivek Singh","vivek10","passmeVivek","cutie1@gmail.com"),
("Vatsal Gupta","vatsal10","passmeVatsal","cutie2@gmail.com");
