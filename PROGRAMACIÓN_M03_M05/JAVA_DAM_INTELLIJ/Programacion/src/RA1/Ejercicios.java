package RA1;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicios
{
    private static Scanner leer = new Scanner(System.in);

    public static void checkDateTime()  // EJERCICIO 1
    {
        int day, month, year;
        boolean bisiesto = false, isFebrero = false, mesLargo = false;
        String [] listaMeses = new String[]{"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        while (true){
            System.out.println("Introduce el AÑO");
            year = leer.nextInt();
            if (year < 0){
                System.out.println("ERROR: El AÑO no puede ser anterior a cristo\n");
                continue;
            }

            if (year % 4 == 0)
                bisiesto = true;

            break;
        }

        while (true){
            System.out.println("Introduce el MES");
            month = leer.nextInt();
            if (month <= 0 || month > 12) {
                System.out.println("ERROR: El MES introducido no es correcto\n");
                continue;
            }

            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
                mesLargo = true;
            else if (month == 2) {
                isFebrero = true;
            }
            break;
        }

        while (true){
            System.out.println("Introduce el DIA");
            day = leer.nextInt();

            if (isFebrero) {
                if (bisiesto && day > 29){
                    System.out.println("ERROR: El DIA es superior a febrero bisiesto (1 - 29)");
                    continue;
                } else if (!bisiesto && day > 28) {
                    System.out.println("ERROR: El DIA es superior a febrero (1 - 28)");
                    continue;
                }
            }

            if (day <= 0 || day > 30){
                if (mesLargo && day > 31){
                    System.out.println("ERROR: El DIA es superior al mes largo (1 - 31)");
                    continue;
                } else if (!mesLargo) {
                    System.out.println("ERROR: El DIA es superior al mes corto (1 - 30)");
                    continue;
                }
            }
            break;
        }

        if (day < 10 && month > 9)
            System.out.println("Fecha Validada: 0" + day + "/" + month + "/" + year);
        else if (day > 9 && month < 10)
            System.out.println("Fecha Validada: " + day + "/0" + month + "/" + year);
        else if (day < 10 )
            System.out.println("Fecha Validada: 0" + day + "/0" + month + "/" + year);
        else
            System.out.println("Fecha Validada: " + day + "/" + month + "/" + year);

        System.out.println(day + " de " + listaMeses[month - 1] + " del " + year);
    }

    public static void medianaNumeros() // Ejercicio 2
    {
        // Numero maximo, minimo y la mediana
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

    public static void paresSumaPromedioDeImpares() // Ejercicio 3
    {
        int promedio = 0, sumaTotal = 0;
        int[] listaNumeros = new int[10];
        ArrayList<Integer> listaImpares = new ArrayList<>();

        System.out.println("Introduzca 10 números a continuación");

        for (int i = 0; i < listaNumeros.length; i++) {
            System.out.println("Numero " + (i+1));
            listaNumeros[i] = leer.nextInt();
            sumaTotal += listaNumeros[i];
        }

        System.out.println("\nNúmeros Pares: ");

        for (int numero : listaNumeros)
        {
            if (numero % 2 == 0)
                System.out.print(numero + " ,");
            else
                listaImpares.add(numero);
        }

        for (int numero : listaImpares)
        {
            promedio += numero;
        }
        promedio /= listaImpares.size();

        System.out.println("\nSuma Total de todos los números: " + sumaTotal);
        System.out.println("Promedio de todos los impares: " + promedio);
    }

    /*3. Dados 10 números enteros que se ingresan por teclado, calcular cuántos de ellos
     son pares, cuánto suman ellos y el promedio de los impares.*/
}
