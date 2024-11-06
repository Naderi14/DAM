package juanFranciscoSanchezCastelblanque_DAMPR1;

import java.util.Scanner;

/*Realiza un programa en Java donde se le presente al usuario un menú de la siguiente manera:

->1. Calcula descuento
2. Suma.
3. Salir del programa

A continuación, se explica qué debe hacer cada opción del menú:

Opción 1.
Una tienda ofrece un descuento del 15% sobre el total de la compra durante el mes de octubre. 
Dado un mes y un importe, calcula cuál es la cantidad que se debe cobrar al cliente.

Opción 2.
El usuario obtendrá la suma de 2 valores enteros. Los valores sumados serán valores 
mayores que 0 y menores que 10. El usuario verá esto:

Opción 3
Solo cuando el usuario introduzca un 3, finalizará el programa con el siguiente mensaje:

Fin del programa. Examen realizado por NOMBRE APELLIDOS. 6 de Noviembre de 2024.

*/

public class EjercicioExamen {
	private static Scanner leer = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		System.out.println("<- Bienvenido al programa! ->\n----------------------------"
				+ "\n1. Calcular descuento\n2. Sumar\n3. Salir\n"
				+ "----------------------------\n"
				+ "  (Introduzca una opción)");
		
		int opcion = leer.nextInt();
		
		switch(opcion)
		{
			case 1:
				String mesCompra;
				double importeTotal;
				final double descuento = 0.85;
				
				System.out.println("_________________________\n"
						+ "<- Introduce el més de la compra ->");
				mesCompra = leer.next();
				System.out.println("<- Introduce el importe total ->");
				importeTotal = leer.nextDouble();
				
				if (mesCompra.equals("octubre") || mesCompra.equals("Octubre") || mesCompra.equals("10"))
				{
					System.out.println("El descuento aplicado del 15% de Octubre es de: " + (importeTotal * descuento) + "€");
				}
				else
				{
					System.out.println("El mes " + mesCompra + " no tiene descuento, el importe es: " + importeTotal + "€");
				}
				break;
			case 2:
				System.out.println("<- Introduce el número 1 ->");
				int numero1 = leer.nextInt();
				if (numero1 < 0 || numero1 >= 10)
				{
					System.out.println("El número ha de ser mayor que 0 y menor que 10");
					break;
				}
				System.out.println("<- Introduce el número 2 ->");
				
				int numero2 = leer.nextInt();
				if (numero2 < 0 || numero2 >= 10)
				{
					System.out.println("El número ha de ser mayor que 0 y menor que 10");
					break;
				}
				
				System.out.println(numero1 + " + " + numero2 + " = " + (numero1 + numero2));
				break;
			case 3:
				System.out.println("Fin del programa. Examen realizado por Juan Francisco Sanchez Castelblanque. 6 de Noviembre de 2024.");
				break;
			default:
				System.out.println("<!- La opción introducida no es válida -!>");
				break;
		}
	}
}
