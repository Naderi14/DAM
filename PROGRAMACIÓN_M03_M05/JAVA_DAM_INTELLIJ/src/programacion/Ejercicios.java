package programacion;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/*
* 1. Crea un algoritmo que lea 3 números que darán como resultado una fecha (día,
mes, año). Comprobar que sea válida la fecha. Si no es válida, que imprima un
mensaje de error, y si es válida imprimir el mes con su nombre.
*
* 2. Crea un programa en pseudocódigo que lea números enteros hasta teclear 0, y nos
* muestre el máximo, el mínimo y la media de todos ellos. Piensa cómo debemos
* inicializar las variables.
*
* 3. Dados 10 números enteros que se ingresan por teclado, calcular cuántos de ellos
* son pares, cuánto suman ellos y el promedio de los impares.
* */

public class Ejercicios
{
    private static Scanner leer = new Scanner(System.in);

    public static void checkDateTime()  // EJERCICIO 1
    {
        int day, month, year;
        boolean bisiesto = false, isFebrero = false, mesLargo = false;

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
    }
}
