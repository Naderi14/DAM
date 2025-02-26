public enum Size {
    XXS(0f),
    XS(0f),
    S(0f),
    M(0f),
    L(1.05f),
    XL(1.75f),
    XXL(2.55f);

    private float extraPrice;

    private Size(float extraPrice)
    {
        this.extraPrice = extraPrice;
    }

    public float getExtraPrice()
    {
        return this.extraPrice;
    }
}
