package daxbnb.DAO;

import daxbnb.model.Feature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe per realitzar les consultes a la taula Features
 * @author Juan Francisco &lt;<b>ditarex95@gmail.com</b>&gt;
 * @since 0.1v
 */
public class FeaturesDAO {
    /**
     * Declarar variable tipus DBConnection per realitzar les conexions a la DB
     */
    private DBConnection db;

    private static final String CREATE_FEATURE = "{CALL features_insert_new(?)}";
    
    private static final String ALL_FEATURES = "SELECT * FROM features";
    
    private static final String FEATURE_BY_ID = "SELECT * FROM features WHERE id_feature = ?";
    
    private static final String DELETE_FEATURE = "{CALL features_delete_by_id(?)}";
    
    /**
     * Constructor per instanciar la conexió
     */
    public FeaturesDAO()
    {
        db = new DBConnection();
    }

    /**
     * Función que inserta una nueva fila a la BBDD a través de una consulta almacenada
     * @param feature instancia de la tabla feature
     * @return un true si la función funciona y un false si no funciona
     * @throws SQLException
     */
    public boolean createFeature(Feature feature) throws SQLException
    {
        try (Connection conn = db.getConnection())
        {
            PreparedStatement ps = conn.prepareStatement(CREATE_FEATURE);
            ps.setString(1, feature.getFeatureInfo());
            int rowsUpdate = ps.executeUpdate();

            return rowsUpdate > 0;
        }
    }

    /**
     * Metodo que nos devolverá una lista de tipo Feature con la query almacenada en la constante
     * @return una lista de instancias de tipo Feature
     * @throws SQLException Si ocurre un error durante la consulta a la base de datos.
     */
    public List<Feature> getAllFeatures() throws SQLException
    {
        List<Feature> features = new ArrayList<Feature>();

        try (Connection conn = db.getConnection())
        {
            PreparedStatement ps = conn.prepareStatement(ALL_FEATURES);
            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                features.add(resultToFeature(rs));
            }

            return features;
        }
    }

    /**
     * Metodo que nos devolverá una instancia de Feature con la query almacenada en la constante
     * @param idFeature id feature
     * @return una instancia de Feature
     * @throws SQLException Si ocurre un error durante la consulta a la base de datos.
     */
    public Feature getFeatureById(int idFeature) throws SQLException
    {
        try (Connection conn = db.getConnection())
        {
            PreparedStatement ps = conn.prepareStatement(FEATURE_BY_ID);
            ps.setInt(1, idFeature);
            ResultSet rs = ps.executeQuery();

            if (rs.next())
                return resultToFeature(rs);
            else
                return null;
        }
    }
    
    /**
     * Método que nos borrará una fila de la tabla feature de la BBDD
     * @param idFeature id feature
     * @return un true si ha afectado el delete a alguna fila o un false si no ha ocurrido nada
     * @throws SQLException
     */
    public boolean deleteFeature(int idFeature) throws SQLException
    {
        try (Connection conn = db.getConnection())
        {
            PreparedStatement ps = conn.prepareStatement(DELETE_FEATURE);
            ps.setInt(1, idFeature);
            int rowsUpdate = ps.executeUpdate();

            return rowsUpdate > 0;
        }
    }

    /**
     * Metodo que nos devolverá una instancia de tipo Feature con los datos del ResultSet
     * @param result Fila de datos ResultSet donde extraeremos la información de una fila de la tabla features
     * @return una instancia de tipo Feature
     * @throws SQLException Si ocurre un error durante la consulta a la base de datos.
     */
    private Feature resultToFeature(ResultSet result) throws SQLException
    {
        int idFeature = result.getInt("id_feature");
        String featureInfo = result.getString("feature_info");
        return new Feature(idFeature, featureInfo);
    }
}
