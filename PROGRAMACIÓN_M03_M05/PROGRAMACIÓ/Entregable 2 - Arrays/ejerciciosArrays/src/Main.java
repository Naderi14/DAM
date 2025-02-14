import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("<- Introduce el número de ejercicio ->\n" +
                "1.  -  MediaNumeros.main(args);\n" +
                "2.  -  MediaNumerosPosPares.main(args);\n" +
                "3.  -  MediaNotasAlumnos.main(args);\n" +
                "4.  -  Array20Pares.main(args);\n" +
                "5.  -  NumerosPositivosNegativos.main(args);\n" +
                "6.  -  MediaPositivosNegativos.main(args);\n" +
                "7.  -  AlturaMediaPersonas.main(args);\n" +
                "8.  -  SueldoAndEmpleados.main(args);\n" +
                "9.  -  Matriz3P3.main(args);\n" +
                "10. -  MatrizRandomValues.main(args);\n" +
                "11. -  SumaDeMatrices.main(args);\n" +
                "12. -  MatrizMayorMenor.main(args);\n");

        int opcion = scanner.nextInt();

        switch (opcion)
        {
            case 1:
                MediaNumeros.main(args);
                break;
            case 2:
                MediaNumerosPosPares.main(args);
                break;
            case 3:
                MediaNotasAlumnos.main(args);
                break;
            case 4:
                Array20Pares.main(args);
                break;
            case 5:
                NumerosPositivosNegativos.main(args);
                break;
            case 6:
                MediaPositivosNegativos.main(args);
                break;
            case 7:
                AlturaMediaPersonas.main(args);
                break;
            case 8:
                SueldoAndEmpleados.main(args);
                break;
            case 9:
                Matriz3P3.main(args);
                break;
            case 10:
                MatrizRandomValues.main(args);
                break;
            case 11:
                SumaDeMatrices.main(args);
                break;
            case 12:
                MatrizMayorMenor.main(args);
                break;
        }
    }
}
