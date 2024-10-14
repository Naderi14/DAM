package ejerciciosJava1;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio3 {
    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        int promedio = 0, sumaTotal = 0;
        int[] listaNumeros = new int[10];
        ArrayList<Integer> listaImpares = new ArrayList<>();

        System.out.println("Introduzca 10 números a continuación");

        for (int i = 0; i < listaNumeros.length; i++) {
            System.out.println("Numero " + (i+1));
            listaNumeros[i] = leer.nextInt();
            sumaTotal += listaNumeros[i];
        }

        System.out.println("\nNúmeros Pares: ");

        for (int numero : listaNumeros)
        {
            if (numero % 2 == 0)
                System.out.print(numero + " ,");
            else
                listaImpares.add(numero);
        }

        for (int numero : listaImpares)
        {
            promedio += numero;
        }
        promedio /= listaImpares.size();

        System.out.println("\nSuma Total de todos los números: " + sumaTotal);
        System.out.println("Promedio de todos los impares: " + promedio);
    }
}
