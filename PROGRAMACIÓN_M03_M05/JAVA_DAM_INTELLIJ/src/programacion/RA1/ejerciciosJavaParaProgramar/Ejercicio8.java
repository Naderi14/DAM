package programacion.RA1.ejerciciosJavaParaProgramar;

import java.util.Scanner;

public class Ejercicio8 {
    private static Scanner leer = new Scanner(System.in);

    /*Desarrolle un algoritmo que permite calcular la media de notas, finaliza cuando la ultima nota
es un 0.*/
    public static void main(String[] args)
    {
        int nota, contadorNotas = 0;
        double mediaNotas = 0;

        do{
            System.out.println("Introduce nota: ");
            nota = leer.nextInt();

            if (nota == 0)
                break;

            if (nota > 0 && nota <= 10)
            {
                mediaNotas += nota;
                contadorNotas++;
            }
            else
            {
                System.out.println("La nota ha de ser de 1 a 10");
            }
        } while (true);

        mediaNotas /= contadorNotas;

        System.out.println("Media total de las notas: " + mediaNotas);
    }
}
