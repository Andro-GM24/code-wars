CREATE SCHEMA Bank_Ud;
use Bank_Ud;

CREATE TABLE IF NOT EXISTS users(
	id_number binary(16) DEFAULT (UUID_TO_BIN(UUID())),
	name varchar(70) NOT NULL,
    last_name VARCHAR(70) NOT NULL,  
    pasword VARCHAR(8) NOT NULL,
    phone_number VARCHAR(15),
    email VARCHAR(40) UNIQUE NOT NULL    
);
ALTER TABLE users ADD primary key(id_number);

CREATE TABLE IF NOT EXISTS financial_product_status(
	id_status INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(10) NOT NULL,
    description VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS financial_product_type(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    description VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS transaction_status(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS transaction_type(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    description VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS financial_product(
	id INT AUTO_INCREMENT PRIMARY KEY,
    user_fk BINARY(16),
    type_fk INT,
    status_fk INT,
    date DATETIME,
    amount DECIMAL (12, 2) NOT NULL,
    has_card TINYINT(0) NOT NULL,     
    FOREIGN KEY (user_fk) REFERENCES users(id_number),
    FOREIGN KEY (type_fk) REFERENCES financial_product_type(id),
    FOREIGN KEY (status_fk) REFERENCES financial_product_status(id_status)    
);

CREATE TABLE IF NOT EXISTS banking_card(
	id INT AUTO_INCREMENT PRIMARY KEY,
    card_number INT UNIQUE,
    financial_product_fk INT,
    password VARCHAR(50) NOT NULL,
    creation_date datetime NOT NULL,
    expiry_date datetime NOT NULL,
    FOREIGN KEY (financial_product_fk) REFERENCES financial_product(id)
);

CREATE TABLE IF NOT EXISTS movement_history(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30),
    description VARCHAR(120),
    date datetime,
	amount DECIMAL(12, 2) NOT NULL,
    financial_product_fk INT,
    FOREIGN KEY (financial_product_fk) REFERENCES financial_product(id)
);

CREATE TABLE IF NOT EXISTS transaction(
	id INT AUTO_INCREMENT PRIMARY KEY,
    transaction_type_fk INT,
    date datetime,
    status_fk INT,
    amount DECIMAL(12, 2) NOT NULL,
    origin_fk INT,
    destination_fk INT,
	FOREIGN KEY (transaction_type_fk) REFERENCES transaction_type(id),
	FOREIGN KEY (status_fk) REFERENCES transaction_status(id),
	FOREIGN KEY (origin_fk) REFERENCES financial_product(id),
	FOREIGN KEY (destination_fk) REFERENCES financial_product(id)
);

CREATE TABLE IF NOT EXISTS transaction_code(
	id INT AUTO_INCREMENT PRIMARY KEY,
    transaction_fk INT,
    creatrion_date datetime NOT NULL,
    expiry_date datetime NOT NULL,
    status TINYINT(1) NOT NULL,
    FOREIGN KEY (transaction_fk) REFERENCES transaction(id)    
);

INSERT INTO users (name, last_name, pasword, phone_number, email)
VALUES ('John', 'Doe', 'pasord1', '12340', 'john.doe@example.com');

INSERT INTO users (name, last_name, pasword, phone_number, email)
VALUES ('Jane', 'Smith', 'passwd2', '098721', 'jane.smith@example.com');

INSERT INTO users (name, last_name, pasword, phone_number, email)
VALUES ('Alice', 'Johnson', 'passwd3', '11455', 'alice.johnson@example.com');

INSERT INTO users (name, last_name, pasword, phone_number, email)
VALUES ('Bob', 'Brown', 'passwd4', '66800', 'bob.brown@example.com');

INSERT INTO users (name, last_name, pasword, phone_number, email)
VALUES ('Charlie', 'Davis', 'passrd5', '23234', 'charlie.davis@example.com');


INSERT INTO transaction_code (transaction_fk, creatrion_date, expiry_date, status) 
VALUES (1, '2024-06-10 10:00:00', '2024-12-10 10:00:00', 1);

INSERT INTO transaction_code (transaction_fk, creatrion_date, expiry_date, status) 
VALUES (2, '2024-06-11 11:30:00', '2024-12-11 11:30:00', 1);

INSERT INTO transaction_code (transaction_fk, creatrion_date, expiry_date, status) 
VALUES (3, '2024-06-12 14:45:00', '2024-12-12 14:45:00', 0);

INSERT INTO transaction_code (transaction_fk, creatrion_date, expiry_date, status) 
VALUES (4, '2024-06-13 09:15:00', '2024-12-13 09:15:00', 1);

INSERT INTO transaction_code (transaction_fk, creatrion_date, expiry_date, status) 
VALUES (5, '2024-06-14 16:20:00', '2024-12-14 16:20:00', 0);

