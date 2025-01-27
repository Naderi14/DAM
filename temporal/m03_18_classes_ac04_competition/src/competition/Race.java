package competition;

public class Race {
    private Car[] cars;
    private String id;
    private static int idNext;

    public Race()
    {
        this.id = "RAC00" + idNext + "-" + cars.length;
        idNext++;
    }

    public static String getIdNext()
    {
        return "RAC00" + idNext;
    }
}
