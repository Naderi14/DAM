package daxbnb;

import java.sql.SQLException;
import java.util.List;

import daxbnb.DAO.BookingsDAO;
import daxbnb.DAO.CategoriesDAO;
import daxbnb.DAO.FeaturesDAO;
import daxbnb.DAO.UsersDAO;
import daxbnb.exceptions.stays.StayNotFoundException;
import daxbnb.exceptions.users.InvalidLoginException;
import daxbnb.exceptions.users.UserNotFoundException;
import daxbnb.model.Booking;
import daxbnb.model.Category;
import daxbnb.model.Feature;
import daxbnb.model.User;

public class MainBianca {

	public static void main(String[] args) {
		//TAREA 100-CategoriesDAO
		//IMPRIMIR LISTA DE CATEGORIA
		try {
			CategoriesDAO categoriesDAO = new CategoriesDAO();
			List<Category> categories = categoriesDAO.getAllCategories(); 
			System.out.println("Categories List");
			categories.forEach(System.out::println);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		//IMPRIMIR CATEGORIA CON ID INGRESADO
		try {
			CategoriesDAO categoriesDAO = new CategoriesDAO();
			Category category = categoriesDAO.getCategoryById(2);
			System.out.println("Categories by ID");
			System.out.println(category);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
		//TAREA 101-FeaturesDAO
		//IMPRIMIR LISTA DE FEATURES
		try {
			FeaturesDAO featuresDAO = new FeaturesDAO();
			List<Feature> features = featuresDAO.getAllFeatures();
			System.out.println("Features List");
			features.forEach(System.out::println);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		//IMPRIMIR FEATURE CON ID INGRESADO
		try {
			FeaturesDAO featuresDAO = new FeaturesDAO();
			Feature feature = featuresDAO.getFeatureById(3);
			System.out.println("Features by ID");
			System.out.println(feature);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		//TAREA 105-UsersDAO
		//IMPRIMIR USER CON ID INGRESADO
		try {
			UsersDAO usersDAO = new UsersDAO();
			User user = usersDAO.getUserById(5);
			System.out.println("Users by ID");
			System.out.println(user);
		}catch(SQLException | UserNotFoundException e){
			throw new RuntimeException(e);
		}

        //IMPRIMIR LISTA DE USER
		try {
			UsersDAO usersDAO = new UsersDAO();
			List<User> user = usersDAO.getAllUsers();
			System.out.println("User List");
			user.forEach(System.out::println);
		}catch(SQLException | UserNotFoundException e){
			throw new RuntimeException(e);
		}

        //IMPRIMIR USER POR SU DNI
		try {
			UsersDAO usersDAO = new UsersDAO();
			User user = usersDAO.getUserByDni("56789012E");
			System.out.println("Users by DNI");
			System.out.println(user);
		}catch (SQLException | UserNotFoundException e){
			throw new RuntimeException(e);
		}
		
		//VALIDA EL LOGIN DE UN USER
		try {
			UsersDAO usersDAO = new UsersDAO();
			User login = usersDAO.login("pedrol", "1234");
			System.out.println("Login");
			System.out.println(login);
		}catch(SQLException | InvalidLoginException | UserNotFoundException e) {
			throw new RuntimeException(e);
		}

		//IMPRIMIR LISTA DE BOOKING CON ID DE STAY
		try {
			BookingsDAO bookingsDAO = new BookingsDAO();
			List<Booking> booking = bookingsDAO.getBookingsByIdStay(2);
			System.out.println("Booking List By ID Stay");
			booking.forEach(System.out::println);
		}catch(SQLException | UserNotFoundException | StayNotFoundException e) {
			throw new RuntimeException(e);
		}

		}
}
