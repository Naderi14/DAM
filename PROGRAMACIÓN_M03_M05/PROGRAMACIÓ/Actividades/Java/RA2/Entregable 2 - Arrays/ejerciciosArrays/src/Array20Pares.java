/*Crea un programa que cree un array de 20 elementos llamado Pares y guarde los 20
primeros números pares (de forma automática). Mostrar por pantalla el contenido del
array creado.*/

public class Array20Pares {
    public static void main(String[] args) {
        int[] Pares = new int[20];
        int numero = 0;

        for (int i = 0; i < Pares.length; i++)
        {
            Pares[i] = numero;
            numero += 2;
        }

        for (int i = 0; i < Pares.length; i++)
        {
            System.out.println("Numero " + (i + 1) + ": " + Pares[i]);
        }
    }
}
