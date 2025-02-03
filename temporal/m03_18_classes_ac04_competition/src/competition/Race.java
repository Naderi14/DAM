package competition;

public class Race {
    private static final String ID_BASE = "RAC00";
    private Car[] cars;
    private String id;
    private static int idNext;

    public Race(Car[] cars)
    {
        this.cars = cars;
        this.id = ID_BASE + idNext + "-" + cars.length;
        idNext++;
    }

    public static String getIdNext()
    {
        return ID_BASE + idNext;
    }

    public void startRace()
    {
        for (Car car : cars)
        {
            car.increasePoints((int) (Math.random() * 100) + 1);
        }
    }

    public Car[] getCars()
    {
        return cars;
    }

    public void setCars(Car[] cars)
    {
        this.cars = cars;
        this.id = id.substring(0, id.length() - 1) + cars.length;
    }

    @Override
    public String toString()
    {
        String header = String.format(
                this.id +
                "\n%-10s %-13s %-12s %-8s %-8s %-5s %-4s %-4s %-4s %-5s %-20s %-12s%n",
                "ID", "BRAND", "MODEL", "YEAR", "FUEL", "CC", "D.", "W.", "S.", "P.", "DRIVER", "CODE"
        );

        String row = "";

        for (Car car : cars)
        {
            row += car.carData() + "\n";
        }

        return header + row;
    }
}
