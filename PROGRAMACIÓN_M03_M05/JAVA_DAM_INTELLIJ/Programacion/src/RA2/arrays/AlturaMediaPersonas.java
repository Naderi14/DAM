package RA2.arrays;

/*Crea un programa para leer la altura de N personas y calcular la altura media. Calcular
cuántas personas tienen una altura superior a la media y cuántas tienen una altura
inferior a la media. El valor de N se pide por teclado y debe ser entero positivo.*/

public class AlturaMediaPersonas {
    public static void main(String[] args)
    {
        System.out.println("<- Cuantas personas vas anotar su altura ->");
        int personas = Main.scanner.nextInt();

        int[] alturas = new int[personas];
        int suma = 0;

        for (int i = 0; i < alturas.length; i++)
        {
            System.out.println("<- Persona " + (i + 1) + ": ");
            alturas[i] = Main.scanner.nextInt();
        }

        for (int i = 0; i < alturas.length; i++)
        {
            suma += alturas[i];
        }

        double media = (double) suma / alturas.length;

        System.out.println("Media altura = " + media);
    }
}