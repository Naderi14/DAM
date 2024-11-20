package RA2.actividadStrings;

/*12. Se leerá una frase y se debe contar y mostrar cuántas palabras contiene esa frase.*/

import java.util.Scanner;

public class ContadorPalabras {
    private static final Scanner leer = new Scanner(System.in);

    public static void main(String[] args)
    {
        int contadorPalabras = 0, contadorLetras = 0;

        System.out.println("<- Introduce una frase para analizar la cantidad de palabras ->");
        String texto = leer.nextLine();

        if (texto.charAt(0) != ' ')
            contadorPalabras++;

        for (int i = 0; i < texto.length(); i++)
        {
            if (texto.charAt(i) != ' ')
            {
                contadorLetras++;
            }
            else
            {
                if (contadorLetras > 0)
                    contadorPalabras++;

                contadorLetras = 0;
            }
        }

        System.out.println("La frase tiene: " + contadorPalabras + " palabras");
    }
}
