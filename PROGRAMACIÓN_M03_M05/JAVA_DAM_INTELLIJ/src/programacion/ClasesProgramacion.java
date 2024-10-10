package programacion;

import java.util.Scanner;

public class ClasesProgramacion
{
    private static Scanner leer = new Scanner(System.in);

    public static void Bucles()
    {
        System.out.println("Introduce la edad");
        int edad = leer.nextInt();
        if (edad >= 18)
            System.out.println("Eres mayor de edad");
        else
            System.out.println("Eres menor de edad");
    }

    public static void BucleFor()
    {
        System.out.println("Los números pares son los siguientes: ");
        for (int i = 0; i < 100; i += 2)
        {
            System.out.print(i + " ,");
        }
    }
}
