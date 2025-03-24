import airTrafic.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // 1. Models
        System.out.println("\nCreate 2 Models: ");
        Model airbusA320 = new Model("AIRBUS-A320", 10, 3500.0);
        Model boeing787 = new Model("BOEING-787", 10, 8000.0);

        // Show models
        System.out.println("\nShow models: ");
        System.out.println(airbusA320 + "\n" + boeing787);


        // 2. Airports
        System.out.println("\nCreate 5 Airports: ");
        Airport barcelona = new Airport(Code.BCN);
        Airport madrid = new Airport(Code.MAD);
        Airport newYork = new Airport(Code.JFK);
        Airport london = new Airport(Code.LHR);
        Airport tokyo = new Airport(Code.HKD);

        System.out.println("\nShow airports: ");
        System.out.println(barcelona + "\n" +
                madrid + "\n" +
                newYork + "\n" +
                london + "\n" +
                tokyo);


        // 3. Passengers
        System.out.println("\nCreate Passengers: ");
        Passenger passengerA1 = new Passenger("John", "Doe", "A11111111");
        Passenger passengerA2 = new Passenger("Jane", "Smith", "B22222222");
        Passenger passengerA3 = new Passenger("Carlos", "Silva", "C33333333");
        Passenger passengerA4 = new Passenger("Peter", "King", "D44444444");
        Passenger passengerA5 = new Passenger("Aura", "Queen", "E55555555");
        Passenger passengerA6 = new Passenger("Mona", "Lisa", "F66666666");
        Passenger passengerA7 = new Passenger("Marian", "Tool", "G77777777");
        Passenger passengerA8 = new Passenger("Lola", "Viva", "H88888888");
        Passenger passengerA9 = new Passenger("Jules", "Verne", "I99999999");
        Passenger passengerA10 = new Passenger("Lady", "Gaga", "J12121212");
        Passenger passengerA11 = new Passenger("Victoria", "Beckham", "K13131313");
        Passenger passengerA12 = new Passenger("Kyle", "Blue", "L14141414");
        Passenger passengerA13 = new Passenger("David", "Milan", "A11111111");
        Passenger passengerA14 = new Passenger("John", "Lloyd", "a11111111");

        List<Passenger> travelers = new ArrayList<>();
        travelers.add(passengerA1);
        travelers.add(passengerA2);
        travelers.add(passengerA3);
        travelers.add(passengerA4);
        travelers.add(passengerA5);
        travelers.add(passengerA6);
        travelers.add(passengerA7);
        travelers.add(passengerA8);
        travelers.add(passengerA9);
        travelers.add(passengerA10);
        travelers.add(passengerA11);
        travelers.add(passengerA12);
        travelers.add(passengerA13);
        travelers.add(passengerA14);

        System.out.println("\nShow passengerA1: ");
        travelers.forEach(System.out::println);


        // 4. Flights
        System.out.println("\nCreate flight Barcelona - Madrid at 08:45: ");
        Flight flight1 = new Flight("IB123", barcelona, madrid, airbusA320, "08:45");

        System.out.println("\nShow flight: ");
        System.out.println(flight1);


        System.out.println("\nCreate flight Barcelona - New York at 10:55");
        Flight flight11 = new Flight("IB152", barcelona, newYork, boeing787, "10:55");

        System.out.println("\nShow flight");
        System.out.println(flight11);

        System.out.println("\nCreate flight Barcelona - London at 14:30");
        Flight flight12 = new Flight("BA205", barcelona, london, airbusA320, "14:30");

        System.out.println("\nShow flight");
        System.out.println(flight12);

        System.out.println("\nCreate flight Barcelona - London at 16:25");
        Flight flight13 = new Flight("BA206", barcelona, london, airbusA320, "16:25");

        System.out.println("\nShow flight");
        System.out.println(flight13);

        System.out.println("\nCreate flight Barcelona - Tokyo at 18:40");
        Flight flight14 = new Flight("AA332", barcelona, tokyo, boeing787, "18:40");

        System.out.println("\nShow flight");
        System.out.println(flight14);

        System.out.println("\nCreate flight Madrid - Barcelona at 21:55");
        Flight flight21 = new Flight("AA101", madrid, barcelona, airbusA320, "21:15");

        System.out.println("\nShow flight");
        System.out.println(flight21);

        System.out.println("\nCreate flight London - Barcelona at 21:30");
        Flight flight22 = new Flight("AA122", london, barcelona, airbusA320, "21:30");

        System.out.println("\nShow flight");
        System.out.println(flight22);

        System.out.println("\nAdd passenger passengerA1 to flight Barcelona Madrid at 08:45: ");
        System.out.println(flight1.addPassenger(passengerA1));

        System.out.println("\nAdd the same passenger passengerA1 to flight: ");
        System.out.println(flight1.addPassenger(passengerA1));

        System.out.println("\nAdd passenger passengerA13 with same dni to flight: ");
        System.out.println(flight1.addPassenger(passengerA13));

        System.out.println("\nAdd passenger passengerA14 with same dni to flight: ");
        System.out.println(flight1.addPassenger(passengerA14));

        System.out.println("\nAdd all passengers (from A2 to A12) to flight (only 10 should be added): ");
        travelers.remove(passengerA1);
        travelers.remove(passengerA13);
        travelers.remove(passengerA14);

        for (Passenger p : travelers)
        {
            System.out.println(flight1.addPassenger(p));
        }
        System.out.println("Size: " + flight1.getPassengers().size());

        System.out.println("\nList flight passengers:");
        Set<Passenger> passengerSet = flight1.getPassengers();
        for (Passenger p : passengerSet)
        {
            System.out.println(p);
        }

        System.out.println("\nSort flight Passengers by lastName:");
        List<Passenger> passengerList = flight1.sortPassengers();
        for (Passenger p : passengerList)
        {
            System.out.println(p);
        }

        System.out.println("\nSearch Passengers with text = \"a\" in flight");
        passengerList = flight1.searchPassengers("a");
        for (Passenger p : passengerList)
        {
            System.out.println(p);
        }

        System.out.println("\nSearch Passengers with text = \"VA\" in flight");
        passengerList = flight1.searchPassengers("VA");
        for (Passenger p : passengerList)
        {
            System.out.println(p);
        }

        System.out.println("\nAdd departing flights from Barcelona airpor to Madrid, New York and Tokyo");
        System.out.println("flght1, flight11, flight12, flight13, flight14");
        barcelona.addDepartureFlight(flight1);
        barcelona.addDepartureFlight(flight11);
        barcelona.addDepartureFlight(flight12);
        barcelona.addDepartureFlight(flight13);
        barcelona.addDepartureFlight(flight14);

        System.out.println("\nAdd arriving flights to Barcelona from Madrid and London");
        System.out.println("flght21, flight22");
        barcelona.addArrivingFlight(flight21);
        barcelona.addArrivingFlight(flight22);

        System.out.println("\nShow flights departing from Barcelona:");
        List<Flight> flights = barcelona.getDepartingFlights();
        for (Flight f : flights)
        {
            System.out.println(f);
        }

        System.out.println("\nShow flights arriving to Barcelona:");
        flights = barcelona.getArrivingFlights();
        for (Flight f : flights)
        {
            System.out.println(f);
        }
    }
}