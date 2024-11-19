package RA1.programacionModularEjercicios;

/*Realizar un programa en Java que utilice una función para calcular el
cubo de un número, mostrando luego por pantalla dicho resultado.*/

import java.util.Scanner;

public class Ejercicio3 {
    public static void expCubo()
    {
        Scanner leer = new Scanner(System.in);

        System.out.println("EX3: Introduce el número para calcularlo al cubo");
        int numero = leer.nextInt();

        System.out.println("El " + numero + " al cubo es: " + cubo(numero));
    }

    private static int cubo(int numero)
    {
        return (int) Math.pow(numero, 3);
    }
}
