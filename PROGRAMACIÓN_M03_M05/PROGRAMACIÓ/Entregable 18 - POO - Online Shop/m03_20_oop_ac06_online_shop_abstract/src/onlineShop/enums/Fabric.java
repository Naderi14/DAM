package onlineShop.enums;

public enum Fabric {
    COTTON (1),
    LINEN (2),
    POLYESTER (3),
    RAYON (4),
    LYCRA (5);

    private final float price;

    private Fabric(float price)
    {
        this.price = price;
    }

    public float getPrice()
    {
        return price;
    }
}
