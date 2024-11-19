package RA1.ejerciciosJavaParaProgramar;

import java.util.Scanner;

public class Ejercicio5 {
    private static Scanner leer = new Scanner(System.in);

    /*Desarrolle un algoritmo que funcione como caja registradora.*/
    public static void main(String[] args)
    {
        int opcion;
        double precioProducto, totalCompra = 0;

        while (true)
        {
            System.out.println("\n\n\n\nSeleccione opción\n1. Registrar producto\n2. Emitir factura");
            opcion = leer.nextInt();

            if (opcion == 1)
            {
                System.out.println("\nIntroduce precio producto a registrar: ");
                precioProducto = leer.nextDouble();

                totalCompra += precioProducto;
            }
            else
            {
                if (totalCompra <= 0)
                    System.out.println("\n\nNo hay productos con los que facturar, no hay CACHING tampoco.\n");
                else
                    System.out.println("\n\n $$ CACHING! $$\nTotal Factura: " + totalCompra + "€");

                break;
            }
        }
    }
}
