/*Crea un algoritmo en pseudocódigo que al introducir una cantidad de dinero expresado en
euros nos indique cuántos billetes y monedas se puede tener como mínimo.*/

Algoritmo ContadorBilletesMonedasEficiente
	Definir cantDinero tipo Real;
	Definir cantDivisaEfectivo tipo Entero;

	Escribir "Introduzca la cantidad de dinero a retirar.";
	Leer cantDinero;

	cantDivisaEfectivo = cantDinero / 200;
	Escribir "Billetes de 200€: ",cantDivisaEfectivo;
	cantDinero %= 200;

	cantDivisaEfectivo = cantDinero / 100;
	Escribir "Billetes de 100€: ",cantDivisaEfectivo;
	cantDinero %= 100;

	cantDivisaEfectivo = cantDinero / 50;
	Escribir "Billetes de 50€: ",cantDivisaEfectivo;
  	cantDinero %= 50;

	cantDivisaEfectivo = cantDinero / 20;
  	Escribir "Billetes de 20€: ",cantDivisaEfectivo;
  	cantDinero %= 20;

	cantDivisaEfectivo = cantDinero / 10;
  	Escribir "Billetes de 10€: ",cantDivisaEfectivo;
  	cantDinero %= 10;

	cantDivisaEfectivo = cantDinero / 5;
  	Escribir "Billetes de 5€: ",cantDivisaEfectivo;
  	cantDinero %= 5;

	cantDivisaEfectivo = cantDinero / 2;
	Escribir "Monedas de 2€: ",cantDivisaEfectivo;
	cantDinero %= 2;

	cantDivisaEfectivo = cantDinero / 1;
	Escribir "Monedas de 1€: ",cantDivisaEfectivo;
	cantDinero %= 1;

	cantDivisaEfectivo = cantDinero / 0.5;
	Escribir "Monedas de 0.5€: ",cantDivisaEfectivo;
	cantDinero %= 0.5;

	cantDivisaEfectivo = cantDinero / 0.2;
	Escribir "Monedas de 0.2€: ",cantDivisaEfectivo;
	cantDinero %= 0.02;

	cantDivisaEfectivo = cantDinero / 0.1;
	Escribir "Monedas de 0.1€: ",cantDivisaEfectivo;
	cantDinero %= 0.1;

	cantDivisaEfectivo = cantDinero / 0.05;
	Escribir "Monedas de 0.05€: ",cantDivisaEfectivo;
	cantDinero %= 0.05;

	cantDivisaEfectivo = cantDinero / 0.02;
	Escribir "Monedas de 0.02€: ",cantDivisaEfectivo;
	cantDinero %= 0.02;

	cantDivisaEfectivo = cantDinero / 0.01;
	Escribir "Monedas de 0.01€: ",cantDivisaEfectivo;
FinAlgoritmo

Algoritmo ContadorBilletesMonedasConBucles
	Definir cantDinero tipo Real;
	Definir billete5, billete10, billete20, billete50, billete100, billete200,
	moneda001, moneda002, moneda005, moneda010, moneda020, moneda050, moneda1, moneda2 tipo Entero;

	billete5, billete10, billete20, billete50, billete100, moneda001, moneda002, 
	moneda005, moneda010, moneda020, moneda050, moneda1, moneda2 = 0

	Escribir "Introduzca la cantidad de dinero a retirar.";
	Leer cantDinero;

	// Billetes 200€
	While cantDinero >= 200 hacer;
		billete200++;
		cantDinero -= 200;
	FinWhile;

	// Billetes 100€
	Si cantDinero >= 100 entonces;
		billete100++;
		cantDinero -= 100;
	FinSi;

	// Billetes 50€
	Si cantDinero >= 50 entonces;
		billete50++;
		cantDinero -= 50;
	FinSi;

	// Billetes 20€
	While cantDinero >= 20 hacer;
		billete20++;
		cantDinero -= 20;
	FinWhile;

	// Billetes 10€
	Si cantDinero >= 10 entonces;
		billete10++;
		cantDinero -= 10;
	FinSi;

	// Billetes 5€
	Si cantDinero >= 5 entonces;
		billete5++;
		cantDinero -= 5;
	FinSi;

	// Monedas 2€
	While cantDinero >= 2 hacer;
		moneda2++;
		cantDinero -= 2;
	FinWhile;

	// Monedas 1€
	Si cantDinero >= 1 entonces;
		moneda1++;
		cantDinero -= 1;
	FinSi;

	// Monedas 0.5€
	Si cantDinero >= 0.5 entonces;
		moneda050++;
		cantDinero -= 0.5;
	FinSi;

	// Monedas 0.2€
	While cantDinero >= 0.2 hacer;
		moneda020++;
		cantDinero -= 0.2;
	FinWhile;

	// Monedas 0.1€
	Si cantDinero >= 0.1 entonces;
		moneda010++;
		cantDinero -= 0.1;
	FinSi;

	// Monedas 0.05€
	Si cantDinero >= 0.05 entonces;
		moneda005++;
		cantDinero -= 0.05;
	FinSi;

	// Monedas 0.02€
	While cantDinero >= 0.02 hacer;
		moneda002++;
		cantDinero -= 0.02;
	FinWhile;

	// Monedas 0.01€
	Si cantDinero != 0 entonces;
		moneda001++;
		cantDinero -= 0.01;
	FinSi;

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