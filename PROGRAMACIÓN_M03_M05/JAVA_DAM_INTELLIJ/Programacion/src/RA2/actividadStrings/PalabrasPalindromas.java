package RA2.actividadStrings;

import java.util.Scanner;

public class PalabrasPalindromas {
    public static void main(String[] args)
    {
        Scanner leer = new Scanner(System.in);

        String palabra;

        while (true)
        {
            System.out.println("<- Introduce una palabra y veremos si es Palíndroma ->");
            palabra = leer.next();

            if (palabra.matches(".*[0-9].*")) //Compruebo que no tenga números del 0 a 9 en el String
            {
                System.out.println("La palabra no puede contener numeros");
                continue;
            }
            break;
        }

        if (isPalindroma(palabra))
            System.out.println("La palabra " + palabra + " es Palíndroma, se lee igual en ambos sentidos");
        else
            System.out.println("La palabra " + palabra + " no es Palíndroma, no se lee igual");
    }

    private static boolean isPalindroma(String palabra)
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
