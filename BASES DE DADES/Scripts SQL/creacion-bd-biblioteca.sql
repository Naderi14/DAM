-- 1️ Crear la base de datos
CREATE DATABASE biblioteca;
USE biblioteca;

-- 2️ Tabla de Usuarios
CREATE TABLE usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    fecha_registro DATE NOT NULL
);

-- 3 Tabla de Géneros de Libros
CREATE TABLE generos (
    id_genero INT AUTO_INCREMENT PRIMARY KEY,
    nombre_genero VARCHAR(100) UNIQUE NOT NULL
);

-- 4 Tabla de Libros
CREATE TABLE libros (
    id_libro INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    id_genero INT,
    FOREIGN KEY (id_genero) REFERENCES generos(id_genero) ON DELETE SET NULL
);

-- 5️ Tabla de Ejemplares (para registrar la cantidad de libros disponibles)
CREATE TABLE ejemplares (
    id_ejemplar INT AUTO_INCREMENT PRIMARY KEY,
    id_libro INT,
    cantidad_disponible INT NOT NULL CHECK (cantidad_disponible >= 0),
    FOREIGN KEY (id_libro) REFERENCES libros(id_libro) ON DELETE CASCADE
);

-- 6️ Tabla de Préstamos (Registro de préstamos de libros)
CREATE TABLE prestamos (
    id_prestamo INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    id_libro INT,
    fecha_prestamo DATE NOT NULL,
    fecha_devolucion DATE DEFAULT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario) ON DELETE CASCADE,
    FOREIGN KEY (id_libro) REFERENCES libros(id_libro) ON DELETE CASCADE
);



/* INSERCIÓN DE DATOS */
-- Insertar géneros
INSERT INTO generos (nombre_genero) VALUES 
('Novela'), 
('Historia'), 
('Ciencia Ficción'), 
('Poesía'), 
('Misterio');

-- Insertar libros
INSERT INTO libros (titulo, autor, id_genero) VALUES 
('Cien años de soledad', 'Gabriel García Márquez', 1),
('1984', 'George Orwell', 3),
('El código Da Vinci', 'Dan Brown', 5),
('Breve historia del tiempo', 'Stephen Hawking', NULL), 
('Los pilares de la Tierra', 'Ken Follett', 2);

-- Insertar ejemplares
INSERT INTO ejemplares (id_libro, cantidad_disponible) VALUES
(1, 5),
(2, 3),
(3, 1),
(4, 2),
(5, 4);

-- Insertar usuarios
INSERT INTO usuarios (nombre, email, fecha_registro) VALUES 
('Ana Pérez', 'ana@example.com', '2022-03-15'),
('Luis Gómez', 'luis@example.com', '2023-06-10'),
('Carlos Ruiz', 'carlos@example.com', '2021-11-30'),
('María López', 'maria@example.com', '2020-09-20');

-- Insertar préstamos
INSERT INTO prestamos (id_usuario, id_libro, fecha_prestamo, fecha_devolucion) VALUES 
(1, 1, '2023-12-20', NULL),  -- No devuelto
(2, 2, '2024-01-10', '2024-01-20'),  -- Devuelto
(3, 3, '2024-01-05', NULL),  -- No devuelto
(4, 5, '2023-12-28', '2024-01-15');  -- Devuelto
