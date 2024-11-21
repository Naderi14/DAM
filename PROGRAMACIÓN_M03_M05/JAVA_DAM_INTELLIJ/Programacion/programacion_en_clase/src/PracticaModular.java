/* Dado un menu se nos ofrecen las siguientes opciones:
 * 1.Perímetro triángulo
 * 2. Área triángulo
 * 3.Salir
 * En la opción 1 crearemos una funcion llamada
 * perimetroT(double num,double num2,double num3) en la cual se recive 3 números
 * correspondientes con el valor de los lados. La funcion devuelve un double
 * que es el perímetro del triángulo.
 * Opción 2: crear una función áreaT(double base, double altura) y
 * que muestra por pantalla el área del trángulo.
 * Opción : Salir del bucle infinito.
 * */

import java.util.Scanner;

public class PracticaModular {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        int opcion;

        do     // Loop principal
        {
            opcion = getOpcion();
            switchOption(opcion);
        } while (opcion != 3);
    }

    private static int getOpcion() {
        System.out.println("<- Elije la opción del menú deseada ->" +
                "\n1. Perímetro triángulo" +
                "\n2. Área triángulo" +
                "\n3. Salir");

        return scanner.nextInt();
    }

    private static void switchOption(int opcion)
    {
        switch (opcion) {
            case 1:
                System.out.println("<- Lado 1: ");
                double lado1 = scanner.nextDouble();
                System.out.println("<- Lado 2: ");
                double lado2 = scanner.nextDouble();
                System.out.println("<- Lado 3: ");
                double lado3 = scanner.nextDouble();

                showResult(perimetroT(lado1, lado2, lado3));
                break;
            case 2:
                System.out.println("<- Base: ");
                double base = scanner.nextDouble();
                System.out.println("<- Altura: ");
                double altura = scanner.nextDouble();

                showResult(areaT(base, altura));
                break;
            case 3:
                System.out.println("<- Hasta la próxima! ->");
                break;
            default:
                System.out.println("<!- La opción no es válida -!>");
                break;
        }
    }

    private static double perimetroT(double lado1, double lado2, double lado3)
    {
        return lado1 + lado2 + lado3;
    }

    private static double areaT(double base, double altura)
    {
        return base * altura / 2;
    }

    private static void showResult(double result)
    {
        System.out.println("<< Resultado: " + result + " >>\n");
    }
}
