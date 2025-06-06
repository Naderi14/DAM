package RA1.programacionModularEjercicios;

/*10.Crea una aplicación que nos convierta un número en base decimal a
binario. Esto lo realizará un metodo al que le pasaremos el número como
parámetro, devolverá un String con el número convertido a binario.

Para hacer la conversión de decimal a binario, hay que ir dividiendo el
número decimal entre dos y anotar en una columna a la derecha el resto
(un 0 si el resultado de la división es par y un 1 si es impar).

La lista de ceros y unos leídos de abajo a arriba es el resultado.*/

import java.util.Scanner;

public class Ejercicio10 {
    public static void convertidorBinario()
    {
        Scanner leer = new Scanner(System.in);

        System.out.println("Dame un número en Decimal para convertir a Binario");
        int decimal = leer.nextInt();

        System.out.println("El número binario de " + decimal + " es " + decimalToBinario(decimal));
    }

    private static String decimalToBinario(int numero)
    {
        String binarioEnteroInverso = "";
        String numeroBinario = "";

        while (numero != 0)
        {
            binarioEnteroInverso += numero & 1;
            numero >>>= 1;
        }

        for (int i = binarioEnteroInverso.length() - 1; i >= 0; i--)
        {
            numeroBinario += binarioEnteroInverso.charAt(i);
        }

        return numeroBinario;
    }
}
