DROP DATABASE IF EXISTS daxbnb1;
CREATE DATABASE daxbnb1;

CREATE TABLE users (
                       id_user INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                       dni VARCHAR(9) NOT NULL UNIQUE,
                       name VARCHAR(50) NOT NULL,
                       surname VARCHAR(50),
                       email VARCHAR(50) NOT NULL UNIQUE,
                       phone VARCHAR(10) NOT NULL,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL
);

CREATE TABLE clients (
                         id_user INT NOT NULL PRIMARY KEY,
                         address VARCHAR(100) NOT NULL,
                         birth_date DATE,
                         description VARCHAR(255),
                         FOREIGN KEY (id_user) REFERENCES users(id_user)
);

CREATE TABLE admins (
                        id_user INT NOT NULL PRIMARY KEY,
                        perm_level INT NOT NULL,
                        FOREIGN KEY (id_user) REFERENCES users(id_user)
);

CREATE TABLE categories(
                           id_category INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                           category_name VARCHAR(20)
);

CREATE TABLE stays(
                      id_stay INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                      id_category INT NOT NULL,
                      titlename VARCHAR(100),
                      city VARCHAR(50) NOT NULL,
                      location_address VARCHAR(100) NOT NULL,
                      description VARCHAR(255),
                      price decimal(6,2) NOT NULL,
                      active BOOL NOT NULL,
                      num_guests INT NOT NULL,
                      num_baths INT,
                      num_beds INT,
                      num_bedrooms INT,
                      FOREIGN KEY(id_category) REFERENCES categories(id_category)
);

CREATE TABLE bookings(
                         id_booking INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         init_date DATE NOT NULL,
                         end_date DATE NOT NULL,
                         id_user INT NOT NULL,
                         id_stay INT NOT NULL,
                         CONSTRAINT chk_initDate CHECK(init_date < end_date),
                         FOREIGN KEY(id_user) REFERENCES users(id_user),
                         FOREIGN KEY (id_stay) REFERENCES stays(id_stay)
);

CREATE TABLE features (
                          id_feature INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                          feature_info VARCHAR(255)
);

CREATE TABLE stay_feature(
                             id_hasFeature INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                             id_feature INT NOT NULL,
                             id_stay INT  NOT NULL,
                             FOREIGN KEY (id_feature) REFERENCES features(id_feature),
                             FOREIGN KEY (id_stay) REFERENCES stays(id_stay)
);

CREATE TABLE images(
                       id_images INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                       path_url VARCHAR(255),
                       description VARCHAR(255),
                       upload_date DATE DEFAULT(CURRENT_DATE()),
                       id_stay INT NOT NULL,
                       FOREIGN KEY(id_stay) REFERENCES stays(id_stay)
);