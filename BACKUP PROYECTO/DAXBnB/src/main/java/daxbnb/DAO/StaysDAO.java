package daxbnb.DAO;

import daxbnb.exceptions.stays.StayNotFoundException;
import daxbnb.model.Category;
import daxbnb.model.Feature;
import daxbnb.model.Stay;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Classe per realitzar les consultes a la taula Stays
 * @author Juan Francisco &lt;<b>ditarex95@gmail.com</b>&gt;
 * @since 0.1v
 */
public class StaysDAO {
    /**
     * Declarar variable tipus DBConnection per realitzar les conexions a la DB
     */
    private DBConnection db;

    private static final String ALL_STAYS = "SELECT * FROM stays";
    
    private static final String STAYS_BY_CATEGORY = "SELECT * FROM stays WHERE id_category = ?";
    
    private static final String STAYS_SORTED_BY_NAME = "SELECT * FROM stays ORDER BY titlename ASC";
    
    private static final String STAYS_SORTED_BY_PRICE = "SELECT * FROM stays ORDER BY price ASC";
    
    private static final String STAYS_SEARCHED_BY_CITY = "SELECT * FROM stays WHERE city LIKE ?";
    
    private static final String STAY_BY_ID = "SELECT * FROM stays WHERE id_stay = ?";
    
    private static final String AVAILABLE_STAYS = "SELECT * FROM stays WHERE active = 1";
    
    private static final String CREATE_STAY = "{CALL stays_insert_new(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
    
    private static final String UPDATE_STAY = "{CALL stays_update_by_id(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
    
    private static final String DELETE_STAY = "{CALL stays_delete_by_id(?)}";
    
    private static final String IMAGES_DATA_BY_STAY = "SELECT * FROM images WHERE id_stay = ?";
    
    /**
     * Constructor per instanciar la conexió
     */
    public StaysDAO()
    {
        db = new DBConnection();
    }

    /**
     * Metodo que nos devolverá una lista de tipo Stay con la query almacenada en la constante
     *
     * @return una lista de instancias de tipo Stay
     * @throws SQLException Si ocurre un error durante la consulta a la base de datos.
     */
    public List<Stay> getAllStays() throws SQLException, StayNotFoundException {
        return getStays(ALL_STAYS);
    }

    /**
     * Metodo que nos devolverá una lista de tipo Stay con la query almacenada en la constante
     *
     * @param idCategory ID de la categoria relacionada con el Stay
     * @return una lista de instancias de tipo Stay
     * @throws SQLException Si ocurre un error durante la consulta a la base de datos.
     */
    public List<Stay> getStaysByCategory(int idCategory) throws SQLException, StayNotFoundException {
        return getStays(STAYS_BY_CATEGORY, idCategory);
    }

    /**
     * Metodo que nos devolverá una lista de tipo Stay con la query almacenada en la constante orenada por nombre ascendiente
     *
     * @return una lista de instancias de tipo Stay
     * @throws SQLException Si ocurre un error durante la consulta a la base de datos.
     */
    public List<Stay> getStaysSortedByName() throws SQLException, StayNotFoundException {
        return getStays(STAYS_SORTED_BY_NAME);
    }

    /**
     * Metodo que nos devolverá una lista de tipo Stay con la query almacenada en la constante orenada por precio ascendiente
     *
     * @return una lista de instancias de tipo Stay
     * @throws SQLException Si ocurre un error durante la consulta a la base de datos.
     */
    public List<Stay> getStaysSortedByPrice() throws SQLException, StayNotFoundException {
        return getStays(STAYS_SORTED_BY_PRICE);
    }

    public List<Stay> getStaysSearchedByCity(String city) throws SQLException, StayNotFoundException {
        return getStays(STAYS_SEARCHED_BY_CITY, city);
    }

    /**
     * Metodo que nos devolverá una instancia de Stay con la query almacenada en la constante
     *
     * @param idStay id stay
     * @return una instancia de Stay
     * @throws SQLException Si ocurre un error durante la consulta a la base de datos.
     */
    public Stay getStayById(int idStay) throws SQLException, StayNotFoundException {
        try (Connection conn = db.getConnection())
        {
            PreparedStatement ps = conn.prepareStatement(STAY_BY_ID);
            ps.setInt(1, idStay);
            ResultSet rs = ps.executeQuery();

            if (rs.next())
                return resultToStay(rs);
            else
                throw new StayNotFoundException("Stay with ID:" + idStay + " not found.");
        }
    }

    /**
     * Metodo que nos devolverá una lista de tipo Stay con la query, filtrada por si estado active
     *
     * @return una lista de instancias de tipo Stay
     * @throws SQLException Si ocurre un error durante la consulta a la base de datos.
     */
    public List<Stay> getAvailableStays() throws SQLException, StayNotFoundException {
        return getStays(AVAILABLE_STAYS);
    }

    /* DML METHODS */

    /**
     * Método que creará una fila en la tabla stay de la BBDD
     * @param stay instancia de stay
     * @return un true si se ha creado la fila correctamente y un false si no se ha creado
     * @throws SQLException
     */
    public boolean createStay(Stay stay) throws SQLException
    {
        // id_category, titlename, location, description, price, num_guests, num_baths, num_beds, num_bedrooms, active
        try (Connection conn = db.getConnection())
        {
            PreparedStatement ps = conn.prepareStatement(CREATE_STAY);
            ps.setInt(1, stay.getCategory().getIdCategory());
            ps.setString(2, stay.getTitle());
            ps.setString(3, stay.getCity());
            ps.setString(4, stay.getAddress());
            ps.setString(5, stay.getDescription());
            ps.setFloat(6, stay.getPrice());
            ps.setInt(7, stay.getNumGuests());
            ps.setInt(8, stay.getNumBaths());
            ps.setInt(9, stay.getNumBeds());
            ps.setInt(10, stay.getNumBedrooms());
            ps.setBoolean(11, stay.isActive());

            int rowsUpdate = ps.executeUpdate();

            return rowsUpdate > 0;
        }
    }

    /**
     * Método para actualizar una fila de la tabla Stay en la BBDD
     * @param stay instanciá de stay
     * @return true si se ha actualizado la fila correctamente y false si no se ha actualizado
     * @throws SQLException
     */
    public boolean updateStay(Stay stay) throws SQLException
    {
        // idStay, idCategory, titlename, city, address, description, price, active, num_guests, num_baths, num_beds, num_bedrooms
        try (Connection conn = db.getConnection())
        {
            PreparedStatement ps = conn.prepareStatement(UPDATE_STAY);
            ps.setInt(1, stay.getIdStay());
            ps.setInt(2, stay.getCategory().getIdCategory());
            ps.setString(3, stay.getTitle());
            ps.setString(4, stay.getCity());
            ps.setString(5, stay.getAddress());
            ps.setString(6, stay.getDescription());
            ps.setFloat(7, stay.getPrice());
            ps.setBoolean(8, stay.isActive());
            ps.setInt(9, stay.getNumGuests());
            ps.setInt(10, stay.getNumBaths());
            ps.setInt(11, stay.getNumBeds());
            ps.setInt(12, stay.getNumBedrooms());

            int rowsUpdate = ps.executeUpdate();

            return rowsUpdate > 0;
        }
    }

    /**
     * Método para eliminar una fila de la tabla Stays en la BBDD
     * @param idStay id stay
     * @return true si se ha eliminado una fila correctamente y false si no se ha eliminado
     * @throws SQLException
     */
    public boolean deleteStay(int idStay) throws SQLException
    {
        try (Connection conn = db.getConnection())
        {
            PreparedStatement ps = conn.prepareStatement(DELETE_STAY);
            ps.setInt(1, idStay);
            int rowsUpdate = ps.executeUpdate();

            return rowsUpdate > 0;
        }
    }

    /* PRIVATE METHODS */

    /**
     * Metodo privado auxiliar que nos devolverá una lista de Stay con la query pasada por parámetro
     *
     * @param sql consulta sql
     * @return lista de instancias de tipo Stay
     * @throws SQLException Si ocurre un error durante la consulta a la base de datos.
     */
    private List<Stay> getStays(String sql) throws SQLException, StayNotFoundException {
        List<Stay> stays = new ArrayList<>();

        try (Connection conn = db.getConnection())
        {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                stays.add(resultToStay(rs));
            }

            if (stays.isEmpty())
                throw new StayNotFoundException("No stays found");

            return stays;
        }
    }

    /**
     * Metodo sobrecargado privado auxiliar que nos devolverá una lista de Stay con la query pasada por parámetro
     *
     * @param sql consulta sql
     * @param idCategory número ID de la categoria relacionada con el Stay
     * @return lista de instancias de tipo Stay
     * @throws SQLException Si ocurre un error durante la consulta a la base de datos.
     */
    private List<Stay> getStays(String sql, int idCategory) throws SQLException, StayNotFoundException {
        List<Stay> stays = new ArrayList<>();

        try (Connection conn = db.getConnection())
        {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idCategory);
            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                stays.add(resultToStay(rs));
            }

            if (stays.isEmpty())
                throw new StayNotFoundException("No stays found");

            return stays;
        }
    }

    /**
     * Metodo sobrecargado privado auxiliar que nos devolverá una lista de Stay con la query pasada por parámetro
     *
     * @param sql consulta sql
     * @param city número ID de la ciudad del Stay
     * @return lista de instancias de tipo Stay
     * @throws SQLException Si ocurre un error durante la consulta a la base de datos.
     */
    private List<Stay> getStays(String sql, String city) throws SQLException, StayNotFoundException {
        List<Stay> stays = new ArrayList<>();

        try (Connection conn = db.getConnection())
        {
            String additionalQuery = "%" + city + "%";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, additionalQuery);
            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                stays.add(resultToStay(rs));
            }

            if (stays.isEmpty())
                throw new StayNotFoundException("No stays found");

            return stays;
        }
    }

    /**
     * Convierte una fila del ResultSet en una instancia de Stay.
     * Esta funcion también obtiene información relacionada como categoría, imágenes y características asociadas.
     *
     * @param result Fila del ResultSet que contiene los datos de una estancia.
     * @return Objeto Stay completo con sus relaciones cargadas.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    private Stay resultToStay(ResultSet result) throws SQLException
    {
        int idStay = result.getInt("id_stay");
        CategoriesDAO categoriesDAO = new CategoriesDAO();
        Category category = categoriesDAO.getCategoryById(result.getInt("id_category"));

        List<Feature> features = getFeaturesByIdStay(idStay);

        List<String> imagePaths = new ArrayList<>();
        for (HashMap<String, String> image : getImagesDataByStay(idStay))
        {
            imagePaths.add(image.get("path"));
        }

        String title = result.getString("titlename");
        String city = result.getString("city");
        String address = result.getString("location_address");
        String description = result.getString("description");
        float price = result.getFloat("price");
        int numGuests = result.getInt("num_guests");
        int numBaths = result.getInt("num_baths");
        int numBeds = result.getInt("num_beds");
        int numBedrooms = result.getInt("num_bedrooms");
        boolean active = result.getBoolean("active");

        return new Stay(idStay, title, description, city, address, price, active, category, imagePaths, features, numGuests, numBaths, numBeds, numBedrooms);
    }

    /**
     * Obtiene la lista de características asociadas a una estancia a partir de su ID.
     * Se basa en la tabla intermedia stay_feature para obtener los IDs y luego las entidades completas.
     *
     * @param idStay ID de la estancia para la que se quieren obtener las características.
     * @return Lista de objetos Feature asociados a la estancia.
     * @throws SQLException Si ocurre un error durante el acceso a la base de datos.
     */
    private List<Feature> getFeaturesByIdStay(int idStay) throws SQLException {
        StayFeatureDAO stayFeatureDAO = new StayFeatureDAO();
        FeaturesDAO featuresDAO = new FeaturesDAO();
        List<Integer> featureIds = stayFeatureDAO.getFeatureIdsByStay(idStay);
        List<Feature> features = new ArrayList<>();
        for (Integer idFeature : featureIds)
        {
            features.add(featuresDAO.getFeatureById(idFeature));
        }

        return features;
    }

    /**
     * Obtiene los datos de las imágenes asociadas a una estancia en forma de lista de HashMaps.
     * Cada HashMap representa una imagen con su ID, ruta, descripción y fecha de subida.
     *
     * @param idStay ID de la estancia cuyas imágenes se quieren obtener.
     * @return Lista de HashMaps donde cada uno contiene los datos de una imagen.
     * @throws SQLException Si ocurre un error durante la consulta a la base de datos.
     */
    public List<HashMap<String, String>> getImagesDataByStay(int idStay) throws SQLException
    {
        try (Connection conn = db.getConnection())
        {
            PreparedStatement ps = conn.prepareStatement(IMAGES_DATA_BY_STAY);
            ps.setInt(1, idStay);
            ResultSet rs = ps.executeQuery();

            List<HashMap<String, String>> images = new ArrayList<>();

            while(rs.next())
            {
                HashMap<String, String> imageData = new LinkedHashMap<>();
                imageData.put("idImage", rs.getString("id_image"));
                imageData.put("path", rs.getString("path_url"));
                imageData.put("description", rs.getString("description"));
                imageData.put("uploadDate", rs.getString("upload_date"));
                images.add(imageData);
            }

            return images;
        }
    }
}