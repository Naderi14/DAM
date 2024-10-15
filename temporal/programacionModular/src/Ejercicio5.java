package programacion.RA1.programacionModularEjercicios;

/*Realizar una función en Java que reciba un número real y devuelva un -1
si es negativo, 1 si es positivo y 0 si es 0.*/

import java.util.Scanner;

public class Ejercicio5 {
    public static void positiveNegativeZero()
    {
        Scanner leer = new Scanner(System.in);

        System.out.println("Introduzca un número real");
        double numero = leer.nextDouble();

        System.out.println("La respuesta es: " + checkNumber(numero));
    }

    private static int checkNumber(double numeroReal)
    {
        int result;

        if (numeroReal > 0)
            result = 1;
        else if (numeroReal == 0)
            result = 0;
        else
            result = -1;

        return result;
    }
}
