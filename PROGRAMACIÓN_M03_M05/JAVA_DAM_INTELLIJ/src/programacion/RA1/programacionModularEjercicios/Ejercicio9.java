package programacion.RA1.programacionModularEjercicios;

/*Crea una aplicación que nos pida un número por teclado y con un
metodo se lo pasamos por parámetro para que nos indique si es o no un
número primo, debe devolver true si es primo sino false.
Un número primo es aquel solo puede dividirse entre 1 y sí mismo. Por
ejemplo: 25 no es primo, ya que 25 es divisible entre 5, sin embargo, 17
si es primo.*/

import java.util.Scanner;

public class Ejercicio9 {
    public static void numeroPrimoOno()
    {
        Scanner leer = new Scanner(System.in);

        System.out.println("EX9: Introduce un número para ver si es primo o no");
        int numero = leer.nextInt();

        if (esPrimo(numero))
            System.out.println("El número " + numero + " es Primo");
        else
            System.out.println("El número " + numero + " no es Primo");

    }

    private static boolean esPrimo(int numero)
    {
        if (numero < 2)
            return false;

        for (int i = 2; i <= numero / 2; i++)
        {
            if (numero % i == 0)
                return false;
        }

        return true;
    }
}
