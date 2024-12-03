package dungeonGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Dungeon {
    private static final Scanner scanner = new Scanner(System.in);

    private static List<Monster> monsterList = new ArrayList<>();

    private static int posJugadorX, posJugadorY;
    private static int posMonsterX, posMonsterY;
    private static int posEscapeX, posEscapeY;
    private static int posTreasureX, posTreasureY;

    private static boolean isEnd = false;
    private static boolean isMapLoaded = false;

    /*private static char[][] mapa = {    // Dibujamos el mapa de forma manual por ahora
            {'S', '.', '.', 'T'},
            {'.', '.', 'M', '.'},
            {'.', '.', '.', 'E'}
    };*/

    private static char[][] mapa = {            // Un mapa un poco mas grande
            {'S', '.', '.', '.', '.', '.', 'T', '.', '.', '.'},
            {'.', '.', '.', '.', 'M', '.', '.', '.', 'T', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'M', '.', '.', '.', '.', '.', '.', '.', '.', 'T'},
            {'.', '.', '.', '.', '.', '.', '.', 'M', '.', '.'},
            {'.', '.', 'T', '.', '.', '.', '.', '.', '.', 'E'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'}
    };

    public static void main(String[] args)
    {
        while (!isEnd)
        {
            actualizarMapa();
            menuJuego();
            moverEnemigos();
        }
    }

    private static void menuJuego()
    {
        boolean isAvailableMove = false;
        char letra;
        System.out.println("(----- Mover personaje -----)\n (W) arriba | (A) izquierda | (S) abajo | (D) derecha");

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
                        posTreasureX = j;
                        posTreasureY = i;
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
        // DEBUG mostrar las ubicaciones
        System.out.println("Posicion jugador: (" + posJugadorX + "," + posJugadorY + ")");
        /*System.out.println("Posicion monstruo: (" + posMonsterX + "," + posMonsterY + ")");
        System.out.println("Posicion tesoro: (" + posTreasureX + "," + posTreasureY + ")");
        System.out.println("Posicion escape: (" + posEscapeX + "," + posEscapeY + ")");*/
    }
}
