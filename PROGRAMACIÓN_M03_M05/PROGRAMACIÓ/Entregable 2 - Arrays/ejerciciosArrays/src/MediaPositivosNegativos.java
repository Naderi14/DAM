/*Crea un programa que llene un array con 10 números enteros que se leen por teclado.
A continuación, calcula y muestra la media de los valores positivos y la de los valores
negativos del array.*/

public class MediaPositivosNegativos {
    public static void main(String[] args) {
        int[] numeros = new int[10];
        int sumaPositivos = 0, sumaNegativos = 0, contadorPositivos = 0, contadorNegativos = 0;

        for (int i = 0; i < numeros.length; i++)
        {
            System.out.println("<- Número " + (i + 1) + ": ");
            numeros[i] = Main.scanner.nextInt();
        }

        for (int i = 0; i < numeros.length; i++)
        {
            if (numeros[i] >= 0)
            {
                contadorPositivos++;
                sumaPositivos += numeros[i];
            }
            else
            {
                contadorNegativos++;
                sumaNegativos += numeros[i];
            }
        }

        double mediaPositivos = (double) sumaPositivos / contadorPositivos;
        double mediaNegativos = (double) sumaNegativos / contadorNegativos;

        System.out.println("Media positivos = " + mediaPositivos + " | Media negativos = " + mediaNegativos);
    }
}
