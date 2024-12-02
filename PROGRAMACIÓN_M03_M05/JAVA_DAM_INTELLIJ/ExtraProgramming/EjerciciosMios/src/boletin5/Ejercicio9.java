package boletin5;

/*9. Hacer lo mismo que el ejercicio anterior, pero con una matriz 9x9x9. Creamos un cubo con las caras
puestas a 1 y el interior a 0.*/

public class Ejercicio9 {
    public static void main(String[] args)
    {
        int[][][] cubo = new int[9][9][9];

        for (int i = 0; i < cubo.length; i++)
        {
            for (int j = 0; j < cubo[i].length; j++)
            {
                for (int k = 0; k < cubo[i][j].length; k++)
                {
                    if (i == 0 || i == cubo.length - 1)
                        cubo[i][j][k] = 1;
                    else if (j == 0 || j == cubo[i].length - 1)
                        cubo[i][j][k] = 1;
                    else if (k == 0 || k == cubo[i][j].length - 1)
                        cubo[i][j][k] = 1;
                }
            }
        }

        for (int i = 0; i < cubo.length; i++) {
            System.out.println("--------- Capa " + i + " ---------");
            for (int j = 0; j < cubo[i].length; j++) {
                for (int k = 0; k < cubo[i][j].length; k++) {
                    System.out.print(cubo[i][j][k] + "  ");
                }
                System.out.println();
            }
        }
    }
}
