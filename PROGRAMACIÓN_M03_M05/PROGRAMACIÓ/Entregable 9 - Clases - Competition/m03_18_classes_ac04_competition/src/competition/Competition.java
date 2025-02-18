package competition;

import java.util.Arrays;
import java.util.Comparator;

public class Competition {
    private Car[] cars;
    private Race[] races;
    private int numRaces;

    public Competition(Car[] cars, int numRaces) {
        this.cars = cars;
        this.races = new Race[numRaces];

        for (Car car : cars)
        {
            car.setPoints(-1);
        }

        for (int i = 0; i < numRaces; i++)
        {
            this.races[i] = new Race(cars);
        }
    }

    public String startCompetition()
    {
        String header = "------------- Sart Competition -----------\n";
        String bodyRaces = "";
        for (int i = 0; i < races.length; i++)
        {
            bodyRaces += "Race: " + i + "\n";
            races[i].startRace();
            bodyRaces += races[i].toString() + "\n";
        }
        String footer = "------------ Competition Finished -----------";

        return header + bodyRaces + footer;
    }

    /*public String orderClassification()
    {
        String header = "Order Classification\nFinal Classification:\n";

        String body = "";
        int[] indexSorteds = new int[cars.length];
        boolean[] usedIndexes = new boolean[cars.length];

        for (int i = 0; i < cars.length; i++)
        {
            int majorIndex = -1;
            for (int j = 0; j < cars.length; j++)
            {
                if (!usedIndexes[j])
                    if (majorIndex == -1 || cars[j].getPoints() > cars[majorIndex].getPoints())
                        majorIndex = j;
            }

            indexSorteds[i] = majorIndex;
            usedIndexes[majorIndex] = true;
        }

        for (int i = 0; i < cars.length; i++)
        {
            body += cars[indexSorteds[i]].carData() + "\n";
        }

        return header + body;
    }*/

    public String orderClassification() {
        String header = "Order Classification\nFinal Classification:\n";

        // Ordenar el array usando Arrays.sort y un Comparator
        Arrays.sort(cars, Comparator.comparingInt(Car::getPoints).reversed());

        String body = "";
        for (Car car : cars) {
            body += car.carData() + "\n";
        }

        return header + body;
    }
}
