package vehicle;

import vehicle.interfaces.Movable;
import vehicle.interfaces.Refillable;
import vehicle.interfaces.Repairable;

public class Car extends Vehicle implements Repairable, Refillable {
    private int petrol;

    public Car(int posX, int posY, int money, boolean available) {
        super(posX, posY, money, available);
        this.petrol = Refillable.CAR;
    }

    @Override
    public boolean move(char pos) {
       if (petrol >= Movable.CAR_CONSUM && isAvailable())
       {
           if (pos == 'x')
               setPosX(getPosX() + Movable.CAR);
           else if (pos == 'y')
               setPosY(getPosY() + Movable.CAR);

           petrol -= Movable.CAR_CONSUM;
           return true;
       }

       return false;
    }

    @Override
    public boolean repair() {
        if (!isAvailable() && getMoney() >= Repairable.CAR)
        {
            setAvailable(true);
            setMoney(getMoney() - Repairable.CAR);
            return true;
        }

        return false;
    }

    @Override
    public boolean refill() {
        if ((isAvailable() && petrol < Refillable.CAR) && getMoney() > Refillable.CAR - petrol)
        {
            setMoney(getMoney() - (Refillable.CAR - petrol));
            petrol = Refillable.CAR;
            return true;
        }

        return false;
    }

    public int getPetrol() {
        return petrol;
    }

    public void setPetrol(int petrol) {
        this.petrol = petrol;
    }

    @Override
    public String toString()
    {
        return String.format("Car: petrol=%s, pos=[%s, %s], $=%s, available=%s",
                petrol, getPosX(), getPosY(), getMoney(), isAvailable());
    }
}
