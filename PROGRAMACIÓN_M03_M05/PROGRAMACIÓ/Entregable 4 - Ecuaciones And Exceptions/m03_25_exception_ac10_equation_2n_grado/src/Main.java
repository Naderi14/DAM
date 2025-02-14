import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        pedirNumerosParaCalcular();
        pedirNumerosParaCalcular();
        pedirNumerosParaCalcular();
        pedirNumerosParaCalcular();
        pedirNumerosParaCalcular();
    }

    public static void pedirNumerosParaCalcular()
    {
        Ecuaciones2oGrado ecuaciones2oGrado = new Ecuaciones2oGrado();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter A: ");
        double cofA = sc.nextDouble();
        System.out.println("Enter B: ");
        double cofB = sc.nextDouble();
        System.out.println("Enter C: ");
        double cofC = sc.nextDouble();

        try
        {
            double[] soluciones = ecuaciones2oGrado.roots(cofA, cofB, cofC);

            for (int i = 0; i < soluciones.length; i++)
            {
                System.out.println("Solucion " + i + ": " + soluciones[i]);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}