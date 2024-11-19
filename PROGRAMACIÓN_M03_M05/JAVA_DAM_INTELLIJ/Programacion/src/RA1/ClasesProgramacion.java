package RA1;

import java.util.Scanner;

public class ClasesProgramacion
{
    private static Scanner leer = new Scanner(System.in);

    public static void bucles()
    {
        System.out.println("Introduce la edad");
        int edad = leer.nextInt();
        if (edad >= 18)
            System.out.println("Eres mayor de edad");
        else
            System.out.println("Eres menor de edad");
    }

    public static void bucleFor()
    {
        System.out.println("Los números pares son los siguientes: ");
        for (int i = 0; i < 100; i += 2)
        {
            System.out.print(i + " ,");
        }
    }

    public static void cashTotal()
    {
        int efectivoTotal = 0;

        System.out.println("Introduce la cantidad de dinero");
        double dinero = leer.nextDouble();

        while (dinero > 0)
        {
            if (dinero >= 200) {
                efectivoTotal++;
                dinero -= 200;
            } else if (dinero >= 100) {
                efectivoTotal++;
                dinero -= 100;
            } else if (dinero >= 50) {
                efectivoTotal++;
                dinero -= 50;
            } else if (dinero >= 20) {
                efectivoTotal++;
                dinero -= 20;
            } else if (dinero >= 10) {
                efectivoTotal++;
                dinero -= 10;
            } else if (dinero >= 5) {
                efectivoTotal++;
                dinero -= 5;
            } else if (dinero >= 2) {
                efectivoTotal++;
                dinero -= 2;
            } else if (dinero >= 1) {
                efectivoTotal++;
                dinero -= 1;
            } else if (dinero >= 0.5) {
                efectivoTotal++;
                dinero -= 0.5;
                dinero = Math.round(dinero * 100.0) / 100.0;
            } else if (dinero >= 0.2) {
                efectivoTotal++;
                dinero -= 0.2;
                dinero = Math.round(dinero * 100.0) / 100.0;
            } else if (dinero >= 0.1) {
                efectivoTotal++;
                dinero -= 0.1;
                dinero = Math.round(dinero * 100.0) / 100.0;
            } else if (dinero >= 0.05) {
                efectivoTotal++;
                dinero -= 0.05;
                dinero = Math.round(dinero * 100.0) / 100.0;
            } else if (dinero >= 0.02) {
                efectivoTotal++;
                dinero -= 0.02;
                dinero = Math.round(dinero * 100.0) / 100.0;
            } else {
                efectivoTotal++;
                dinero -= 0.01;
                dinero = Math.round(dinero * 100.0) / 100.0;
            }
        }

        System.out.println("El total de efectivo es de " + efectivoTotal + " entre billetes y monedas.");
    }
}
