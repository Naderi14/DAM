package competition;

public class Race {
    private Car[] cars;
    private String id;
    private static int idNext;

    public Race(Car[] cars)
    {
        this.cars = cars;
        this.id = "RAC00" + idNext + "-" + cars.length;
        idNext++;
    }

    public static String getIdNext()
    {
        return "RAC00" + idNext;
    }

    public void startRace()
    {
        for (Car car : cars)
        {
            car.increasePoints((int) (Math.random() * 100) + 1);
        }
    }

    @Override
    public String toString()
    {
        String header = String.format(
                "%-10s %-13s %-12s %-8s %-8s %-5s %-4s %-4s %-4s %-5s %-20s %-12s%n",
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
