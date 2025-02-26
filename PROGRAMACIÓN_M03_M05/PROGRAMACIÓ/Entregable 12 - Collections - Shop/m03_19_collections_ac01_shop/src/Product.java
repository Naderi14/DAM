public class Product {
    private String id;
    private String name;
    private float price;
    private Size size;
    private boolean active;

    private static int idNext;

    public Product(String name, float price, Size size, boolean active)
    {
        this.name = name;
        this.price = price;
        this.size = size;
        this.active = active;
    }
}
