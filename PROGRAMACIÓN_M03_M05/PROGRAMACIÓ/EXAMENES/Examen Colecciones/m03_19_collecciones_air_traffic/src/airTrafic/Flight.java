package airTrafic;

import java.util.*;

public class Flight {
    private String flightNumber;
    private Airport origin;
    private Airport destination;
    private Model model;
    private Set<Passenger> passengers;
    private String departureTime;

    public Flight(String flightNumber, Airport origin, Airport destination, Model model, String departureTime) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.model = model;
        this.departureTime = departureTime;
        passengers = new HashSet<>();
    }

    public boolean addPassenger(Passenger passenger)
    {
        if (!passengers.contains(passenger) && passengers.size() < model.getCapacity())
        {
            return passengers.add(passenger);
        }

        return false;
    }

    public List<Passenger> sortPassengers()
    {
        List<Passenger> passengerList = new ArrayList<>(passengers);

        for (int i = 0; i < passengerList.size() - 1; i++) {
            for (int j = i + 1; j < passengerList.size(); j++) {
                if (passengerList.get(i).getLastName().compareToIgnoreCase(passengerList.get(j).getLastName()) > 0 ) {
                    Passenger temp = passengerList.set(i, passengerList.get(j));
                    passengerList.set(j, temp);
                }
            }
        }

        return passengerList;
    }

    public List<Passenger> searchPassengers(String text)
    {
        List<Passenger> passengerList = new ArrayList<>();

        for (Passenger passenger : passengers)
        {
            if (passenger.getFirstName().toLowerCase().contains(text.toLowerCase()) ||
            passenger.getLastName().toLowerCase().contains(text.toLowerCase()) ||
            passenger.getPassport().toLowerCase().contains(text.toLowerCase()))
            {
                passengerList.add(passenger);
            }
        }

        return passengerList;
    }

    @Override
    public String toString()
    {
        return String.format("%-15S %-25s %-25s %-15S %-15S",
                flightNumber, origin, destination, model.getModelName(), departureTime);
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Airport getOrigin() {
        return origin;
    }

    public void setOrigin(Airport origin) {
        this.origin = origin;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Set<Passenger> passengers) {
        this.passengers = passengers;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
}
