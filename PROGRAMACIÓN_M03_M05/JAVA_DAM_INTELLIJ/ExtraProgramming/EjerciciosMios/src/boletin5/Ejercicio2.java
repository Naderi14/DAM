package boletin5;

/*2. Crear y cargar una tabla de tamaño 4x4 y decir si es simétrica o no, es decir si se obtiene la
misma tabla al cambiar las filas por columnas.*/

public class Ejercicio2 {
    public static void main(String[] args) {
        int[][] tabla = new int[3][3];
        boolean simetrico = true;

        for (int i = 0; i < tabla.length; i++)
        {
            for (int j = 0; j < tabla[i].length; j++)
            {
                System.out.println("(" + i + ", " + j + "): ");
                tabla[i][j] = Main.sc.nextInt();
            }
        }

        for (int i = 0; i < tabla.length; i++)
        {
            for (int j = 0; j < tabla[i].length; j++)
            {
                if (tabla[i][j] != tabla[j][i])
                    simetrico = false;

                System.out.print(tabla[i][j] + "  ");
            }
            System.out.println();
        }

        if (simetrico)
            System.out.println("<- La tabla es simétrica ->");
        else
            System.out.println("<- La tabla es asimétrica ->");

    }
}
