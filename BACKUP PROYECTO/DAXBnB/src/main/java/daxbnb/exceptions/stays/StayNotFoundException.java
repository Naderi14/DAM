package daxbnb.exceptions.stays;

/**
 * Se lanza cuando no se encuentra un alojamiento (stay) con el identificador especificado.
 * Generalmente se produce durante búsquedas por ID o al intentar acceder a detalles de un alojamiento.
 */
public class StayNotFoundException extends Exception {
    public StayNotFoundException(String message) {
        super(message);
    }
}
