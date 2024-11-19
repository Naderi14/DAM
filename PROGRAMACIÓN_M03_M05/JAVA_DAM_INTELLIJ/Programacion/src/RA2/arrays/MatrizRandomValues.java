package RA2.arrays;

import java.util.Random;

public class MatrizRandomValues {
    private static Random random = new Random();

    public static void main(String[] args)
    {
        System.out.println("<- Introduce el número de filas que tendrá la matriz ->");
        int filas = Main.scanner.nextInt();

        int[][] matriz = new int[5][filas];

        for (int i = 0; i < matriz.length; i++)
        {
            for (int j = 0; j < matriz[i].length; j++)
            {
                matriz[i][j] = random.nextInt(11);
            }
        }

        for (int i = 0; i < matriz.length; i++)
        {
            for (int j = 0; j < matriz[i].length; j++)
            {
                System.out.print(matriz[i][j]);

                if (matriz[i][j] == 10)     // Imprimir de forma mas bonita en consola quando aparece un 10
                    System.out.print("  ");
                else
                    System.out.print("   ");
            }
            System.out.println();
        }
    }
}
