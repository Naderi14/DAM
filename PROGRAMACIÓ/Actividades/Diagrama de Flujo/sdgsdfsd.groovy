Algoritmo NumeroMayor
	Definir numero1, numero2, numero3 tipo enteros;
	Escribir "Introduce el número 1";
	Leer numero1;
	Escribir "Introduce el número 2";
	Leer numero2;
	Escribir "Introduce el número 3";
	Leer numero3;
	Si numero1 > numero2 Y numero1 > numero3 entonces;
			Escribir numero1, "es el mayor";
	Sino;
		Si numero2 > numero3 entonces;
			Escribir numero2, "es el mayor";
		Sino;
			Escribir numero3, "es el mayor";
		FinSi;
	FinSi;
FinAlgoritmo

Algoritmo OperarNumeros
	Definir numero1, numero2, suma, resta, producto tipo entero;
	Definir division tipo real;
	Escribir "Introduce numero1";
	Leer numero1;
	Escribir "Introduce numero2";
	Leer numero2;
	suma = numero1 + numero2;
	resta = numero1 - numero2;
	producto = numero1 * numero2;
	Si numero2 == 0 entonces;
		Escribir "No se puede realizar la división por 0";
		division = 0;
	Sino;
		division = numero1 / numero2;
	FinSi;
	Escribir "Suma:",suma,"Resta:",resta,"Producto:",producto,"Division:",division;
FinAlgoritmo




