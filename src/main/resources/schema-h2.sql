CREATE TABLE employees(id BIGINT PRIMARY KEY AUTO_INCREMENT,
                       firstname VARCHAR(30) NOT NULL,
                       middleinitial CHAR(1) NOT NULL,
                       lastname VARCHAR(30) NOT NULL,
                       dateofbirth SMALLDATETIME NOT NULL,
                       dateofemployment SMALLDATETIME NOT NULL,
                       status VARCHAR(8) DEFAULT 'ACTIVE' NOT NULL
                       );