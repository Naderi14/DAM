package game;

import java.util.InputMismatchException;
import java.util.Scanner;

import exceptionsPersonalized.*;

public class Partido {
	private static final String ILLEGAL_MESSAGE = "java.lang.IllegalArgumentException";
	
	private int puntos = 0;
	private int contadorTransacciones = 0;
	
	public static void main(String[] args) 
	{
		Partido partido = new Partido();
		
		System.out.println("¡Bienvenido de vuelta a su cuenta Player1!");
		try 
		{
			partido.pedirOpcion();
		}
		catch (IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	private void menu()
	{
		System.out.println("1.Ingresar puntos\n2.Quitar puntos\n3.Salir");
	}
	
	private void pedirOpcion() throws IllegalArgumentException
	{
		Scanner sc = new Scanner(System.in);
		int puntos;
		boolean isExit = false;
		while (!isExit)
		{			
			menu();
			int opcion;
			try 
			{
				opcion = sc.nextInt();
				switch (opcion)
				{
					case 1:
						System.out.print("\nIngrese puntos para depósito:");
						puntos = sc.nextInt();
						if (puntos <= 0)
							throw new InvalidDepositAmountException();
						if (this.puntos + puntos > 1000)
							throw new AccountLimitExceededException();
						ingresaPuntos(puntos);
						break;
					case 2:
						System.out.print("\nIngrese puntos para retiro:");
						puntos = sc.nextInt();
						if (puntos <= 0)
							throw new InvalidAmountException();
						if (puntos > this.puntos)
							throw new InsufficientPointsException();
							
						quitaPuntos(puntos);
						break;
					case 3:
						System.out.println("\n¡Hasta la próxima!");
						isExit = true;
						break;
					default:
						throw new IllegalArgumentException(ILLEGAL_MESSAGE);
				}
			}
			catch (InvalidDepositAmountException | InvalidAmountException | 
					InsufficientPointsException | AccountLimitExceededException e)
			{
				System.out.println(e.getMessage());
			}
			catch (InputMismatchException e)
			{
				e = new InputMismatchException("Error: Introduce un valor válido");
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			
			if (contadorTransacciones >= 5)
			{
				throw new IllegalArgumentException(ILLEGAL_MESSAGE);
			}
		}
	}
	
	private void ingresaPuntos(int puntos)
	{
		this.puntos += puntos;
		System.out.println("Transacción exitosa. Saldo actual: " + this.puntos + "\n");
		contadorTransacciones++;
	}
	
	private void quitaPuntos(int puntos)
	{
		this.puntos -= puntos;
		System.out.println("Transacción exitosa. Saldo actual: " + this.puntos + "\n");
		contadorTransacciones++;
	}
}
