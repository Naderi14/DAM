package daxbnb.exceptions.stays;

/**
 * Esta excepción se lanza cuando no se puede acceder a un alojamiento (Stay).
 * Sucede cuando un usuario intenta acceder o reservar un alojamiento y no esta disponible o es inaccesible.
 */
public class StayUnavailableException extends Exception {
	public StayUnavailableException(String message) {
		super(message);
	}
}
