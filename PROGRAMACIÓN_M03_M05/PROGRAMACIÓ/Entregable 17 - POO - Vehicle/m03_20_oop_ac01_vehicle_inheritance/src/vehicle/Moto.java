package vehicle;

public class Moto extends Vehicle{
    protected int cc;

    public Moto(String registration, String model, String make, int cc) {
        super(registration, model, make);
        this.cc = cc;
    }

    @Override
    public String toString()
    {
        return String.format(toStringBase() + "|CC: %s",
                cc);
    }

    public String toStringOnlyThis()
    {
        return String.format("CC: %s", cc);
    }

    @Override
    public double weight()
    {
        return cc * super.weight() / 10;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }
}
