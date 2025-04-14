import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    private static DBConnection db;

    public static void main(String[] args)
    {
        db = new DBConnection();

        try (Connection conn = db.getConnection()){
            ResultSet resultSet = conn.createStatement().executeQuery("SELECT * FROM users");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") + " " + resultSet.getString("surname"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}