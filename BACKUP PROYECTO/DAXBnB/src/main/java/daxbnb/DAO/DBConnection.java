package daxbnb.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Juan Francisco &lt;<b>ditarex95@gmail.com</b>&gt;
 * @since 0.1v
 * Clase que realitza la conexió a la BBDD
 */
public class DBConnection {
    /**
     * Variables constants on s'enmagatzenen les dades de la BBDD
     */
    private static final String URL = "jdbc:mysql://barcelona.skimdoo.com:3306/daxbnb";
    private static final String USER = "root";
    private static final String PASS = "rootpass";

    public DBConnection()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

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
