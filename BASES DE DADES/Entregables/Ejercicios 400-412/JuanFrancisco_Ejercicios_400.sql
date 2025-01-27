/* EJERCICIO 401
 * "Muestre el sueldo más alto, el más bajo, la suma y la media de todos los
sueldos para todos los empleados. Redondee los resultados hasta el número entero
más cercano."*/

SELECT max(SUELDO) AS "Sueldo Máximo", min(SUELDO) AS "Sueldo Mínimo", round(avg(SUELDO), 0) AS "Media Sueldos"  
FROM empleados;

/*EJERCICIO 402
"Muestra los puestos de trabajo que hay en la empresa (sin que se repitan).
Ordena el resultado por orden alfabético."*/

SELECT DISTINCT PUESTO_TRABAJO 
FROM empleados
ORDER BY PUESTO_TRABAJO ASC;

/*EJERCICIO 403
"Muestra cuantos puestos de trabajo hay con el siguiente formato: "Hay 19
puestos de trabajo.""*/

SELECT concat('Hay ', count(DISTINCT PUESTO_TRABAJO), ' puestos de trabajo.') AS "Cantidad"
FROM empleados;

/*EJERCICIO 404
"Modifique la consulta del ejercicio 401 para mostrar el puesto de trabajo, el
máximo, sueldo mínimo, la suma y el sueldo medio para cada puesto de trabajo,
ordena el resultado por la columna del sueldo máximo descendientemente."*/

SELECT PUESTO_TRABAJO ,max(SUELDO) AS "Sueldo Máximo", min(SUELDO) AS "Sueldo Mínimo", round(avg(SUELDO), 0) AS "Media Sueldos"  
FROM empleados
GROUP BY PUESTO_TRABAJO;

/*EJERCICIO 405
"Escriba una consulta para mostrar el puesto de trabajo y el número de
personas en ese puesto."*/

SELECT PUESTO_TRABAJO, count(EMPLEADO_ID) AS "Número Empleados"
FROM empleados
GROUP BY PUESTO_TRABAJO;

/*EJERCICIO 406
"Modifique la consulta del ejercicio anterior para filtrar los datos y que
aparezcan únicamente los puestos de trabajo que contengan la letra p, tanto
mayúsculas como minúsculas."*/

SELECT PUESTO_TRABAJO, count(EMPLEADO_ID) AS "Número Empleados"
FROM empleados
GROUP BY PUESTO_TRABAJO
HAVING PUESTO_TRABAJO LIKE '%p%';

/*EJERCICIO 407
"Determine el número jefes. Etiquete la columna "Numero de jefes". Utilice la
columna jefe_id para determinar el número de jefes que hay en la empresa."*/

SELECT count(DISTINCT JEFE_ID) AS "Número de jefes"
FROM empleados;

/*EJERCICIO 408
"Escriba una consulta para visualizar la diferencia entre el mayor y menor
sueldo de los los empleados. Etiquete la columna como "Diferencia"."*/

SELECT max(SUELDO) - min(SUELDO) AS "Diferencia" 
FROM empleados;

/*EJERCICIO 409
"Muestre el número de jefe y el sueldo de su empleado peor pagado para ese
jefe. Excluya los empleados de los que no tengan jefe. Excluya los grupos de trabajo
en los que el del empleado peor pagado sea 6000€ o menos. Ordene el resultado por
sueldo en orden descendente."*/

SELECT JEFE_ID, min(SUELDO) AS "Peor Sueldo"
FROM empleados
WHERE JEFE_ID IS NOT NULL
GROUP BY JEFE_ID 
HAVING min(SUELDO) > 6000
ORDER BY SUELDO;

/*EJERCICIO 410
"Escriba una consulta para mostrar identificador del pedido, así como
identificador del producto (sin que se repita), el número de veces que el producto
aparece en el pedido y la cantidad total del producto en el pedido. Selecciona
únicamente los pedidos 13 y 58, ordena el resultado por pedido_id y producto_id."*/

SELECT PEDIDO_ID, PRODUCTO_ID, count(PRODUCTO_ID) AS "Cantidad Producto", CANTIDAD
FROM pedido_articulos
WHERE PEDIDO_ID = 13 OR PEDIDO_ID = 58
GROUP BY PRODUCTO_ID 
ORDER BY PEDIDO_ID, PRODUCTO_ID;

/*EJERCICIO 411
"Cree una consulta que muestre el número total de empleados y, de ese total,
el número de empleados contratados en enero, febrero y marzo (poner alias).
Ejemplo:
	TOTAL 	   Enero 	Febrero 	Marzo
---------- ---------- ---------- ----------2016-08-25
	107 		14 		  13 		17"*/

SELECT count(*) AS "Número Empleados", 
	(SELECT count(*) FROM empleados WHERE FECHA_CONTRATO LIKE '____-01-%') AS "Enero",
	(SELECT count(*) FROM empleados WHERE FECHA_CONTRATO LIKE '____-02-%') AS "Febrero",
	(SELECT count(*) FROM empleados WHERE FECHA_CONTRATO LIKE '____-03-%') AS "Marzo" 
FROM empleados;

/*EJERCICIO 412
"Cree una consulta para visualizar el puesto de trabajo, el total de empleados
de cada puesto, la cantidad de jefes de cada puesto y la cantidad de empleados que
ganan más de 7000€ de cada puesto de trabajo.
Ejemplo:
	PUESTO 					TOTAL 		JEFES 		7000
------------------------ -----------   ------      ------- 
Administration Assistant     1            1           0
Sales Representative        30            5           22
Stock Clerk                 20            5           0
Programmer                  5             2           1"*/

SELECT PUESTO_TRABAJO, count(*) AS "Cantidad empleados", count(DISTINCT JEFE_ID) AS "Jefes",
	count(CASE WHEN SUELDO > 7000 THEN 1 END) AS "Cantidad empleados mas de 7000€"
FROM empleados
GROUP BY PUESTO_TRABAJO;
