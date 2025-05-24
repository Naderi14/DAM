package daxbnb.model;

/**
 * @author Bianca Sanchez <bmszsanchez@alumnes.ilerna.com>
 * 
 * @since 0.1v
 * 
 * Clase que hereda de usuario que representa un client registrado en la plataforma
 * 
 *
 */
public class Client extends User {
	/**
	 * Dirección del cliente.
	 */
	private String address;
	
	/**
	 * Fecha de nacimiento del cliente.
	 */
	private String birthDate;
	
	/**
	 * Descripción o biografía del cliente.
	 */
	private String description;
	
	/**
	 * Constructor de la clase Client completo.
	 * 
	 * @param idUser      Identificador del usuario (heredado de User).
	 * @param name        Nombre del usuario (heredado de User).
	 * @param surname     Apellido del usuario (heredado de User).
	 * @param email       Correo electrónico del usuario (heredado de User).
	 * @param phone       Teléfono de contacto del usuario (heredado de User).
	 * @param username    Nombre de usuario para iniciar sesión (heredado de User).
	 * @param password    Contraseña del usuario (heredado de User).
	 * @param dni         Documento de Identidad del usuario (heredado de User).
	 * @param address      Dirección del cliente.
	 * @param birthDate   Fecha de nacimiento del cliente.
	 * @param description Descripción o biografía del cliente.
	 */
	public Client(int idUser, String name, String surname, String email, String phone, String username, String password,
			String dni, String address, String birthDate, String description) {
		super(idUser, name, surname, email, phone, username, password, dni);
		this.address = address;
		this.birthDate = birthDate;
		this.description = description;
	}

	/**
	 * Constructor de la clase Client sin ID.
	 *
	 * @param name        Nombre del usuario (heredado de User).
	 * @param surname     Apellido del usuario (heredado de User).
	 * @param email       Correo electrónico del usuario (heredado de User).
	 * @param phone       Teléfono de contacto del usuario (heredado de User).
	 * @param username    Nombre de usuario para iniciar sesión (heredado de User).
	 * @param password    Contraseña del usuario (heredado de User).
	 * @param dni         Documento de Identidad del usuario (heredado de User).
	 * @param address      Dirección del cliente.
	 * @param birthDate   Fecha de nacimiento del cliente.
	 * @param description Descripción o biografía del cliente.
	 */
	public Client(String name, String surname, String email, String phone, String username, String password,
				  String dni, String address, String birthDate, String description) {
		super(name, surname, email, phone, username, password, dni);
		this.address = address;
		this.birthDate = birthDate;
		this.description = description;
	}
	
	
	/**
	 * Devuelve la dirección del cliente.
	 * 
	 * @return Dirección del cliente.
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Establece la dirección del cliente.
	 * 
	 * @param address Dirección del cliente.
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Devuelve la fecha de nacimiento del cliente.
	 * 
	 * @return Fecha de nacimiento.
	 */
	public String getBirthDate() {
		return birthDate;
	}

	/**
	 * Establece la fecha de nacimiento del cliente.
	 * 
	 * @param birthDate Fecha de nacimiento.
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * Devuelve la descripción del cliente.
	 * 
	 * @return Descripción o biografía.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Establece la descripción del cliente.
	 * 
	 * @param description Descripción o biografía.
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Devuelve una representación en texto del cliente en formato cadena.
	 * 
	 * @return Cadena de texto con la información del cliente.
	 */
	@Override
	public String toString() {
		return "Client [" + super.toString() + ", address=" + address + ", birthDate=" + birthDate + ", description=" + description + "]";
	}
	
	
	
	
}
