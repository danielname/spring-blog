CREATE DATABASE IF NOT EXISTS springblog_db;
USE springblog_db;

INSERT INTO users (email, password, username)
    VALUE ('example@email.com', 'password', 'exampleUser');