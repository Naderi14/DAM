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

	Si numero1 > numero2 entonces;
		Escribir "El ",numero1," es mayor que ",numero2;
	Sino;
		Si numero1 == numero2 entonces;
			Escribir "Ambos números son iguales";
		Sino;
			Escribir "El ",numero2," es mayor que ",numero1;
		FinSi;
	FinSi;
FinAlgoritmo

//3. Leer 2 números distintos y mostrar la división del mayor entre el menor.
Algoritmo OperarNumeros
	Definir numero1, numero2, menor, mayor tipo Entero;
	Definir division tipo Real;
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
		Si nota < 3 entonces;
			Escribir "Muy deficiente";
		FinSi;
		Si nota < 5 entonces;
			Escribir "Insuficiente";
		FinSi;
		Si nota < 6 entonces;
			Escribir "Bien";
		FinSi;
		Si nota < 9 entonces;
			Escribir "Notable";
		FinSi;
		Si nota > 9 entonces;
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

Algoritmo Bucles
	Definir numero, i tipo Entero;
	Leer numero;
	Escribir "Bucle While";
	While numero < 20;
	    Escribir numero;
	    numero = numero + 1;
	FinWhile;
	Escribir "Bucle FOR";
	For i = 0 hasta 20;
	    Display i;
	FinFor;
FinAlgoritmo

Algoritmo HastaDecir0
	Definir numero tipo Entero;
	Escribir "Dame un número";
	Leer numero;
	While numero != 0 hacer;
		Escribir "De nuevo un número";
		Leer numero;
	FinWhile;
FinAlgoritmo

Crea un algoritmo en pseudocódigo que al introducir una cantidad de dinero expresado en
euros nos indique cuántos billetes y monedas se puede tener como mínimo.

Algoritmo ContadorBilletesMonedas
	Definir cantDinero tipo Real;
	Definir billete5, billete10, billete20, billete50, billete100, billete200,
	moneda001, moneda002, moneda005, moneda010, moneda020, moneda050, moneda1, moneda2 tipo Entero;

	billete5, billete10, billete20, billete50, billete100, moneda001, moneda002, 
	moneda005, moneda010, moneda020, moneda050, moneda1, moneda2 = 0

	Escribir "Dime la cantidad de dinero que tienes y te la devolveré en efectivo";
	Leer cantDinero;

	// Billetes 200€
	While cantDinero > 200 hacer;
		billete200++;
		cantDinero -= 200;
	FinWhile;

	// Billetes 100€
	While cantDinero > 100 hacer;
		billete100++;
		cantDinero -= 100;
	FinWhile;

	// Billetes 50€
	While cantDinero > 50 hacer;
		billete50++;
		cantDinero -= 50;
	FinWhile;

	// Billetes 20€
	While cantDinero > 20 hacer;
		billete20++;
		cantDinero -= 20;
	FinWhile;

	// Billetes 10€
	While cantDinero > 10 hacer;
		billete10++;
		cantDinero -= 10;
	FinWhile;

	// Billetes 5€
	While cantDinero > 5 hacer;
		billete5++;
		cantDinero -= 5;
	FinWhile;

	// Monedas 2€
	While cantDinero > 2 hacer;
		moneda2++;
		cantDinero -= 2;
	FinWhile;

	// Monedas 1€
	While cantDinero > 1 hacer;
		moneda1++;
		cantDinero -= 1;
	FinWhile;

	// Monedas 0.5€
	While cantDinero > 0.5 hacer;
		moneda050++;
		cantDinero -= 0.5;
	FinWhile;

	// Monedas 0.2€
	While cantDinero > 0.2 hacer;
		moneda020++;
		cantDinero -= 0.2;
	FinWhile;

	// Monedas 0.1€
	While cantDinero > 0.1 hacer;
		moneda010++;
		cantDinero -= 0.1;
	FinWhile;

	// Monedas 0.05€
	While cantDinero > 0.05 hacer;
		moneda005++;
		cantDinero -= 0.05;
	FinWhile;

	// Monedas 0.02€
	While cantDinero > 0.02 hacer;
		moneda002++;
		cantDinero -= 0.02;
	FinWhile;

	// Monedas 0.01€
	While cantDinero != 0 hacer;
		moneda001++;
		cantDinero -= 0.01;
	FinWhile;

	Escribir "Efecto total que dispondrás con tu dinero:";
	Escribir "Billetes 200€: ", billete200;
	Escribir "Billetes 100€: ", billete100;
	Escribir "Billetes 50€: ", billete50;
	Escribir "Billetes 20€: ", billete20;
	Escribir "Billetes 10€: ", billete10;
	Escribir "Billetes 5€: ", billete5;

	Escribir "Monedas 2€: ", moneda2;
	Escribir "Monedas 1€: ", moneda1;
	Escribir "Monedas 0.5€: ", moneda050;
	Escribir "Monedas 0.2€: ", moneda020;
	Escribir "Monedas 0.1€: ", moneda010;
	Escribir "Monedas 0.05€: ", moneda005;
	Escribir "Monedas 0.02€: ", moneda002;
	Escribir "Monedas 0.01€: ", moneda001;
FinAlgoritmo