package programacion.RA2.actividadStrings;

/*14. Hacer un programa que al recibir como datos dos cadenas de caracteres, forme una
cadena intercalando los caracteres de las palabras de las cadenas recibidas.*/

import java.util.Scanner;

public class MezclarCadenas {
    private static final Scanner leer = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("<- Introduce a continuación 2 frases ->");
        String cadena1 = leer.nextLine();
        String cadena2 = leer.nextLine();

        if (cadena1.length() > cadena2.length())
        {
            System.out.println("Cadena intercalada: " + mezclarCadenas(cadena2, cadena1));
        }
        else
        {
            System.out.println("Cadena intercalada: " + mezclarCadenas(cadena1, cadena2));
        }
    }

    private static String mezclarCadenas(String cadena1, String cadena2)
    {
        String cadenaMezclada = "";

        for (int i = 0; i < cadena1.length(); i++)
        {
            cadenaMezclada += cadena1.charAt(i);
            cadenaMezclada += cadena2.charAt(i);
        }

        return cadenaMezclada;
    }
}
