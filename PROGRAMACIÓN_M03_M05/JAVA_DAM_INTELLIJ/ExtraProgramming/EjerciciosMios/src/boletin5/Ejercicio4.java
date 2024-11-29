package boletin5;

/*4. Crear y cargar una tabla de tamaño 3x3, trasponerla y mostrarla.*/

public class Ejercicio4 {
    public static void main(String[] args) {
        int[][] tabla = new int[3][3];
        int aux;

        for (int i = 0; i < tabla.length; i++)
        {
            for (int j = 0; j < tabla[i].length; j++)
            {
                System.out.println("(" + i + ", " + j + "): ");
                tabla[i][j] = Main.sc.nextInt();
            }
        }

        // Mostramos la matriz original
        for (int i = 0; i < tabla.length; i++)
        {
            for (int j = 0; j < tabla[i].length; j++)
            {
                System.out.print(tabla[i][j] + "  ");
            }
            System.out.println();
        }

        // Transponemos la matriz, filas por columnas
        for (int i = 0; i < tabla.length; i++)
        {
            for (int j = 0; j < i; j++)
            {
                aux = tabla[i][j];
                tabla[i][j] = tabla[j][i];
                tabla[j][i] = aux;
            }
        }
        System.out.println("\n");
        // Mostrar la tabla alterada transpuesta
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
