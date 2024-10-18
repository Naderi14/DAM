package programacion.RA1.pseudoACodigo;

/*Leer una calificación numérica entre 0 y 10 y transformarla en calificación alfabética,
escribiendo el resultado.*/

import java.util.Scanner;

public class Ejercicio4 {
    private static Scanner leer = new Scanner(System.in);

    public static void main(String[] args)
    {
        int nota;

        while (true)
        {
            System.out.println("Introduce la nota del exmámen");
            nota = leer.nextInt();

            if (nota < 0 || nota > 10)
            {
                System.out.println("Error: La nota ha de estar entre el 0 y el 10");
                continue;
            }

            break;
        }

        if (nota < 3)
            System.out.println("Muy Deficiente");
        else if (nota < 5)
            System.out.println("Insuficiente");
        else if (nota < 6)
            System.out.println("Bien");
        else if (nota < 9)
            System.out.println("Notable");
        else
            System.out.println("Sobresaliente");
    }
}
