package controllers;

import effects.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*
* Capas de complejidad que se podrian implementar
*
* Hacer lógica de objetos usables instantaneos random al recoger tesoros:
*   - Poder atravesar un muro 1 vez
*   - El score del jugador va bajando por cada paso y se define el score por el tamaño del nivel
*       y por tanto hay un objeto que evita que no decaigan los puntos temporalmente
*
* Hacer lógica de maldiciones aleatorias al cargar el nivel:
*
* */

public class Dungeon {
    private final String BLACK = "\u001B[30m";
    private final String RED = "\u001B[31m";
    private final String GREEN = "\u001B[32m";
    private final String YELLOW = "\u001B[33m";
    private final String BLUE = "\u001B[34m";
    private final String PURPLE = "\u001B[35m";
    private final String CYAN = "\u001B[36m";
    private final String WHITE = "\u001B[37m";
    private final String RESET = "\u001B[0m";

    private final Random random = new Random();

    private static List<Monster> monsterList = new ArrayList<>();
    private static List<Treasure> treasureList = new ArrayList<>();
    private static List<Level> levelList = new ArrayList<>();

    private Player player;

    private static int scoreSaved = 0;
    private static int numNivelActual = 0;

    public int posEscapeX;
    public int posEscapeY;

    private static boolean isEnd = false;
    private static boolean isMapLoaded = false;

    private static char[][] mapa;

    public void mainDungeon()
    {
        inicializarNiveles();
        RiddleController.crearAdivinanzas();
        cargarNivel(levelList.get(numNivelActual));
        boolean isEndRound = false;

        while (!isEnd)
        {
            actualizarMapa();
            player.menuJugador();
            verifyFoundedTreasure();
            isEndRound = verifyFindEscapeDungeon();
            moverEnemigos();
            verifyCollisionPlayerMonster();
            if (!isEnd && !isEndRound)
                mapa[player.getPosY()][player.getPosX()] = 'S';   // Cerciorarse que el player no desaparezca
        }
        actualizarMapa();
    }

    private void inicializarNiveles()   // Sirve para crear los niveles disponibles en la lista de niveles
    {
        levelList.add(new Level (new char[][] {     // LVL 1
                {'S', '#', 'M', 'M'},
                {' ', '#', ' ', 'E'},
                {' ', 'T', 'M', ' '}
        }, getRandomCurse()));

        levelList.add(new Level (new char[][] {     // LVL 2
                {'S', ' ', 'E'},
                {' ', '#', ' '},
                {'T', 'M', 'M'}
        }, getRandomCurse()));

        levelList.add(new Level (new char[][] {     // LVL 3
                {'S', '#', 'E', 'M', 'T'},
                {' ', '#', '#', ' ', ' '},
                {' ', ' ', 'M', '#', ' '},
                {'T', 'M', ' ', ' ', ' '}
        }, getRandomCurse()));

        levelList.add(new Level (new char[][] {     // LVL 4
                {'S', ' ', '#', '#', '#', 'E'},
                {' ', '#', 'M', 'M', '#', ' '},
                {' ', '#', ' ', ' ', '#', ' '},
                {' ', ' ', ' ', '#', '#', ' '},
                {'T', '#', 'M', ' ', ' ', 'M'}
        }, getRandomCurse()));

        levelList.add(new Level (new char[][] {     // LVL 5
                {'S', ' ', ' ', '#', '#', ' ', ' ', ' ', 'T'},
                {'#', '#', ' ', '#', 'M', ' ', '#', 'M', ' '},
                {' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' '},
                {' ', '#', 'M', ' ', ' ', ' ', '#', 'M', 'T'},
                {'M', ' ', ' ', '#', ' ', 'M', ' ', '#', 'E'}
        }, getRandomCurse()));

        levelList.add(new Level (new char[][]{      // LVL 6
                {'S', '#', 'T', '#', ' ', ' ', 'T', ' ', ' ', ' '},
                {' ', '#', 'M', '#', 'M', ' ', ' ', ' ', 'T', ' '},
                {' ', '#', 'T', '#', ' ', ' ', '#', '#', '#', ' '},
                {' ', '#', ' ', '#', ' ', ' ', ' ', 'M', '#', ' '},
                {' ', ' ', ' ', ' ', ' ', 'M', ' ', ' ', '#', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', 'M'},
                {'M', ' ', ' ', 'M', ' ', ' ', 'M', 'T', '#', 'E'}
        }, getRandomCurse()));

        levelList.add(new Level (new char[][] {     // LVL 7
                {'S', '#', ' ', 'M', ' ', 'E'},
                {' ', '#', 'M', '#', 'M', ' '},
                {' ', '#', 'T', '#', ' ', 'M'},
                {' ', '#', ' ', '#', 'M', 'T'},
                {'M', ' ', 'M', '#', 'T', 'M'}
        }, getRandomCurse()));

        levelList.add(new Level (new char[][] {     // LVL 8
                {'S', 'T', 'T', 'T', 'T', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', 'M', ' ', ' ', ' '},
                {'#', '#', '#', '#', '#', '#', ' ', '#', ' ', 'M', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'T'},
                {' ', ' ', ' ', ' ', 'M', '#', ' ', '#', 'M', '#', '#', '#', '#', ' ', '#', '#', '#', '#'},
                {' ', '#', '#', '#', ' ', '#', ' ', '#', 'T', '#', ' ', ' ', ' ', 'M', ' ', ' ', ' ', ' '},
                {' ', ' ', 'T', '#', ' ', '#', ' ', '#', '#', '#', ' ', '#', '#', '#', '#', '#', ' ', ' '},
                {' ', ' ', ' ', '#', ' ', ' ', 'M', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#', ' ', ' '},
                {' ', 'M', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', 'M', ' ', '#', ' ', 'M'},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', 'M', ' ', ' ', ' ', ' ', 'T', 'M', 'T', '#', ' ', ' '},
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', 'M', ' ', '#', 'M', ' '},
                {' ', ' ', ' ', ' ', 'M', ' ', ' ', 'M', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' '},
                {' ', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', 'M'},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', 'M', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {'M', ' ', 'M', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                {' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', 'M', ' ', '#', ' ', '#', '#', '#', '#', ' ', ' ', '#', '#', '#', '#', 'M', 'M'},
                {'M', ' ', ' ', ' ', '#', ' ', '#', 'T', ' ', ' ', 'M', 'M', '#', 'M', 'T', '#', ' ', ' '},
                {' ', ' ', 'M', ' ', ' ', ' ', '#', '#', '#', '#', '#', '#', '#', ' ', ' ', '#', 'T', ' '},
                {'T', ' ', ' ', ' ', 'M', ' ', ' ', ' ', ' ', 'M', ' ', ' ', ' ', 'M', 'M', '#', '#', 'E'}
        }, getRandomCurse()));
    }

    private void cargarNivel(Level level)   // Cargar el nivel actual limpiando el historial del anterior en cuanto a tesoros y monstruos
    {
        monsterList.clear();
        treasureList.clear();
        mapa = level.getMapa();
        isMapLoaded = false;
    }

    private void moverEnemigos()
    {
        for (Monster monster : monsterList)
        {
            monster.planearMove(mapa);
        }

        for (Monster monster : monsterList)
        {
            monster.checkConflicts(monsterList);
        }

        for (Monster monster : monsterList)
        {
            monster.applyMove(mapa);
        }
    }

    private void actualizarMapa()
    {
        if (isMapLoaded) {
            imprimirMapaConMarco();
        } else {
            imprimirMapaConMarco();
            levelList.get(numNivelActual).aplicarEfecto(this);
            isMapLoaded = true;
        }
    }

    private void imprimirMapaConMarco() {
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

    private void inicializarElementos(int j, int i) {
        if (mapa[i][j] == 'S') {
            scoreSaved = Player.scoreTotal;
            player = new Player(i, j);
            Player.scoreTotal = scoreSaved;
        } else if (mapa[i][j] == 'M') {
            monsterList.add(new Monster(j, i));
        } else if (mapa[i][j] == 'T') {
            IEffect effect = getRandomEffect();
            treasureList.add(new Treasure(j, i, random.nextInt(10) + 1, effect));
        } else if (mapa[i][j] == 'E') {
            posEscapeX = j;
            posEscapeY = i;
        }
    }

    private void imprimirMarcoHorizontal()
    {
        System.out.print(PURPLE + "#" + RESET);
        for (int i = 0; i < mapa[0].length * 3 + 1; i++)
        {
            System.out.print(PURPLE + "#" + RESET);
        }
        System.out.println(PURPLE + "#" + RESET);
    }

    private void verifyCollisionPlayerMonster()
    {
        for (Monster monster : monsterList)
        {
            if (monster.getPosY() == player.getPosY() && monster.getPosX() == player.getPosX() && Player.getEscudos() == 0)
            {
                Scanner sc = new Scanner(System.in);
                System.out.println("\n\n\n\n<- Un monstruo te ha cazado y te propone una adivinanza para tu salvación ->\n");

                int numAdivinanza = random.nextInt(RiddleController.adivinanzas.size());
                RiddleData adivinanza = RiddleController.adivinanzas.get(numAdivinanza);
                System.out.println("|| " + adivinanza.getAdivinanza() + " ||\n" +
                        "1. " + adivinanza.getOpciones(1) + "\n" +
                        "2. " + adivinanza.getOpciones(2) + "\n" +
                        "3. " + adivinanza.getOpciones(3));

                int numRespuesta;
                do{
                    System.out.println("\n<- Opcion: ");
                    numRespuesta = sc.nextInt();
                    if (numRespuesta <= 0 || numRespuesta > 3)
                        System.out.println("<!- Opción no válida -!>");
                } while (numRespuesta <= 0 || numRespuesta > 3);

                if (adivinanza.isRespuestaCorrecta(adivinanza.getOpciones(numRespuesta)))
                {
                    System.out.println("<- CORRECTO! TE HAS SALVADO DE LA MUERTE ->\n");
                    monster.retrocederPosicion(mapa);
                }
                else
                {
                    System.out.println("<!========= INCORRECTO! HAS SIDO DERROTADO POR UN MONSTRUO =========!>");
                    isEnd = true;
                }
                break;
            }
            else if (monster.getPosY() == player.getPosY() && monster.getPosX() == player.getPosX() && Player.getEscudos() > 0)
            {
                Player.restarEscudo();
                monster.retrocederPosicion(mapa);
                System.out.println("<!- El monstruo te ha quitado 1 escudo, te quedan " + Player.getEscudos() + " escudos -!>");
            }
        }
    }

    private void verifyFoundedTreasure()
    {
        for (Treasure treasure : treasureList)
        {
            if (treasure.getPosY() == player.getPosY() && treasure.getPosX() == player.getPosX())
            {
                System.out.println("<- Tesoro encontrado de " + treasure.getValue() + " score ->");
                Player.scoreTotal += treasure.getValue();
                treasure.aplicarEfecto(this);
                treasureList.remove(treasure);
                break;
            }
        }
    }

    private boolean verifyFindEscapeDungeon()
    {
        if (player.getPosY() == posEscapeY && player.getPosX() == posEscapeX)
        {
            System.out.println("<!- Has escapado de la mazmorra con " + scoreSaved + " score -!>\n");
            numNivelActual++;
            if (numNivelActual < levelList.size())
                cargarNivel(levelList.get(numNivelActual));
            else
            {
                System.out.println("<!- HAS COMPLETADO TODOS LOS NIVELES, FELICIDADES -!> \nby Ditarex\n");
                isEnd = true;
            }
            return true;
        }
        return false;
    }

    private IEffect getRandomEffect()
    {
        int randomEffect = random.nextInt(3);
        switch (randomEffect)
        {
            case 0: return new DisappearMonsterEffect(66);
            case 1: return new AddShieldEffect(66);
            case 2: return new AcrossWallEffect(66);
            default: return null;
        }
    }

    private IEffect getRandomCurse()
    {
        int randomEffect = random.nextInt(1);
        switch (randomEffect)
        {
            case 0: return new SlowEffectCurse(66);
            default: return null;
        }
    }

    public static List<Monster> getMonsters()
    {
        return monsterList;
    }

    public static char[][] getMapa()
    {
        return mapa;
    }

    public Player getPlayer()
    {
        return player;
    }
}