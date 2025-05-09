package daxbnb.loadData;

import daxbnb.DAO.BookingsDAO;
import daxbnb.DAO.CategoriesDAO;
import daxbnb.DAO.FeaturesDAO;
import daxbnb.DAO.ImagesDAO;
import daxbnb.DAO.StayFeatureDAO;
import daxbnb.DAO.StaysDAO;
import daxbnb.DAO.UsersDAO;
import daxbnb.exceptions.stays.StayNotFoundException;
import daxbnb.exceptions.users.UserNotFoundException;
import daxbnb.model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Clase para intermediar los datos de archivos .csv a los DAO para subirlos a la BBDD
 * @author Juan Francisco &lt;<b>ditarex95@gmail.com</b>&gt;
 * @since 0.2v
 */
public class LoadData {
    /**
     * Método que simplifica la llamada a todas las funciones de LoadData para cargar todos los csv si se tienen en el mismo momento.
     * Además muestra con log si han ido cargando correctamente o no
     * @param clientsPath ruta csv clientes
     * @param adminsPath ruta csv admins
     * @param staysPath ruta csv stays
     * @param bookingsPath ruta csv bookings
     * @param featuresPath ruta csv features
     * @param categoriesPath ruta csv categories
     * @param imagesPath ruta csv images
     * @param stayFeaturesPath ruta csv stay feature
     */
    public static void loadAll(String clientsPath, String adminsPath, String staysPath, String bookingsPath, String featuresPath,
                                  String categoriesPath, String imagesPath, String stayFeaturesPath)
    {
        System.out.println(loadClients(clientsPath) ? "Clients loaded" : "Error");
        System.out.println(loadAdmins(adminsPath) ? "Admins loaded" : "Error");
        System.out.println(loadStays(staysPath) ? "Stays loaded" : "Error");
        System.out.println(loadBookings(bookingsPath) ? "Bookings loaded" : "Error");
        System.out.println(loadFeatures(featuresPath) ? "Features loaded" : "Error");
        System.out.println(loadCategories(categoriesPath) ? "Categories loaded" : "Error");
        System.out.println(loadImages(imagesPath) ? "Images loaded" : "Error");
        System.out.println(loadStayFeatures(stayFeaturesPath) ? "StayFeatures loaded" : "Error");
    }

    /**
     * Método que realiza la carga de datos desde un archivo csv de usuarios
     * @deprecated No se va a usar por ahora por razones de contexto
     * @param filePath ruta del archivo csv a cargar en el buffer
     * @return boolean true si se ha realizado correctamente la carga de datos a la BBDD
     */
    public static boolean loadUsers(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            UsersDAO usersDAO = new UsersDAO();
            br.readLine(); // Saltar la primera fila que son los nombres de las columnas
            while ((line = br.readLine()) != null)
            {
                String[] data = line.split(";");
                usersDAO.insertUser(new User(data[1], data[2], data[3], data[4], data[5], data[6], data[0]));
            }
            return true;
        }
        catch (IOException | SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * Método que realiza la carga de datos desde un archivo csv de clients
     * @param filePath ruta del archivo csv a cargar en el buffer
     * @return boolean true si se ha realizado correctamente la carga de datos al DAO
     */
    public static boolean loadClients(String filePath)
    {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            UsersDAO usersDAO = new UsersDAO();
            br.readLine();
            while ((line = br.readLine()) != null)
            {
                String[] data = line.split(";");
                usersDAO.insertClient(new Client(data[1], data[2], data[3], data[4], data[5], data[6], data[0], data[7], data[8], data[9]));
            }
            return true;
        }
        catch (IOException | SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * Método que realiza la carga de datos desde un archivo csv de admins
     * @param filePath ruta del archivo csv a cargar en el buffer
     * @return boolean true si se ha realizado correctamente la carga de datos al DAO
     */
    public static boolean loadAdmins(String filePath)
    {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            UsersDAO usersDAO = new UsersDAO();
            br.readLine();
            while ((line = br.readLine()) != null)
            {
                String[] data = line.split(";");
                usersDAO.insertAdmin(new Admin(data[1], data[2], data[3], data[4], data[5], data[6], data[0], Integer.parseInt(data[7])));
            }
            return true;
        }
        catch (IOException | SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * Método que realiza la carga de datos desde un archivo csv de stays
     * @param filePath ruta del archivo csv a cargar en el buffer
     * @return boolean true si se ha realizado correctamente la carga de datos al DAO
     */
    public static boolean loadStays(String filePath)
    {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            StaysDAO staysDAO = new StaysDAO();
            br.readLine(); // Saltar la primera fila que son los nombres de las columnas
            while ((line = br.readLine()) != null)
            {
                String[] data = line.split(";");
                CategoriesDAO categoriesDAO = new CategoriesDAO();
                staysDAO.createStay(new Stay(data[1], data[4], data[2], data[3], Float.parseFloat(data[5]), Boolean.parseBoolean(data[6]),
                        categoriesDAO.getCategoryById(Integer.parseInt(data[0])), new ArrayList<>(), new ArrayList<>(),
                        Integer.parseInt(data[7]), Integer.parseInt(data[8]), Integer.parseInt(data[9]), Integer.parseInt(data[10])));
            }
            return true;
        }
        catch (IOException | SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * Método que realiza la carga de datos desde un archivo csv de bookings
     * @param filePath ruta del archivo csv a cargar en el buffer
     * @return boolean true si se ha realizado correctamente la carga de datos a la BBDD
     */
    public static boolean loadBookings(String filePath)
    {
    	try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            BookingsDAO bookingsDAO = new BookingsDAO();
            br.readLine(); 
            while ((line = br.readLine()) != null)
            {
                String[] data = line.split(";");
                UsersDAO usersDAO = new UsersDAO();
                StaysDAO staysDAO = new StaysDAO();
                bookingsDAO.createBooking(new Booking(data[0], data[1], usersDAO.getUserById(Integer.parseInt(data[2])), staysDAO.getStayById(Integer.parseInt(data[3]))));
            }
            return true;
        }
        catch (IOException | SQLException | UserNotFoundException | StayNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Método que realiza la carga de datos desde un archivo csv de stay feature
     * @param filePath ruta del archivo csv a cargar en el buffer
     * @return boolean true si se ha realizado correctamente la carga de datos a la BBDD
     */
    public static boolean loadStayFeatures(String filePath)
    {
    	try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            StayFeatureDAO stayFeatureDAO = new StayFeatureDAO();
            br.readLine(); 
            while ((line = br.readLine()) != null)
            {
                String[] data = line.split(";");
                stayFeatureDAO.addFeatureToStay(Integer.parseInt(data[1]), Integer.parseInt(data[0]));
            }
            return true;
        }
        catch (IOException | SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * Método que realiza la carga de datos desde un archivo csv de categories
     * @param filePath ruta del archivo csv a cargar en el buffer
     * @return boolean true si se ha realizado correctamente la carga de datos a la BBDD
     */
    public static boolean loadCategories(String filePath)
    {
    	try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            CategoriesDAO categoriesDAO = new CategoriesDAO();
            br.readLine();
            while ((line = br.readLine()) != null)
            {
                categoriesDAO.insertCategory(new Category(line));
            }
            return true;
        }
        catch (IOException | SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Método que realiza la carga de datos desde un archivo csv de features
     * @param filePath ruta del archivo csv a cargar en el buffer
     * @return boolean true si se ha realizado correctamente la carga de datos a la BBDD
     */
    public static boolean loadFeatures(String filePath)
    {
    	try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            FeaturesDAO featuresDAO = new FeaturesDAO();
            br.readLine();
            while ((line = br.readLine()) != null)
            {
                featuresDAO.createFeature(new Feature(line));
            }
            return true;
        }
        catch (IOException | SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * Método que realiza la carga de datos desde un archivo csv de images
     * @param filePath ruta del archivo csv a cargar en el buffer
     * @return boolean true si se ha realizado correctamente la carga de datos a la BBDD
     */
    public static boolean loadImages(String filePath)
    {
    	try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            ImagesDAO imagesDAO = new ImagesDAO();
            br.readLine(); 
            while ((line = br.readLine()) != null)
            {
                String[] data = line.split(";");
                imagesDAO.addImageToStay(data[0], data[1], Integer.parseInt(data[2]));
            }
            return true;
        }
        catch (IOException | SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
