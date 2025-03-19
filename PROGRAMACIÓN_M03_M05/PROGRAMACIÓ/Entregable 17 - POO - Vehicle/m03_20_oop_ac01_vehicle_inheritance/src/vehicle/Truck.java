package vehicle;

public class Truck extends Car{
    protected int maxLoad;
    protected boolean hasFridge;

    public Truck(String registration, String model, String make, byte numSeats, byte numDoors, String fuelType, int maxLoad, boolean hasFridge) {
        super(registration, model, make, numSeats, numDoors, fuelType);
        this.maxLoad = maxLoad;
        this.hasFridge = hasFridge;
    }

    @Override
    public String toString()
    {
        return String.format("Truck: " + super.toStringBase() + "|MaxLoad: %-8s |Fridge: %s",
                maxLoad, hasFridge);
    }

    @Override
    public String toStringOnlyThis()
    {
        return String.format("MaxLoad: %-8s |Fridge: %s",
                maxLoad, hasFridge);
    }

    public int getMaxLoad() {
        return maxLoad;
    }

    public void setMaxLoad(int maxLoad) {
        this.maxLoad = maxLoad;
    }

    public boolean isHasFridge() {
        return hasFridge;
    }

    public void setHasFridge(boolean hasFridge) {
        this.hasFridge = hasFridge;
    }
}
