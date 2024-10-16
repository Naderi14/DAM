import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio3 {
    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        int sumaTotal = 0, numero, contadorImpares = 0, contadorPares = 0;
        double promedio = 0;

        System.out.println("Introduzca 10 números a continuación");

        for (int i = 0; i < 10; i++) {
            System.out.println("Numero " + (i+1));
            numero = leer.nextInt();
            sumaTotal += numero;

            if (numero % 2 == 0)
                contadorPares++;

            else
            {
                contadorImpares++;
                promedio += numero;
            }
        }
        promedio /= (double) contadorImpares;

        System.out.println("\nCantidad números Pares: " + contadorPares );
        System.out.println("Suma Total de todos los números: " + sumaTotal);
        System.out.println("Promedio de todos los impares: " + promedio);
    }
}
