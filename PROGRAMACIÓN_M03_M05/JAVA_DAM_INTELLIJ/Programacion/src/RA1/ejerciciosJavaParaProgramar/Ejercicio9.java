package RA1.ejerciciosJavaParaProgramar;

import java.util.Scanner;

public class Ejercicio9 {
    private static Scanner leer = new Scanner(System.in);

    /*Lee por pantalla dos números, luego muéstrale al usuario el siguiente menú:
a. Suma
b. Resta
c. Multiplicación
d. División
De acuerdo a la opción ingresada el usuario realiza la operación correspondiente con los
números introducidos y se muestra el resultado por pantalla.*/
    public static void main(String[] args)
    {
        System.out.println("Introduce 2 números");
        double numero1 = leer.nextDouble();
        double numero2 = leer.nextDouble();

        System.out.println("Selecciona la opción para calcular\n1. Sumar\n2. Restar\n3. Multiplicar\n4. Dividir\n");
        int opcion = leer.nextInt();

        switch (opcion)
        {
            case 1:
                System.out.println("Resultado Suma: " + (numero1 + numero2));
                break;
            case 2:
                System.out.println("Resultado Resta: " + (numero1 - numero2));
                break;
            case 3:
                System.out.println("Resultado Multiplicación: " + (numero1 * numero2));
                break;
            case 4:
                if (numero2 == 0)
                    System.out.println("No se puede dividir por 0");
                else
                    System.out.println("Resultado División: " + (numero1 / numero2));
                break;
            default:
                System.out.println("Opción inválida");
                break;
        }
    }
}





