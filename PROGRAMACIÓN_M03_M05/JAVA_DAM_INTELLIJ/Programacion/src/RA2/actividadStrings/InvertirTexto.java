package RA2.actividadStrings;

/*3. Invertir el texto: “Tratamiento de cadenas con JAVA”*/

import java.util.Scanner;

public class InvertirTexto {
    private static Scanner leer = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("<- Introduce un texto para invertirlo ->");
        String texto = leer.nextLine();
        String textoInvertido = "";

        for (int i = texto.length() - 1; i >= 0; i--)
        {
            textoInvertido += (texto.charAt(i));
        }

        System.out.println(textoInvertido);
    }
}
