package programacionModularAct1;

/*Realice un programa modular donde se calcule la suma de los dígitos de
un número que el usuario introduzca por pantalla.*/

/*
 * Juan Francisco Sanchez Castelblanque DAM 1r
 */

import java.util.Scanner;

public class Ejercicio1 {
	public static void sumarDigitosDeNumero()
    {
        System.out.println("EX1: Introduce un número para sumar sus digitos");

        System.out.println("La suma total de los digitos del número es: " + sumaDigitos(pedirNumero()));
    }

    private static int pedirNumero()
    {
        Scanner leer = new Scanner(System.in);
        return leer.nextInt();
    }

    private static int sumaDigitos(int numero)
    {
        int sumaTotal = 0;

        while (numero > 0)
        {
            sumaTotal += numero % 10;
            numero /= 10;
        }

        return sumaTotal;
    }
}
