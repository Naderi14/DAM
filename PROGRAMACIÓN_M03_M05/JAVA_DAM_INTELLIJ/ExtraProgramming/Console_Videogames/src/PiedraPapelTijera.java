import java.util.*;

public class PiedraPapelTijera {
    static Scanner leer = new Scanner(System.in);
    static Random random = new Random();
    static boolean turnoOponente = true;
    static List<String> armas = Arrays.asList("Piedra", "Papel", "Tijeras");
    static int manoOponente, manoJugador = 0, vidasJugador = 3, vidasOponente = 3;

    public static void main(String[] args)
    {
        loopPrincipal();
    }

    private static void loopPrincipal()
    {
        while (vidasJugador > 0 && vidasOponente > 0)
        {
            System.out.flush();
            menuSeleccionMano();

            if (turnoOponente)
            {
                manoOponente = random.nextInt(2);
                enfrentamiento();
            }
        }

        finalJuego();
    }

    private static void menuSeleccionMano()
    {
        System.out.println("Vidas: " + vidasJugador + " | Vidas Oponente: " + vidasOponente);
        System.out.println("Elije --> 1. Piedra | 2. Papel | 3. Tijeras");

        manoJugador = leer.nextInt() - 1;
    }

    private static void enfrentamiento()
    {
        if (manoJugador == manoOponente)
            System.out.println("Ha sido un empate, el oponente usó " + armas.get(manoOponente));
        else if (manoJugador == 0 && manoOponente == 2 || manoJugador == 2 && manoOponente == 1 || manoJugador == 1 && manoOponente == 0)
        {
            System.out.println("Has ganado! el oponente usó " + armas.get(manoOponente));
            vidasOponente--;
        }
        else
        {
            System.out.println("Has perdido! el oponente usó " + armas.get(manoOponente));
            vidasJugador--;
        }
    }

    private static void finalJuego()
    {
        if (vidasJugador > 0)
            System.out.println("Ganaste la partida!");
        else
            System.out.println("Perdiste la partida!");
    }
}