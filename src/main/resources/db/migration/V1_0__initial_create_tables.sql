DROP TABLE IF EXISTS lt.vendors;
CREATE TABLE IF NOT EXISTS lt.vendors (
    id				bigserial NOT NULL PRIMARY KEY,
    vendor_name 	varchar(100) NOT NULL
    );

DROP TABLE IF EXISTS lt.courses;
CREATE TABLE IF NOT EXISTS lt.courses (
    id				bigserial NOT NULL PRIMARY KEY,
    course_code 	varchar(50) NOT NULL,
    course_name 	varchar(250) NOT NULL,
    duration 		integer NULL,
    vendor		bigint NOT NULL,
    FOREIGN KEY (vendor) REFERENCES lt.vendors(id)
    );

DROP TABLE IF EXISTS lt.trainers;
CREATE TABLE IF NOT EXISTS lt.trainers (
    id				bigserial NOT NULL PRIMARY KEY,
    first_name 		varchar(100) NOT NULL,
    last_name 		varchar(100) NOT NULL,
    phone 			varchar(50) NULL,
    email 			varchar(100) NULL
    );

DROP TABLE IF EXISTS lt.students;
CREATE TABLE IF NOT EXISTS lt.students (
    id				bigserial NOT NULL PRIMARY KEY,
    first_name 		varchar(100) NOT NULL,
    last_name 		varchar(100) NOT NULL,
    phone 			varchar(50) NULL,
    email 			varchar(100) NULL
    );

DROP TABLE IF EXISTS lt.events;
CREATE TABLE IF NOT EXISTS lt.events (
    id				bigserial NOT NULL PRIMARY KEY,
    course			bigint NOT NULL,
    trainer			bigint NOT NULL,
    "date" 			date NOT NULL,
    FOREIGN KEY (course) REFERENCES lt.courses(id),
    FOREIGN KEY (trainer) REFERENCES lt.trainers(id)
    );

DROP TABLE IF EXISTS lt.forms;
CREATE TABLE IF NOT EXISTS lt.forms (
    id				bigserial NOT NULL PRIMARY KEY,
    student 		bigint NOT NULL,
    "event"			bigint NOT NULL,
    first_name_ed 	varchar(100) NULL,
    last_name_ed 	varchar(100) NULL,
    phone_ed 		varchar(50) NULL,
    email_ed 		varchar(100) NULL,
    FOREIGN KEY (student) REFERENCES lt.students(id),
    FOREIGN KEY ("event") REFERENCES lt.events(id)
    );

DROP TABLE IF EXISTS lt.users_salt;
CREATE TABLE IF NOT EXISTS lt.users_salt (
    id				bigserial NOT NULL PRIMARY KEY,
    login 			varchar(100) NOT NULL,
    hash 			bytea NOT NULL,
    salt 			bytea NOT NULL,
    "role" 			varchar(100) NOT NULL,
    form			bigint NULL,
    FOREIGN KEY (form) REFERENCES lt.forms(id)
);