package vehicle;

import vehicle.interfaces.Movable;
import vehicle.interfaces.Refillable;
import vehicle.interfaces.Repairable;

public class Truck extends Vehicle implements Repairable, Refillable {
    private int petrol;
    private int load;

    public Truck(int posX, int posY, int money, boolean available, int load) {
        super(posX, posY, money, available);
        this.petrol = Refillable.TRUCK;
        this.load = load;
    }

    @Override
    public boolean move(char pos) {
        if (petrol >= Movable.TRUCK_CONSUM && isAvailable())
        {
            if (pos == 'x')
                setPosX(getPosX() + Movable.TRUCK);
            else if (pos == 'y')
                setPosY(getPosY() + Movable.TRUCK);

            petrol -= Movable.TRUCK_CONSUM;
            return true;
        }

        return false;
    }

    @Override
    public boolean repair() {
        if (!isAvailable() && getMoney() >= Repairable.TRUCK)
        {
            setAvailable(true);
            setMoney(getMoney() - Repairable.TRUCK);
            return true;
        }

        return false;
    }

    @Override
    public boolean refill() {
        if ((isAvailable() && petrol < Refillable.TRUCK) && getMoney() > Refillable.TRUCK - petrol)
        {
            setMoney(getMoney() - (Refillable.TRUCK - petrol));
            petrol = Refillable.TRUCK;
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

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    @Override
    public String toString()
    {
        return String.format("Truck: petrol=%s, pos=[%s, %s], $=%s, available=%s",
                petrol, getPosX(), getPosY(), getMoney(), isAvailable());
    }
}
