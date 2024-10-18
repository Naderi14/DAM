package programacion.RA1.ejerciciosJavaParaProgramar;

import java.util.Scanner;

public class Ejercicio1 {
    private static Scanner leer = new Scanner(System.in);

    /*Desarrolla un algoritmo que calcule la suma de los múltiplos de 5 entre 1 y 100. El programa
debe imprimir los múltiplos y la suma.*/
    public static void main(String[] args)
    {
        int sumaTotal = 0;

        System.out.print("Múltiplo: ");
        for (int i = 0; i <= 100; i += 5)
        {
            System.out.print(i + ", ");
            sumaTotal += i;
        }

        System.out.println("\nSuma total múltiplos de cinco: " + sumaTotal);
    }
}
