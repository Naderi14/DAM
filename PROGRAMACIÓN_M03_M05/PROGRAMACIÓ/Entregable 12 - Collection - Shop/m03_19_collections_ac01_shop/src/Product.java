public class Product {
    private String id;
    private String name;
    private float price;
    private Size size;
    private boolean active;

    private static int idNext = 0;
 
    public Product(String name, float price, Size size, boolean active)
    {
        this.name = name;
        this.price = price;
        this.size = size;
        this.active = active;
        this.id = generateNextId();
        idNext++;
    }

    private String generateNextId()
    {
        String lyricsProduct;
        if (this.name.length() <= 5)
            lyricsProduct = this.name;
        else
            lyricsProduct = this.name.substring(0, 5);

        if (idNext < 10)
            return String.format("0000%s-%s-%s", idNext, lyricsProduct, this.size);
        else if (idNext < 100)
            return String.format("000%s-%s-%s", idNext, lyricsProduct, this.size);
        else if (idNext < 1000)
            return String.format("00%s-%s-%s", idNext, lyricsProduct, this.size);
        else if (idNext < 10000)
            return String.format("0%s-%s-%s", idNext, lyricsProduct, this.size);
        else
            return String.format("%s-%s-%s", idNext, lyricsProduct, this.size);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public Size getSize() {
        return size;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public String toString()
    {
        return String.format("%15s | %18s | %5s | %8s | %s",
                this.id, this.name, this.size, this.price, this.active);
    }
}
