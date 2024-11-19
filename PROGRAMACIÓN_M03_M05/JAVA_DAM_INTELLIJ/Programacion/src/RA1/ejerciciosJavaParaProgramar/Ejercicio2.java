package RA1.ejerciciosJavaParaProgramar;

import java.util.Scanner;

public class Ejercicio2 {
    private static Scanner leer = new Scanner(System.in);

    /*Desarrolla un algoritmo que dada la velocidad de un coche en km por hora (km/hora), la
convierta a metros por segundo(m/s).*/
    public static void main(String[] args)
    {
        System.out.println("Que velocidad tiene el coche? (km/h)");

        int velocidad = leer.nextInt();
        double velocidadConvertida;

        velocidadConvertida = (double) ((velocidad * 1000) / 60) / 60;

        System.out.println("Velocidad en metros por segundo: " + velocidadConvertida);
    }
}
