package daxbnb.exceptions.bookings;

/**
 * Esta excepción se lanza cuando hay un conflicto al reservear en una fecha donde ya hay una reserva de antes.
 */
public class BookingConflictException extends Exception {
	public BookingConflictException (String message) {
		super(message);
	}
}
