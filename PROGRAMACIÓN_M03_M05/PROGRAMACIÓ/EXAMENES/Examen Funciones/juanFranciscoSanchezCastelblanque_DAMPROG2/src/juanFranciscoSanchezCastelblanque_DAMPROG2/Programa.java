package juanFranciscoSanchezCastelblanque_DAMPROG2;

import java.util.Scanner;

public class Programa {
	private static final Scanner scanner = new Scanner(System.in);
	
	// ====================================== MENUS PRINCIPALES ========================================= 
	
	public static void main(String[] args)
	{
		int opcion;
		
		System.out.println("/// Bienvenido al programa del exámen ///\n");
		
		do {
			System.out.println("<- Introduce la opción deseada ->\n"
					+ "1. Conversión a segundos\n"
					+ "2. Nota media\n"
					+ "3. Temperaturas\n"
					+ "4. Salir del programa");
			
			opcion = scanner.nextInt();
			menu(opcion);
		} while (opcion != 4);
	}
	
	private static void menu(int opcion)
	{
		switch (opcion)
		{
			case 1:
				convert2Seconds();
				break;
			case 2:
				System.out.println("<- Nota media total: " + notaMedia() + "\n");
				break;
			case 3:
				menuTemperatura();
				break;
			case 4:
				System.out.println("\nFin del programa. Examen realizado por Juan Francisco Sanchez Castelblanque. 22 de Noviembre de 2024.");
				break;
			default:
				System.out.println("<!- Opción incorrecta -!>");
				break;
		}
	}
	
	// ====================================== EJERCICIO 1 ========================================= 
	
	private static void convert2Seconds()
	{
		int days, hours, minutes, seconds;
		
		System.out.println("<- Introduce los dias: ");
		days = scanner.nextInt();
		System.out.println("<- Introduce las horas: ");
		hours = scanner.nextInt();
		System.out.println("<- Introduce los minutos: ");
		minutes = scanner.nextInt();
		System.out.println("<- Introduce los segundos: ");
		seconds = scanner.nextInt();
		
		System.out.println("Conversiones: \n"
				+ "dAS: " + dAS(days) + " segundos\n"
				+ "hAS: " + hAS(hours) + " segundos\n"
				+ "mAS: " + mAS(minutes) + " segundos\n"
				+ "msAS: " + msAS(minutes, seconds) + " segundos\n"
				+ "hmsAS: " + hmsAS(hours, minutes, seconds) + " segundos\n"
				+ "dhmsAS: " + dhmsAS(days, hours, minutes, seconds) + " segundos\n");
	}

	// REFACTOR

	private static long dAS(int days)
	{
		int hours = days * 24;
		return hAS(hours);
	}

	private static long hAS(int hours)
	{
		int minutes = hours * 60;
		return mAS(minutes);
	}

	private static long mAS(int minutes)
	{
		return minutes * 60;
	}

	private static long msAS(int minutes, int seconds)
	{
		return mAS(minutes) + seconds;
	}

	private static long hmsAS(int hours, int minutes, int seconds)
	{
		return hAS(hours) + mAS(minutes) + seconds;
	}

	private static long dhmsAS(int days, int hours, int minutes, int seconds)
	{
		return dAS(days) + hAS(hours) + mAS(minutes) + seconds;
	}
	
	// ====================================== EJERCICIO 2 ========================================= 
	
	private static double notaMedia()
	{
		System.out.println("<- Dame tu nota de Entornos, Sistemas Informáticos, Bases de datos, Lenguaje de marcas y Programación: ->");
		
		double sumaNotas = 0;
		
		for (int i = 1; i <= 5; i++)
		{
			System.out.println("<- Nota " + i + ": ");
			double nota = scanner.nextDouble();
			
			if (nota > 10 || nota < 0)
			{
				System.out.println("<!- Deben tener valores entre 0 y 10 -!>");
				i--;
			}
			else
			{
				sumaNotas += nota;
			}
		}
		
		return sumaNotas / 5.0;
	}
	
	// ====================================== EJERCICIO 3 ========================================= 
	
	private static void menuTemperatura()
	{
		System.out.println("<- Elije que conversión hacer ->\n"
				+ "1. De Celsius a Fahrenheit\n"
				+ "2. De Fahrenheit a Celsius");
		
		int opcion = scanner.nextInt();
		
		if (opcion == 1)
		{
			System.out.println("<- Introduce grados Celsius: ");
			System.out.println("\n<- Los grados en Fahrenheit son " + c2f(scanner.nextDouble()) + "ºF ->\n");
		}
		else if (opcion == 2)
		{
			System.out.println("<- Introduce grados Fahrenheit: ");
			System.out.println("\n<- Los grados en Celsius son " + f2c(scanner.nextDouble()) + "ºC ->\n");
		}
		else
			System.out.println("<!- Opción incorrecta -!>\n");
	}
	
	private static double c2f(double c)
	{
		return (c * 9.0 / 5.0) + 32;
	}
	
	private static double f2c(double f)
	{
		return (f - 32) * 5.0 / 9.0;
	}
}
