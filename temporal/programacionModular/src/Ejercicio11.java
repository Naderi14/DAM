package programacion.RA1.programacionModularEjercicios;

/*11.Realizar un programa que compruebe si una palabra es palíndroma, es
decir, si se lee igual de izquierda a derecha que de derecha a izquierda.
Por ejemplo: RADAR, ANILINA....*/

import java.util.Scanner;

public class Ejercicio11 {
    public static void chekPalabraPalindroma()
    {
        Scanner leer = new Scanner(System.in);

        String palabra;

        while (true)
        {
            System.out.println("Introduce una palabra y veremos si es Capicua (Catalan) / Palíndroma (Castellano)");
            palabra = leer.next();

            if (palabra.matches(".*[0-9].*"))
            {
                System.out.println("La palabra no puede contener numeros");
                continue;
            }

            break;
        }

        if (isCapICua(palabra))
            System.out.println("La palabra " + palabra + " es Capicua, se lee igual en ambos sentidos");
        else
            System.out.println("La palabra " + palabra + " no es Capicua, no se lee igual");
    }

    private static boolean isCapICua(String palabra)
    {
        String palabraInvertida = "";

        for (int i = palabra.length() - 1; i >= 0; i--)
        {
            palabraInvertida += palabra.charAt(i);
        }

        if (palabra.equals(palabraInvertida))
            return true;
        else
            return false;
    }
}
