-- EJERCICIO 301
SELECT apellido, puesto_trabajo FROM empleados
INTERSECT
SELECT apellido, puesto_trabajo FROM empleados 
WHERE puesto_trabajo != 'Sales Representative';

-- EJERCICIO 302
SELECT u.PAIS_ID 
FROM ubicaciones u, almacenes a 
WHERE u.UBICACION_ID = a.UBICACION_ID;

-- EJERCICIO 303
SELECT apellido, puesto_trabajo, 
	CASE 
		WHEN puesto_trabajo = 'Programmer' THEN 'X'
		WHEN puesto_trabajo = 'Accountant' THEN 'Y'
		WHEN puesto_trabajo = 'Stock Manager' THEN 'Z'
	END AS "Letra"
FROM empleados
UNION
SELECT APELLIDO, PUESTO_TRABAJO, 
	CASE 
		WHEN puesto_trabajo = 'Programmer' THEN 'X'
		WHEN puesto_trabajo = 'Accountant' THEN 'Y'
		WHEN puesto_trabajo = 'Stock Manager' THEN 'Z'
	END AS "Letra"
FROM empleados;

-- EJERCICIO 304
SELECT EMPLEADO_ID, PUESTO_TRABAJO 
FROM empleados 
WHERE PUESTO_TRABAJO = 'Sales Representative'
INTERSECT 
SELECT EMPLEADO_ID, PUESTO_TRABAJO
FROM empleados
WHERE APELLIDO LIKE 'B%';

-- EJERCICIO 305
SELECT	c.NOMBRE, c.WEB, NULL AS TELEFONO
FROM clientes c
WHERE NOMBRE LIKE 'B%'
UNION
SELECT co.NOMBRE, NULL AS WEB, co.TELEFONO
FROM contactos co
WHERE TELEFONO LIKE '%0';

-- EJERCICIO 306
SELECT puesto_trabajo AS "Puesto", fecha_contrato AS "Fecha Contrato"
FROM empleados
WHERE fecha_contrato BETWEEN '2016-01-01' AND '2016-02-29'
UNION
SELECT puesto_trabajo AS "Puesto", fecha_contrato AS "Fecha Contrato"
FROM empleados
WHERE fecha_contrato BETWEEN '2016-03-01' AND '2016-08-25';


-- EJERCICIO 307	
SELECT CONCAT(INCREMENT * 100, '%'), EMPLEADO_ID, SUELDO * INCREMENT
FROM (
    SELECT EMPLEADO_ID, SUELDO,
        CASE
            WHEN PUESTO_TRABAJO IN ('Sales Representative', 'Shipping Clerk', 'Stock Clerk') THEN 0.05
            WHEN PUESTO_TRABAJO = 'Programmer' THEN 0.1
            WHEN PUESTO_TRABAJO IN ('Administration Vice President', 'Sales Manager') THEN 0.15
            ELSE 0
        END INCREMENT
    FROM empleados
) INCREMENTS
ORDER BY increment;
	