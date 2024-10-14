import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio2 {
    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        int minimo = Integer.MAX_VALUE, maximo = Integer.MIN_VALUE, numero, suma = 0;
        double media;

        ArrayList<Integer> listaNumeros = new ArrayList<>();

        System.out.println("Se le pedirán numeros hasta que introduzca un 0. Posteriormente le pasaremos los resultados\n");

        do{
            System.out.println("Introduce número");
            numero = leer.nextInt();

            if (numero == 0)
                break;

            if (numero > maximo)
                maximo = numero;

            if (numero < minimo)
                minimo = numero;

            listaNumeros.add(numero);

        } while (true); // Saldrá cuando haya un numero == 0

        for (int numeros : listaNumeros)
        {
            suma += numeros;
        }

        media = (double) suma / listaNumeros.size();

        System.out.println("Máximo: " + maximo + "  | Mínimo: " + minimo);
        System.out.println("Media total: " + media);
    }
}
