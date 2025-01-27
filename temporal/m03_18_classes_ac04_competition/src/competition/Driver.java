package competition;

public class Driver {
    private String name;
    private String id;
    private static int idNext = 0;

    public Driver(String name)
    {
        this.name = name;

        String iniciales = "";
        for (int i = 0; i < 3; i++)
        {
            iniciales += name.charAt(i);
        }

        this.id = "DRI000" + idNext + iniciales;
    }
}
