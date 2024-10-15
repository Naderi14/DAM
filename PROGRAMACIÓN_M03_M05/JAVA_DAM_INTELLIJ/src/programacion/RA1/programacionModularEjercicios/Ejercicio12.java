package programacion.RA1.programacionModularEjercicios;

/*Crea una aplicación que nos calcule el área de un círculo, cuadrado o
triangulo.

Preguntaremos al usuario de qué figura queremos calcular el área y según lo
introducido pedirá de nuevo al usuario los valores necesarios para calcular el
área.

Crea un metodo por cada figura para calcular cada área, este devolverá un
número real.

Muestra el resultado final por pantalla.
Aquí te mostramos que necesita cada figura:
- Circulo: (radio^2) * PI
- Triangulo: (base * altura) / 2
- Cuadrado: lado * lado*/

import java.util.Scanner;

public class Ejercicio12 {
    public static void areaDeTresFiguras()
    {
        Scanner leer = new Scanner(System.in);

        System.out.println("Introduce que figura quiere calcular\n 1. Circulo\n 2. Triangulo\n 3. Cuadrado");
        int opcion = leer.nextInt();

        switch (opcion)
        {
            case 1: // Circulo
                System.out.println("Introduce el valor de Radio");
                double radio = leer.nextDouble();
                System.out.println("Area Circulo: " + areaCirculo(radio));
                break;
            case 2: // Triangulo
                System.out.println("Introduce el valor de Base");
                double base = leer.nextDouble();
                System.out.println("Introduce el valor de Altura");
                double altura = leer.nextDouble();
                System.out.println("Area Circulo: " + areaTriangulo(base, altura));
                break;
            case 3: // Cuadrado
                System.out.println("Introduce el valor de Lado");
                double lado = leer.nextDouble();
                System.out.println("Area Circulo: " + areaCuadrado(lado));
                break;
            default:
                System.out.println("La opción introducida no es correcta");
                break;
        }
    }

    private static double areaCirculo(double radio)
    {
        return (Math.pow(radio, 2)) * Math.PI;
    }

    private static double areaTriangulo(double base, double altura)
    {
        return base * altura / 2;
    }

    private static double areaCuadrado(double lado)
    {
        return lado * lado;
    }
}
