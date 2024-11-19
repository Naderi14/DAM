package RA2.arrays;

import RA2.actividadStrings.*;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("<- Introduce el número de ejercicio ->\n" +
                "1.  -  MediaNumeros.main(args);\n" +
                "2.  -  MediaNumerosPosPares.main(args);\n" +
                "3.  -  MediaNotasAlumnos.main(args);\n" +
                "4.  -  Array20Pares.main(args);\n" +
                "5.  -  NumerosPositivosNegativos.main(args);\n" +
                "6.  -  .main(args);\n" +
                "7.  -  .main(args);\n" +
                "8.  -  .main(args);\n" +
                "9.  -  .main(args);\n" +
                "10. -  .main(args);\n" +
                "11. -  .main(args);\n" +
                "12. -  .main(args);\n");

        int opcion = scanner.nextInt();

        switch (opcion)
        {
            case 1:
                MediaNumeros.main(args);
                break;
            case 2:
                MediaNumerosPosPares.main(args);
                break;
            case 3:
                MediaNotasAlumnos.main(args);
                break;
            case 4:
                Array20Pares.main(args);
                break;
            case 5:
                NumerosPositivosNegativos.main(args);
                break;
            case 6:

                break;
            case 7:

                break;
            case 8:

                break;
            case 9:

                break;
            case 10:

                break;
            case 11:

                break;
            case 12:

                break;
        }
    }
}
