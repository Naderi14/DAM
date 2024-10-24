package ejerciciosJava2;

import java.util.Scanner;

public class PreciosDescuentos {
    private static Scanner leer = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("<- Introduce una opción del menú ->\n1. Calcular descuento\n2. Salir");
        int opcion = leer.nextInt();

        double precioTotal;
        double descuento;

        switch (opcion)
        {
            case 1:
                while (true)
                {
                    System.out.println("<- Introduce el precio total ->");
                    precioTotal = leer.nextDouble();

                    if (precioTotal > 0)
                        break;
                    else
                        System.out.println("<!- El precio no es válido -!>");
                }

                for (int i = 5; i <= 100; i += 5)
                {
                    descuento = precioTotal * ((double)i / 100);
                    System.out.println("<- Descuento " + i + "% = " + (precioTotal - descuento));
                }
                break;
            case 2:
                break;
            default:
                System.out.println("<!- La opción introducida no es válida -!>");
                break;
        }
    }
}
