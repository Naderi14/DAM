package daxbnb.exceptions.users;

/**
 * Se lanza cuando no se encuentra un usuario con el identificador proporcionado,
 * ya sea por ID, DNI, email o username.
 */
public class UserNotFoundException extends Exception {
  public UserNotFoundException(String message) {
    super(message);
  }
}
