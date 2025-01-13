import java.util.Arrays;

public class MeanAndMedianCalculator {
    public double mean(double[] x) throws IllegalArgumentException
    {
        if (x == null)
            throw new IllegalArgumentException("NullPointerException: El array es nulo o esta vacio");

        double sumaTotal = 0;
        for (int i = 0; i < x.length; i++)
        {
            sumaTotal += x[i];
        }

        return sumaTotal / x.length;
    }

    public double median(double[] x) throws IllegalArgumentException
    {
        if (x == null)
            throw new IllegalArgumentException("NullPointerException: El array es nulo o esta vacio");

        Arrays.sort(x);

        if (x.length % 2 == 0)
        {
            return (x [x.length / 2] + x [(x.length / 2) - 1]) / 2;
        }
        else
        {
            return x [x.length / 2];
        }
    }

    public double harmonicMean(double[] x) throws IllegalArgumentException
    {
        if (x == null || x.length == 0)
            throw new NullPointerException("NullPointerException: El array es nulo o esta vacio");

        double sumaTotal = 0;
        for (int i = 0; i < x.length; i++)
        {
            if (x[i] == 0)
                throw new IllegalArgumentException("Value can't be zero");

            if (x[i] < 0)
                throw new IllegalArgumentException("Value can't be negative");

            sumaTotal += 1.0 / x[i];
        }

        return x.length / sumaTotal;
    }
}