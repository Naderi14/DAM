package daxbnb.model;

/**
 * Clase que nos dará la información de una reserva
 * 
 * @author Bianca Sanchez <bmszsanchez@alumnes.ilerna.com>
 * @since 0.1v
 */
public class Booking {
	/**
	 * Identificador único de la reserva.
	 */
	private int idBooking;

	/**
	 * Fecha de inicio de la reserva (en formato String).
	 */
	private String initDate;

	/**
	 * Fecha de finalización de la reserva (en formato String).
	 */
	private String endDate;

	/**
	 * Usuario que realiza la reserva.
	 */
	private User user;

	/**
	 * Alojamiento reservado.
	 */
	private Stay stay;

	/**
	 * Constructor que inicializa todos los atributos de la reserva.
	 * 
	 * @param idBooking
	 * @param initDate
	 * @param endDate
	 * @param user
	 * @param stay
	 */
	public Booking(int idBooking, String initDate, String endDate, User user, Stay stay) {
		this.idBooking = idBooking;
		this.initDate = initDate;
		this.endDate = endDate;
		this.user = user;
		this.stay = stay;
	}

	/**
	 * Constructor que inicializa todos los atributos de la reserva sin el ID.
	 *
	 * @param initDate
	 * @param endDate
	 * @param user
	 * @param stay
	 */
	public Booking(String initDate, String endDate, User user, Stay stay) {
		this.initDate = initDate;
		this.endDate = endDate;
		this.user = user;
		this.stay = stay;
	}

	/**
	 * Obtiene el ID de la reserva.
	 * 
	 * @return ID de la reserva.
	 */
	public int getIdBooking() {
		return idBooking;
	}

	/**
	 * Establece el ID de la reserva.
	 * 
	 * @param idBooking Nuevo ID de la reserva.
	 */
	public void setIdBooking(int idBooking) {
		this.idBooking = idBooking;
	}

	/**
	 * Obtiene la fecha de inicio de la reserva.
	 * 
	 * @return Fecha de inicio de la reserva.
	 */
	public String getInitDate() {
		return initDate;
	}

	/**
	 * Establece la fecha de inicio de la reserva.
	 * 
	 * @param initDate Nueva fecha de inicio.
	 */
	public void setInitDate(String initDate) {
		this.initDate = initDate;
	}

	/**
	 * Obtiene la fecha de finalización de la reserva.
	 * 
	 * @return Fecha de finalización de la reserva.
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * Establece la fecha de finalización de la reserva.
	 * 
	 * @param endDate Nueva fecha de finalización.
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * Obtiene el usuario que realizó la reserva.
	 * 
	 * @return Usuario que realiza la reserva.
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Establece el usuario que realiza la reserva.
	 * 
	 * @param user Usuario que realiza la reserva.
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Obtiene el alojamiento reservado.
	 * 
	 * @return Alojamiento de la reserva.
	 */
	public Stay getStay() {
		return stay;
	}

	/**
	 * Establece el alojamiento reservado.
	 * 
	 * @param stay Nuevo alojamiento de la reserva.
	 */
	public void setStay(Stay stay) {
		this.stay = stay;
	}

	/**
	 * Devuelve una representación en texto de la reserva.
	 * 
	 * @return Información detallada de la reserva en formato cadena.
	 */
	@Override
	public String toString() {
		return "Booking [idBooking=" + idBooking + ", initDate=" + initDate + ", endDate=" + endDate + ", user=" + user
				+ ", stay=" + stay + "]";
	}

}
