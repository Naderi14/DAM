package programacion.RA2.actividadStrings;

import java.util.Scanner;

public class MainCadenas {
    private static Scanner leer = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("<- Introduce el número de ejercicio ->");
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

                break;
            case 14:
                break;
            case 15:
                break;
        }
    }
}
