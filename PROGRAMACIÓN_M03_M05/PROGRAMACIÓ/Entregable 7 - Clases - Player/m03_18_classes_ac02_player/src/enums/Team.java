package enums;

public enum Team {
    FCB("Futbol Club Barcelona","Spain"),
    RM("Real Madrid", "Spain"),
    SFC("Sevilla FC", "Spain"),
    PSG("Paris Saint Germain", "France"),
    BNF("Benfica", "Portugal"),
    JUV("Juventus", "Italy");

    private final String name;
    private final String country;

    private Team(String name, String country)
    {
        this.name = name;
        this.country = country;
    }

    public String getName()
    {
        return this.name;
    }

    public String getCountry()
    {
        return this.country;
    }
}
