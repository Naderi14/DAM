package boletin5;

/*6. Crear y cargar una tabla de tamaño 10x10, mostrar la suma de cada fila y de cada columna.*/

public class Ejercicio6 {
    public static void main(String[] args)
    {
        int[][] tabla = new int[10][10];
        int sumaFila = 0;

        for (int i = 0; i < tabla.length; i++)
        {
            for (int j = 0; j < tabla[i].length; j++)
            {
                tabla[i][j] = Main.rand.nextInt(10);
            }
        }

        // Mostramos tabla
        for (int i = 0; i < tabla.length; i++)
        {
            for (int j = 0; j < tabla[i].length; j++)
            {
                System.out.print(tabla[i][j] + "  ");
                sumaFila += tabla[i][j];
            }
            System.out.println(" | Suma Fila: " + sumaFila);
            sumaFila = 0;
        }

        System.out.println("-  -  -  -  -  -  -  -  -  -");

        for (int i = 0; i < tabla[0].length; i++)
        {
            int sumaColumna = 0;
            for (int j = 0; j < tabla.length; j++)
            {
                sumaColumna += tabla[j][i];
            }
            System.out.print(sumaColumna + "|");
        }
    }
}
