package RA1;

import java.util.Scanner;

public class PracticaEjercicios {
    private static Scanner leer = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("Introduce el num de ejercicio 1-9");
        int opcion = leer.nextInt();
        switch (opcion)
        {
            case 1:
                ejercicio1();
                break;
            case 2:
                ejercicio2();
                break;
            case 3:
                ejercicio3();
                break;
            case 4:
                ejercicio4();
                break;
            case 5:
                ejercicio5();
                break;
            case 6:
                ejercicio6();
                break;
            case 7:
                ejercicio7();
                break;
            case 8:
                ejercicio8();
                break;
            case 9:
                ejercicio9();
                break;
        }
    }

    /*Desarrolla un algoritmo que calcule la suma de los múltiplos de 5 entre 1 y 100. El programa
debe imprimir los múltiplos y la suma.*/
    public static void ejercicio1()
    {
        int sumaTotal = 0;

        System.out.print("Múltiplo: ");
        for (int i = 0; i <= 100; i += 5)
        {
            System.out.print(i + ", ");
            sumaTotal += i;
        }

        System.out.println("\nSuma total múltiplos de cinco: " + sumaTotal);
    }

    /*Desarrolla un algoritmo que dada la velocidad de un coche en km por hora (km/hora), la
convierta a metros por segundo(m/s).*/
    public static void ejercicio2()
    {
        System.out.println("Que velocidad tiene el coche? (km/h)");

        int velocidad = leer.nextInt();
        double velocidadConvertida;

        velocidadConvertida = (double) ((velocidad * 1000) / 60) / 60;

        System.out.println("Velocidad en metros por segundo: " + velocidadConvertida);
    }

    /*Dado un número de días , pedidos por pantalla, ¿A cuántos días, meses, años corresponde?
Por ejemplo: Dados 366 días, la solución es 1 año y 1 día.*/
    public static void ejercicio3()
    {
        System.out.println("Introduce una cantidad de dias");

        int years = 0, months = 0, days = 0;

        days = leer.nextInt();

        years = days / 365;
        days %= 365;
        months = days / 30;
        days %= 30;

        for (int i = 0; i < years; i++)
        {
            days--;

            if (days <= 0)
            {
                months--;
                days = 29;
            }
        }

        System.out.println("Años: " + years + " | Meses: " + months + " | Dias: " + days);
    }

    /*Una ONG tiene puntos de reparto de vacunas que se pretende funcionen de la siguiente
manera. Cada día, empezar con 1000 vacunas disponibles y a través de un programa que
controla las entregas avisar si el inventario baja de 200 unidades. Desarrollar pseudocódigo y
diagrama de flujo.*/
    public static void ejercicio4()
    {
        int vacunas = 1000, dia = 1, gastoDiario;
        while (vacunas > 0)
        {
            System.out.println("\nDia: " + dia + "   |  Vacunas Restantes: " + vacunas);
            System.out.println("Repartir número de vacunas: ");
            gastoDiario = leer.nextInt();

            dia++;

            vacunas -= gastoDiario;
            if (vacunas < 200)
            {
                if (vacunas <= 0)
                    break;

                System.out.println("\n<!-- [ALERTA] Las vacunas están por debajo de 200 unidades --!>\n");
            }
        }

        System.out.println("\n<!-- [ALERTA] Se han agotado las vacunas --!>");
    }

    /*Desarrolle un algoritmo que funcione como caja registradora.*/
    public static void ejercicio5()
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
                System.out.println("\n\n $$ CACHING! $$\nTotal Factura: " + totalCompra + "€");
                break;
            }
        }
    }

    /*Desarrolla un algoritmo que permita leer tres valores y almacenarlos en las variables A, B y C.
El algoritmo debe imprimir cual es el mayor cuál es el menor. Los valores deben ser distintos,
en el caso de que no lo sean imprime un mensaje de error.*/
    public static void ejercicio6()
    {
        int variableA, variableB, variableC;

        System.out.println("Introduce 3 números");
        variableA = leer.nextInt();
        variableB = leer.nextInt();
        variableC = leer.nextInt();

        if (variableA == variableB || variableB == variableC || variableC == variableA)
            System.out.println("Ha petao, 2 valores almenos son iguales");
        else
        {
            if (variableA > variableB && variableA > variableC)
            {
                System.out.println(variableA + " es mayor");
                if (variableB < variableC)
                    System.out.println(variableB + " es menor");
                else
                    System.out.println(variableC + " es menor");
            }
            else if (variableB > variableC)
            {
                System.out.println(variableB + " es mayor");
                if (variableA < variableC)
                    System.out.println(variableA + " es menor");
                else
                    System.out.println(variableC + " es menor");
            }
            else
            {
                System.out.println(variableC + " es mayor");
                if (variableA < variableB)
                    System.out.println(variableA + " es menor");
                else
                    System.out.println(variableB + " es menor");
            }
        }
    }

    /*Desarrolle un algoritmo que realice la suma de los números enteros comprendidos entre el 1
y el 10.*/
    public static void ejercicio7()
    {
        int sumaTotal = 0;

        for (int i = 1; i <= 10; i++)
        {
            sumaTotal += i;
        }

        System.out.println("Suma total, números enteros del 1 - 10: " + sumaTotal);
    }

    /*Desarrolle un algoritmo que permite calcular la media de notas, finaliza cuando la ultima nota
es un 0.*/
    public static void ejercicio8()
    {
        int nota, contadorNotas = 0;
        double mediaNotas = 0;

        do{
            System.out.println("Introduce nota: ");
            nota = leer.nextInt();

            if (nota == 0)
                break;

            if (nota > 0 && nota <= 10)
            {
                mediaNotas += (double) nota;
                contadorNotas++;
            }
            else
            {
                System.out.println("La nota ha de ser de 1 a 10");
            }
        } while (true);

        mediaNotas /= contadorNotas;

        System.out.println("Media total de las notas: " + mediaNotas);
    }

    /*Lee por pantalla dos números, luego muéstrale al usuario el siguiente menú:
a. Suma
b. Resta
c. Multiplicación
d. División
De acuerdo a la opción ingresada el usuario realiza la operación correspondiente con los
números introducidos y se muestra el resultado por pantalla.*/
    public static void ejercicio9()
    {
        System.out.println("Introduce 2 números");
        double numero1 = leer.nextDouble();
        double numero2 = leer.nextDouble();

        System.out.println("Selecciona la opción para calcular\n1. Sumar\n2. Restar\n3. Multiplicar\n4. Dividir\n");
        int opcion = leer.nextInt();

        switch (opcion)
        {
            case 1:
                System.out.println("Resultado Suma: " + (numero1 + numero2));
                break;
            case 2:
                System.out.println("Resultado Resta: " + (numero1 - numero2));
                break;
            case 3:
                System.out.println("Resultado Multiplicación: " + (numero1 * numero2));
                break;
            case 4:
                if (numero2 == 0)
                    System.out.println("No se puede dividir por 0");
                else
                    System.out.println("Resultado División: " + (numero1 / numero2));
                break;
            default:
                System.out.println("Opción inválida");
                break;
        }
    }
}