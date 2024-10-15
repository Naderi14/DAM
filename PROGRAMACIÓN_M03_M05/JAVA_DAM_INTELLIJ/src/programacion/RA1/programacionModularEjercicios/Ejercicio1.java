package programacion.RA1.programacionModularEjercicios;

/*Realice un programa modular donde se calcule la suma de los dígitos de
un número que el usuario introduzca por pantalla.*/

import java.util.Scanner;

public class Ejercicio1 {
    public static void sumarDigitosDeNumero()
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
