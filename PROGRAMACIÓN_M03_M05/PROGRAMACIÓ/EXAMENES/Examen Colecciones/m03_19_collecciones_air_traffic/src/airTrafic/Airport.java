package airTrafic;

import java.util.ArrayList;
import java.util.List;

public class Airport {
    private Code code;
    private List<Flight> departingFlights;
    private List<Flight> arrivingFlights;

    public Airport(Code code) {
        this.code = code;
        departingFlights = new ArrayList<>();
        arrivingFlights = new ArrayList<>();
    }

    public void addDepartureFlight(Flight flight)
    {
        departingFlights.add(flight);
    }

    public void addArrivingFlight(Flight flight)
    {
        arrivingFlights.add(flight);
    }

    @Override
    public String toString()
    {
        return String.format("%S %s", code, code.getName());
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public List<Flight> getDepartingFlights() {
        return departingFlights;
    }

    public void setDepartingFlights(List<Flight> departingFlights) {
        this.departingFlights = departingFlights;
    }

    public List<Flight> getArrivingFlights() {
        return arrivingFlights;
    }

    public void setArrivingFlights(List<Flight> arrivingFlights) {
        this.arrivingFlights = arrivingFlights;
    }
}
