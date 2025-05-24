package daxbnb.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Classe per realitzar les consultes a la taula Images
 * @author Juan Francisco &lt;<b>ditarex95@gmail.com</b>&gt;
 * @since 0.1v
 */
public class ImagesDAO {
    /**
     * Declarar variable tipus DBConnection per realitzar les conexions a la DB
     */
    private DBConnection db;

    private static final String ADD_IMAGE_TO_STAY = "{CALL images_add_new(?, ?, ?)}";
    
    private static final String REMOVE_IMAGE_FROM_STAY = "{CALL images_remove_from_stay(?, ?)}";

    private static final String UPDATE_IMAGE_BY_ID = "{CALL images_update_by_id(?, ?, ?)}";
    
    /**
     * Constructor per instanciar la conexió
     */
    public ImagesDAO()
    {
        db = new DBConnection();
    }

    /**
     * Método para registrar una imagen en la BBDD con sus datos básicos
     * @param pathUrl Url de la imagen
     * @param description descripción de la imagen
     * @param idStay id de Stay
     * @return true si se ha insertado la imagen correctamente y false si no lo ha conseguido
     * @throws SQLException
     */
    public boolean addImageToStay(String pathUrl, String description, int idStay) throws SQLException
    {
        try (Connection conn = db.getConnection())
        {
            PreparedStatement ps = conn.prepareStatement(ADD_IMAGE_TO_STAY);
        	ps.setString(1, pathUrl);
        	ps.setString(2, description);
        	ps.setInt(3, idStay);
        	
        	int rowsUpdate = ps.executeUpdate();
        	
        	return rowsUpdate > 0;
        }
    }

    public boolean updateImageById(int idImage, String pathUrl, String description) throws SQLException
    {
        try (Connection conn = db.getConnection())
        {
            PreparedStatement ps = conn.prepareStatement(UPDATE_IMAGE_BY_ID);
            ps.setString(1, pathUrl);
            ps.setString(2, description);
            ps.setInt(3, idImage);

            int rowsUpdate = ps.executeUpdate();

            return rowsUpdate > 0;
        }
    }

    /**
     * Método que elimina una imagen de la BBDD
     * @param idImage id de la imagen
     * @param idStay id del stay
     * @return true si la imagen se ha eliminado correctamente y false si no lo ha conseguido
     * @throws SQLException 
     */
    public boolean removeImageFromStay(int idImage, int idStay) throws SQLException
    {
        try (Connection conn = db.getConnection())
        {
            PreparedStatement ps = conn.prepareStatement(REMOVE_IMAGE_FROM_STAY);
        	ps.setInt(1, idImage);
        	ps.setInt(2, idStay);
        	
        	int rowsUpdate = ps.executeUpdate();
        	
        	return rowsUpdate > 0;
       	}
    }
}
