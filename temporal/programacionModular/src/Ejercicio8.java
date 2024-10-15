package programacion.RA1.programacionModularEjercicios;

/*Crea una aplicación que nos convierta una cantidad de euros introducida
por teclado a otra moneda, estas pueden ser a dólares, yenes o libras. El
metodo tendrá como parámetros, la cantidad de euros y la moneda a
pasar que será una cadena, este no devolverá ningún valor, mostrará un
mensaje indicando el cambio (void).
El cambio de divisas es:

0.86 libras es un 1 €
1.28611 $ es un 1 €
129.852 yenes es un 1 €*/

import java.util.Scanner;

public class Ejercicio8 {
    public static void cambioDeDivisa()
    {
        Scanner leer = new Scanner(System.in);

        double euros;
        String divisa;

        while (true)
        {
            System.out.println("EX8: Introduzca la cantidad de euros que desea intercambiar");
            euros = leer.nextDouble();

            if (euros > 0)
                break;

            System.out.println("La cantidad ha de ser superior a 0€");
        }

        while (true)
        {
            System.out.println("A que divisa desea intercambiar? (dolar / libra / yen)");
            divisa = leer.next();

            if (divisa.equals("dolar") || divisa.equals("libra") || divisa.equals("yen"))
                break;

            System.out.println("La divisa no coincide con ninguna del sistema, tenga en cuenta si introdujo mayúsculas");
        }

        calcularDivisa(euros, divisa);
    }

    private static void calcularDivisa(double cantidadEuros, String divisaNombre)
    {
        double cambio;
        if (divisaNombre.equals("dolar"))
        {
            cambio = Math.round(cantidadEuros * 1.28611);
            System.out.println(cantidadEuros + "€  ==> $" + cambio);
        }
        else if (divisaNombre.equals("libra"))
        {
            cambio = Math.round(cantidadEuros * 0.86);
            System.out.println(cantidadEuros + "€  ==> £" + cambio);
        }
        else
        {
            cambio = Math.round(cantidadEuros * 129.852);
            System.out.println(cantidadEuros + "€  ==> " + cambio + "¥");
        }

    }
}
