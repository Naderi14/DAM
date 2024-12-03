package dungeonGame;

import java.util.Random;

public class Monster {
    private int posX, posY;
    private char symbol = 'M';

    public Monster(int x, int y)
    {
        this.posX = x;
        this.posY = y;
    }

    public int getPosX()
    {
        return posX;
    }

    public int getPosY()
    {
        return posY;
    }

    public void move(char[][] mapa)
    {
        Random random = new Random();
        int x = 0, y = 0;
        boolean isAvailableToMove = false;

        while(!isAvailableToMove)
        {
            int vectorDirection = random.nextInt(4) + 1;

            switch (vectorDirection)
            {
                case 1: // Arriba
                    y = -1;
                    break;
                case 2: // Izquierda
                    x = -1;
                    break;
                case 3: // Abajo
                    y = 1;
                    break;
                case 4: // Derecha
                    x = 1;
                    break;
            }

            int newX = posX + x;
            int newY = posY + y;

            if (newX >= 0 && newX < mapa[0].length && newY >= 0 && newY < mapa.length)
            {
                if (mapa[newY][newX] == '.' || mapa[newY][newX] == 'S')
                {
                    isAvailableToMove = true;
                    mapa[posY][posX] = '.';
                    posX = newX;
                    posY = newY;
                    mapa[posY][posX] = symbol;
                }
            }
        }
    }
}
