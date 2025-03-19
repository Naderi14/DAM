package vehicle;

public class Vehicle {
    protected String registration;
    protected String make;
    protected String model;

    public Vehicle(String registration, String make, String model)
    {
        this.registration = registration;
        this.make = make;
        this.model = model;
    }

    public double weight()
    {
        if (registration.charAt(0) == 'A')
            return 1;
        else
            return 2;
    }

    @Override
    public String toString()
    {
        return String.format("Vehicle: %-12s|Model: %-10s|Make: %-10s ",
                registration, model, make);
    }

    public String toStringBase()
    {
        return String.format("%-12s|Model: %-10s|Make: %-10s ",
                registration, model, make);
    }

    public String toStringOnlyThis()
    {
        return "";
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
