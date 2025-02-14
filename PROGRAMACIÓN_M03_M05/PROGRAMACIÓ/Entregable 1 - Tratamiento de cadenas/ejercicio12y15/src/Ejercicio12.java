import java.util.Scanner;

public class Ejercicio12
{
    private static final Scanner leer = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("<- Introduce una frase para analizar la cantidad de palabras ->");
        String texto = leer.nextLine();

        String[] textoSpliteado = texto.split(" ");
        int contadorPalabras = textoSpliteado.length;

        System.out.println("La frase tiene: " + contadorPalabras + " palabras");
    }
}
