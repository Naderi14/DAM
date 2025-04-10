package vehicle;

import vehicle.interfaces.Movable;
import vehicle.interfaces.Repairable;

public class Bike extends Vehicle implements Repairable {
    public Bike(int posX, int posY, int money, boolean available) {
        super(posX, posY, money, available);
    }

    @Override
    public boolean move(char pos) {
        if (isAvailable())
        {
            if (pos == 'x')
                setPosX(getPosX() + Movable.CAR);
            else if (pos == 'y')
                setPosY(getPosY() + Movable.CAR);

            return true;
        }

        return false;
    }

    @Override
    public boolean repair() {
        if (!isAvailable() && getMoney() >= Repairable.BIKE)
        {
            setAvailable(true);
            setMoney(getMoney() - Repairable.BIKE);
            return true;
        }

        return false;
    }

    @Override
    public String toString()
    {
        return String.format("Bike: pos=[%s, %s], $=%s, available=%s",
                getPosX(), getPosY(), getMoney(), isAvailable());
    }
}
