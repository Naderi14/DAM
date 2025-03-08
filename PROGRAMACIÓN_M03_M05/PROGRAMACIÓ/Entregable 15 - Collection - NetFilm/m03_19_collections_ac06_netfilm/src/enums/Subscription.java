package enums;

public enum Subscription {
    BASIC_ADVERTS (5.49f, 1),
    BASIC (7.99f, 2),
    STANDARD (12.99f, 3),
    PREMIUM (17.99f, 4);

    private final float cost;
    private final int id;

    private Subscription (float cost, int id)
    {
        this.cost = cost;
        this.id = id;
    }

    public float getCost()
    {
        return this.cost;
    }

    public int getId()
    {
        return this.id;
    }

    public static Subscription fromId(int id)
    {
        for (Subscription s : Subscription.values())
            if (s.id == id)
                return s;

        throw new IllegalArgumentException("<!- NON-EXISTENT SUBSCRIPTION NUMBER: " + id);
    }
}
