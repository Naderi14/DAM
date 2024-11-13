package programacion.RA2;

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
                break;
            case 4:
                break;
            case 5:
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
            case 13:
                break;
            case 14:
                break;
            case 15:
                break;
        }
    }
}
