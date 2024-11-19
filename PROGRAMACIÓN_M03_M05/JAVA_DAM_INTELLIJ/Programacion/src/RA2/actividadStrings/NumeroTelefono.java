package RA2.actividadStrings;

/*13. Se leerá un número de teléfono en formato cadena, y se debe convertir de la
siguiente manera:
Número recibido: 34644683430
Nueva cadena: (+34) 644 683 430*/

import java.util.Scanner;

public class NumeroTelefono {
    private static final Scanner leer = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("<- Introduce tu número de telefono con prefijo, todo junto->");
        String numero = leer.next();

        String numeroNoPrefijo = "", prefijo = "";
        int cantidadNumeros = 0;

        for (int i = numero.length() - 1; i >= 0; i--)
        {
            cantidadNumeros++;

            if (cantidadNumeros == 9)
            {
                numeroNoPrefijo = numero.substring(numero.length() - cantidadNumeros);

                for (int j = 0; j < numero.length() - cantidadNumeros; j++)
                {
                    prefijo += numero.charAt(j);
                }
                break;
            }
        }

        System.out.print("(+" + prefijo + ") ");

        int contador = 0;

        for (int i = 0; i < numeroNoPrefijo.length() / 3; i++)
        {
            String trioNums = "";

            for (int j = 0; j < 3; j++)
            {
                trioNums += numeroNoPrefijo.charAt(contador);
                contador++;
            }
            System.out.print(trioNums + " ");
            trioNums = "";
        }
    }
}
