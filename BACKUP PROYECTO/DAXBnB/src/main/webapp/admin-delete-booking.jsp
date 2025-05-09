<%@ page import="daxbnb.model.Booking" %>
<%@ page import="java.util.List" %>
<%@ page import="daxbnb.DAO.BookingsDAO" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="daxbnb.exceptions.users.UserNotFoundException" %>
<%@ page import="daxbnb.exceptions.stays.StayNotFoundException" %><%--
  Created by IntelliJ IDEA.
  User: Fran
  Date: 08/05/2025
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
    <%
        List<Booking> bookings;
        BookingsDAO bookingsDAO = new BookingsDAO();

        try {
            bookings = bookingsDAO.getAllBookings();
        } catch (SQLException | UserNotFoundException | StayNotFoundException e) {
            throw new RuntimeException(e);
        }
    %>
    <div class="text-center">
        <h2>DELETE BOOKING</h2>
    </div>
    <form method="post">
        <div class="col-12 my-3">
            <label for="idBookingForDelete" class="form-label">Select ID Booking</label>
            <input type="hidden" name="action" value="delete-booking"/>
            <select class="form-select" name="idBookingForDelete" id="idBookingForDelete" required="">
                <option value="">Choose...</option>
                <% for (Booking booking : bookings) { %>
                <option value="<%= booking.getIdBooking() %>">
                    <%= booking.getIdBooking() %> - <%= booking.getInitDate() %> - <%= booking.getEndDate() %> - <%= booking.getStay().getTitle() %> - <%= booking.getUser().getUsername() %>
                </option>
                <% } %>
            </select>
        </div>
        <button class="w-100 btn btn-success btn-lg" type="submit">Delete</button>
    </form>
</body>
</html>
