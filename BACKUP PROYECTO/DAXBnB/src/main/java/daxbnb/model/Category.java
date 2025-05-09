package daxbnb.model;

/**
 * Clase que da la información de la categoria de los tipos de Stays/Estancias
 * @author Juan Francisco &lt;<b>ditarex95@gmail.com</b>&gt;
 * @since 0.1v
 */
public class Category {
    /** Identificador único de la categoría */
    private int idCategory;

    /** Nombre descriptivo de la categoría */
    private String categoryName;

    /**
     * Constructor que inicializa una categoría con su ID y nombre.
     *
     * @param idCategory    ID único de la categoría
     * @param categoryName  Nombre de la categoría
     */
    public Category(int idCategory, String categoryName) {
        this.idCategory = idCategory;
        this.categoryName = categoryName;
    }

    /**
     * Constructor que inicializa una categoría sin su ID
     *
     * @param categoryName  Nombre de la categoría
     */
    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * Obtiene el identificador único de la categoría.
     *
     * @return el ID de la categoría
     */
    public int getIdCategory() {
        return idCategory;
    }

    /**
     * Establece el identificador único de la categoría.
     *
     * @param idCategory el nuevo ID de la categoría
     */
    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    /**
     * Obtiene el nombre descriptivo de la categoría.
     *
     * @return el nombre de la categoría
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Establece el nombre descriptivo de la categoría.
     *
     * @param categoryName el nuevo nombre de la categoría
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * Devuelve una representación en forma de cadena de la categoría.
     *
     * @return una cadena con el ID y nombre de la categoría
     */
    @Override
    public String toString() {
        return "Category [idCategory=" + idCategory + ", categoryName=" + categoryName + "]";
    }
}
