package competition;

public class Car {
    private Driver driver;
    private String brand;
    private String model;
    private short year = 0;
    private Fuels fuel = Fuels.PETROL;
    private short cc;
    private byte doors;
    private byte wheels;
    private byte seats;
    private int points;
    private String id;
    private static int idNext = 0;

    public Car(Driver driver, String brand, String model, short year, Fuels fuel, short cc, byte doors, byte wheels, byte seats, int points)
    {
        this.driver = driver;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.fuel = fuel;
        this.cc = cc;
        this.doors = doors;
        this.wheels = wheels;
        this.seats = seats;
        this.points = points;
        this.id = generateId();
    }

    public Car(Driver driver, String brand, String model, short year, Fuels fuel, short cc) {
        this.driver = driver;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.fuel = fuel;
        this.cc = cc;
        this.doors = 3;
        this.wheels = 5;
        this.seats = 4;
        this.points = 0;
        this.id = generateId();
    }

    private String generateId()
    {
        String iniciales = "" + this.brand.charAt(0) + this.model.charAt(0);
        idNext++;

        return "CAR000" + idNext + iniciales.toUpperCase();
    }

    @Override
    public String toString()
    {
        // Cabecera de la tabla
        String header = String.format(
                "%-10s %-13s %-12s %-8s %-8s %-5s %-4s %-4s %-4s %-5s %-20s %-12s%n",
                "ID", "BRAND", "MODEL", "YEAR", "FUEL", "CC", "D.", "W.", "S.", "P.", "DRIVER", "CODE"
        );

        // Fila de datos
        String row = String.format(
                "%-10s %-13s %-12s %-8d %-8s %-5s %-4d %-4d %-4d %-5d %-20s %-12s",
                this.id,
                this.brand,
                this.model,
                this.year,
                this.fuel,
                this.cc,
                this.doors,
                this.wheels,
                this.seats,
                this.points,
                this.driver.getName(),
                this.driver.getId()
        );

        return header + row;
    }

    public String carData()
    {
        return String.format(
                "%-10s %-13s %-12s %-8d %-8s %-5s %-4d %-4d %-4d %-5d %-20s %-12s",
                this.id,
                this.brand,
                this.model,
                this.year,
                this.fuel,
                this.cc,
                this.doors,
                this.wheels,
                this.seats,
                this.points,
                this.driver.getName(),
                this.driver.getId()
        );
    }

    public static String getIdNext()
    {
        return "CAR000" + idNext;
    }

    public Driver getDriver()
    {
        return driver;
    }

    public void setDriver(Driver driver)
    {
        this.driver = driver;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public short getYear()
    {
        return year;
    }

    public void setYear(short year)
    {
        this.year = year;
    }

    public Fuels getFuel()
    {
        return fuel;
    }

    public void setFuel(Fuels fuel)
    {
        this.fuel = fuel;
    }

    public short getCc()
    {
        return cc;
    }

    public void setCc(short cc)
    {
        this.cc = cc;
    }

    public byte getDoors()
    {
        return doors;
    }

    public void setDoors(byte doors)
    {
        this.doors = doors;
    }

    public byte getWheels()
    {
        return wheels;
    }

    public void setWheels(byte wheels)
    {
        this.wheels = wheels;
    }

    public byte getSeats()
    {
        return seats;
    }

    public void setSeats(byte seats)
    {
        this.seats = seats;
    }

    public int getPoints()
    {
        return points;
    }

    public void setPoints(int points)
    {
        this.points = points;
    }

    public boolean increasePoints(int points)
    {
        if (points < 0)
            return false;

        this.points += points;
        return true;
    }

    public String getId()
    {
        return id;
    }
}
