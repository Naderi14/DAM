package RA1.programacionModularEjercicios;

/*Realizar una función en Java que reciba un número y devuelva la suma
de sus dígitos.*/

import java.util.Scanner;

public class Ejercicio6 {
    public static void sumarDigitosConFuncion()
    {
        Scanner leer = new Scanner(System.in);

        System.out.println("EX1: Introduce un número para sumar sus digitos");
        int numero = leer.nextInt();

        System.out.println("La suma total de los digitos del número " + numero + " es: " + sumaDigitos(numero));
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
