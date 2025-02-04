package juanFranciscoExcepcionesExamen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Array 
{
	public static void main(String[] args)
	{
		Array array = new Array();
		int[] lista;
		// PEDIMOS LA LONGITUD Y RELLENAMOS EL ARRAY
		Scanner sc = new Scanner(System.in);
		try 
		{	
			System.out.println("<- Introduce la longitud del array(3,4,5,6) ->");
			int longitud = sc.nextInt();
			
			if (longitud < 3 || longitud > 6)
				showError();
			
			lista = array.createArray(longitud);
			array.fillArray(lista);
			
			// EMPEZAMOS EL MENÚ INFINITO		
			while (true)
			{
				System.out.println("1-Show number\n0-Exit\n");
				int opcion = sc.nextInt();
				
				if (opcion == 1)
				{
					array.showNumber(lista);
				}
				else if (opcion == 0)
				{
					break;
				}
				else
				{
					System.out.println("<- Opción inválida ->");
				}
			}
		}
		catch (NumberNotValidException ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	public int[] createArray(int x)
	{		
		return new int[x]; 
	}
	
	public int[] fillArray(int[] array)
	{
		Scanner sc = new Scanner(System.in);
		
		int contador = 0;
		while (contador < array.length)
		{
			try
			{
				System.out.println("<- Introduce el digito " + (contador+1) + " ->");
				array[contador] = sc.nextInt();
				contador++;
			}
			catch (InputMismatchException ex)
			{
				ex = new InputMismatchException("Not a valid digit");
				System.out.println(ex.getMessage());
				sc.nextLine();
			}			
		}
		
		return array;
	}
	
	public void showNumber(int[] array)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("<- Introduce la posición ->");
		
		int position = sc.nextInt();
		
		try
		{
			System.out.println(array[position - 1]);
		}
		catch (ArrayIndexOutOfBoundsException ex)
		{
			ex = new ArrayIndexOutOfBoundsException("Index " + position + " out of bounds for length " + array.length + "\n");
			System.out.println(ex.getMessage());
		}
	}
	
	private static void showError() throws NumberNotValidException
	{
		throw new NumberNotValidException();
	}
}
