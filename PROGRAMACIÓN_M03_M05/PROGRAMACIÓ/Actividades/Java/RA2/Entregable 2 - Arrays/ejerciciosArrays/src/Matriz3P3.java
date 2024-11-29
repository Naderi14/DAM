/*Crea una matriz de 3×3 con los números del 1 al 9. Mostrar por pantalla, tal como
aparece en la matriz.*/

public class Matriz3P3 {
    public static void main(String[] args)
    {
        int[][] matriz = {{1,2,3},{4,5,6},{7,8,9}};

        // Mi algoritmo inicial
        for (int i = 0; i < matriz.length; i++)
        {
            for (int j = 0; j < matriz[i].length; j++)
            {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nSegundo: ");
        // Propuesta Ejercicio
        for (int i = 0; i < matriz.length; i++)
        {
            String fila = "";
            for (int j = 0; j < matriz[i].length; j++)
            {
                 fila += matriz[i][j] + " ";
            }
            System.out.println(fila);
        }
    }
}
