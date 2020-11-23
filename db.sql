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
statement VARCHAR(255),
FOREIGN KEY (meterId) REFERENCES user(meterId)
);


CREATE TABLE admin (
name VARCHAR(20),
username VARCHAR(20) NOT NULL,
password VARCHAR(20) NOT NULL,
email VARCHAR(50)
);

INSERT INTO admin VALUES("Vivek Singh","vivek10","passmeVivek","cutie1@gmail.com"),
("Vatsal Gupta","vatsal10","passmeVatsal","cutie2@gmail.com");
