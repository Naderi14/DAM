package RA2_ejerciciosExtra;

import java.util.Scanner;

public class Graficos1 {
    Scanner scanner = new Scanner(System.in);

    public void menuGraficos()
    {
        boolean salir = false;

        while (!salir)
        {
            System.out.println("<- Introduce la opción ->\n" +
                    "1. Grafico 1\n" +
                    "1. Grafico 2\n" +
                    "1. Grafico 3\n" +
                    "1. Grafico 4\n" +
                    "1. Grafico 5\n" +
                    "1. Grafico 6\n" +
                    "7. Salir");

            int opcion = scanner.nextInt();

            switch (opcion)
            {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:
                    System.out.println("<- Hasta la próxima ->");
                    salir = true;
                    break;
                default:
                    System.out.println("<- Opción no válida ->");
                    break;
            }
        }
    }


}
