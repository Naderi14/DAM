package daxbnb.DAO;

import daxbnb.exceptions.stays.StayNotFoundException;
import daxbnb.exceptions.users.UserNotFoundException;
import daxbnb.model.Booking;
import daxbnb.model.Stay;
import daxbnb.model.User;
import daxbnb.DAO.StaysDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe per realitzar les consultes a la taula Bookings
 * @author Juan Francisco &lt;<b>ditarex95@gmail.com</b>&gt;
 * @since 0.1v
 */
public class BookingsDAO {
    /**
     * Declarar variable tipus DBConnection per realitzar les conexions a la DB
     */
    private DBConnection db;

    private static final String CREATE_BOOKING = "{CALL bookings_insert_new(?, ?, ?, ?)}"; 
    
    private static final String BOOKINGS_BY_ID_USER = "SELECT * FROM bookings WHERE id_user = ?";
    
    private static final String BOOKINGS_BY_ID_STAY = "SELECT * FROM bookings WHERE id_stay = ?";
    
    private static final String ALL_BOOKINGS = "SELECT * FROM bookings";
    
    private static final String CANCEL_BOOKING = "{CALL bookings_delete_by_id(?)}";
    
    private static final String BOOKING_BY_ID = "SELECT * FROM bookings WHERE id_booking = ?";
    
    /**
     * Constructor per instanciar la conexió
     */
    public BookingsDAO()
    {
        db = new DBConnection();
    }

    //TODO: Crear los JavaDocs de las funciones de BookingsDAO ->
    
    /**
     * Metodo que si cumple su función crea una fila de datos
     * @param  booking instancia de la clase booking con su información
     * @return verdadero en caso de que se hayan creado filas y regresa falso en caso contrario
     * @throws SQLException
     */
    public boolean createBooking(Booking booking) throws SQLException
    {
        try (Connection conn = db.getConnection())
        {
            PreparedStatement ps = conn.prepareStatement(CREATE_BOOKING);
        	ps.setString(1, booking.getInitDate());
        	ps.setString(2, booking.getEndDate());
        	ps.setInt(3, booking.getUser().getIdUser());
        	ps.setInt(4, booking.getStay().getIdStay());
        	
        	int rowsUpdate = ps.executeUpdate();
        	
        	return rowsUpdate > 0;
        }
    }

    /**
     * Metodo que nos devolverá una lista de tipo Booking con la query almacenada en la constante
     * @param idUser ID único del YUser en la BBDD
     * @return una lista de instancias de tipo User
     */
    public List<Booking> getBookingsByIdUser(int idUser) throws SQLException, UserNotFoundException, StayNotFoundException {
        List<Booking> bookings = new ArrayList<>();

        try (Connection conn = db.getConnection())
        {
            PreparedStatement ps = conn.prepareStatement(BOOKINGS_BY_ID_USER);
            ps.setInt(1, idUser);
            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                bookings.add(resultToBooking(rs));
            }

            return bookings;
        }
    }

    /**
     * Metodo que devolverá una lista de tipo Booking con la query almacenada en la constante
     * @param idStay 
     * @return una lista de instancias de tipo Stay
     * @throws SQLException
     */
    public List<Booking> getBookingsByIdStay(int idStay) throws SQLException, UserNotFoundException, StayNotFoundException {
        List<Booking> bookings = new ArrayList<>();

        try (Connection conn = db.getConnection())
        {
        	PreparedStatement ps = conn.prepareStatement(BOOKINGS_BY_ID_STAY);
        	ps.setInt(1, idStay);
        	ResultSet rs = ps.executeQuery();
        	
        	while(rs.next())
        	{
        		bookings.add(resultToBooking(rs));
        	}
        	return bookings;
        }
    }

    /**
     * Metodo que nos devolverá una lista de tipo Booking con la query almacenada en la constante
     * @return una lista de instancias de tipo Booking
     */
    public List<Booking> getAllBookings() throws SQLException, UserNotFoundException, StayNotFoundException {
        List<Booking> bookings = new ArrayList<>();

        try (Connection conn = db.getConnection())
        {
            PreparedStatement ps = conn.prepareStatement(ALL_BOOKINGS);
            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                bookings.add(resultToBooking(rs));
            }

            return bookings;
        }
    }

    /**
     * Metodo que si cumple su funcion eliminara una linea.
     * @param idBooking 
     * @return Verdadero en el caso de eliminar la linea y falso en caso contrario
     * @throws SQLException
     */
    public boolean cancelBooking(int idBooking) throws SQLException
    {
        try (Connection conn = db.getConnection())
        {
            PreparedStatement ps = conn.prepareStatement(CANCEL_BOOKING);
        	ps.setInt(1, idBooking);
        	int rowsUpdate = ps.executeUpdate();
        	
        	return rowsUpdate > 0;
        }
    }

    /**
     * Metodo que nos devolverá una instancia de Booking con la query almacenada en la constante
     * @param idBooking id booking
     * @return una instancia de Booking
     */
    public Booking getBookingById(int idBooking) throws SQLException, UserNotFoundException, StayNotFoundException {
        try (Connection conn = db.getConnection())
        {
            PreparedStatement ps = conn.prepareStatement(BOOKING_BY_ID);
            ps.setInt(1, idBooking);
            ResultSet rs = ps.executeQuery();

            if (rs.next())
                return resultToBooking(rs);
            else
                return null;
        }
    }

    /**
     * Metodo que nos devolverá una instancia de Booking mediante los datos del resultSet
     * @param result Fila de datos ResultSet donde extraeremos la información de la tabla bookings
     * @return una instancia de Booking
     */
    private Booking resultToBooking(ResultSet result) throws SQLException, UserNotFoundException, StayNotFoundException {
        int idBooking = result.getInt("id_booking");
        String initDate = result.getString("init_date");
        String endDate = result.getString("end_date");
        int idUser = result.getInt("id_user");
        UsersDAO usersDAO = new UsersDAO();
        User user = usersDAO.getUserById(idUser);
        int idStay = result.getInt("id_stay");
        StaysDAO staysDAO = new StaysDAO();
        Stay stay = staysDAO.getStayById(idStay);

        return new Booking(idBooking, initDate, endDate, user, stay);
    }
}
