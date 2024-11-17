package programacion.RA1.ejerciciosJava2;

import java.util.Scanner;

public class MenuFormasGeometricas {
    private static Scanner leer = new Scanner(System.in);

    /*Crea un programa donde se muestre el siguiente menú:
Elige una de las siguientes opciones:
1.Cuadrado
2.Pirámide
3.Gráfico 2
4.Tríangulo inverso.*/
    public static void main(String[] args)
    {
        System.out.println("<- Que figura deseas ver? ->\n1. Cuadrado\n2. Pirámide\n3. Gráfico 2\n4. Triángulo inverso");
        int opcion = leer.nextInt();

        switch (opcion)
        {
            case 1:
                for (int i = 0; i < 5; i++)
                {
                    for (int j = 0; j < 5; j++)
                    {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            case 2:
                for (int i = 0; i < 5; i++)
                {
                    for (int j = i; j >= 0; j--)
                    {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            case 3:
                for (int i = 0; i < 5; i++)
                {
                    for (int j = 0; j < 5; j++)
                    {
                        if (j == i)
                            System.out.print("*");
                        else
                            System.out.print(" ");
                    }
                    System.out.println();
                }
                break;
            case 4:
                for (int i = 0; i < 5; i++)
                {
                    for (int j = 5; j > i; j--)
                    {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            default:
                break;
        }
    }
}
