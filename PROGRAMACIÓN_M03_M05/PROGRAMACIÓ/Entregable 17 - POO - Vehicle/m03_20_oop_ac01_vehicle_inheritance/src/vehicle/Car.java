package vehicle;

public class Car extends Vehicle{
    protected byte numSeats;
    protected byte numDoors;
    protected String fuelType;

    public Car(String registration, String model, String make, byte numSeats, byte numDoors, String fuelType) {
        super(registration, model, make);
        this.numSeats = numSeats;
        this.numDoors = numDoors;
        this.fuelType = fuelType;
    }

    @Override
    public double weight()
    {
        return numSeats * numDoors * super.weight();
    }

    public boolean has4Doors()
    {
        return numDoors == 4;
    }

    @Override
    public String toString()
    {
        return String.format("Car: " + super.toStringBase() + "|Seats: %-5s|Doors: %-5s|Fuel: %-10s",
                numSeats, numDoors, fuelType);
    }

    @Override
    public String toStringBase()
    {
        return String.format(super.toStringBase() + "|Seats: %-5s|Doors: %-5s|Fuel: %-10s",
                numSeats, numDoors, fuelType);
    }

    @Override
    public String toStringOnlyThis()
    {
        return String.format("Seats: %-5s|Doors: %-5s|Fuel: %-10s",
                numSeats, numDoors, fuelType);
    }

    public byte getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(byte numSeats) {
        this.numSeats = numSeats;
    }

    public byte getNumDoors() {
        return numDoors;
    }

    public void setNumDoors(byte numDoors) {
        this.numDoors = numDoors;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
}
