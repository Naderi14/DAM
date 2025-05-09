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
	id_image INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
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