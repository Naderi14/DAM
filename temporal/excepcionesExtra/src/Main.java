import exceptions.AsientosInsuficientesException;
import exceptions.NumeroInvalidoException;

import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        boolean isExit = false;
        int asientosDisponibles = 10;

        while (!isExit && asientosDisponibles > 0)
        {
            try
            {
                if (menuPrograma(asientosDisponibles))
                {
                    isExit = true;
                    continue;
                }
                asientosDisponibles -= reservarAsientos(asientosDisponibles);
            }
            catch (NumeroInvalidoException | AsientosInsuficientesException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }

    private static boolean menuPrograma(int asientosDisponibles) throws AsientosInsuficientesException, NumeroInvalidoException
    {
        if (asientosDisponibles > 0)
        {
            System.out.println("Elija la opción:\n1. Reservar Asientos\n2. Salir");
            int opcion = sc.nextInt();

            if (opcion == 1)
            {

            }
            else if (opcion == 2)
            {
                System.out.println("Hasta la próxima");
                return true;
            }
            else
            {
                throw new NumeroInvalidoException("Número de opción inválido");
            }
        }
        else
        {
            System.out.println("Todos los asientos ya estan reservados, hasta la próxima");
            return true;
        }

        return false;
    }

    private static int reservarAsientos(int asientosDisponibles) throws AsientosInsuficientesException, NumeroInvalidoException
    {
        System.out.println("\nCuantos desea reservar?\t\tDisponibles [" + asientosDisponibles + "]");
        int reservados = sc.nextInt();

        if (reservados > 0)
            if (reservados > asientosDisponibles)
                throw new AsientosInsuficientesException("Insuficientes asientos para la reserva");
            else
            {
                System.out.println("\n<- Asientos reservados correctamente ->\n");
                return reservados;
            }
        else
            throw new NumeroInvalidoException("Número de reserva inválido");
    }
}