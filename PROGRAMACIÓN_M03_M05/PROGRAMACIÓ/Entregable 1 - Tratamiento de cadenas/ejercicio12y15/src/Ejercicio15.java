import java.util.Scanner;

public class Ejercicio15
{
    private static final Scanner leer = new Scanner(System.in);

    public static void main(String[] args)
    {
        int contadorPalabras = 0;

        System.out.println("<- Introduce un texto para contar sus palabras de menos de 5 letras ->");
        String texto = leer.nextLine();

        String[] textoSpliteado = texto.split(" ");

        for (int i = 0; i < textoSpliteado.length; i++)
        {
            if (textoSpliteado[i].length() < 5)
            {
                contadorPalabras++;
            }
        }

        System.out.println("<- Palabras de menos de 5 letras: " + contadorPalabras + " palabras ->");
    }
}
