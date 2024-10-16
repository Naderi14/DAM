package programacionModularAct1;

import java.util.Scanner;

/*Realizar una función en Java llamada Factorial, que devuelva el factorial
de un número.*/

/*
 * Juan Francisco Sanchez Castelblanque DAM 1r
 */

public class Ejercicio2 {

    public static void numeroFactorial()
    {
        Scanner leer = new Scanner(System.in);

        System.out.println("EX2: Introduce un número para calcular su factorial");
        int numero = leer.nextInt();

        System.out.println("El factorial de " + numero + " es " + factorial(numero));
    }

    private static int factorial(int numero)
    {
        int factorial = 1;

        while (numero != 0)
        {
            factorial *= numero;
            numero--;
        }

        return factorial;
    }
}
