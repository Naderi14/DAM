package clases;

import java.util.Arrays;
import java.util.Comparator;

public class ContainerShip {
    private String name;
    private Container[] containers;
    private int numContainers;
    private int currentWeight;
    private float maxSpeed;  //knots = nusos => 1 nus = 1.852 km / h
    private int maxWeight;
    private int nextLocation;

    public ContainerShip(String name, float maxSpeed, int maxWeight, int maxContainers)
    {
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.maxWeight = maxWeight;
        numContainers = 0;
        containers = new Container[maxContainers];
    }

    @Override
    public String toString() {
        String header = String.format(
                "SHIP: " + this.name + "\n" +
                "-----------------------------------------------------------\n" +
                "CONTAINERS:\n" +
                "-----------------------------------------------------------\n" +
                "%-15s %-10s %-10s %-12s %-10s%n",
                "ID", "LOCATION", "WEIGHT", "TYPE", "COST"

        );

        String bodyData = "";
        for (Container container : containers)
        {
            if (container != null)
                bodyData += container.toString();
        }

        String footer = String.format(
                "-----------------------------------------------------------" +
                "\nNUM CONTAINERS: " + this.numContainers +
                "\nCURRENT WEIGHT: " + this.currentWeight +
                "\nMAX SPEED: " + this.maxSpeed +
                "\nMAX WEIGHT: " + this.maxWeight
        );

        return header + bodyData + footer;
    }

    public boolean addContainer(Container container)
    {
        if (numContainers < containers.length)
        {
            if (container.getWeight() + currentWeight <= maxWeight)
            {
                nextLocation++;

                container.setLocation(nextLocation);
                containers[nextLocation - 1] = container;
                currentWeight += container.getWeight();

                numContainers++;
                return true;
            }
        }

        return false;
    }

    public double totalTransportCost()
    {
        double totalCost = 0;
        for (Container container : containers)
        {
            if (container != null)
                totalCost += container.getTransportCost();
        }

        return totalCost;
    }

    public Container[] orderContainers()
    {
        Container[] containersOrdered = containers;
        Arrays.sort(containersOrdered, Comparator.comparingInt(Container::getWeight));
        return containersOrdered;
    }

    public String getName() {
        return name;
    }

    public int getNumContainers() {
        return numContainers;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public Container[] getContainers() {
        return containers;
    }

    public void setContainers(Container[] containers) {
        this.containers = containers;
    }

    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public void setName(String name) {
        this.name = name;
    }
}
