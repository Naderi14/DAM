package RA2.actividadStrings;

import java.util.Scanner;

public class MainCadenas {
    private static Scanner leer = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("<- Introduce el número de ejercicio ->\n" +
                "1.  -  LongitudTexto.main(args);\n" +
                "2.  -  DesmenuzarString.main(args);\n" +
                "3.  -  InvertirTexto.main(args);\n" +
                "4.  -  EliminarEspacios.main(args);\n" +
                "5.  -  ContarLetras.main(args);\n" +
                "6.  -  DividirCadenaTexto.main(args);\n" +
                "7.  -  MinusMayusMinus.main(args);\n" +
                "8.  -  CompareStrings.main(args);\n" +
                "9.  -  ReemplazarLetra.main(args);\n" +
                "10. -  String2ASCII.main(args);\n" +
                "11. -  BuscadorPalabraLarga.main(args);\n" +
                "12. -  ContadorPalabras.main(args);\n" +
                "13. -  NumeroTelefono.main(args);\n" +
                "14. -  MezclarCadenas.main(args);\n" +
                "15. -  PalabrasDe5Chars.main(args);\n" +
                "16. -  PalabrasPalindromas.main(args);\n");
        int opcion = leer.nextInt();

        switch (opcion)
        {
            case 1:
                LongitudTexto.main(args);
                break;
            case 2:
                DesmenuzarString.main(args);
                break;
            case 3:
                InvertirTexto.main(args);
                break;
            case 4:
                EliminarEspacios.main(args);
                break;
            case 5:
                ContarLetras.main(args);
                break;
            case 6:
                DividirCadenaTexto.main(args);
                break;
            case 7:
                MinusMayusMinus.main(args);
                break;
            case 8:
                CompareStrings.main(args);
                break;
            case 9:
                ReemplazarLetra.main(args);
                break;
            case 10:
                String2ASCII.main(args);
                break;
            case 11:
                BuscadorPalabraLarga.main(args);
                break;
            case 12:
                ContadorPalabras.main(args);
                break;
            case 13:
                NumeroTelefono.main(args);
                break;
            case 14:
                MezclarCadenas.main(args);
                break;
            case 15:
                PalabrasDe5Chars.main(args);
                break;
            case 16:
                PalabrasPalindromas.main(args);
                break;
        }
    }
}
