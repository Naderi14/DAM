import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Juan Francisco <ditarex95@gmail.com>
 * @since 0.1v
 * Clase que realitza la conexió a la BBDD
 */
public class DBConnection {
    /**
     * Variables constants on s'enmagatzenen les dades de la BBDD
     */
    private static final String URL = "jdbc:mysql://localhost:3306/daxbnb";
    private static final String USER = "root";
    private static final String PASS = "rootpass";

    /**
     * Funció estàtica que utilitzarem els credencials per establir la conexió
     * @return La conexió amb la BBDD, podrem utilitzar aquesta funció per fer la resta de tasques
     * @throws SQLException en cas d'error ens llença una excepció SQL
     */
    public Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    /**
     * Función estàtica para cerrar la conexión con la BBDD
     * @param conn Li pasem la conexió oberta per entrada
     * @throws SQLException en cas d'error ens llença una excepció SQL
     */
    public void closeConnection(Connection conn) throws SQLException
    {
        conn.close();
    }
}
