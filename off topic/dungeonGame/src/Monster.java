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
        boolean isAvailableMove = false;

        while(!isAvailableMove)
        {
            int tempX = 0, tempY = 0;
            int vectorDirection = random.nextInt(4) + 1;

            switch (vectorDirection)
            {
                case 1: // Arriba
                    tempY = -1;
                    break;
                case 2: // Izquierda
                    tempX = -1;
                    break;
                case 3: // Abajo
                    tempY = 1;
                    break;
                case 4: // Derecha
                    tempX = 1;
                    break;
            }

            int newX = posX + tempX;
            int newY = posY + tempY;

            if (newX >= 0 && newX < mapa[0].length && newY >= 0 && newY < mapa.length)
            {
                if (mapa[newY][newX] == ' ' || mapa[newY][newX] == 'S')
                {
                    mapa[posY][posX] = ' ';
                    posX = newX;
                    posY = newY;
                    mapa[posY][posX] = symbol;
                    isAvailableMove = true;
                }
            }
        }
    }
}