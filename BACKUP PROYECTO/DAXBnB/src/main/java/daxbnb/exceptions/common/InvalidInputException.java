package daxbnb.exceptions.common;

/**
 * Se lanza cuando un campo recibido no cumple con las reglas de validación esperadas,
 * como valores nulos, strings vacíos, formatos incorrectos, etc.
 */
public class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}
