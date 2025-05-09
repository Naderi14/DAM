package daxbnb.loadScripts;

import daxbnb.DAO.DBConnection;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase para cargar un script .sql y ejecutarlo directamente hacia la BBDD
 * @author Juan Francisco &lt;<b>ditarex95@gmail.com</b>&gt;
 * @since 0.2v
 */
public class RunScript {
    private static DBConnection db = new DBConnection();

    /**
     * Método para ejecutar un script SQL a partir de su ruta relativa o absoluta
     * @param filePath ruta relativa o absoluta
     * @return boolean
     * @throws SQLException
     */
    public static boolean executeSQLScript(String filePath) throws SQLException
    {
        boolean result = true;

        try
        {
            Statement st = db.getConnection().createStatement();
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            StringBuilder sqlScript = new StringBuilder();
            boolean dropedTable = false;
            String line;

            while ((line = br.readLine()) != null)
            {
                if (line.trim().isEmpty() || line.trim().startsWith("--"))
                    continue;

                sqlScript.append(line);

                if (line.trim().endsWith(";"))
                {
                    try
                    {
                        st.execute(sqlScript.toString().replace(";", "").trim());
                        if (dropedTable)
                        {
                            db.closeConnection(st.getConnection());
                            st = db.getConnection().createStatement();
                            dropedTable = false;
                        }
                        sqlScript.setLength(0);
                    }
                    catch (SQLException e)
                    {
                        result = false;
                    }
                }

                if (line.trim().contains("DROP DATABASE IF EXISTS daxbnb1;"))
                    dropedTable = true;
            }

            db.closeConnection(st.getConnection());
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        return result;
    }
}
