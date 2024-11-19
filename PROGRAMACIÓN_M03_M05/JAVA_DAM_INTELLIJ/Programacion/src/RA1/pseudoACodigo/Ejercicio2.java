package RA1.pseudoACodigo;

/*Pedir 2 números y mostrar el mayor, o si son iguales, en el caso de que lo sean.*/

import java.util.Scanner;

public class Ejercicio2 {
    private static Scanner leer = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("Dame 2 numeros a continuación");
        int numero1 = leer.nextInt();
        int numero2 = leer.nextInt();

        if (numero1 == numero2)
            System.out.println("Los números son iguales");
        else
        {
            if (numero1 > numero2)
                System.out.println(numero1 + " es el mayor");
            else
                System.out.println(numero2 + " es el mayor");
        }
    }
}
