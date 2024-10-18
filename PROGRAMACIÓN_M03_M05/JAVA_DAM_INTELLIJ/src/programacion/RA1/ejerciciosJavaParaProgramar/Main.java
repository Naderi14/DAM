package programacion.RA1.ejerciciosJavaParaProgramar;

import java.util.Scanner;

public class Main {
    private static Scanner leer = new Scanner(System.in);
    public static void main(String[] args)
    {
        System.out.println("Introduce el número de ejercicio");
        int opcion = leer.nextInt();

        switch (opcion)
        {
            case 1:
                Ejercicio1.main(args);
                break;
            case 2:
                Ejercicio2.main(args);
                break;
            case 3:
                Ejercicio3.main(args);
                break;
            case 4:
                Ejercicio4.main(args);
                break;
            case 5:
                Ejercicio5.main(args);
                break;
            case 6:
                Ejercicio6.main(args);
                break;
            case 7:
                Ejercicio7.main(args);
                break;
            case 8:
                Ejercicio8.main(args);
                break;
            case 9:
                Ejercicio9.main(args);
                break;
        }
    }
}
