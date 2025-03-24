package airTrafic;

public enum Code {
    BCN("Barcelona - El Prat"),
    MAD("Madrid-Barajas"),
    JFK("New York-John F. Kennedy"),
    LHR("London-Heathrow"),
    HKD("Tokyo-Haneda");

    private final String name;

    private Code(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
