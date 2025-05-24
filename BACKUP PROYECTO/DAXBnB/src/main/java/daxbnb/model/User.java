package daxbnb.model;

/**
 * Representa a usuarios de cualquier índole que serán considerados en la plataforma,
 * siempre y cuando proporcionen su información básica.
 * 
 * @author Bianca Sanchez <bmszsanchez@alumnes.ilerna.com>
 * @since 0.1v
 */
public class User {
    /**
     * Identificador único del usuario.
     */
    private int idUser;
    /**
     * Nombre del usuario.
     */
    private String name;
    /**
     * Apellido del usuario.
     */
    private String surname;
    /**
     * Dirección de correo electrónico del usuario.
     */
    private String email;
    /**
     *  Número de teléfono del usuario.
     */
    private String phone;
    /**
     * Nombre de usuario utilizado para iniciar sesión.
     */
    private String username;
    /**
     * Contraseña del usuario para acceder a la plataforma.
     */
    private String password;
    /**
     * Documento de Identidad del usuario.
     */
    private String dni;

    /**
     * Constructor completo de la clase User completo.
     * 
     * @param idUser
     * @param name
     * @param surname
     * @param email
     * @param phone
     * @param username
     * @param password
     * @param dni
     */
    public User(int idUser, String name, String surname, String email, String phone, String username, String password,
            String dni) {
        this.idUser = idUser;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.dni = dni;
    }

    /**
     * Constructor completo de la clase User sin ID
     *
     * @param name
     * @param surname
     * @param email
     * @param phone
     * @param username
     * @param password
     * @param dni
     */
    public User(String name, String surname, String email, String phone, String username, String password,
                String dni) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.dni = dni;
    }

    /**
     * Obtiene el ID del usuario.
     * 
     * @return  ID del usuario.
     */
    public int getIdUser() {
        return idUser;
    }

    /**
     * Establece el ID del usuario.
     * 
     * @param idUser Nuevo ID del usuario.
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    /**
     * Obtiene el nombre del usuario.
     * 
     * @return Nombre del usuario.
     */
    public String getName() {
        return name;
    }

    /**
     *  Establece el nombre del usuario.
     *  
     * @param name Nuevo nombre del usuario.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *  Obtiene el apellido del usuario.
     *  
     * @return Apellido del usuario.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Establece el apellido del usuario.
     * 
     * @param surname Nuevo apellido del usuario.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Obtiene el email del usuario.
     * 
     * @return Correo electrónico del usuario.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el email del usuario.
     * 
     * @param email Nuevo correo electrónico del usuario.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene el número de teléfono del usuario.
     * 
     * @return Número de teléfono.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Establece el número de teléfono del usuario.
     * 
     * @param phone Nuevo número de teléfono.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Obtiene el nombre de usuario.
     * 
     * @return Nombre de usuario.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Establece el nombre de usuario.
     * 
     * @param username Nuevo nombre de usuario.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Obtiene la contraseña del usuario.
     * 
     * @return Contraseña.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña del usuario.
     * 
     * @param password Nueva contraseña.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Obtiene el DNI del usuario.
     * 
     * @return Documento de Identidad.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el DNI del usuario.
     * 
     * @param dni Nuevo DNI del usuario.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Devuelve una representación en texto del usuario.
     * 
     * @return Información completa del usuario en formato cadena.
     */
    @Override
    public String toString() {
        return "idUser=" + idUser + ", name=" + name + ", surname=" + surname + ", email=" + email + ", phone="
                + phone + ", username=" + username + ", password=" + password + ", dni=" + dni;
    }
}
