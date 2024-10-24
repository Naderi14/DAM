package ejerciciosJava2;

import java.util.Scanner;

public class CalcularAreaPerimetro {
    private static Scanner leer = new Scanner(System.in);

    /*Calcula el perímetro y el área de un círculo dado su radio (introducido por teclado),
deberás preguntar primero qué cálculo se desea realizar. Dependiendo de la petición
del usuario, muestra por consola el aria o el perímetro. Si el usuario no entra un
número, se mostrará el mensaje "This is not a number".*/
    public static void main(String[] args)
    {
        System.out.println("<- Introduce el radio en decimales si lo deseas ->");
        double radio = leer.nextDouble();

        System.out.println("<- Elija el cáculo (introducir número) ->\n1. Calcular ÁREA\n2. Calcular PERÍMETRO");

        int opcion = leer.nextInt();
        if (opcion == 1)
        {
            System.out.println("Área círculo: " + ((radio * radio) * Math.PI));
        }
        else if (opcion == 2)
        {
            System.out.println("Área perímetro: " + (radio * Math.PI * 2));
        }
        else
        {
            System.out.println("<!- La opción introducida esta fuera de rango -!>");
        }
    }
}