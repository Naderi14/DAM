package programacion.RA1.ejerciciosJavaParaProgramar;

import java.util.Scanner;

public class Ejercicio3 {
    private static Scanner leer = new Scanner(System.in);

    /*Dado un número de días , pedidos por pantalla, ¿A cuántos días, meses, años corresponde?
Por ejemplo: Dados 366 días, la solución es 1 año y 1 día.*/
    public static void main(String[] args)
    {
        System.out.println("Introduce una cantidad de dias");

        int years = 0, months = 0, days = 0;

        days = leer.nextInt();

        years = days / 365;
        days %= 365;
        months = days / 30;
        days %= 30;

        for (int i = 0; i < years; i++)
        {
            days--;

            if (days <= 0)
            {
                months--;
                days = 29;
            }
        }

        System.out.println("Años: " + years + " | Meses: " + months + " | Dias: " + days);
    }
}
