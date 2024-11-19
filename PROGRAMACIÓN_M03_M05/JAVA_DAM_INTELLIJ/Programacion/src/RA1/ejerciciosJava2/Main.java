package RA1.ejerciciosJava2;

import java.util.Scanner;

public class Main {
    private static Scanner leer = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("<- Introduce el nombre de ejercicio ->");
        int opcion = leer.nextInt();

        switch (opcion)
        {
            case 1:
                Imprenta.main(args);
                break;
            case 2:
                CalcularAreaPerimetro.main(args);
                break;
            case 3:
                MenuFormasGeometricas.main(args);
                break;
            case 4:
                PreciosDescuentos.main(args);
                break;
        }
    }
}
