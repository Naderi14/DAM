package daxbnb.exceptions.images;

/**
 * Excepcion que se lanza cuando la imagen no se ha subido correctamente.
 * Comprende errores como fallos durante el proceso de subida o dimensiones invalidas.
 */
public class ImageUploadException extends Exception {
	public ImageUploadException(String message) {
		super(message);
	}
}
