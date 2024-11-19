package RA2.arrays;

/*Crea un programa que lea 10 números enteros por teclado y los guarde en un Array. A
continuación, calcula y muestra la media de los números que estén en las posiciones
pares del array. (Considera la primera posición del array, posición 0, como par.*/

public class MediaNumerosPosPares {
    public static void main(String[] args)
    {
        int[] numeros = new int[10];
        int suma = 0, contador = 0;

        for (int i = 0; i < numeros.length; i++)
        {
            System.out.println("<- Número " + i + ": ");
            numeros[i] = Main.scanner.nextInt();
        }

        for (int i = 0; i < numeros.length; i += 2)
        {
            suma += numeros[i];
            contador++;
        }

        double media = (double) suma / contador;

        System.out.println("Media aritmética = " + media);
    }
}
