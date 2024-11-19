package RA2.actividadStrings;

/*12. Se leerá una frase y se debe contar y mostrar cuántas palabras contiene esa frase.*/

import java.util.Scanner;

public class ContadorPalabras {
    private static final Scanner leer = new Scanner(System.in);

    public static void main(String[] args)
    {
        boolean isWord = false;
        int contadorPalabras = 0;

        System.out.println("<- Introduce una frase para analizar la cantidad de palabras ->");
        String texto = leer.nextLine();

        for (int i = 0; i < texto.length(); i++)
        {
            if (!isWord)
            {
                isWord = true;
                contadorPalabras++;
            }

            if (texto.charAt(i) == ' ')
            {
                isWord = false;
            }
        }

        System.out.println("La frase tiene: " + contadorPalabras + " palabras");
    }
}
