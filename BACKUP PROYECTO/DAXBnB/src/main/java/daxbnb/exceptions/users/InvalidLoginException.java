package daxbnb.exceptions.users;

/**
 * Se lanza cuando las credenciales proporcionadas por el usuario son incorrectas
 * (usuario no existe o contraseña incorrecta).
 */
public class InvalidLoginException extends Exception {
    public InvalidLoginException(String message) {
        super(message);
    }
}
