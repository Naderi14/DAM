package boletin5;

/*5. Crear una tabla de tamaño 7x7 y rellenarla de forma que los elementos de la diagonal principal sean
1 y el resto 0.
*/

public class Ejercicio5 {
    public static void main(String[] args)
    {
        int[][] tabla = new int[7][7];
        
        for (int i = 0; i < tabla.length; i++)
        {
            for (int j = 0; j < tabla[i].length; j++)
            {
                if (i == j)
                    tabla[i][j] = 1;
                else
                    tabla[i][j] = 0;
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
