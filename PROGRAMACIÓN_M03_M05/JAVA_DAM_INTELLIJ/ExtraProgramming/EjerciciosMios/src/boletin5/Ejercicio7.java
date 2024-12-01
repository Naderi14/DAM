package boletin5;

/*7. utilizando dos tablas de tamaño 5x9 y 9x5, cargar la primera y trasponerla en la segunda.*/

public class Ejercicio7 {
    public static void main(String[] args)
    {
        int[][] tabla1 = new int[5][9];
        int[][] tabla2 = new int[9][5];

        for (int i = 0; i < tabla1.length; i++) 
        {
            for (int j = 0; j < tabla1[i].length; j++)
            {
                tabla1[i][j] = Main.rand.nextInt(10);
            }
        }

        for (int i = 0; i < tabla1.length; i++)
        {
            for (int j = 0; j < tabla1[i].length; j++)
            {
                tabla2[j][i] = tabla1[i][j];
            }
        }

        for (int i = 0; i < tabla2.length; i++)
        {
            for (int j = 0; j < tabla2[i].length; j++)
            {
                System.out.print(tabla2[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
