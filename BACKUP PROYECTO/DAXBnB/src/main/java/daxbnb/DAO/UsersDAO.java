package daxbnb.DAO;

import daxbnb.exceptions.users.InvalidLoginException;
import daxbnb.exceptions.users.UserNotFoundException;
import daxbnb.model.Admin;
import daxbnb.model.Client;
import daxbnb.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe per realitzar les consultes a les taules Users i filles
 * @author Juan Francisco &lt;<b>ditarex95@gmail.com</b>&gt;
 * @since 0.1v
 */
public class UsersDAO {
    /**
     * Declarar variable tipus DBConnection per realitzar les conexions a la DB
     */
    private DBConnection db;

    private static final String INSERT_CLIENT = "{CALL users_insert_client(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
    
    private static final String INSERT_USER = "{CALL users_insert_user(?, ?, ?, ?, ?, ?, ?)}";
    
    private static final String INSERT_ADMIN = "{CALL users_insert_admin(?, ?, ?, ?, ?, ?, ?)}";
    
    private static final String USER_BY_ID = "SELECT * FROM users WHERE id_user = ?";
    
    private static final String LOGIN = "SELECT * FROM users WHERE username = ? AND password = ?";
    
    private static final String ALL_USERS = "SELECT * FROM users";
    
    private static final String USER_BY_DNI = "SELECT * FROM users WHERE dni = ?";

    private static final String USER_BY_USERNAME = "SELECT * FROM users WHERE username = ?";
    
    private static final String DELETE_USER = "{CALL users_delete_by_dni(?)}"; 
    
    private static final String UPDATE_PASSWORD = "{CALL users_update_password(?, ?)}";
    
    private static final String IS_ADMIN = "SELECT * FROM admins WHERE id_user = ?";
    
    private static final String IS_CLIENT = "SELECT * FROM clients WHERE id_user = ?";
    
    /**
     * Constructor per instanciar la conexió
     */
    public UsersDAO()
    {
        db = new DBConnection();
    }

    //TODO: Crear los JavaDocs de las funciones de UsersDAO ->

    /**
     * Método para registrar un cliente en la BBDD
     * @param client instancia de la clase client con su información
     * @return true si se ha registrado el cliente correctamente y false si no lo ha conseguido
     * @throws SQLException
     */
    public boolean insertClient(Client client) throws SQLException
    {
        try (Connection conn = db.getConnection())
        {
            PreparedStatement ps = conn.prepareStatement(INSERT_CLIENT);
        	ps.setString(1, client.getDni());
        	ps.setString(2, client.getName());
        	ps.setString(3, client.getSurname());
        	ps.setString(4, client.getEmail());
        	ps.setString(5, client.getPhone());
        	ps.setString(6, client.getUsername());
        	ps.setString(7, client.getPassword());
        	ps.setString(8, client.getAddress());
        	ps.setString(9, client.getBirthDate());
        	
        	int rowsUpdate = ps.executeUpdate();
        	
        	return rowsUpdate > 0;
        }
    }

    /**
     * Método para registrar un usuario en la BBDD con sus datos básicos
     * @deprecated Se encuentra en desuso porque por ahora no tiene sentido crear datos de un usuario sin que sea Cliente o Admin
     * @param user instancia de la clase User con su información
     * @return true si se ha registrado el usuario correctamente y false si no lo ha conseguido
     * @throws SQLException
     */
    public boolean insertUser(User user) throws SQLException
    {
        try (Connection conn = db.getConnection())
        {
            PreparedStatement ps = conn.prepareStatement(INSERT_USER);
            ps.setString(1, user.getDni());
            ps.setString(2, user.getName());
            ps.setString(3, user.getSurname());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPhone());
            ps.setString(6, user.getUsername());
            ps.setString(7, user.getPassword());

            int rowsUpdate = ps.executeUpdate();

            return rowsUpdate > 0;
        }
    }
    
    /**
     * Método para registrar un administrador en la BBDD con sus datos básicos
     * @param admin instancia de la clase Admin con su información
     * @return true si se ha creado el administrador correctamente y false si no lo ha conseguido
     * @throws SQLException
     */
    public boolean insertAdmin(Admin admin) throws SQLException
    {
        try (Connection conn = db.getConnection())
        {
            PreparedStatement ps = conn.prepareStatement(INSERT_ADMIN);
        	ps.setString(1, admin.getDni());
        	ps.setString(2, admin.getName());
        	ps.setString(3, admin.getSurname());
        	ps.setString(4, admin.getEmail());
        	ps.setString(5, admin.getPhone());
        	ps.setString(6, admin.getUsername());
        	ps.setString(7, admin.getPassword());
        	ps.setInt(8, admin.getPermLevel());
        	
        	int rowsUpdate = ps.executeUpdate();
        	
        	return rowsUpdate > 0;
       	}
    }

    /**
     * Metodo que nos devolverá una instancia de User con la query almacenada en la constante
     * @param idUser ID único del usuario en la BBDD
     * @return una instancia de User o null en caso de no coincidir los datos
     */
    public User getUserById(int idUser) throws SQLException, UserNotFoundException {
        try (Connection conn = db.getConnection())
        {
            PreparedStatement ps = conn.prepareStatement(USER_BY_ID);
            ps.setInt(1, idUser);
            ResultSet rs = ps.executeQuery();

            if (rs.next())
                return resultToUser(rs);
            else
                throw new UserNotFoundException("User with ID:" + idUser + " not found");
        }
    }

    /**
     * Metodo que nos devolverá una instancia de User con la query almacenada en la constante
     * @param username username único del usuario en la BBDD
     * @return una instancia de User o excepción en caso de no encontrar los datos
     */
    public User getUserByUsername(String username) throws SQLException, UserNotFoundException {
        try (Connection conn = db.getConnection())
        {
            PreparedStatement ps = conn.prepareStatement(USER_BY_USERNAME);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next())
                return resultToUser(rs);
            else
                throw new UserNotFoundException("User with username:" + username + " not found");
        }
    }

    /**
     * Metodo que nos devolverá una instancia de User con la query almacenada en la constante
     * @param username nombre usuario único para el login
     * @param password contraseña configurada del usuario para acceder a su cuenta
     * @return una instancia de User o null en caso de no coincidir los datos
     */
    public User login(String username, String password) throws SQLException, UserNotFoundException, InvalidLoginException {
        try (Connection conn = db.getConnection())
        {
            PreparedStatement ps = conn.prepareStatement(LOGIN);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next())
                return resultToUser(rs);
            else
                throw new InvalidLoginException("Username or password is wrong");
        }
    }

    /**
     * Metodo que nos devolverá una lista de tipo User con la query almacenada en la constante
     * @return una lista de instancias de tipo User
     */
    public List<User> getAllUsers() throws SQLException, UserNotFoundException {
        List<User> users = new ArrayList<>();

        try (Connection conn = db.getConnection())
        {
            PreparedStatement ps = conn.prepareStatement(ALL_USERS);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                users.add(resultToUser(rs));
            }

            return users;
        }
    }

    /**
     * Metodo que nos devolverá una instancia de User con la query almacenada en la constante
     * @param dni documento de identidad nacional del usuario
     * @return una instancia de User o null en caso de no coincidir los datos
     */
    public User getUserByDni(String dni) throws SQLException, UserNotFoundException {
        try (Connection conn = db.getConnection())
        {
            PreparedStatement ps = conn.prepareStatement(USER_BY_DNI);
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next())
                return resultToUser(rs);
            else
                throw new UserNotFoundException("User with DNI:" + dni + " not found");
        }
    }

    /**
     * Metodo que ejecuta una consulta para eliminar a los usuarios con el dni introducido
     * @param dni documento de identidad nacional del usuario
     * @return verdadero si se cumple la funcion y falso en caso de no cumplirse
     * @throws SQLException
     */
    public boolean deleteUser(String dni) throws SQLException
    {
        try (Connection conn = db.getConnection())
        {
            PreparedStatement ps = conn.prepareStatement(DELETE_USER);
        	ps.setString(1, dni);
        	int rowsUpdate = ps.executeUpdate();
        	
        	return rowsUpdate > 0;
        }
    }

    /**
     * Método para actualizar la constraseña del usuario
     * @param dni dni del usuario registrado
     * @param newPass nueva contraseña
     * @return true si se ha cambiado la constraseña correctamente y false si no se ha podido cambiar
     * @throws SQLException
     */
    public boolean updatePassword(String dni, String newPass) throws SQLException
    {
    	try (Connection conn = db.getConnection())
        {
            PreparedStatement ps = conn.prepareStatement(UPDATE_PASSWORD);
        	ps.setString(1, dni);
        	ps.setString(2, newPass);
        	
        	int rowsUpdate = ps.executeUpdate();
        	
        	return rowsUpdate > 0;
        }
    }

    /**
     * Método para devolver una cadena de texto informativa del tipo de usuario que es
     * @param idUser ID del usuario que se quiere comprobar su rol
     * @return Dato String contextual del tipo de usuario que és, puede ser ADMIN, CLIENT o UNKNOWN
     * @throws SQLException
     */
    public String getUserRole(int idUser) throws SQLException
    {
        if (isAdmin(idUser))
            return "ADMIN";
        if (isClient(idUser))
            return "CLIENT";
        else
            return "UNKNOWN";
    }

    //OPCIONAL
    public boolean updateProfilePicture(String dni, String newPath) throws SQLException
    {
        String sqlUser = "UPDATE users SET <path_photo> = ? WHERE dni = ?";
        //TODO: realizar conexion y logica para setear una nueva imagen de perfil en el usuario encontrado con el DNI ->
        return false;
    }

    /**
     * Metodo que nos devolverá una instancia de los datos proporcionados por un ResultSet
     * @param result Fila de datos ResultSet donde extraeremos la información general de un usuario de la table users
     * @return una instancia de User que puede ser de tipo Client o Admin
     */
    private User resultToUser(ResultSet result) throws SQLException, UserNotFoundException {
        int idUser = result.getInt("id_user");
        String dni = result.getString("dni");
        String name = result.getString("name");
        String surname = result.getString("surname");
        String email = result.getString("email");
        String phone = result.getString("phone");
        String username = result.getString("username");
        String password = result.getString("password");

        if (isAdmin(idUser))
        {
            ResultSet resultAdmin;
            try (Connection conn = db.getConnection())
            {
                PreparedStatement ps = conn.prepareStatement(IS_ADMIN);
                ps.setInt(1, idUser);
                resultAdmin = ps.executeQuery();
                resultAdmin.next();
                int permLevel = resultAdmin.getInt("perm_level");
                return new Admin(idUser, name, surname, email, phone, username, password, dni, permLevel);
            }
        }
        else if (isClient(idUser))
        {
            ResultSet resultClient;
            try (Connection conn = db.getConnection())
            {
                PreparedStatement ps = conn.prepareStatement(IS_CLIENT);
                ps.setInt(1, idUser);
                resultClient = ps.executeQuery();
                resultClient.next();
                String address = resultClient.getString("address");
                String birth_date = resultClient.getString("birth_date");
                String description = resultClient.getString("description");
                return new Client(idUser, name, surname, email, phone, username, password, dni, address, birth_date, description);
            }
        }
        else
        {
            throw new UserNotFoundException("Internal Error: User with id " + idUser + " have not been registered properly or does not exist");
        }
    }

    /**
     * Metodo que nos devolverá si existe el admin con el idUser
     * @param idUser Id del user con el que verificaremos en la clase admin si existe en la consulta
     * @return dato de tipo booleano si lo encontró en la tabla o no
     */
    public boolean isAdmin(int idUser) throws SQLException
    {
    	try (Connection conn = db.getConnection())
        {
            PreparedStatement ps = conn.prepareStatement(IS_ADMIN);
            ps.setInt(1, idUser);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }

    /**
     * Metodo que nos devolverá si existe el cliente con el idUser
     * @param idUser Id del user con el que verificaremos en la clase client si existe en la consulta
     * @return dato de tipo booleano si lo encontró en la tabla o no
     */
    public boolean isClient(int idUser) throws SQLException
    {
        try (Connection conn = db.getConnection())
        {
            PreparedStatement ps = conn.prepareStatement(IS_CLIENT);
            ps.setInt(1, idUser);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }
}
