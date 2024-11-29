package ejerciciosCadenas;

/*12. Se leerá una frase y se debe contar y mostrar cuántas palabras contiene esa frase.*/

import java.util.Scanner;

public class ContadorPalabras {
    private static final Scanner leer = new Scanner(System.in);

    public static void main(String[] args)
    {
        // boolean isWord = false;

        System.out.println("<- Introduce una frase para analizar la cantidad de palabras ->");
        String texto = leer.nextLine();

        String[] textoSpliteado = texto.split(" ");
        int contadorPalabras = textoSpliteado.length;

        /*for (int i = 0; i < texto.length(); i++)
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
        }*/

        System.out.println("La frase tiene: " + contadorPalabras + " palabras");
    }
}
