package daxbnb;

import daxbnb.DAO.*;
import daxbnb.exceptions.stays.StayNotFoundException;
import daxbnb.exceptions.users.InvalidLoginException;
import daxbnb.exceptions.users.UserNotFoundException;
import daxbnb.loadData.LoadData;
import daxbnb.loadScripts.RunScript;
import daxbnb.model.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainFran {
    public static void main(String[] args)
    {
        /*String sqlPath = "scripts/BBDD_script_and_inserts.sql";

        try
        {
            RunScript.executeSQLScript(sqlPath);
            System.out.println("El Script se ha leido correctamente");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }*/

        /*String csvClients = "files/csv/clients.csv";
        String csvAdmins = "files/csv/admins.csv";
        String csvBookings = "files/csv/bookings.csv";
        String csvCategories = "files/csv/categories.csv";
        String csvFeatures = "files/csv/features.csv";
        String csvImages = "files/csv/images.csv";
        String csvStays = "files/csv/stays.csv";
        String csvStayFeatures = "files/csv/stay_feature.csv";

        LoadData.loadClients(csvClients);*/

        // IMPRIMIR CATEGORIES
        /*try {
            CategoriesDAO categoriesDAO = new CategoriesDAO();
            List<Category> categories = categoriesDAO.getAllCategories();
            System.out.println("\nCategories List charged");
            categories.forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // IMPRIMIR FEATURES
        try {
            FeaturesDAO featuresDAO = new FeaturesDAO();
            List<Feature> features = featuresDAO.getAllFeatures();
            System.out.println("\nFeatures List charged");
            features.forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // IMPRIMIR BOOKINGS
        try {
            BookingsDAO bookingsDAO = new BookingsDAO();
            List<Booking> bookings = bookingsDAO.getAllBookings();
            System.out.println("\nBookings List charged");
            bookings.forEach(System.out::println);
        } catch (SQLException | UserNotFoundException | StayNotFoundException e) {
            throw new RuntimeException(e);
        }*/

        // IMPRIMIR STAYS
        try {
            UsersDAO usersDAO = new UsersDAO();
            User user = usersDAO.login("mariag", "1234");
            System.out.println("\nUser login");
            System.out.println("\nUser: " + user);
        } catch (SQLException | InvalidLoginException | UserNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
