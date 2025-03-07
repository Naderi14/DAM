///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/																														  /
/													Ejercicios 501 - 510												  /
/																														  /
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
==============================================================================================================================
EJERCICIO 501 
"Muestra el id y dirección de todas las propiedades cuyo precio sea superior al precio
medio de todas las propiedades"

SELECT p.id , p.direccion
FROM propiedades p 
WHERE p.precio > (SELECT avg(p2.precio) FROM propiedades p2);

==============================================================================================================================
EJERCICIO 502 
"Muestra el nombre y email de los clientes que han comprado al menos una propiedad"

SELECT DISTINCT c.nombre , c.email
FROM clientes c 
WHERE c.id = (SELECT t.cliente_id FROM transacciones WHERE t.tipo = 'Compra');

==============================================================================================================================
EJERCICIO 503 
"Muestra los nombre y correo electrónicos de los agentes que han gestionado más de
una transacción"

SELECT a.nombre , a.email 
FROM agentes a
WHERE a.id = (SELECT t.agente_id FROM transacciones t GROUP BY t.agente_id HAVING count(t.id) > 1);

==============================================================================================================================
EJERCICIO 504 
"Muestra el id todas las propiedades que aún no han sido vendidas ni alquiladas"

SELECT p.id 
FROM propiedades p
WHERE p.estado != 'Venta' AND p.estado != 'Alquiler';

==============================================================================================================================
EJERCICIO 505 
"Muestra el nombre del cliente que ha realizado más alquileres"

-- SOLUCION 1
SELECT c.nombre 
FROM clientes c , transacciones t
WHERE c.id = t.cliente_id AND t.tipo = 'Alquiler'
GROUP BY c.id
ORDER BY count(t.id) DESC 
LIMIT 1;

-- SOLUCION 2
SELECT c.nombre
FROM clientes c
WHERE c.id = (SELECT t.cliente_id FROM transacciones t WHERE t.tipo = 'Alquiler'
		GROUP BY t.cliente_id ORDER BY count(t.id) DESC LIMIT 1
	);

==============================================================================================================================
EJERCICIO 506 
"Muestra las direcciones de las propiedades de tipo "Casa" cuyo precio es mayor que
la propiedad más cara del tipo "Piso""

SELECT p.direccion 
FROM propiedades p 
WHERE p.tipo = 'Casa' AND p.precio > (SELECT max(p2.precio) FROM propiedades p2 WHERE p2.tipo = 'Piso');

==============================================================================================================================
EJERCICIO 507 
"Muestra los nombres de los clientes que han realizado transacciones después del 1
de enero de 2023"

SELECT c.nombre 
FROM clientes c, transacciones t
WHERE c.id = t.cliente_id AND t.fecha > '2023-01-01';

==============================================================================================================================
EJERCICIO 508 
"Encuentra la dirección de la propiedad más cara comprada por el cliente que ha
gastado más dinero en total en compras"

SELECT p.direccion 
FROM propiedades p, transacciones t
WHERE p.id = t.propiedad_id AND t.cliente_id = (
			SELECT t.cliente_id
			FROM transacciones t, propiedades p 
			WHERE t.propiedad_id = p.id
			GROUP BY t.cliente_id
			ORDER BY sum(p.precio) DESC
			LIMIT 1
		)
ORDER BY p.precio DESC
LIMIT 1;

==============================================================================================================================
EJERCICIO 509 
"Encuentra las direcciones de las propiedades cuyo precio es mayor que el promedio
de compras del cliente que ha gastado menos dinero en total."

SELECT p2.direccion 
FROM (SELECT t2.cliente_id
			FROM transacciones t2, propiedades p2 
			WHERE t2.propiedad_id = p2.id
			GROUP BY t2.cliente_id
			ORDER BY sum(p2.precio) ASC
			LIMIT 1) clmin, propiedades p, propiedades p2, transacciones t
WHERE t.cliente_id = clmin.cliente_id AND p.id = t.propiedad_id AND p2.id = t.propiedad_id
GROUP BY p2.direccion, p2.precio
HAVING p2.precio >= avg(p.precio);

==============================================================================================================================
EJERCICIO 510 
"Encuentra la dirección de la propiedad más cara alquilada por el cliente que ha
realizado la mayor cantidad de alquileres"

SELECT p2.direccion 
FROM (SELECT t2.cliente_id
			FROM transacciones t2, propiedades p2 
			WHERE t2.propiedad_id = p2.id AND p2.estado = 'Alquiler'
			GROUP BY t2.cliente_id
			ORDER BY count(p2.precio) DESC
			LIMIT 1) clmax, propiedades p, propiedades p2, transacciones t
WHERE t.cliente_id = clmax.cliente_id AND t.tipo = 'Alquiler' AND p.id = t.propiedad_id AND p2.id = t.propiedad_id
GROUP BY p2.direccion, p2.precio
HAVING p2.precio = max(p.precio);