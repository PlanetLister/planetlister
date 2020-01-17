CREATE DATABASE IF NOT EXISTS planetlister_db;
USE planetlister_db;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS planets;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS ad_category;

CREATE TABLE users (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(120) UNIQUE NOT NULL,
    email VARCHAR (80) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    filepath_to_avatar VARCHAR(120) DEFAULT NULL,
    PRIMARY KEY (id)

);

CREATE TABLE planets (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    planetname VARCHAR(50) NOT NULL,
    planetdesc VARCHAR(650) NOT NULL,
    filepath_to_image VARCHAR(120) DEFAULT NULL,
    user_id INT UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES  users(id)
);


CREATE TABLE categories (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(50),
    PRIMARY KEY (id)
);

CREATE TABLE ad_category (
    planet_id INT UNSIGNED NOT NULL,
    category_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (planet_id) REFERENCES planets(id),
    FOREIGN KEY (category_id) REFERENCES categories(id)

);