package programacion.RA1.pseudoACodigo;

/*Una tienda ofrece un descuento del 15% sobre el total de la compra durante el mes
de octubre. Dado un mes y un importe, calcula cuál es la cantidad que se debe cobrar al
cliente.*/

import java.util.Scanner;

public class Ejercicio6 {
    private static Scanner leer = new Scanner(System.in);

    public static void main(String[] args)
    {
        int mesCompra;
        double totalCompra;

        while (true)
        {
            System.out.println("Introduce el mes de la compra");
            mesCompra = leer.nextInt();

            if (mesCompra <= 0 || mesCompra > 12)
            {
                System.out.println("Error: El mes de la compra no es correcto, debe ser de 1 a 12");
                continue;
            }

            break;
        }

        while (true)
        {
            System.out.println("Introduce el total de la compra");
            totalCompra = leer.nextDouble();

            if (totalCompra <= 0)
            {
                System.out.println("Error: El total no puede ser menor o igual a 0");
                continue;
            }

            break;
        }

        if (mesCompra == 10)
            totalCompra *= 0.85;

        System.out.println("Este mes pagará " + totalCompra + "€");
    }
}
