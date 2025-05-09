<%@ page import="daxbnb.model.Stay" %>
<%@ page import="java.util.List" %>
<%@ page import="daxbnb.model.Booking" %>
<%@ page import="daxbnb.model.User" %>
<%@ page import="daxbnb.DAO.StaysDAO" %>
<%@ page import="daxbnb.DAO.BookingsDAO" %>
<%@ page import="daxbnb.DAO.UsersDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="daxbnb.exceptions.stays.StayNotFoundException" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Fran
  Date: 07/05/2025
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Panel</title>
</head>
<body>
    <jsp:include page="header.jsp" />

    <%
        // Action por defecto será listar las estancias
        String action = "list-stays";
        String msgError = null;

        if ("POST".equalsIgnoreCase(request.getMethod()))
        {
            try
            {
                action = request.getParameter("action");
                switch (action)
                {
                    case "list-stays":
                        break;
                    case "create-stay":
                        break;
                    case "update-stay":
                        break;
                    case "delete-stay":
                        break;
                    case "list-bookings":
                        break;
                    case "update-booking":
                        break;
                    case "delete-booking":
                        break;
                    case "list-users":
                        break;
                    case "update-user":
                        break;
                    case "delete-user":
                        break;
                    case "logout":
                        response.sendRedirect("logout.jsp");
                        break;
                    default:
                        System.out.println("ERROR: Option does not exist.");
                        break;
                }
            }
            catch (Exception e)
            {
                System.out.println("ERROR: " + e.getMessage());
            }

        }
    %>

    <div class="container">
        <div class="row my-3">
            <!-- Left content: menu -->
            <div class="col-md-2 my-2">
                <!-- Stay Buttons -->
                <form method="POST">
                    <input type="hidden" name="action" value="list-stays"/>
                    <button type="submit" class="btn btn-primary btn-menu w-100">List Stays</button>
                </form>
                <form method="POST">
                    <input type="hidden" name="action" value="create-stay"/>
                    <button type="submit" class="btn btn-primary btn-menu w-100">Create new Stay</button>
                </form>
                <form method="POST">
                    <input type="hidden" name="action" value="update-stay"/>
                    <button type="submit" class="btn btn-primary btn-menu w-100">Update Stay</button>
                </form>
                    <form method="POST">
                    <input type="hidden" name="action" value="delete-stay"/>
                    <button type="submit" class="btn btn-primary btn-menu w-100">Delete Stay</button>
                </form>
    
                <!-- Booking Buttons -->
                <form method="POST">
                    <input type="hidden" name="action" value="list-bookings"/>
                    <button type="submit" class="btn btn-success btn-menu w-100">List Bookings</button>
                </form>
                <form method="POST">
                    <input type="hidden" name="action" value="update-booking"/>
                    <button type="submit" class="btn btn-success btn-menu w-100">Update Booking</button>
                </form>
                    <form method="POST">
                    <input type="hidden" name="action" value="delete-booking"/>
                    <button type="submit" class="btn btn-success btn-menu w-100">Delete Booking</button>
                </form>
    
                <!-- User Buttons -->
                <form method="POST">
                    <input type="hidden" name="action" value="list-users"/>
                    <button type="submit" class="btn btn-warning btn-menu w-100">List Users</button>
                </form>
                <form method="POST">
                    <input type="hidden" name="action" value="update-user"/>
                    <button type="submit" class="btn btn-warning btn-menu w-100">Update User</button>
                </form>
                    <form method="POST">
                    <input type="hidden" name="action" value="delete-user"/>
                    <button type="submit" class="btn btn-warning btn-menu w-100">Delete User</button>
                </form>
                
                <!-- LOGOUT -->
                <form method="POST">
                    <input type="hidden" name="action" value="logout"/>
                    <button type="submit" class="btn btn-danger btn-menu w-100">Logout</button>
                </form>
            </div>
            <div class="col-md-1">
                <!-- ESPACIO VACIO -->
            </div>
            <div class="col-md-8 px-5 my-2">
                <% if ("list-stays".equals(action)) { %>
                    <jsp:include page="admin-list-stays.jsp" />
                <% } else if ("create-stay".equals(action)) { %>
                    <jsp:include page="admin-create-stay.jsp" />
                <% } else if ("update-stay".equals(action)) { %>
                    <jsp:include page="admin-update-stay.jsp" />
                <% } else if ("delete-stay".equals(action)) { %>
                    <jsp:include page="admin-delete-stay.jsp" />
                <% } else if ("list-bookings".equals(action)) { %>
                    <jsp:include page="admin-list-bookings.jsp" />
                <% } else if ("update-booking".equals(action)) { %>
                    <jsp:include page="admin-update-booking.jsp" />
                <% } else if ("delete-booking".equals(action)) { %>
                    <jsp:include page="admin-delete-booking.jsp" />
                <% } else if ("list-users".equals(action)) { %>
                    <jsp:include page="admin-list-users.jsp" />
                <% } else if ("update-user".equals(action)) { %>
                    <jsp:include page="admin-update-user.jsp" />
                <% } else if ("delete-user".equals(action)) { %>
                    <jsp:include page="admin-delete-user.jsp" />
                <% } %>
            </div>
        </div>
    </div>

    <jsp:include page="footer.jsp" />
</body>
</html>
