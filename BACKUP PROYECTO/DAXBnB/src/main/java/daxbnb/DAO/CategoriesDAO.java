package daxbnb.DAO;

import daxbnb.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe per realitzar les consultes a la taula Categories
 * @author Juan Francisco &lt;<b>ditarex95@gmail.com</b>&gt;
 * @since 0.1v
 */
public class CategoriesDAO {
    /**
     * Declarar variable tipus DBConnection per realitzar les conexions a la DB
     */
    private DBConnection db;

    private static final String ALL_CATEGORIES = "SELECT * FROM categories";
    
    private static final String CATEGORY_BY_ID = "SELECT * FROM categories WHERE id_category = ?";
    
    private static final String INSERT_CATEGORY = "{CALL categories_insert_new(?)}";
    
    private static final String DELETE_CATEGORY= "{CALL categories_delete_by_id(?)}";
    
    /**
     * Constructor per instanciar la conexió
     */
    public CategoriesDAO()
    {
        db = new DBConnection();
    }

    /**
     * Metodo que nos devolverá una lista de tipo Category con la query almacenada en la constante
     * @return una lista de instancias de tipo Category
     */
    public List<Category> getAllCategories() throws SQLException
    {
        List<Category> categories = new ArrayList<>();

        try (Connection conn = db.getConnection())
        {
            PreparedStatement ps = conn.prepareStatement(ALL_CATEGORIES);
            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                categories.add(resultToCategory(rs));
            }

            return categories;
        }
    }

    /**
     * Metodo que nos devolverá una instancia de Category con la query almacenada en la constante
     * @param idCategory id category
     * @return una instancia de Category
     */
    public Category getCategoryById(int idCategory) throws SQLException
    {
        try (Connection conn = db.getConnection())
        {
            PreparedStatement ps = conn.prepareStatement(CATEGORY_BY_ID);
            ps.setInt(1, idCategory);
            ResultSet rs = ps.executeQuery();

            if (rs.next())
                return resultToCategory(rs);
            else
                return null;
        }
    }


    /**
     * Función que inserta una nueva categoria a la BBDD a través de una consulta almacenada
     * @param category intancia de la tabla category
     * @return un true si la función funciona y un false si no funciona
     * @throws SQLException
     */
    public boolean insertCategory(Category category) throws SQLException
    {
        try (Connection conn = db.getConnection())
        {
            PreparedStatement ps = conn.prepareStatement(INSERT_CATEGORY);
            ps.setString(1, category.getCategoryName());
            int rowsUpdate = ps.executeUpdate();

            return rowsUpdate > 0;
        }
    }

    /**
     * Función que borra la fila entera de la tabla categories en la BBDD
     * @param idCategory
     * @return un true si la función funciona y un false si no funciona
     * @throws SQLException
     */
    public boolean deleteCategory(int idCategory) throws SQLException
    {
        try (Connection conn = db.getConnection())
        {
            PreparedStatement ps = conn.prepareStatement(DELETE_CATEGORY);
            ps.setInt(1, idCategory);
            int rowsUpdate = ps.executeUpdate();

            return rowsUpdate > 0;
        }
    }

    /**
     * Metodo que nos devolverá una instancia de Category mediante los datos del resultSet
     * @param result Fila de datos ResultSet donde extraeremos la información de la tabla categories
     * @return una instancia de Category
     */
    private Category resultToCategory(ResultSet result) throws SQLException
    {
        int idCategory = result.getInt("id_category");
        String categoryName = result.getString("category_name");
        return new Category(idCategory, categoryName);
    }
}
