package daxbnb;

import java.sql.SQLException;
import java.util.List;

import daxbnb.DAO.BookingsDAO;
import daxbnb.DAO.StayFeatureDAO;
import daxbnb.exceptions.stays.StayNotFoundException;
import daxbnb.exceptions.users.UserNotFoundException;
import daxbnb.DAO.StaysDAO;
import daxbnb.model.Booking;
import daxbnb.model.Stay;

public class MainJavier {
	public static void main(String[] args) {
		// TAREA 99-BOOKINGSDAO
		// Método getBookingsByUser
		try {
            BookingsDAO bookingsDAO = new BookingsDAO();
            List<Booking> bookings = bookingsDAO.getBookingsByIdUser(4);
            System.out.println("\nBookings List charged - getBookingsByUser");
            bookings.forEach(System.out::println);
        } catch (SQLException | UserNotFoundException | StayNotFoundException e) {
            throw new RuntimeException(e);
        }
		
		//Método getAllBookings
		try {
            BookingsDAO bookingsDAO = new BookingsDAO();
            List<Booking> bookings = bookingsDAO.getAllBookings();
            System.out.println("\nBookings List charged - getAllBookings");
            bookings.forEach(System.out::println);
        } catch (SQLException | UserNotFoundException | StayNotFoundException e) {
            throw new RuntimeException(e);
        }
		
		//Método getBookingsById
		try {
            BookingsDAO bookingsDAO = new BookingsDAO();
            Booking bookings = bookingsDAO.getBookingById(3);
            System.out.println("\nBookings List charged - getBookingsById");
            System.out.println(bookings);
        } catch (SQLException | UserNotFoundException | StayNotFoundException e) {
            throw new RuntimeException(e);
        }
		
		//Método getFeatureIdsByStay
		try {
			BookingsDAO bookingsDAO = new BookingsDAO();
			List<Booking> bookings = bookingsDAO.getBookingsByIdStay(4);
			System.out.println("\nBookings List charged - getFeatureIdsByStay");
			bookings.forEach(System.out::println);
		} catch (SQLException | UserNotFoundException | StayNotFoundException e) {
			throw new RuntimeException(e);
		}

		// Método getAllBookings
		try {
			BookingsDAO bookingsDAO = new BookingsDAO();
			List<Booking> bookings = bookingsDAO.getAllBookings();
			System.out.println("\nBookings List charged - getAllBookings");
			bookings.forEach(System.out::println);
		} catch (SQLException | UserNotFoundException | StayNotFoundException e) {
			throw new RuntimeException(e);
		}

		// Método getBookingsById
		try {
			BookingsDAO bookingsDAO = new BookingsDAO();
			Booking bookings = bookingsDAO.getBookingById(3);
			System.out.println("\nBookings List charged - getBookingsById");
			System.out.println(bookings);
		} catch (SQLException | UserNotFoundException | StayNotFoundException e) {
			throw new RuntimeException(e);
		}

		// TAREA 103 - STAYFEATURESDAO
		// Método getFeatureIdsByStay
		try {
			StayFeatureDAO stayFeatureDAO = new StayFeatureDAO();
			List<Integer> stayFeature = stayFeatureDAO.getFeatureIdsByStay(3);
			System.out.println("\nInteger List charged - getFeatureIdsByStay");
			stayFeature.forEach(System.out::println);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		// TAREA 104-STAYSDAO
		// Método getAllStays
		try {
			StaysDAO staysDAO = new StaysDAO();
			List<Stay> stay = staysDAO.getAllStays();
			System.out.println("\nStays List charged - getAllStays");
			stay.forEach(System.out::println);
		} catch (SQLException | StayNotFoundException e) {
			throw new RuntimeException(e);
		}

		// Método getStaysByCategory
		try {
			StaysDAO staysDAO = new StaysDAO();
			List<Stay> stay = staysDAO.getStaysByCategory(3);
			System.out.println("\nStays List charged - getStaysByCategory");
			stay.forEach(System.out::println);
		} catch (SQLException | StayNotFoundException e) {
			throw new RuntimeException(e);
		}

		// Método getStaysSortedByName
		try {
			StaysDAO staysDAO = new StaysDAO();
			List<Stay> stay = staysDAO.getStaysSortedByName();
			System.out.println("\nStays List charged - getStaysSortedByName");
			stay.forEach(System.out::println);
		} catch (SQLException | StayNotFoundException e) {
			throw new RuntimeException(e);
		}

		// Método getStaysSortedByPrice
		try {
			StaysDAO staysDAO = new StaysDAO();
			List<Stay> stay = staysDAO.getStaysSortedByPrice();
			System.out.println("\nStays List charged - getStaysSortedByPrice");
			stay.forEach(System.out::println);
		} catch (SQLException | StayNotFoundException e) {
			throw new RuntimeException(e);
		}

		// Método getStaysSearchedByCity
		try {
			StaysDAO staysDAO = new StaysDAO();
			List<Stay> stay = staysDAO.getStaysSearchedByCity("Teruel");
			System.out.println("\nStays List charged - getStaysSearchedByCity");
			stay.forEach(System.out::println);
		} catch (SQLException | StayNotFoundException e) {
			System.out.println("La funcion ha sido comprobada");
			throw new RuntimeException(e);
		}

		// Método getStayById
		try {
			StaysDAO staysDAO = new StaysDAO();
			Stay stay = staysDAO.getStayById(3);
			System.out.println("\nStays List charged - getStayById");
			System.out.println(stay);
		} catch (SQLException | StayNotFoundException e) {
			throw new RuntimeException(e);
		}

		// Método getAvailableStays
		try {
			StaysDAO staysDAO = new StaysDAO();
			List<Stay> stay = staysDAO.getAvailableStays();
			System.out.println("\nBookings List charged - getAvailableStays");
			stay.forEach(System.out::println);
		} catch (SQLException | StayNotFoundException e) {
			throw new RuntimeException(e);
		}

	}
}
