package programacion.RA1.ejerciciosJavaParaProgramar;

import java.util.Scanner;

public class Ejercicio6 {
    private static Scanner leer = new Scanner(System.in);

    /*Desarrolla un algoritmo que permita leer tres valores y almacenarlos en las variables A, B y C.
El algoritmo debe imprimir cual es el mayor cuál es el menor. Los valores deben ser distintos,
en el caso de que no lo sean imprime un mensaje de error.*/
    public static void main(String[] args)
    {
        int variableA, variableB, variableC;

        System.out.println("Introduce 3 números");
        variableA = leer.nextInt();
        variableB = leer.nextInt();
        variableC = leer.nextInt();

        if (variableA == variableB || variableB == variableC || variableC == variableA)
            System.out.println("Ha petao, 2 valores almenos son iguales");
        else
        {
            if (variableA > variableB && variableA > variableC)
            {
                System.out.println(variableA + " es mayor");
                if (variableB < variableC)
                    System.out.println(variableB + " es menor");
                else
                    System.out.println(variableC + " es menor");
            }
            else if (variableB > variableC)
            {
                System.out.println(variableB + " es mayor");
                if (variableA < variableC)
                    System.out.println(variableA + " es menor");
                else
                    System.out.println(variableC + " es menor");
            }
            else
            {
                System.out.println(variableC + " es mayor");
                if (variableA < variableB)
                    System.out.println(variableA + " es menor");
                else
                    System.out.println(variableB + " es menor");
            }
        }
    }
}
