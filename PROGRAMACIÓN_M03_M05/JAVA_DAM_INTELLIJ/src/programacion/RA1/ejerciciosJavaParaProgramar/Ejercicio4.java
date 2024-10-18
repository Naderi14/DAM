package programacion.RA1.ejerciciosJavaParaProgramar;

import java.util.Scanner;

public class Ejercicio4 {
    private static Scanner leer = new Scanner(System.in);

    /*Una ONG tiene puntos de reparto de vacunas que se pretende funcionen de la siguiente
manera. Cada día, empezar con 1000 vacunas disponibles y a través de un programa que
controla las entregas avisar si el inventario baja de 200 unidades. Desarrollar pseudocódigo y
diagrama de flujo.*/
    public static void main(String[] args)
    {
        int vacunas = 1000, dia = 1, gastoDiario;
        while (vacunas > 0)
        {
            System.out.println("\nDia: " + dia + "   |  Vacunas Restantes: " + vacunas);
            System.out.println("Repartir número de vacunas: ");
            gastoDiario = leer.nextInt();

            dia++;

            vacunas -= gastoDiario;
            if (vacunas < 200)
            {
                if (vacunas <= 0)
                    break;

                System.out.println("\n<!-- [ALERTA] Las vacunas están por debajo de 200 unidades --!>\n");
            }
        }

        System.out.println("\n<!-- [ALERTA] Se han agotado las vacunas --!>");
    }
}
