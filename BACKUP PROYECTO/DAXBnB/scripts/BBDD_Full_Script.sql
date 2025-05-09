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

-- USERS
INSERT INTO users (dni, name, surname, email, phone, username, password) VALUES
    ('12345678A', 'Juan', 'Pérez', 'juan@example.com', '600111222', 'juanp', '1234'),
    ('23456789B', 'María', 'Gómez', 'maria@example.com', '600222333', 'mariag', '1234'),
    ('34567890C', 'Carlos', 'Sánchez', 'carlos@example.com', '600333444', 'carloss', '1234'),
    ('45678901D', 'Laura', 'Ruiz', 'laura@example.com', '600444555', 'laurar', '1234'),
    ('56789012E', 'Pedro', 'López', 'pedro@example.com', '600555666', 'pedrol', '1234'),
    ('67890123F', 'Lucía', 'Martínez', 'lucia@example.com', '600666777', 'luciam', '1234'),
    ('78901234G', 'David', 'Torres', 'david@example.com', '600777888', 'davidt', '1234'),
    ('89012345H', 'Ana', 'Ramírez', 'ana@example.com', '600888999', 'anar', '1234'),
    ('90123456I', 'Pablo', 'Navarro', 'pablo@example.com', '600999000', 'pablon', '1234'),
    ('01234567J', 'Elena', 'Moreno', 'elena@example.com', '600000111', 'elenam', '1234');

-- ADMIN
INSERT INTO admins (id_user, perm_level) VALUES (1, 5);

-- CLIENTS
INSERT INTO clients (id_user, address, birth_date, description) VALUES
    (2, 'Calle Mayor 12', '1990-05-01', 'Cliente frecuente'),
    (3, 'Av. de Andalucía 45', '1985-03-12', ''),
    (4, 'Plaza del Sol 3', '1992-08-24', 'Le encanta viajar'),
    (5, 'Calle Luna 78', '1980-11-11', ''),
    (6, 'Camino Verde 7', '1995-09-15', ''),
    (7, 'Paseo del Prado 1', '1988-06-30', ''),
    (8, 'Calle Real 9', '1975-02-19', ''),
    (9, 'Avenida del Mar 33', '1993-04-22', ''),
    (10, 'Calle Norte 4', '1986-07-10', '');

-- CATEGORIES
INSERT INTO categories (category_name) VALUES
    ('Apartamento'),
    ('Casa'),
    ('Villa'),
    ('Ático');

-- STAYS
INSERT INTO stays (id_category, titlename, city, location_address, description, price, active, num_guests, num_baths, num_beds, num_bedrooms) VALUES
    (1, 'Apartamento Centro','Madrid, España', 'Calle Gran Vía 1', 'En pleno centro de Madrid', 85.00, true, 2, 1, 1, 1),
    (2, 'Casa Rural','Teruel, España', 'Camino del Bosque 12', 'Ideal para desconectar', 120.00, true, 5, 2, 4, 3),
    (3, 'Villa Lujo','Lugo, España', 'Avenida de Lujo 99', 'Con piscina privada', 250.00, true, 8, 3, 6, 4),
    (1, 'Piso Moderno','Castilloviejo, España', 'Calle Nueva 22', 'Recién reformado', 90.00, true, 3, 1, 2, 2),
    (4, 'Ático con Terraza','Barcelona, España', 'Calle Alta 10', 'Vistas espectaculares', 110.00, true, 2, 1, 1, 1),
    (2, 'Casa Familiar','Barcelona, España', 'Calle Tranquila 33', 'Perfecta para niños', 100.00, true, 4, 2, 3, 3),
    (3, 'Villa Mediterránea','Benidorm, España', 'Costa Azul 88', 'Cerca de la playa', 180.00, true, 6, 2, 4, 3),
    (1, 'Estudio Económico','Vic, España', 'Calle Pequeña 5', 'Ideal para una persona', 50.00, true, 1, 1, 1, 1);

-- FEATURES
INSERT INTO features (feature_info) VALUES
    ('WiFi'),
    ('Aire acondicionado'),
    ('Calefacción'),
    ('Piscina'),
    ('Jardín'),
    ('Terraza'),
    ('Cocina equipada'),
    ('TV por cable');

-- STAY_FEATURES
INSERT INTO stay_feature (id_feature, id_stay) VALUES
    (1, 1), (2, 1),
    (3, 2), (4, 2),
    (4, 3), (5, 3),
    (1, 4), (6, 4),
    (6, 5), (2, 5),
    (1, 6), (7, 6),
    (3, 7), (8, 7),
    (8, 8), (2, 8);

-- IMAGES
INSERT INTO images (path_url, description, id_stay) VALUES
    ('images/stay1_1.jpg', 'Salón moderno', 1),
    ('images/stay2_1.jpg', 'Exterior con jardín', 2),
    ('images/stay3_1.jpg', 'Piscina de noche', 3),
    ('images/stay4_1.jpg', 'Dormitorio principal', 4),
    ('images/stay5_1.jpg', 'Vistas desde la terraza', 5),
    ('images/stay6_1.jpg', 'Cocina equipada', 6),
    ('images/stay7_1.jpg', 'Patio interior', 7),
    ('images/stay8_1.jpg', 'Zona de estudio', 8),
    ('images/stay1_2.jpg', 'Baño completo', 1);

-- BOOKINGS
INSERT INTO bookings (init_date, end_date, id_user, id_stay) VALUES
    ('2025-05-01', '2025-05-05', 2, 1),
    ('2025-06-10', '2025-06-15', 3, 2),
    ('2025-07-20', '2025-07-25', 4, 3),
    ('2025-08-01', '2025-08-10', 5, 4),
    ('2025-05-15', '2025-05-20', 6, 5),
    ('2025-09-01', '2025-09-07', 7, 6),
    ('2025-10-05', '2025-10-12', 8, 7),
    ('2025-12-24', '2025-12-31', 9, 8),
    ('2025-11-01', '2025-11-05', 10, 1),
    ('2025-06-01', '2025-06-03', 3, 2),
    ('2025-07-01', '2025-07-04', 4, 3),
    ('2025-08-15', '2025-08-20', 5, 4),
    ('2025-09-10', '2025-09-14', 6, 5),
    ('2025-10-20', '2025-10-24', 7, 6),
    ('2025-11-10', '2025-11-15', 8, 7),
    ('2025-12-10', '2025-12-14', 9, 8);

create
    definer = root@`%` procedure bookings_delete_by_id(IN p_id_booking int)
BEGIN
	DELETE FROM bookings WHERE id_booking = p_id_booking;
END;

create
    definer = root@`%` procedure bookings_insert_new(IN p_init_date date, IN p_end_date date, IN p_id_user int,
                                                     IN p_id_stay int)
BEGIN
	INSERT INTO bookings (init_date, end_date, id_user, id_stay) VALUES (p_init_date, p_end_date, p_id_user, p_id_stay);
END;

create
    definer = root@`%` procedure categories_delete_by_id(IN p_id_category int)
BEGIN
	DELETE FROM categories WHERE id_category = p_id_category;
END;

create
    definer = root@`%` procedure categories_insert_new(IN p_category_name varchar(20))
BEGIN
	INSERT INTO categories (category_name) VALUES (p_category_name);
END;

create
    definer = root@`%` procedure features_delete_by_id(IN p_id_feature int)
BEGIN
	DELETE FROM features WHERE id_feature = p_id_feature;
END;

create
    definer = root@`%` procedure features_insert_new(IN p_feature_info varchar(255))
BEGIN
	INSERT INTO features (feature_info) VALUES (p_feature_info);
END;

create
    definer = root@`%` procedure has_features_add_feature_to_stay(IN p_id_stay int, IN p_id_feature int)
BEGIN
	INSERT INTO stay_feature (id_stay, id_feature) VALUES (p_id_stay, p_id_feature);
END;

create
    definer = root@`%` procedure has_features_delete_all_features_from_stay(IN p_id_stay int)
BEGIN
	DELETE FROM stay_feature WHERE id_stay = p_id_stay;
END;

create
    definer = root@`%` procedure has_features_remove_feature_from_stay(IN p_id_stay int, IN p_id_feature int)
BEGIN
	DELETE FROM stay_feature WHERE id_stay = p_id_stay AND id_feature = p_id_feature;
END;

create
    definer = root@`%` procedure images_add_new(IN p_path_url varchar(255), IN p_description varchar(255),
                                                IN p_id_stay int)
BEGIN
    INSERT INTO images (path_url, description, id_stay)
    VALUES (p_path_url, p_description, p_id_stay);
END;

create
    definer = root@`%` procedure images_remove_one(IN p_id_image int, IN p_id_stay int)
BEGIN
	DELETE FROM images WHERE id_image = p_id_image AND id_stay = p_id_stay;
END;

create
    definer = root@`%` procedure stays_delete_by_id(IN p_id_stay int)
BEGIN
	DELETE FROM stays WHERE id_stay = p_id_stay;
END;

create
    definer = root@`%` procedure stays_insert_new(IN p_id_category int, IN p_titlename varchar(100),
                                                  IN p_city varchar(50), IN p_location_address varchar(100),
                                                  IN p_description varchar(255), IN p_price decimal(6, 2),
                                                  IN p_num_guests int, IN p_num_baths int, IN p_num_beds int,
                                                  IN p_num_bedrooms int, IN p_active int)
BEGIN
    INSERT INTO stays (
        id_category,
        titlename,
        city,
        location_address,
        description,
        price,
        num_guests,
        num_baths,
        num_beds,
        num_bedrooms,
        active
    )
    VALUES (
        p_id_categorie,
        p_titlename,
        p_city,
        p_location_address,
        p_description,
        p_price,
        p_num_guests,
        p_num_baths,
        p_num_beds,
        p_num_bedrooms,
        p_active
    );
END;

create
    definer = root@`%` procedure stays_update_by_id(IN p_id_stay int, IN p_id_category int, IN p_titlename varchar(100),
                                                    IN p_city varchar(50), IN p_location_address varchar(100),
                                                    IN p_description varchar(255), IN p_price decimal(6, 2),
                                                    IN p_active tinyint(1), IN p_num_guests int, IN p_num_baths int,
                                                    IN p_num_beds int, IN p_num_bedrooms int)
BEGIN
    UPDATE stays SET
    	id_category = p_id_category,
        titlename = p_titlename,
        city = p_city,
        location_address = p_location_address,
        description = p_description,
        price = p_price,
        active = p_active,
        num_guests = p_num_guests,
        num_baths = p_num_baths,
        num_beds = p_num_beds,
        num_bedrooms = p_num_bedrooms
    WHERE id_stay = p_id_stay;
END;

create
    definer = root@`%` procedure users_delete_by_dni(IN p_dni varchar(9))
BEGIN
    DECLARE v_id_user INT;

    SELECT id_user INTO v_id_user
    FROM users
    WHERE dni = p_dni;

    IF v_id_user IS NOT NULL THEN
	    DELETE FROM clients WHERE id_user = v_id_user;
	    DELETE FROM admins WHERE id_user = v_id_user;
	    DELETE FROM users WHERE id_user = v_id_user;
	END IF;
END;

create
    definer = root@`%` procedure users_insert_admin(IN p_dni varchar(9), IN p_name varchar(50),
                                                    IN p_surname varchar(50), IN p_email varchar(50),
                                                    IN p_phone varchar(10), IN p_username varchar(50),
                                                    IN p_password varchar(255), IN p_perm_level int)
BEGIN
	DECLARE last_id INT;

    INSERT INTO users (dni, name, surname, email, phone, username, password)
    VALUES (p_dni, p_name, p_surname, p_email, p_phone, p_username, p_password);

    SET last_id = LAST_INSERT_ID();

    INSERT INTO admins (id_user, perm_level)
    VALUES (p_id_user, p_perm_level);
END;

create
    definer = root@`%` procedure users_insert_client(IN p_dni varchar(20), IN p_name varchar(100),
                                                     IN p_surname varchar(100), IN p_email varchar(100),
                                                     IN p_phone varchar(20), IN p_username varchar(50),
                                                     IN p_password varchar(255), IN p_address varchar(255),
                                                     IN p_birth_date date)
BEGIN
    DECLARE last_id INT;

    INSERT INTO users (dni, name, surname, email, phone, username, password)
    VALUES (p_dni, p_name, p_surname, p_email, p_phone, p_username, p_password);

    SET last_id = LAST_INSERT_ID();

    INSERT INTO clients (id_user, address, birth_date)
    VALUES (last_id, p_address, p_birth_date);
END;

create
    definer = root@`%` procedure users_update_password(IN p_dni varchar(9), IN p_new_password varchar(255))
BEGIN
    UPDATE users SET password = p_new_password WHERE dni = p_dni;
END;