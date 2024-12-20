package examenRA3;

import java.util.Iterator;
import java.util.Scanner;

public class Programa {
	public static void main(String[] args) {
		boolean isEnd = false;
		
		while (!isEnd)
		{
			mostrarMenu();
			isEnd = !isInteractuaMenu();
		}
	}
	
	// Funcion que permite la gestión del programa y entrada de opciones por el usuario
	public static boolean isInteractuaMenu()
	{
		Programa pr = new Programa();
		Scanner sc = new Scanner(System.in);
		
		String[] nombresHortalizas = {"Zanahorias","Tomates","Pepinos","Alubias",
				  "Sandías","Melones","Cardos","Borrajas"};
		String anuncio = "Hortalizas ricas en calcio y vitaminas recogidas en el día listas para ser comidas";
		
		int opcion = sc.nextInt();
		switch (opcion)
		{
			case 1:
				guardaStock(nombresHortalizas);
				break;
			case 2:
				pr.precioAnuncio(anuncio);
				break;
			case 3:
				mostrarAnuncioReves(anuncio, pr);
				break;
			case 4:
				System.out.println("Fin del programa. Examen realizado por Juan Francisco Sanchez Castelblanque. 17 de diciembre de 2024.");
				return false;
			default:
				System.out.println("<- Opción incorrecta ->");
				break;
		}
		
		return true;
	}
	
	// Función para mostrar el menú exclusivamente
	public static void mostrarMenu()
	{
		System.out.println(
				"\n1. Seguimiento de stock\n"
				+ "2. Promocionar productos\n"
				+ "3. Anunciar huerto\n"
				+ "4. Salir del programa\n");
	}
	
	// Funcion que realiza múltiples tareas de gestión de inventarios, rellenar, mostrar cantidades, total, menor y media
	public static void guardaStock(String[] array)
	{
		int[] cantidadHortalizas = new int[array.length];
		
		// Rellenar hortalizas
		for (int i = 0; i < cantidadHortalizas.length; i++)
		{
			cantidadHortalizas[i] = (int) (Math.random() * 70) + 2;
		}
		
		// Mostamos las hortalizas con sus cantidades
		System.out.println("Hola! Dime cuantas hortalizas tienes de:");
		for (int i = 0; i < cantidadHortalizas.length; i++)
		{
			System.out.printf("%s: %d\n",array[i],cantidadHortalizas[i]);
		}
		
		// Mostramos el total de hortalizas
		int sumaTotal = 0;
		for (int i = 0; i < cantidadHortalizas.length; i++)
		{
			sumaTotal += cantidadHortalizas[i];
		}
		System.out.printf("\nLa cantidad total de hortalizas es: %d\n",sumaTotal);
		
		// Mirar cual es la que menos tiene y guardar su posición
		int posicionHortaliza = 0;
		int menorCantidad = Integer.MAX_VALUE;
		for (int i = 0; i < cantidadHortalizas.length; i++)
		{
			if (menorCantidad > cantidadHortalizas[i])
			{
				menorCantidad = cantidadHortalizas[i];
				posicionHortaliza = i;
			}
		}
		System.out.printf("La hortaliza %s solo tiene %d unidades!\n",
				array[posicionHortaliza], cantidadHortalizas[posicionHortaliza]);
		
		// Realizamos la media y la mostramos
		double mediaHortalizas = (double) sumaTotal / cantidadHortalizas.length;
		System.out.printf("La media de las hortalizas es: %2.2f\n", mediaHortalizas);
	}
	
	// Función que permite calcular el costo en € de un anuncio(String)	
	public void precioAnuncio(String anuncio)
	{
		Programa pr = new Programa();
		
		String[] palabras = anuncio.split(" ");
		
		final int precioPalabra = 7;
		int precioAnuncio = palabras.length * 7;
		System.out.printf("Estimado Ramiro su anuncio costará %d x %d = %d céntimos.\n",palabras.length,precioPalabra,precioAnuncio);
		System.out.println(pr.anuncioMayuscula(anuncio));
	}
	
	// Función que permite devolver un String en mayúsculas
	public String anuncioMayuscula(String anuncio)
	{
		return anuncio.toUpperCase();
	}
	
	// Función que muestra un String palabra por palabra de forma inversa (La palabra no la invierte)
	public static void mostrarAnuncioReves(String anuncio, Programa pr)
	{
		String anuncioMayus = pr.anuncioMayuscula(anuncio);
		String[] palabras = anuncioMayus.split(" ");
		
		for (int i = palabras.length - 1; i >= 0; i--)
		{
			System.out.println(palabras[i]);
		}
	}
}
