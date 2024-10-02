//Soluciones de Pseudocódigo 1.

//1. Calcular y mostrar el área de un cuadrado de lado igual a 7.
Algoritmo AreaCuadrado
	Definir lado, area tipo Entero;
	lado = 7;
	area = lado^2;
	Escribir "Área cuadrado: ",area;
FinAlgoritmo

//2. Pedir 2 números y mostrar el mayor, o si son iguales, en el caso de que lo sean.
Algoritmo NumMayorIgual
	Definir numero1, numero2 tipo Entero;
	Escribir "Introduce el numero1";
	Leer numero1;
	Escribir "Introduce el numero2";
	Leer numero2;
FinAlgoritmo

//3. Leer 2 números distintos y mostrar la división del mayor entre el menor.
Algoritmo OperarNumeros
	Definir numero1, numero2, menor, mayor tipo Entero;
	Definir division tipo real;
	Escribir "Introduce numero1";
	Leer numero1;
	Escribir "Introduce numero2";
	Leer numero2;

	Si numero1 > numero2 entonces;
		menor = numero2;
		mayor = numero1;
	Sino;
		menor = numero1;
		mayor = numero2;

	Si menor == 0 entonces;
		Escribir "No se puede realizar la división por 0";
	Sino;
		division = mayor / menor;
		Escribir "Resultado división: ",division;
FinAlgoritmo

/*4. Leer una calificación numérica entre 0 y 10 y transformarla en calificación alfabética,
escribiendo el resultado.
• de 0 a <3 Muy deficiente.
• de 3 a <5 Insuficiente.
• de 5 a <6 Bien.
• De 6 a <9 Notable.
• De 9 a 10 Sobresaliente.*/
Algoritmo CalificarNota
	Definir nota tipo Real;
	Escribir "Introduce la nota del alumno";
	Leer nota;

	Si nota < 0 OR nota > 10 entonces;
		Escribir "La nota no entra en el rango";
	Sino;
		Si nota >= 0 AND nota < 3 entonces;
			Escribir "Muy deficiente";
		FinSi;
		Si nota >= 3 AND nota < 5 entonces;
			Escribir "Insuficiente";
		FinSi;
		Si nota >= 5 AND nota < 6 entonces;
			Escribir "Bien";
		FinSi;
		Si nota >= 6 AND nota < 9 entonces;
			Escribir "Notable";
		FinSi;
		Si nota >= 9 entonces;
			Escribir "Sobresaliente";
		FinSi;
	FinSi;
FinAlgoritmo

//5. Se leerá una hora expresada en segundos y se debe mostrar en hora, minutos y segundos.
Algoritmo ConverterSegundosToTime
	Definir totalSegundos, segundos, minutos, horas tipo Entero;
	Escribir "Introduce el total de segundos a convertir";
	Leer totalSegundos;

	segundos = totalSegundos % 3600;
	horas = totalSegundos / 3600;
	minutos = segundos / 60;
	segundos = segundos % 60;

	Escribir "Horas: ",horas,"Minutos: ",minutos,"Segundos: ",segundos;
FinAlgoritmo

/*6. Una tienda ofrece un descuento del 15% sobre el total de la compra durante el mes
de octubre. Dado un mes y un importe, calcula cuál es la cantidad que se debe cobrar al
cliente.*/
Algoritmo AplicarDescuentoAvailable
	Definir totalCompra, precioFinal tipo Real;
	Definir numeroMes, descuento tipo Entero

	Escribir "Introduce el precio total de la compra";
	Leer totalCompra;
	Escribir "Introduce el mes cuando se realizó la compra";
	Leer numeroMes;

	Si numeroMes == 10 entonces;
		descuento = (totalCompra / 100) * 15;
		Escribir "Descontado del 15%: ",descuento;
	Sino;
		descuento = 0;
		Escribir "Al no ser Octubre, no hay descuento";
	FinSi;

	precioFinal = totalCompra - descuento;
	
	Escribir "Precio final: ",precioFinal;
FinAlgoritmo