package daxbnb.exceptions.users;

/**
 * Excepción que se lanza cuando el usuario introducido ya existe.
 */
public class DuplicateUserException extends Exception {
	public DuplicateUserException(String message) {
		super(message);
	}
}
