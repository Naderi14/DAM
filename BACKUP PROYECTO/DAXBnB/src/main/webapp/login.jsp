<%--
  Created by IntelliJ IDEA.
  User: Fran
  Date: 05/05/2025
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="daxbnb.DAO.UsersDAO" %>
<%@ page import="daxbnb.model.User" %>
<%@ page import="daxbnb.exceptions.users.InvalidLoginException" %>
<%@ page import="daxbnb.exceptions.users.UserNotFoundException" %>
<%@ page import="java.sql.SQLException" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <jsp:include page="header.jsp" />

    <%
        //Variables to save error and name of user session
        String errorMsg = null;
        String username = null;

        String action = "";
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            try {
                action = request.getParameter("action");
                System.out.println("action = " + action);
                switch (action)
                {
                    case "login":
                        username = request.getParameter("username");
                        String password = request.getParameter("password");
                        UsersDAO usersDAO = new UsersDAO();

                        User user = usersDAO.login(username, password);
                        if (user != null)
                        {
                            HttpSession userSession = request.getSession();
                            userSession.setAttribute("user", user);
                            if (usersDAO.isAdmin(user.getIdUser()))
                                response.sendRedirect("admin-panel.jsp");
                            else
                                response.sendRedirect("index.jsp");
                            return; // Prevent of continuing the program
                        }
                        else
                        {
                            errorMsg = "ERROR: username or password invalid";
                            System.out.println("ERROR: username or password invalid");
                        }
                        break;
                }
            } catch (InvalidLoginException | UserNotFoundException | SQLException | RuntimeException e) {
                errorMsg = "ERROR: " + e.getMessage();
                System.out.println(e.getMessage());
            }

        } else if ("GET".equalsIgnoreCase(request.getMethod())) {

        }
    %>

    <div class="container mt-5 mb-5">
        <div class="row justify-content-center">

            <div class="col-md-6">
                <div class="card mb-5">
                    <div class="card-header">
                        <h2 class="text-center">Login</h2>
                    </div>
                    <div class="card-body">
                        <%-- Show error message if it exists --%>
                        <% if (errorMsg != null) { %>
                            <div class="alert alert-danger text-center">
                                <%= errorMsg %>
                            </div>
                        <% } %>
                        <form method="post">
                            <input type="hidden" name="action" value="login" />
                            <div class="mb-3 p-3">
                                <label for="username" class="form-label">User:</label>
                                <input type="text" class="form-control" id="username" name="username"
                                       value="<%= username != null ? username : "" %>" required>
                            </div>
                            <div class="mb-3 p-3">
                                <label for="password" class="form-label">Password:</label>
                                <input type="password" class="form-control" id="password"
                                       name="password" required>
                            </div>
                            <div class="p-3">
                                <button type="submit" class="btn btn-primary">Login</button>
                            </div>
                            <div class="p-2 text-center">
                                <p class="">If you don't have any account <a href="#">Register Now!</a></p>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="footer.jsp" />
</body>
</html>
