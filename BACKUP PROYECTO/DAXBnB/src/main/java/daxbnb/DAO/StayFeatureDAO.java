package daxbnb.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe per realitzar les consultes a la taula StayFeature
 * @since 0.1v
 */
public class StayFeatureDAO {
    /**
     * Declarar variable tipus DBConnection per realitzar les conexions a la DB
     */
    private DBConnection db;

    private static final String FEATURE_TO_STAY = "{CALL has_features_add_feature_to_stay(?,?)}";
    
    private static final String REMOVE_FEATURE_FROM_STAY = "{CALL has_features_remove_feature_from_stay(?)}";
    
    private static final String FEATURE_IDS_BY_STAY = "SELECT * FROM stay_feature WHERE id_stay = ?";
    
    private static final String DELETE_ALL_FEATURES_FROM_STAY = "{CALL has_features_delete_all_features_from_stay(?)}";
    
    /**
     * Constructor per instanciar la conexió
     */
    public StayFeatureDAO()
    {
        db = new DBConnection();
    }

    //TODO: Crear los JavaDocs de las funciones de StayFeatureDAO ->

    /**
     * Metodo que ejecuta una consulta para relacionar un stay y un feature a la tabla stay_feature.
     * @param idStay numero identificador de Stay que entra por parametro
     * @param idFeature numero identificador de Feature que entra por parametro
     * @return verdadero en caso de que se cumpla la funcion y falso en caso contrario
     * @throws SQLException
     */
    public boolean addFeatureToStay(int idStay, int idFeature) throws SQLException
    {
    	try (Connection conn = db.getConnection())
        {
            PreparedStatement ps = conn.prepareStatement(FEATURE_TO_STAY);
        	ps.setInt(1, idStay);
        	ps.setInt(2, idFeature);
        	int rowsUpdate = ps.executeUpdate();
        	
        	return rowsUpdate > 0;
        }
    }

    /**
     * Metodo que ejecuta una consulta para eliminar información de feature y Stay a la tabla stay_feature
     * @param idStay número identificador de Stay que entra por parametro
     * @param idFeature numero identificador de Feature que entra por parametro
     * @return verdadero en caso de que se cumpla la funcion y falso en caso contrario
     * @throws SQLException
     */
    public boolean removeFeatureFromStay(int idStay, int idFeature) throws SQLException
    {
        try (Connection conn = db.getConnection())
        {
            PreparedStatement ps = conn.prepareStatement(REMOVE_FEATURE_FROM_STAY);
        	ps.setInt(1, idStay);
        	ps.setInt(2, idFeature);
        	int rowsUpdate = ps.executeUpdate();
        	
        	return rowsUpdate > 0;
        }
    }
    /**
     * Metodo que ejecuta una consulta para devolver los id's de Feature de la tabla stay_feature
     * @param idStay numero identificador de Stay que entra por parametro
     * @return una lista de enteros
     * @throws SQLException
     */
    public List<Integer> getFeatureIdsByStay(int idStay) throws SQLException
    {
    	List<Integer> integer = new ArrayList<>();

        try (Connection conn = db.getConnection())
        {
            PreparedStatement ps = conn.prepareStatement(FEATURE_IDS_BY_STAY);
        	ps.setInt(1, idStay);
        	ResultSet rs = ps.executeQuery();
        	
        	while(rs.next()) 
        	{
        		int id = rs.getInt("id_feature");
        		integer.add(id);
        	}
        }
		return integer;
    }
    
    /**
     * Metodo que ejecuta una consulta para eliminar las Features de Stay de la tabla stay_feature
     * @param idStay numero identificador de Stay que entra por parametro
     * @return verdadero en caso de que se cumpla la funcion y falso en caso contrario
     * @throws SQLException
     */
    public boolean deleteAllFeaturesFromStay(int idStay) throws SQLException
    {
    	try (Connection conn = db.getConnection())
        {
            PreparedStatement ps = conn.prepareStatement(DELETE_ALL_FEATURES_FROM_STAY);
        	ps.setInt(1, idStay);
        	int rowsUpdate = ps.executeUpdate();
        	
        	return rowsUpdate > 0;
        }
    }
}
