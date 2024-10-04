package entornos.desarrollo;

import java.util.Scanner;

public class Ejercicios
{
	private final static Scanner leer = new Scanner(System.in);
	
	public static void condicionales2N()
	{
		int n1, n2;
		
		System.out.println("Estas en 'Condicionales 2N', introduce 2 numeros a continuacion para mirar si son mayores");
		
		n1 = leer.nextInt();
		n2 = leer.nextInt();

		if (n1 < n2) 
		{
			System.out.println("El número: " + n2 + " es mayor y " + n1 + " es el menor.");
		} 
		else 
		{
			System.out.println("El número: " + n1 + " es mayor y " + n2 + " es el menor.");
		}
	}
	
	public static void condicionales3N()
	{
		// Declarar variables
		int n1, n2, n3, mayor;
		
		System.out.println("Estas el 'Condicionales 3N', introduce 3 numeros a continuacion para mirar si son mayores");
		
		n1 = leer.nextInt();
		n2 = leer.nextInt();
		n3 = leer.nextInt();
		
		// Asignamos el numero1 a mayor
		mayor = n1;
		
		// Estructura condicional para comprobar si hay alguno mayor 
		if (mayor < n2) 
		{
			mayor = n2;
		} 
		if(mayor < n3)
		{
			mayor = n3;
		}
		
		// Imprimimos el resultado
		System.out.println("El número: " + mayor + " es el mayor de los tres");
	}
	
	public static void calificarNota()
	{
		int nota = 0;
		boolean isNotaValida = false;
		
		System.out.println("Introduce la nota del alumno");
		
		// NO TENGAIS ESTO EN CUENTA OK? 
		do {
			try
			{
				nota = leer.nextInt();
				if (nota <= 10 && nota >= 0)
				{
					isNotaValida = true;
					continue;
				}
			}
			catch (Exception e)
			{
				leer.nextLine();
			}
			System.out.println("Nota no válida, introduzca de nuevo");
		} while(!isNotaValida);	
		
		// Estructura condicional
		if (nota < 3)
			System.out.println("Muy Deficiente");
		
		else if(nota < 5) 
			System.out.println("Insuficiente");
		
		else if(nota < 6) 
			System.out.println("Bien");
		
		else if(nota < 9)
			System.out.println("Notable");
		
		else 
			System.out.println("Sobresaliente");
	}
}
