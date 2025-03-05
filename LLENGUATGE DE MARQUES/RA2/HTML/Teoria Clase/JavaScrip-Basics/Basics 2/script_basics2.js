// EXERCICIS del 1 - 17
// descomentar per executar el codi;

console.log("Ejercicio 1: " + max(5, 9))
console.log("Ejercicio 2: " + c2f(30))
console.log("Ejercicio 3: " + moreThan10("Esto es"))
console.log("Ejercicio 4: " + numberType(-9))
console.log("Ejercicio 5: " + areaSquare(5, 9))
console.log("Ejercicio 6: " + evenOdd(5))
console.log("Ejercicio 7: " + isPalindrome("Eve"))
console.log("Ejercicio 8: " + divisibleBy3(9))
console.log("Ejercicio 9: " + areaCircle(5))
console.log("Ejercicio 10: " + convert2Euros(14) + "€")
console.log("Ejercicio 11: " + discount(50, 22) + "€")
console.log("Ejercicio 12: " + distance(20, 5) + " kilometros")
console.log("Ejercicio 13: " + km2Miles(10) + " millas")
console.log("Ejercicio 14: " + priceDiscount(50, "VIP") + "€")
console.log("Ejercicio 15: " + travelPrice(11) + "€")
console.log("Ejercicio 16: " + deliverTime("internacional"))
console.log("Ejercicio 17: " + fee(5) + "€")

/*1. Mayor
Escribe una función que determine el mayor de 2 números. Utilitza un condicional.*/
function max(a, b)
{
    return a > b ? a : b;
}

/*2. Convertir Temperatura
Escribe una función que convierta la temperatura de Celsius a Fahrenheit.*/
function c2f(c)
{
    return (9 / 5) * c + 32; 
}

/*3. Longitud de una palabra
Escribe una función que compruebe si una palabra tiene más de 10 letras. Utiliza la propiedad lenght.*/
function moreThan10(word)
{
    return word.length > 10 ? "Es mayor de 10" : "Es menor o igual a 10";
}

/*4. Tipo de número
Escribe una función que compruebe si el número es positivo, negativo o zero.*/
function numberType(num)
{
    if (num > 0) return "Positivo";
    else if (num < 0) return "Negativo";
    else return "Zero"; 
}

/*5. Área de un rectángulo
Escribe una función que calcule el área de un rectángulo.*/
function areaSquare(base, height)
{
    return "Área rectángulo: " + (base * height);
}

/*6. Par o impar
Escribe una función que compruebe si el número es par o impar. Si es par, devuelve la palabra 'even', si es impar
devuelve la palabra 'odd'. Utiliza el módulo de 2 para saber si es par o impar.*/
function evenOdd(num)
{
    return num % 2 == 0 ? "even" : "odd";
}

/*7. Palíndromo
Escribe una función que verifique si una palabra es un palíndromo ignorando mayúsculas y minúsculas. Utiliza los
métodes de string.*/
function isPalindrome(word)
{
    return word.toLowerCase().split("").reverse().join("") == word.toLowerCase();
}

/*8. Divisible por 3
Escribe una función que compruebe si un número es divisible por 3.*/
function divisibleBy3(num)
{
    return num % 3 == 0;
}

/*9. Área de un círculo
Escribe una función que calcule el área de un círculo.*/
function areaCircle(radius)
{
    return Math.round(Math.PI * Math.pow(radius, 2) * 100) / 100;
}

/*10. Convertir de dólares a euros
Escribe una función que convierta de dólares a euros, sabiendo que un 1 $ = 0.85 €.*/
function convert2Euros(dollars)
{
    return Math.round((dollars * 0.85) * 100) / 100;
}

/*11. Calcular descuento
Escribe una función que calcule el precio con descuento.*/
function discount(price, percent)
{
    return Math.round((price * (1 - (percent / 100))) * 100) / 100;
}

/*12. Calcular distancia recorrida
Escribe una función que calcule la distancia recorrida sabiendo la velocidad (km / horas) i el tiempo (en horas). La
fórmula de la velocidad es la siguiente:*/
function distance(speed, time)
{
    return Math.round((speed * time) * 100) / 100;
}

/*13. Convertir a millas
Escribe una función que convierta la distancia de kilómetros a millas. 1 kilómetro = 0.621371 millas.*/
function km2Miles(km)
{
    return Math.round((km * 0.621371) * 100) / 100;
}

/*
14. Descuento según el cliente
Escribe una función que calcule un descuento dependiendo del tipo de cliente.
Si el cliente (variable client) es "VIP" el descuento es del 20%, si es "Regular" el descuento es del 10%, cualquier otro
tipo de cliente, el descuento es del 0%.*/
function priceDiscount(price, client)
{
    if (client == "VIP") return discount(price, 20);
    else if (client == "Regular") return discount(price, 10);
    else return price;
}

/*15. Precio del viaje
Escribe una función que calcule el precio del viaje dependiendo de la hora del dia.
Si la hora es de las 6 a las 12 (no inclusivo), el precio es de 10 €.
Si la hora es de las 12 a las 18 (no inclusivo), el precio es de 15 €.
Si no, el precio es de 20 €.*/
function travelPrice(hour)
{
    if (hour >= 6 && hour < 12) return 10;
    else if (hour >= 12 && hour < 18) return 15;
    else return 20;
}

/*16. Tiempo de entrega
Escribe una función que calcule el tiempo de entrega dependiendo del tipo de destino.
Si el destino es "local", el tiempo es de 1 dia.
Si el destino es "nacional", el tiempo es de 3 dias.
Si el destino es "internacional", el tiempo es de 7 dias.*/
function deliverTime(destination)
{
    if (destination == "local") return 1;
    else if (destination == "nacional") return 3;
    else if (destination == "internacional") return 7;
    else return "Error, destination not found";
}

/*17. Tiempo de uso
Escribe una función que calcule el precio de una tarifa dependiendo de su uso.
Si el uso es de 1 hora o menos, el precio es de 10.
Si el uso es de más de 1 hora o menos o igual a 5 horas, el precio es de 20.
Sino, el precio es de 30.*/
function fee(hours)
{
    if (hours <= 1) return 10;
    else if (hours > 1 && hours <= 5) return 20;
    else return 30;
}