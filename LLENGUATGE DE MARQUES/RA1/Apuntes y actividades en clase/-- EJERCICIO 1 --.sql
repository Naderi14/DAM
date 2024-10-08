-- EJERCICIO 1 --
SELECT phone
FROM customers
WHERE salesRepEmployeeNumber <> 5;

-- EJERCICIO 2 --
SELECT AVG(quantityOrdered)
FROM orderdetails;

-- EJERCICIO 3 --
SELECT *
FROM payments
WHERE paymentDate BETWEEN '2024-01-01' AND '2024-12-31'
ORDER BY paymentDate ASC;

-- EJERCICIO 4 --
SELECT COUNT(*)
FROM customers
WHERE state IS NOT NULL;

SELECT COUNT(state) 
FROM customers;

-- EJERCICIO 5 --
SELECT COUNT(status)
FROM orders
WHERE status != 'Cancelled'
GROUP BY status
HAVING COUNT(status) < 2;

-- EJERCICIO 6 --
SELECT CONCAT(firstName,' ',lastName) AS full_name
FROM employees;

-- EJERCICIO 7 --
SELECT SUM(amount)
FROM payments;

-- EJERCICIO 8 --
SELECT buyPrice * quantityInStock AS SUM(totalValue)
FROM products;

-- EJERCICIO 9 --
SELECT orderNumber, priceEach * quantityOrdered AS totalCost
FROM orderdetails;

-- EJERCICIO 10 --
SELECT *
FROM employees
WHERE email NOT LIKE '%_@__%.__%';