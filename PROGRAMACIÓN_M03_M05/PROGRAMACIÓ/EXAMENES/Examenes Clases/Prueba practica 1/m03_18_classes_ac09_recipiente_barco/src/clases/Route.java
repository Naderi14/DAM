package clases;

public class Route {
    private String origin;
    private String destination;
    private float distance;
    private ContainerShip ship;

    public Route(String origin, String destination, float distance, ContainerShip ship)
    {
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
        this.ship = ship;
    }

    public double getTime()
    {
        return this.distance / (ship.getMaxSpeed() * 1.852);
    }

    @Override
    public String toString()
    {
        return String.format("Route (Origin:%s | Destination:%s | Distance:%s)", origin, destination, distance);
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public ContainerShip getShip() {
        return ship;
    }

    public void setShip(ContainerShip ship) {
        this.ship = ship;
    }
}
