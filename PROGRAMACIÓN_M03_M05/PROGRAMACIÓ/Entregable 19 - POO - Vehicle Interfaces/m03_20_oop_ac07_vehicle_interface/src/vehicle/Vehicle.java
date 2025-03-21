package vehicle;

import vehicle.interfaces.Movable;

public abstract class Vehicle implements Movable {
    private int posX;
    private int posY;
    private int money;
    private boolean available;

    public Vehicle(int posX, int posY, int money, boolean available) {
        this.posX = posX;
        this.posY = posY;
        this.money = money;
        this.available = available;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public boolean collision()
    {
        if (available)
        {
            available = false;
            return true;
        }
        return false;
    }
}
