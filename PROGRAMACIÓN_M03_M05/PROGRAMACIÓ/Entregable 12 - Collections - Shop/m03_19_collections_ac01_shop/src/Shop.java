import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Shop {
    private String name;
    private List<Product> products = new ArrayList<>();

    public Shop(String name)
    {
        this.name = name;
    }

    public boolean addProduct(Product product)
    {
        if (product != null)
        {
            products.add(product);
            return true;
        }

        return false;
    }

    public String allProductsString()
    {
        String head = String.format("%15s | %18s | %5s | %8s | %s\n", "ID", "NAME", "SIZE", "PRICE", "ACTIVE");
        String body = "";
        for (Product product : products)
        {
            body += product + "\n";
        }

        return head + body;
    }

    public boolean removeProduct(Product product)
    {
        if (product != null)
        {
            products.remove(product);
            return true;
        }

        return false;
    }

    public boolean removeProductById(String id)
    {
        for (Product product : products)
        {
            if (product.getId().equals(id))
            {
                products.remove(product);
                return true;
            }
        }

        return false;
    }

    public int numProducts()
    {
        return products.size();
    }

    public float total()
    {
        float total = 0;
        for (Product product : products)
        {
            total += product.getPrice();
        }

        return total;
    }

    public float totalBySize(Size size)
    {
        float total = 0;
        for (Product product : products)
        {
            if (product.getSize() == size)
            {
                total += product.getPrice();
            }
        }

        return total;
    }

    public List<Product> listProductsNameAndSize(String text, Size size)
    {
        List<Product> listProducts = new ArrayList<>();
        for (Product product : products)
        {
            if (product.getName().equalsIgnoreCase(text) && product.getSize() == size)
            {
                listProducts.add(product);
            }
        }

        return listProducts;
    }

    public float average()
    {
        float avg = 0;
        int count = 0;
        for (Product product : products)
        {
            if (product.isActive())
            {
                avg += product.getPrice();
                count++;
            }
        }

        return avg / count;
    }
}