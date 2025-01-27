package competition;

public class Driver {
    private String name;
    private String id;
    private static int idNext = 0;

    public Driver(String name)
    {
        this.name = name;

        String iniciales = "";
        for (int i = 0; i < this.name.length(); i++)
        {
            if (i < 3)
                iniciales += name.charAt(i);
        }

        this.id = "DRI000" + idNext + iniciales.toUpperCase();
        idNext++;
    }

    public static String getIdNext()
    {
        return "DRI000" + idNext;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getId()
    {
        return id;
    }

    @Override
    public String toString()
    {
        return String.format("%s\t\t%s\n012345678901234567890123456789", this.name, this.id);
    }
}
