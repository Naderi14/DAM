package dungeonGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*
* Hacer lógica de objetos usables instantaneos random al recoger tesoros:
*   - Hacer desaparecer un monstruo aleatorio
*   - Poder atravesar un muro 1 vez
*   - Evitar que te mate el monstruo porque lo "esquivas" 1 vez
*   - El score del jugador va bajando por cada paso y se define el score por el tamaño del nivel
*
* Hacer lógica de maldiciones aleatorias al cargar el nivel:
*   - Maldición de lentitud: el usuario en vez de dar 1 paso por frame, es 1 paso cada 2 frames
* */

public class Dungeon {
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    public static final String RESET = "\u001B[0m";

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    private static List<Monster> monsterList = new ArrayList<>();
    private static List<Treasure> treasureList = new ArrayList<>();
    private static List<Level> levelList = new ArrayList<>();

    private static int posJugadorX, posJugadorY;
    private static int posEscapeX, posEscapeY;
    private static int scoreTotal = 0;
    private static int nivelActual = 0;

    private static boolean isEnd = false;
    private static boolean isMapLoaded = false;

    private static char[][] mapa;

    public static void main(String[] args)
    {
        inicializarNiveles();
        cargarNivel(levelList.get(nivelActual));
        while (!isEnd)
        {
            actualizarMapa();
            menuJuego();
            moverEnemigos();
            verifyCollisionPlayerMonster();
            verifyFoundedTreasure();
            verifyFindEscapeDungeon();
            if (!isEnd)
                mapa[posJugadorY][posJugadorX] = 'S';   // Cerciorarse que el player no desaparezca
        }
        actualizarMapa();
    }

    private static void inicializarNiveles()
    {
        levelList.add(new Level (new char[][] {     // LVL 1
                {'S', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'T', '#'},
                {'#', '#', '#', '#', '#', '#', ' ', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                {'#', 'T', ' ', ' ', ' ', '#', ' ', '#', 'T', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
                {'#', '#', '#', '#', ' ', '#', ' ', '#', '#', '#', ' ', '#', '#', '#', '#', '#', ' ', '#'},
                {'#', 'T', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#', ' ', '#'},
                {'#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', 'M', ' ', '#', ' ', '#'},
                {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#'},
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', 'M', ' ', '#', ' ', '#'},
                {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#'},
                {'#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#'},
                {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
                {'#', ' ', 'M', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
                {'#', ' ', 'M', ' ', '#', ' ', '#', '#', '#', '#', ' ', ' ', '#', '#', '#', '#', ' ', '#'},
                {'#', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#'},
                {'#', 'T', 'M', ' ', ' ', ' ', '#', 'T', '#', '#', '#', '#', '#', '#', 'T', '#', ' ', ' '},
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', 'E'}
        }));

        levelList.add(new Level (new char[][] {     // LVL 1
                {'S', ' ', 'E'},
                {' ', '#', ' '},
                {'T', ' ', 'M'}
        }));

        levelList.add(new Level (new char[][] {     // LVL 2
                {'S', '#', ' ', 'M'},
                {' ', '#', ' ', 'E'},
                {' ', 'T', ' ', ' '}
        }));

        levelList.add(new Level (new char[][] {     // LVL 3
                {'S', '#', 'E', 'M', 'T'},
                {' ', '#', '#', ' ', ' '},
                {' ', ' ', ' ', '#', ' '},
                {'T', ' ', ' ', ' ', ' '}
        }));

        levelList.add(new Level (new char[][] {     // LVL 4
                {'S', ' ', '#', '#', '#', 'E'},
                {' ', '#', ' ', 'M', '#', ' '},
                {' ', '#', ' ', ' ', '#', ' '},
                {' ', ' ', ' ', '#', '#', ' '},
                {'T', '#', ' ', ' ', ' ', ' '}
        }));

        levelList.add(new Level (new char[][] {     // LVL 5
                {'S', ' ', ' ', '#', '#', ' ', ' ', ' ', 'T'},
                {'#', '#', ' ', '#', ' ', ' ', '#', 'M', ' '},
                {' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' '},
                {' ', '#', 'M', ' ', ' ', ' ', '#', ' ', 'T'},
                {' ', ' ', ' ', '#', ' ', ' ', ' ', '#', 'E'}
        }));

        levelList.add(new Level (new char[][]{      // LVL 6
                {'S', '#', 'T', '#', ' ', ' ', 'T', ' ', ' ', ' '},
                {' ', '#', ' ', '#', 'M', ' ', ' ', ' ', 'T', ' '},
                {' ', '#', 'T', '#', ' ', ' ', '#', '#', '#', ' '},
                {' ', '#', ' ', '#', ' ', ' ', ' ', ' ', '#', ' '},
                {' ', ' ', ' ', 'T', ' ', 'M', ' ', ' ', '#', ' '},
                {' ', ' ', 'T', ' ', ' ', ' ', ' ', ' ', '#', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', 'M', 'T', '#', 'E'}}
        ));
    }

    private static void cargarNivel(Level level)
    {
        monsterList.clear();
        treasureList.clear();
        posJugadorY = 0;
        posJugadorX = 0;
        mapa = level.getMapa();
        isMapLoaded = false;
    }

    private static void menuJuego()
    {
        boolean isAvailableMove = false;
        char letra;
        System.out.println("S - Jugador / T - Tesoro / M - Monstruo / E - Escape\n(W) arriba | (A) izquierda | (S) abajo | (D) derecha            Score: " + scoreTotal);
        System.out.println("Posicion Jugador: (" + posJugadorY + "," + posJugadorX + ")");
        while (!isAvailableMove)
        {
            letra = scanner.next().toUpperCase().charAt(0);

            switch (letra)
            {
                case 'W':
                    if (posJugadorY - 1 < 0)
                        break;
                    else if (mapa[posJugadorY - 1][posJugadorX] == '#')
                        break;
                    else
                    {
                        updatePlayerPos('y', -1);
                        isAvailableMove = true;
                    }
                        break;
                case 'A':
                    if (posJugadorX - 1 < 0)
                        break;
                    else if (mapa[posJugadorY][posJugadorX - 1] == '#')
                        break;
                    else
                    {
                        updatePlayerPos('x', -1);
                        isAvailableMove = true;
                    }
                    break;
                case 'S':
                    if (posJugadorY + 1 >= mapa.length)
                        break;
                    else if (mapa[posJugadorY + 1][posJugadorX] == '#')
                        break;
                    else
                    {
                        updatePlayerPos('y', 1);
                        isAvailableMove = true;
                    }
                    break;
                case 'D':
                    if (posJugadorX + 1 >= mapa[0].length)
                        break;
                    else if (mapa[posJugadorY][posJugadorX + 1] == '#')
                        break;
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
            mapa[posJugadorY][posJugadorX] = ' ';
            posJugadorX += move;
            mapa[posJugadorY][posJugadorX] = 'S';
        }
        else
        {
            mapa[posJugadorY][posJugadorX] = ' ';
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
        if (isMapLoaded) {
            imprimirMapaConMarco();
        } else {
            imprimirMapaConMarco();
            isMapLoaded = true;
        }
    }

    private static void imprimirMapaConMarco() {
        imprimirMarcoHorizontal();
        for (int i = 0; i < mapa.length; i++) {
            System.out.print(PURPLE + "# " + RESET);
            for (int j = 0; j < mapa[i].length; j++) {
                if (mapa[i][j] == 'S')
                    System.out.print(GREEN + mapa[i][j] + "  " + RESET);
                else if (mapa[i][j] == 'T')
                    System.out.print(YELLOW + mapa[i][j] + "  " + RESET);
                else if (mapa[i][j] == 'M')
                    System.out.print(RED + mapa[i][j] + "  " + RESET);
                else if (mapa[i][j] == 'E')
                    System.out.print(BLUE + mapa[i][j] + "  " + RESET);
                else if (mapa[i][j] == '#')
                    System.out.print(PURPLE + mapa[i][j] + "  " + RESET);
                else
                    System.out.print(mapa[i][j] + "  ");
                if (!isMapLoaded) {
                    inicializarElementos(j, i);
                }
            }
            System.out.println(PURPLE + "#" + RESET);
        }
        imprimirMarcoHorizontal();
    }

    private static void inicializarElementos(int j, int i) {
        if (mapa[i][j] == 'S') {
            posJugadorX = j;
            posJugadorY = i;
        } else if (mapa[i][j] == 'M') {
            monsterList.add(new Monster(j, i));
        } else if (mapa[i][j] == 'T') {
            treasureList.add(new Treasure(j, i, random.nextInt(10) + 1));
        } else if (mapa[i][j] == 'E') {
            posEscapeX = j;
            posEscapeY = i;
        }
    }

    private static void imprimirMarcoHorizontal()
    {
        System.out.print(PURPLE + "#" + RESET);
        for (int i = 0; i < mapa[0].length * 3 + 1; i++)
        {
            System.out.print(PURPLE + "#" + RESET);
        }
        System.out.println(PURPLE + "#" + RESET);
    }

    private static void verifyCollisionPlayerMonster()
    {
        for (Monster monster : monsterList)
        {
            if (monster.getPosY() == posJugadorY && monster.getPosX() == posJugadorX)
            {
                System.out.println("<!========= HAS SIDO DERROTADO POR UN MONSTRUO =========!>");
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
            System.out.println("<!- Has escapado de la mazmorra con " + scoreTotal + " score -!>\n");
            nivelActual++;
            if (nivelActual < levelList.size())
                cargarNivel(levelList.get(nivelActual));
            else
            {
                System.out.println("<!- HAS COMPLETADO TODOS LOS NIVELES, FELICIDADES -!> \nby Ditarex\n");
                isEnd = true;
            }
        }
    }
}