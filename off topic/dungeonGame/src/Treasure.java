public class Treasure {
    private int posX, posY, value;

    public Treasure(int x, int y, int value)
    {
        this.posX = x;
        this.posY = y;
        this.value = value;
    }

    public int getPosX()
    {
        return posX;
    }

    public int getPosY()
    {
        return posY;
    }

    public int getValue()
    {
        return value;
    }
}
