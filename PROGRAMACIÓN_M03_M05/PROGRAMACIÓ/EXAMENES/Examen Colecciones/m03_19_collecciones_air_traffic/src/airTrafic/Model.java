package airTrafic;

public class Model {
    private String modelName;
    private int capacity;
    private double range;

    public Model(String modelName, int capacity, double range) {
        this.modelName = modelName;
        this.capacity = capacity;
        this.range = range;
    }

    @Override
    public String toString()
    {
        return String.format("%S %S %S", modelName, capacity, range);
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }
}
