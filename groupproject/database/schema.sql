-- Creating the database --
CREATE DATABASE IF NOT EXISTS jupiter_company;
USE jupiter_company;

CREATE TABLE employees (
    employee_id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    start_date DATE NOT NULL,
    start_salary DECIMAL(10,2) NOT NULL,
    employee_contract_signed BOOLEAN NOT NULL DEFAULT FALSE,
    social_security_number CHAR(11) NOT NULL UNIQUE,
    birthdate DATE NOT NULL,
    phone_number VARCHAR(20) NOT NULL,
    emergency_contact_name VARCHAR(100) NOT NULL,
    emergency_contact_phone_number VARCHAR(20) NOT NULL,
    PRIMARY KEY (employee_id)
);

CREATE TABLE users (
    username VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL,
    enabled BOOLEAN NOT NULL,
    PRIMARY KEY (username)
);

CREATE TABLE authorities (
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    CONSTRAINT fk_authorities_users
        FOREIGN KEY (username) REFERENCES users(username),
    CONSTRAINT ux_authorities UNIQUE (username, authority)
);
