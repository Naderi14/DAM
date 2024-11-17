package programacion.RA1.ejerciciosJava2;

import java.util.Scanner;

public class Imprenta {
    private static Scanner leer = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("<- Introduce el tamaño de papel ->");
        String tipoSize = leer.next();

        switch (tipoSize)
        {
            case "A1":
                System.out.println("<- El tamaño del papel A1 es de 594 x 841 mm ->");
                break;
            case "A2":
                System.out.println("<- El tamaño del papel A2 es de 420 x 594 mm ->");
                break;
            case "A3":
                System.out.println("<- El tamaño del papel A3 es de 297 x 420 mm ->");
                break;
            case "A4":
                System.out.println("<- El tamaño del papel A4 es de 210 x 297 mm ->");
                break;
            case "A5":
                System.out.println("<- El tamaño del papel A5 es de 148 x 210 mm ->");
                break;
            case "A6":
                System.out.println("<- El tamaño del papel A6 es de 105 x 148 mm ->");
                break;
            case "A7":
                System.out.println("<- El tamaño del papel A7 es de 74 x 105 mm ->");
                break;
            case "A8":
                System.out.println("<- El tamaño del papel A8 es de 52 x 74 mm ->");
                break;
            default:
                System.out.println("<!- No existen estos tamaños -!>");
                break;
        }
    }
}
