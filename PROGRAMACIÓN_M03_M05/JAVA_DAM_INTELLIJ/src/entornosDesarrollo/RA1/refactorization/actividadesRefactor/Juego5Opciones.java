package entornosDesarrollo.RA1.refactorization.actividadesRefactor;

import java.util.Random;
import java.util.Scanner;

public class Juego5Opciones {
    private static final Scanner leer = new Scanner(System.in);
    private static Random random = new Random();
    private static byte manoOponente, manoJugador = 0;
    private static boolean end = false;

    public static void main(String[] args)
    {

        init();
        while (!end)
        {
            menu();
            manoJugador = selectOption();
            if (manoJugador < 0 || manoJugador > 5)
                System.out.println("\n<! La opcion introducida no es válida !>\n");
            else {
                if (manoJugador == 0)
                {
                    displayBye();
                    break;
                }

                System.out.println("Player: -" + getText(manoJugador) + "-");
                manoOponente = (byte) getRPSLS();
                System.out.println("Oponente: -" + getText(manoOponente) + "-\n");
                System.out.println(winner(manoJugador, manoOponente) + "\n");

                if (menuPlayAgain() == 2)
                {
                    end = true;
                    displayBye();
                }
            }
        }
    }

    private static void init()
    {
        System.out.println("**********************************************************************\n" +
                "* ROCK PAPER SCISSORS LIZARD SPOCK                    © Juan Francisco  *\n" +
                "*                                                                       *\n" +
                "* An extension of the children's game of rock paper scissors,           *\n" +
                "* with two additional handshapes: lizard and Spock.                     *\n" +
                "* Rules: Scissors cuts paper                                            *\n" +
                "*        Paper covers rock                                              *\n" +
                "*        Rock crushes lizard                                            *\n" +
                "*        Lizard poisons Spock                                           *\n" +
                "*        Spock smashes scissors                                         *\n" +
                "*        Scissors decapitates lizard                                    *\n" +
                "*        Lizard eats paper                                              *\n" +
                "*        Paper disproves Spock                                          *\n" +
                "*        Spock vaporizes rock                                           *\n" +
                "*        and as it always has, rock crushes scissors.                   *\n" +
                "**********************************************************************");
    }

    private static void menu()
    {
        System.out.println("1. Piedra | 2. Papel | 3. Tijeras | 4. Lagartija | 5. Spock" +
                "\n0. Salir");
    }

    private static byte selectOption()
    {
        System.out.println("Elije la opción:");

        return leer.nextByte();
    }

    private static int getRPSLS()
    {
        return random.nextInt(5) + 1;
    }

    private static String getText(byte option)
    {
        String palabra = "";

        switch (option)
        {
            case 1:
                palabra = "ROCK";
                break;
            case 2:
                palabra = "PAPER";
                break;
            case 3:
                palabra = "SCISSORS";
                break;
            case 4:
                palabra = "LIZARD";
                break;
            case 5:
                palabra = "SPOCK";
                break;
        }

        return palabra;
    }

    private static String winner(byte player1, byte player2)
    {
        if (manoJugador == manoOponente)
            return "Empate!";
        else if (manoJugador == 1 && manoOponente == 3 || manoJugador == 3 && manoOponente == 2 || manoJugador == 2 && manoOponente == 1 ||
                manoJugador == 1 && manoOponente == 4 || manoJugador == 3 && manoOponente == 4 || manoJugador == 2 && manoOponente == 5 ||
                manoJugador == 4 && manoOponente == 2 || manoJugador == 4 && manoOponente == 5 || manoJugador == 5 && manoOponente == 1 ||
                manoJugador == 5 && manoOponente == 3)
        {
            return "Has ganado!";
        }
        else
        {
            return "Ha ganado el Oponente!";
        }
    }

    private static byte menuPlayAgain()
    {
        System.out.println("<- Quieres volver a jugar? ->\n   1. YES  |  2. NO");

        return leer.nextByte();
    }

    private static void displayBye()
    {
        System.out.println("<- Hasta la próxima! ->");
    }
}
