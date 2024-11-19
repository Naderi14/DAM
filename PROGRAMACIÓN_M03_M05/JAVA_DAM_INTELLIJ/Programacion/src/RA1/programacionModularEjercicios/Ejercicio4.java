package RA1.programacionModularEjercicios;

/*Realizar un programa en Java que utilice una función para calcular el
menor de dos números y le muestre al usuario el resultado final.*/

import java.util.Scanner;

public class Ejercicio4 {
    public static void menorDeDos()
    {
        Scanner leer = new Scanner(System.in);

        System.out.println("EX4: Introduce dos numeros para saber el menor");
        int numero1 = leer.nextInt();
        int numero2 = leer.nextInt();

        System.out.println("El menor de ambos es: " + menor(numero1, numero2));
    }

    private static int menor(int num1, int num2)
    {
        return Math.min(num1, num2);
    }
}
