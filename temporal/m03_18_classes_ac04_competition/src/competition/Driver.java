package competition;

public class Driver {
    private static final String ID_BASE = "DRI000";
    private String name;
    private String id;
    private static int idNext = 0;

    public Driver(String name)
    {
        this.name = name;
        this.id = getIdNext() + getInitialsId();
        idNext++;
    }

    private String getInitialsId()
    {
        String iniciales = "";
        for (int i = 0; i < this.name.length(); i++)
        {
            if (i < 3)
                iniciales += name.charAt(i);
        }

        return iniciales.toUpperCase();
    }

    public static String getIdNext()
    {
        return ID_BASE + idNext;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
        this.id = id.substring(0,id.length() - 3) + getInitialsId();
    }

    public String getId()
    {
        return id;
    }

    @Override
    public String toString()
    {
        return String.format("Driver: %s\t|\t%s", this.name, this.id);
    }
}
