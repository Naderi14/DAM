package dungeonGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Dungeon {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    private static List<Monster> monsterList = new ArrayList<>();
    private static List<Treasure> treasureList = new ArrayList<>();

    private static int posJugadorX, posJugadorY;
    private static int posEscapeX, posEscapeY;
    private static int scoreTotal = 0;

    private static boolean isEnd = false;
    private static boolean isMapLoaded = false;

    /*private static char[][] mapa = {    // Dibujamos el mapa de forma manual por ahora
            {'S', '.', '.', 'T'},
            {'.', '.', 'M', '.'},
            {'.', '.', '.', 'E'}
    };*/

    private static char[][] mapa = {            // Un mapa un poco mas grande
            {'S', '.', 'T', '.', '.', '.', 'T', '.', '.', '.'},
            {'.', '.', '.', '.', 'M', '.', '.', '.', 'T', '.'},
            {'.', '.', 'T', '.', '.', '.', '.', '.', '.', '.'},
            {'M', '.', '.', '.', '.', '.', '.', '.', '.', 'T'},
            {'.', '.', '.', 'T', '.', 'M', '.', 'M', '.', '.'},
            {'.', '.', 'T', '.', '.', '.', '.', '.', '.', 'E'},
            {'.', '.', '.', '.', '.', '.', 'M', '.', '.', '.'}
    };

    public static void main(String[] args)
    {
        while (!isEnd)
        {
            actualizarMapa();
            menuJuego();
            moverEnemigos();
            verifyCollisionPlayerMonster();
            verifyFoundedTreasure();
            verifyFindEscapeDungeon();
            mapa[posJugadorY][posJugadorX] = 'S';
        }
    }

    private static void menuJuego()
    {
        boolean isAvailableMove = false;
        char letra;
        System.out.println("S - Jugador / T - Tesoro / M - Monstruo / E - Escape\n(W) arriba | (A) izquierda | (S) abajo | (D) derecha            Score: " + scoreTotal);

        while (!isAvailableMove)
        {
            letra = scanner.next().toUpperCase().charAt(0);

            switch (letra)
            {
                case 'W':
                    if (posJugadorY - 1 < 0)
                        System.out.println("<- No es posible moverse a esa casilla ->");
                    else
                    {
                        updatePlayerPos('y', -1);
                        isAvailableMove = true;
                    }
                        break;
                case 'A':
                    if (posJugadorX - 1 < 0)
                        System.out.println("<- No es posible moverse a esa casilla ->");
                    else
                    {
                        updatePlayerPos('x', -1);
                        isAvailableMove = true;
                    }
                    break;
                case 'S':
                    if (posJugadorY + 1 >= mapa.length)
                        System.out.println("<- No es posible moverse a esa casilla ->");
                    else
                    {
                        updatePlayerPos('y', 1);
                        isAvailableMove = true;
                    }
                    break;
                case 'D':
                    if (posJugadorX + 1 >= mapa[0].length)
                        System.out.println("<- No es posible moverse a esa casilla ->");
                    else
                    {
                        updatePlayerPos('x', 1);
                        isAvailableMove = true;
                    }
                    break;
                default:
                    System.out.println("<- No se corresponde con ningún movimiento ->");
                    break;
            }
        }
    }

    private static void updatePlayerPos(char coordenada, int move)
    {
        if (coordenada == 'x')
        {
            mapa[posJugadorY][posJugadorX] = '.';
            posJugadorX += move;
            mapa[posJugadorY][posJugadorX] = 'S';
        }
        else
        {
            mapa[posJugadorY][posJugadorX] = '.';
            posJugadorY += move;
            mapa[posJugadorY][posJugadorX] = 'S';
        }
    }

    private static void moverEnemigos()
    {
        for (Monster monster : monsterList)
        {
            monster.move(mapa);
        }
    }

    private static void actualizarMapa()
    {
        if (isMapLoaded)
        {
            for (int i = 0; i < mapa.length; i++)
            {
                for (int j = 0; j < mapa[i].length; j++)
                {
                    System.out.print(mapa[i][j] + "  ");
                }
                System.out.println();
            }
        }
        else
        {
            for (int i = 0; i < mapa.length; i++)
            {
                for (int j = 0; j < mapa[i].length; j++)
                {
                    System.out.print(mapa[i][j] + "  ");
                    if (mapa[i][j] == 'S')
                    {
                        posJugadorX = j;
                        posJugadorY = i;
                    }
                    else if (mapa[i][j] == 'M')
                    {
                        monsterList.add(new Monster(j, i));
                    }
                    else if (mapa[i][j] == 'T')
                    {
                        treasureList.add(new Treasure(j, i, random.nextInt(10) + 1));
                    }
                    else if (mapa[i][j] == 'E')
                    {
                        posEscapeX = j;
                        posEscapeY = i;
                    }
                }
                System.out.println();
            }
            isMapLoaded = true;
        }
    }

    private static void verifyCollisionPlayerMonster()
    {
        for (Monster monster : monsterList)
        {
            if (monster.getPosY() == posJugadorY && monster.getPosX() == posJugadorX)
            {
                System.out.println("<!- HAS DERROTADO POR UN MONSTRUO -!>");
                isEnd = true;
                break;
            }
        }
    }

    private static void verifyFoundedTreasure()
    {
        for (Treasure treasure : treasureList)
        {
            if (treasure.getPosY() == posJugadorY && treasure.getPosX() == posJugadorX)
            {
                System.out.println("<- Tesoro encontrado de " + treasure.getValue() + " score ->");
                scoreTotal += treasure.getValue();
            }
        }
    }

    private static void verifyFindEscapeDungeon()
    {
        if (posJugadorY == posEscapeY && posJugadorX == posEscapeX)
        {
            System.out.println("<!- Has escapado de la mazmorra con " + scoreTotal + " score -!>\n <------- FELICIDADES MI BUBU ------->");
            isEnd = true;
        }
    }
}
