package ejerciciosRepasoProgramacion;

import java.util.Scanner;

public class Ejercicio7 {
    /*Desarrolle un algoritmo que realice la suma de los números enteros comprendidos entre el 1
y el 10.*/
    public static void main(String[] args)
    {
        int sumaTotal = 0;

        for (int i = 1; i <= 10; i++)
        {
            sumaTotal += i;
        }

        System.out.println("Suma total, números enteros del 1 - 10: " + sumaTotal);
    }
}
