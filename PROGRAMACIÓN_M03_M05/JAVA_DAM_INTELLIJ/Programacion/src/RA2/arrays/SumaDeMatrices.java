package RA2.arrays;

/*Crea dos matrices de NxN y suma sus valores. Los resultados se deben almacenar en
otra matriz. Los valores y la longitud, serán insertados por el usuario. Muestra las
matrices originales y el resultado.*/

public class SumaDeMatrices {
    public static void main(String[] args)
    {
        System.out.println("<- Introduce el size que tendrán las matrices ->");
        int size = Main.scanner.nextInt();

        int[][] matriz1 = new int[size][size];
        int[][] matriz2 = new int[size][size];
        int[][] matrizResultado = new int[size][size];

        for (int i = 1; i < 3; i++)
        {
            System.out.println("<- Introduce los valores de la matriz " + i);
            for (int j = 0; j < matriz1.length; j++)
            {
                for (int k = 0; k < matriz1[j].length; k++)
                {
                    System.out.println("Valor (" + (j + 1) + "," + (k + 1) + "): ");
                    if (i == 1)
                        matriz1[j][k] = Main.scanner.nextInt();
                    else
                        matriz2[j][k] = Main.scanner.nextInt();
                }
            }
        }

        for (int i = 0; i < matrizResultado.length; i++)
        {
            for (int j = 0; j < matrizResultado[i].length; j++)
            {
                matrizResultado[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }

        for (int i = 1; i < 4; i++)
        {
            System.out.println("<- Matriz " + i + " ->");
            for (int j = 0; j < matriz1.length; j++)
            {
                for (int k = 0; k < matriz1[j].length; k++)
                {
                    if (i == 1)
                        System.out.print(matriz1[j][k] + "\t");
                    else if (i == 2)
                        System.out.print(matriz2[j][k] + "\t");
                    else
                        System.out.print(matrizResultado[j][k] + "\t");
                }
                System.out.println();
            }
        }
    }
}
