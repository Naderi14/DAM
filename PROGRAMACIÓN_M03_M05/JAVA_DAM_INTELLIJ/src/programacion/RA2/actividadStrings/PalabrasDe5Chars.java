package programacion.RA2.actividadStrings;

/*15. Se leerá un texto largo, y deberás indicar el porcentaje de palabras que tienen menos
de 5 caracteres y el porcentaje de palabras con 5 o más caracteres.

Pista: Recorre el texto recibido que será un único String, y ve acumulando las letras
que leas en una variable “palabra”, cuando encuentres un espacio en vez de una
letra, ya tendrás una palabra completa, y podrás contar cuantos caracteres tiene.
Una vez termines con esa palabra, reinicia “palabra” haciendo palabra = “”;*/

import java.util.Scanner;

public class PalabrasDe5Chars {
    private static final Scanner leer = new Scanner(System.in);

    public static void main(String[] args)
    {
        int contadorPalabras = 0;

        System.out.println("<- Introduce un texto para contar sus palabras de menos de 5 letras ->");
        String texto = leer.nextLine();
        String palabraTemp = "";

        for (int i = 0; i < texto.length(); i++)
        {
            if (texto.charAt(i) != ' ')
            {
                palabraTemp += texto.charAt(i);
            }

            if (texto.charAt(i) == ' ' || i == texto.length() - 1)
            {
                if (palabraTemp.length() < 5)
                {
                    contadorPalabras++;
                }
                palabraTemp = "";
            }
        }

        System.out.println("<- Palabras de menos de 5 letras: " + contadorPalabras + " palabras ->");
    }
}
