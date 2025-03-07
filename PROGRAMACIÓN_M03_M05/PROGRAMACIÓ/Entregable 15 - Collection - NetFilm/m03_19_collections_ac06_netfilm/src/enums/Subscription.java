package enums;

public enum Subscription {
    BASIC_ADVERTS (5.49f),
    BASIC (7.99f),
    STANDARD (12.99f),
    PREMIUM (17.99f);

    private float cost;

    private Subscription (float cost)
    {
        this.cost = cost;
    }

    public float getCost()
    {
        return this.cost;
    }
}
