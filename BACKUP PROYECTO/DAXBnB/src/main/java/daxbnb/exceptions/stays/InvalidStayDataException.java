package daxbnb.exceptions.stays;
/**
 * Se lanza cuando los datos introducidos del alojamiento(Stay) no son validos.
 * Podria pasar si la base de datos rechaza los datos introducidos.
 */
public class InvalidStayDataException extends Exception {
	public InvalidStayDataException(String message) {
		super(message);
	}
}
