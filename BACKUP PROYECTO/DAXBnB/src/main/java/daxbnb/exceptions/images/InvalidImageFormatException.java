package daxbnb.exceptions.images;

/**
 * Excepcion que se lanza cuando la imagen no completa con los formatos especificados.
 * Podría pasar si el formato de la imagen no es PNG.
 */
public class InvalidImageFormatException extends Exception {
	public InvalidImageFormatException(String message) {
		super(message);
	}
}
