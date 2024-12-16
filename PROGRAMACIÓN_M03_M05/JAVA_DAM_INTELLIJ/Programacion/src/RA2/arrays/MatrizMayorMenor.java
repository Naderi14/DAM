package RA2.arrays;

/*Crea una matriz de tamaño NxM. Los tamaños serán pedidos al usuario por teclado.
Una vez creada la matriz, pedir al usuario que rellene la matriz completa con números
enteros.

Para finalizar, muestra en pantalla los números mayor y el menor que contengan la
matriz.*/

public class MatrizMayorMenor {
    public static void main(String[] args)
    {
        System.out.println("<- Introduce el tamaño que tendrá la matriz ->");
        int size = Main.scanner.nextInt();

        int[][] matriz = new int[size][size];

        for (int i = 0; i < matriz.length; i++)
        {
            for (int j = 0; j < matriz[i].length; j++)
            {
                System.out.println("Introduce valor (" + (i + 1) + "," + (j + 1) + "): ");
                matriz[i][j] = Main.scanner.nextInt();
            }
        }

        int numeroMayor = matriz[0][0], numeroMenor = matriz[0][0];
        int mejorNumero = 0;

        for (int i = 0; i < matriz.length; i++)
        {
            for (int j = 0; j < matriz[i].length; j++)
            {
                if (numeroMayor < matriz[i][j])
                    numeroMayor = matriz[i][j];

                if (numeroMenor > matriz[i][j])
                    numeroMenor = matriz[i][j];

                if (matriz[i][j] == 24)     // Easter Egg
                    mejorNumero = matriz[i][j];
            }
        }

        // Si ves esto Leyre
        // En el ejercicio esta la frase:
        //      Cuando esté la matriz rellena con datos, debes volver a recorrerla para buscar cuál es el
        //      número mayor y cuál es el -> mejor <-
        // No me restes nota, solo tómalo cómo lo que es, para sacar una carcajada ;)

        String mejor = mejorNumero == 24 ? " | Mejor: 24 el mejor número" : ""; // Condición para que aparezca el Easter Egg

        System.out.print("\nMayor: " + numeroMayor + " | Menor: " + numeroMenor + mejor);
    }
}