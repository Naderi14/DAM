package daxbnb.exceptions.common;

/**
 * Se lanza cuando ocurre un error inesperado al interactuar con la base de datos.
 * Esta excepción encapsula errores técnicos (SQLException, etc.) y los traduce
 * en mensajes de alto nivel para el frontend.
 */
public class DatabaseException extends Exception {
    public DatabaseException(String message) {
        super(message);
    }
}
