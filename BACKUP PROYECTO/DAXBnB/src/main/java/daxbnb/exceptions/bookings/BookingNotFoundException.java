package daxbnb.exceptions.bookings;

/**
 * Lanza una excepcion cuando no se encuentra una reserva existente.
 * Podria suceder si al ingresar el ID, este no se ha encontrado.
 */
public class BookingNotFoundException extends Exception{
	public BookingNotFoundException(String message) {
		super(message);
	}
}
