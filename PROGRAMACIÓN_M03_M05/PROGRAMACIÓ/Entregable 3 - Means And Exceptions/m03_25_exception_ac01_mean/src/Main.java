public class Main {
    final static MeanAndMedianCalculator MEANS = new MeanAndMedianCalculator();

    public static void main(String[] args)
    {


        //10 elements
        double[] array1a = new double[]{10.0, 80.0, 50.0, 40.0, 30.0, 70.0, 60.0, 20.0, 90.0, 100.0};
        //11 elements
        double[] array1b = new double[]{30.0, 90.0, 100.0, 40.0, 70.0, 60.0, 50.0, 80.0, 20.0, 10.0, 110.0};
        //11 elements with 1 zero
        double[] array2a = new double[]{0.00, 10.0, 0.0, 30.0, 40.0, 50.0, 60.0, 70.0, 80.0, 90.0, 100.0};
        //11 elements with 1 negative
        double[] array2b = new double[]{-10.00, 10.0, -20.0, 30.0, 40.0, 50.0, 60.0, 70.0, 80.0, 90.0, 100.0};
        //array null
        double[] arrayNull = null;

        callMeansAndShow(array1a, "array1a");
        callMeansAndShow(array1b, "array1b");
        callMeansAndShow(array2a, "array2a");
        callMeansAndShow(array2b, "array2b");
        callMeansAndShow(arrayNull, "arrayNull");

    }

    public static void callMeansAndShow(double[] x, String nombreArray)
    {
        System.out.println(nombreArray + ":");
        try
        {
            System.out.println("Mean: " + MEANS.mean(x));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            System.out.println("Median: " + MEANS.median(x));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            System.out.println("Harmonic Mean: " + MEANS.harmonicMean(x));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}