package vehicle;

import vehicle.interfaces.Movable;
import vehicle.interfaces.Refillable;
import vehicle.interfaces.Repairable;

public class Moto extends Vehicle implements Repairable, Refillable {
    private int petrol;

    public Moto(int posX, int posY, int money, boolean available) {
        super(posX, posY, money, available);
        this.petrol = Refillable.MOTO;
    }

    @Override
    public boolean move(char pos) {
        if (petrol >= Movable.MOTO_CONSUM && isAvailable())
        {
            if (pos == 'x')
                setPosX(getPosX() + Movable.MOTO);
            else if (pos == 'y')
                setPosY(getPosY() + Movable.MOTO);

            petrol -= Movable.MOTO_CONSUM;
            return true;
        }

        return false;
    }

    @Override
    public boolean repair() {
        if (!isAvailable() && getMoney() >= Repairable.MOTO)
        {
            setAvailable(true);
            setMoney(getMoney() - Repairable.MOTO);
            return true;
        }

        return false;
    }

    @Override
    public boolean refill() {
        if ((isAvailable() && petrol < Refillable.MOTO) && getMoney() > Refillable.MOTO - petrol)
        {
            setMoney(getMoney() - (Refillable.MOTO - petrol));
            petrol = Refillable.MOTO;
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
        return String.format("Moto: petrol=%s, pos=[%s, %s], $=%s, available=%s",
                petrol, getPosX(), getPosY(), getMoney(), isAvailable());
    }
}
