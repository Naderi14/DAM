package entornosDesarrollo.RA1.refactorization.actividadesRefactor;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Juego5Opciones {
    private static final Scanner leer = new Scanner(System.in);
    private static Random random = new Random();
    private static boolean turnoOponente = true;
    private static int manoOponente, manoJugador = 0, vidasJugador = 3, vidasOponente = 3;

    public static void main(String[] args)
    {
        init();
        menu();
        seleccionMano();
    }

    private static void init()
    {
        System.out.println("**********************************************************************\n" +
                "* ROCK PAPER SCISSORS LIZARD SPOCK                    © Joan Sèculi  *\n" +
                "*                                                                    *\n" +
                "* An extension of the children's game of rock paper scissors,        *\n" +
                "* with two additional handshapes: lizard and Spock.                  *\n" +
                "* Rules: Scissors cuts paper                                         *\n" +
                "*        Paper covers rock                                           *\n" +
                "*        Rock crushes lizard                                         *\n" +
                "*        Lizard poisons Spock                                        *\n" +
                "*        Spock smashes scissors                                      *\n" +
                "*        Scissors decapitates lizard                                 *\n" +
                "*        Lizard eats paper                                           *\n" +
                "*        Paper disproves Spock                                       *\n" +
                "*        Spock vaporizes rock                                        *\n" +
                "*        and as it always has, rock crushes scissors.                *\n" +
                "**********************************************************************");
    }

    private static void menu()
    {
        System.out.println("1. Piedra | 2. Papel | 3. Tijeras | 4. Lagartija | 5. Spock");
    }

    private static byte seleccionMano()
    {
        System.out.println("Elije la opción");

        return leer.nextByte();
    }

    public static byte getRPSLS()
    {
        return 0;
    }
}
