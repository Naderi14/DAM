package ejerciciosJava2;

import java.util.Scanner;

public class Main {
    private static Scanner leer = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("<- Introduce el ejercicio que desea ver ->\n1. Imprenta\n2. Calcular circulo\n3. Menu Formas Geometricas\n4. Descuento precio");
        int opcion = leer.nextInt();

        switch (opcion)
        {
            case 1:
                Imprenta.main(args);
                break;
            case 2:
                CalcularAreaPerimetro.main(args);
                break;
            case 3:
                MenuFormasGeometricas.main(args);
                break;
            case 4:
                PreciosDescuentos.main(args);
                break;
        }
    }
}