package daxbnb.model;

/**
 * Clase que hereta d'usuari amb privilegis d'administrador en la plataforma
 * @author Javier Tolosana &lt;<b>tolosanabernad12@alumnes.ilerna.com</b>&gt;
 * @since 0.1v
 */
public class Admin extends User{
  
	/** Nivel de permisos del usuario*/
	private int permLevel;
	
	/**
     * Constructor con todos los atributos
     * @param permLevel		Nivel de permisos del usuario
     */
	public Admin(int idUser, String name, String surname, String email, String phone, String username, String password,
			String dni, int permLevel) {
		super(idUser, name, surname, email, phone, username, password, dni);
		this.permLevel = permLevel;
	}

	/**
	 * Constructor sin el ID
	 * @param permLevel		Nivel de permisos del usuario
	 */
	public Admin(String name, String surname, String email, String phone, String username, String password,
				 String dni, int permLevel) {
		super(name, surname, email, phone, username, password, dni);
		this.permLevel = permLevel;
	}
	
	/** @return el nivel de permisos del usuario. */
	public int getPermLevel() {
		return permLevel;
	}
	
	/** @param permLevel establece el nivel de permisos del usuario.*/
	public void setPermLevel(int permLevel) {
		this.permLevel = permLevel;
	}

	/** @return la información del constructor del usuario admin. */
	@Override
	public String toString() {
		return "Admin [" + super.toString() + ", permLevel=" + permLevel + "]";
	}
}
