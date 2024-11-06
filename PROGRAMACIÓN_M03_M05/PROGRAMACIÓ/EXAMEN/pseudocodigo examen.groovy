/*Pide un número entero a un usuario y dime si los dígitos de ese número son pares o impares.
Ejemplo:
-> Dame un número entero:
-> 345
-> El 5 es impar;
    El 4 es par;                 
    El 3 es impar;*/

Algoritmo ParImpar
	Definir numero, checkNumero tipo Entero;
	Escribir "Introduce un número";
	Leer numero;

	Si numero > 0 entonces;
		Mientras numero > 0;
			checkNumero = numero % 10;

			Si checkNumero % 2 == 0 entonces;
				Escribir "El número",checkNumero,"es PAR\n";
			Sino;
				Escribir "El número",checkNumero,"es IMPAR\n";
			FinSi;

			numero /= 10;
		FinMientras;
	Sino;
		Escribir "El número introducido debe ser mayor a 0";
	FinSi;
FinAlgoritmo