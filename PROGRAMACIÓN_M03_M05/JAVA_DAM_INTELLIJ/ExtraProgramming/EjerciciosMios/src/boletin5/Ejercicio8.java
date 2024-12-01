package boletin5;

/*8. Crear una matriz “marco” de tamaño 8x6: todos sus elementos deben ser 0 salvo los de los bordes que
deben ser 1. Mostrarla.*/

public class Ejercicio8 {
    public static void main(String[] args)
    {
        int[][] marco = new int[8][6];

        for (int i = 0; i < marco.length; i++)
        {
            for (int j = 0; j < marco[i].length; j++)
            {
                if (i == 0)
                    marco[i][j] = 1;
                else if (j == 0)
                    marco[i][j] = 1;
                else if (j == marco[i].length - 1)
                    marco[i][j] = 1;
                else if (i == marco.length - 1)
                    marco[i][j] = 1;
                else
                    marco[i][j] = 0;
            }
        }

        for (int i = 0; i < marco.length; i++) {
            for (int j = 0; j < marco[i].length; j++) {
                System.out.print(marco[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
