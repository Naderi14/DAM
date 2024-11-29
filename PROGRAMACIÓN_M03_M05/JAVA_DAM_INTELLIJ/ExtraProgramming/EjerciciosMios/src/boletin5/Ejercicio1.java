package boletin5;

/*1. Crear una tabla bidimensional de tamaño 5x5 y rellenarla de la siguiente forma: la posición T[n,m]
debe contener n+m. Después se debe mostrar su contenido.*/

public class Ejercicio1 {
    public static void main(String[] args)
    {
        int[][] tabla = new int[5][5];

        for (int i = 0; i < tabla.length; i++)
        {
            for (int j = 0; j < tabla[i].length; j++)
            {
                tabla[i][j] = i + j;
            }
        }

        for (int i = 0; i < tabla.length; i++)
        {
            for (int j = 0; j < tabla[i].length; j++)
            {
                System.out.print(tabla[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
