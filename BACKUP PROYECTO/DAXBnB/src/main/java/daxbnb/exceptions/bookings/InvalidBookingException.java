package daxbnb.exceptions.bookings;

/**
 * Esta excepeción se lanza cuando al subir un Booking algun dato es invalido o falta.
 */
public class InvalidBookingException extends Exception {
	public InvalidBookingException(String message) {
		super(message);
	}
}
