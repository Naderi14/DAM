package clases;

public class Container {
    private String id; // Unique id CONT0001, CONT0002, etc.
    private int location;
    private int weight; // Weight in kg
    private ContainerType type; // Type of container
    private double transportCost; // transport price

    private static int idNext = 0;
    private static final double BASE_COST = 0;

    public Container(ContainerType type, int weight)
    {
        if (idNext < 10)
            this.id = "CONT000" + idNext;
        else if (idNext < 100)
            this.id = "CONT00" + idNext;

        transportCost = BASE_COST;
        this.type = type;
        this.weight = weight;
        this.location = -1;
        if (type == ContainerType.FREEZE || type == ContainerType.OPEN_TOP)
            this.transportCost += this.transportCost * 0.2;

        idNext++;
    }

    @Override
    public String toString() {
        String header = String.format(
                "%-15s %-10s %-10s %-12s %-10s%n",
                this.id, this.location, this.weight, this.type, this.transportCost
        );

        return header;
    }

    public String getId()
    {
        return id;
    }

    public int getLocation()
    {
        return location;
    }

    public int getWeight()
    {
        return weight;
    }

    public ContainerType getType()
    {
        return type;
    }

    public double getTransportCost()
    {
        return transportCost;
    }

    public void setLocation(int location)
    {
        this.location = location;
    }
}
