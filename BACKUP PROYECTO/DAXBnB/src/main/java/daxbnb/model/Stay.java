package daxbnb.model;

import java.util.List;

/**
 * Clase que nos da la información de una Estáncia
 * @author Juan Francisco &lt;<b>ditarex95@gmail.com</b>&gt;
 * @since 0.1v
 */
public class Stay {
    /** Id única de la estancia */
    private int idStay;

    /** Título descriptivo de la estancia */
    private String title;

    /** Descripción completa de la estancia */
    private String description;

    /** Ciudad y/o provincia de la estancia */
    private String city;

    /** Ubicación física de la estancia */
    private String address;

    /** Precio por noche de la estancia */
    private float price;

    /** Estado de la estancia (true/1 = activa, false/0 = inactiva) */
    private boolean active;

    /** Categoría a la que pertenece la estancia (ej: CABIN, APARTMENT, TINY_HOUSE, etc.) */
    private Category category;

    /** Lista de URLs de imágenes asociadas a al estancia */
    private List<String> images;

    /** Lista de características concretas que tiene la estancia */
    private List<Feature> features;

    /** Número máximo de huéspedes permitidos. */
    private int numGuests;

    /** Número de baños disponibles en la estancia */
    private int numBaths;

    /** Número de camas disponibles en la estancia */
    private int numBeds;

    /** Número de dormitorios de la estancia */
    private int numBedrooms;

    /**
     * Constructor con todos los atributos
     * @param idStay       ID único de la estancia
     * @param title        Título de la estancia
     * @param description  Descripción de la estancia
     * @param address     Ubicación de la estancia
     * @param price        Precio por noche
     * @param active        Estado de la estancia (activa/inactiva)
     * @param category    Categoría de la estancia
     * @param images       Lista de imágenes asociadas
     * @param features     Lista de características
     * @param numGuests    Número máximo de huéspedes
     * @param numBaths     Número de baños
     * @param numBeds      Número de camas
     * @param numBedrooms  Número de dormitorios
     */
    public Stay(int idStay, String title, String description, String city, String address, float price, boolean active, Category category, List<String> images, List<Feature> features, int numGuests, int numBaths, int numBeds, int numBedrooms) {
        this.idStay = idStay;
        this.title = title;
        this.description = description;
        this.city = city;
        this.address = address;
        this.price = price;
        this.active = active;
        this.category = category;
        this.images = images;
        this.features = features;
        this.numGuests = numGuests;
        this.numBaths = numBaths;
        this.numBeds = numBeds;
        this.numBedrooms = numBedrooms;
    }

    /**
     * Constructor con todos los atributos sin su ID
     * @param title        Título de la estancia
     * @param description  Descripción de la estancia
     * @param address     Ubicación de la estancia
     * @param price        Precio por noche
     * @param active        Estado de la estancia (activa/inactiva)
     * @param category    Categoría de la estancia
     * @param images       Lista de imágenes asociadas
     * @param features     Lista de características
     * @param numGuests    Número máximo de huéspedes
     * @param numBaths     Número de baños
     * @param numBeds      Número de camas
     * @param numBedrooms  Número de dormitorios
     */
    public Stay(String title, String description, String city, String address, float price, boolean active, Category category, List<String> images, List<Feature> features, int numGuests, int numBaths, int numBeds, int numBedrooms) {
        this.title = title;
        this.description = description;
        this.city = city;
        this.address = address;
        this.price = price;
        this.active = active;
        this.category = category;
        this.images = images;
        this.features = features;
        this.numGuests = numGuests;
        this.numBaths = numBaths;
        this.numBeds = numBeds;
        this.numBedrooms = numBedrooms;
    }

    /** @return el ID de la estancia. */
    public int getIdStay() {
        return idStay;
    }

    /** @param idStay establece el ID de la estancia. */
    public void setIdStay(int idStay) {
        this.idStay = idStay;
    }

    /** @return el título de la estancia. */
    public String getTitle() {
        return title;
    }

    /** @param title establece el título de la estancia. */
    public void setTitle(String title) {
        this.title = title;
    }

    /** @return la descripción de la estancia. */
    public String getDescription() {
        return description;
    }

    /** @param description establece la descripción de la estancia. */
    public void setDescription(String description) {
        this.description = description;
    }

    /** @return la ubicación de la estancia. */
    public String getAddress() {
        return address;
    }

    /** @param address establece la ubicación de la estancia. */
    public void setAddress(String address) {
        this.address = address;
    }

    /** @return el precio por noche de la estancia. */
    public float getPrice() {
        return price;
    }

    /** @param price establece el precio por noche. */
    public void setPrice(float price) {
        this.price = price;
    }

    /** @return true si la estancia está activa, false si está dada de baja. */
    public boolean isActive() {
        return active;
    }

    /** @param active establece el estado de la estancia. */
    public void setActive(boolean active) {
        this.active = active;
    }

    /** @return la categoría de la estancia. */
    public Category getCategory() {
        return category;
    }

    /** @param category establece la categoría de la estancia. */
    public void setCategory(Category category) {
        this.category = category;
    }

    /** @return la lista de imágenes de la estancia. */
    public List<String> getImages() {
        return images;
    }

    /** @param images establece la lista de imágenes. */
    public void setImages(List<String> images) {
        this.images = images;
    }

    /** @return la lista de características de la estancia. */
    public List<Feature> getFeatures() {
        return features;
    }

    /** @param features establece la lista de características. */
    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    /** @return el número máximo de huéspedes. */
    public int getNumGuests() {
        return numGuests;
    }

    /** @param numGuests establece el número de huéspedes. */
    public void setNumGuests(int numGuests) {
        this.numGuests = numGuests;
    }

    /** @return el número de baños de la estancia. */
    public int getNumBaths() {
        return numBaths;
    }

    /** @param numBaths establece el número de baños. */
    public void setNumBaths(int numBaths) {
        this.numBaths = numBaths;
    }

    /** @return el número de camas de la estancia. */
    public int getNumBeds() {
        return numBeds;
    }

    /** @param numBeds establece el número de camas. */
    public void setNumBeds(int numBeds) {
        this.numBeds = numBeds;
    }

    /** @return el número de dormitorios de la estancia. */
    public int getNumBedrooms() {
        return numBedrooms;
    }

    /** @param numBedrooms establece el número de dormitorios. */
    public void setNumBedrooms(int numBedrooms) {
        this.numBedrooms = numBedrooms;
    }

    /** @return ciudad del stay */
    public String getCity() {
        return city;
    }

    /** @param city el nombre de la nueva ciudad */
    public void setCity(String city) {
        this.city = city;
    }

    /** @return el toString de la calse*/
    @Override
    public String toString() {
        return "Stay [" +
                "idStay=" + idStay +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", location='" + address + '\'' +
                ", price=" + price +
                ", active=" + active +
                ", category=" + category.getCategoryName() +
                ", numGuests=" + numGuests +
                ", numBaths=" + numBaths +
                ", numBeds=" + numBeds +
                ", numBedrooms=" + numBedrooms +
                ']';
    }
}
