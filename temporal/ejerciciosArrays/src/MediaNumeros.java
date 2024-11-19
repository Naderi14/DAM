/*Crea un programa que lea 10 números enteros por teclado y los guarde en un Array. A
continuación, calcula y muestra la media de los números introducidos.*/

public class MediaNumeros {

    //DecimalFormat decimalFormat = new DecimalFormat("#.##"); Idea redondeo

    public static void main(String[] args)
    {
        int[] numeros = new int[10];
        int suma = 0;

        for (int i = 0; i < numeros.length; i++)
        {
            System.out.println("<- Número " + (i + 1) + ": ");
            numeros[i] = Main.scanner.nextInt();
        }

        for (int i = 0; i < numeros.length; i++)
        {
            suma += numeros[i];
        }

        double media = (double) suma / numeros.length;

        System.out.println("Media aritmética = " + media);
    }
}
