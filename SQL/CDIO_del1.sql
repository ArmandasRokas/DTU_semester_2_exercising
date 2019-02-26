CREATE TABLE users_cdio(
user_id TINYINT, 
userName VARCHAR(20), 
ini VARCHAR(4), 
cpr VARCHAR(10), 
password VARCHAR(45), 
active boolean,
PRIMARY KEY (user_id)
);



CREATE TABLE roles_cdio(
roles_id TINYINT AUTO_INCREMENT,
 user_id TINYINT,
 role VARCHAR(20),
 PRIMARY KEY (roles_id),
 FOREIGN KEY (user_id) REFERENCES users_cdio(user_id));
 
 INSERT INTO users_cdio 
 values(12,'John', 'JO', '1234567890', '123456', 1);
 
 INSERT INTO roles_cdio (user_id, role)
 values(12, 'user');
 
SELECT * FROM users_cdio;
SELECT * FROM roles_cdio;