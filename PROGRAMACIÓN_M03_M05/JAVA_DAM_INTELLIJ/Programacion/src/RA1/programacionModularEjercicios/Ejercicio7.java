package RA1.programacionModularEjercicios;

/*Crea una aplicación que nos cuente el número de cifras de un número
entero positivo (hay que controlarlo) pedido por teclado. Crea un
metodo que realice esta acción, pasando el número por parámetro,
devolverá el número de cifras.*/

import java.util.Scanner;

public class Ejercicio7 {
    public static void digitCounter()
    {
        Scanner leer = new Scanner(System.in);

        int numero;

        while (true)
        {
            System.out.println("EX7: Introduce un número positivo:");
            numero = leer.nextInt();

            if (numero >= 0)
                break;
            else
                System.out.println("El número introducido es negativo\n");
        }

        System.out.println("El número " + numero + " tiene " + count(numero) + " cifras");

    }

    private static int count(int numero)
    {
        int contador = 0;

        if (numero == 0)
            contador++;

        while (numero > 0)
        {
            numero /= 10;
            contador++;
        }

        return contador;
    }
}
