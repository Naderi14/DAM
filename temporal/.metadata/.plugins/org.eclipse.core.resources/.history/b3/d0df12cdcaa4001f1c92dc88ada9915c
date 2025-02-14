package ejerciciosCadenas;

/*11. Se leerá una frase y se debe encontrar la palabra de mayor longitud. El programa
imprimirá la palabra y el número de caracteres de la misma.*/

import java.util.Scanner;

public class BuscadorPalabraLarga {
    private static final Scanner leer = new Scanner(System.in);
    private static String checkingPalabra = "", palabraLarga = "";

    public static void main(String[] args)
    {
        System.out.println("<- Introduce una frase para analizar la palabra mas larga ->");
        String texto = leer.nextLine();

        for (int i = 0; i < texto.length(); i++)
        {
            if (texto.charAt(i) != ' ')
                checkingPalabra += texto.charAt(i);
            else
            {
                compareSet();
            }
        }
        compareSet();

        System.out.println("La palabra mas larga es: \"" + palabraLarga + "\" y su longitud es de " + palabraLarga.length());
    }

    private static String compareSet()
    {
        if (checkingPalabra.length() > palabraLarga.length())
        {
            palabraLarga = checkingPalabra;
        }
        return checkingPalabra = "";
    }
}
