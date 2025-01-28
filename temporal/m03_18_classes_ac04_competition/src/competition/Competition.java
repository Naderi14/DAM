package competition;

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

    public String orderClassification()
    {
        String header = "Order Classification\nFinal Classification:\n";

        String body = "";

        cars[0].carData();

        return "";
    }
}
