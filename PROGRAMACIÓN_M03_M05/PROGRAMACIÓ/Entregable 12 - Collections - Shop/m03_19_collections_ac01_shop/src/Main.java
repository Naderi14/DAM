import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //1.Instantiate Shop
        System.out.println("1. Instantiate Shop:");
        Shop shop = new Shop("La Botigueta");

        //2.Instantiate Products
        System.out.println("\n2. Instantiate 20 Products with different sizes and prices:");
        Product[] productos = {
                new Product("TSHIRT", 30.25f, Size.XXS, true),
                new Product("CAP", 25.75f, Size.XS, true),
                new Product("TROUSERS", 30.25f, Size.S, true),
                new Product("SKIRT", 28.25f, Size.M, true),
                new Product("GLOVES", 32.35f, Size.L, true),
                new Product("T", 23.79f, Size.XL, true),
                new Product("T", 35.25f, Size.XXL, true),
                new Product("JACKET", 59.97f, Size.XL, true),
                new Product("TSHIRT", 29.95f, Size.XS, true),
                new Product("LONG-SHIRT", 20.56f, Size.XS, true),
                new Product("TANK-TSHIRT", 16.55f, Size.XL, true),
                new Product("TSHIRT", 29.15f, Size.M, true),
                new Product("TANK-TSHIRT", 24.45f, Size.XXL, true),
                new Product("TSHIRT", 32.50f, Size.XS, true),
                new Product("LONG-SHIRT", 32.70f, Size.XS, false),
                new Product("SHIRT", 34.50f, Size.XS, false),
                new Product("TSHIRT", 33.25f, Size.XS, false),
                new Product("SLEEVELESS-SHIRT", 32.50f, Size.XS, false),
                new Product("TSHIRT", 28.50f, Size.XS, false),
                new Product("TSHIRT", 29.50f, Size.S, false)
        };

        //3.Add products Shop
        System.out.println("\n3. Add products Shop:");
        for (Product product : productos)
        {
            shop.addProduct(product);
        }

        //4.Print all products
        System.out.println("\n4. Print all products:");
        System.out.println(shop.allProductsString());

        //5.Print Number Products
        System.out.println("\n5. Num Products: " + shop.numProducts() + " products");

        //6. Get total price
        System.out.println("\n6. Get total: " + shop.total());

        //7. Get total of products
        System.out.println("\n7. Get total by size: " + shop.totalBySize(Size.XL));

        //8. List products with name "SHIRT" and size "XS"
        System.out.println("\n8. List products with name \"SHIRT\" and size \"XS\":");
        List<Product> listaFiltrada = shop.listProductsNameAndSize("SHIRT", Size.XS);
        for (Product product : listaFiltrada)
        {
            System.out.println(product);
        }

        //9. List products with name "t" and size "XL"
        System.out.println("\n9. List products with name \"t\" and size \"XL\":");
        listaFiltrada = shop.listProductsNameAndSize("t", Size.XL);
        for (Product product : listaFiltrada)
        {
            System.out.println(product);
        }

        //10. Remove a product by id
        System.out.println("\n10. Remove product by id");
        System.out.println("Removing 00005-T-XL: " + shop.removeProductById("00005-T-XL"));
        //Print number of products
        System.out.println("Number of products: " + shop.numProducts());
        //11. Remove a product
        System.out.println("\n11. Remove product by object");
        System.out.println("Removing product: " + shop.removeProduct(productos[2]));
        //Print number of products
        System.out.println("Number of products: " + shop.numProducts());
        //12. Average active products
        System.out.println("\n12. Average active products: " + shop.average());
    }
}
