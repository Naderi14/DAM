<%@ page import="daxbnb.model.User" %>
<%@ page import="daxbnb.DAO.UsersDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="daxbnb.exceptions.users.UserNotFoundException" %><%--
  Created by IntelliJ IDEA.
  User: Fran
  Date: 08/05/2025
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
    <%
        UsersDAO usersDAO = new UsersDAO();
        List<User> users;

        try {
            users = usersDAO.getAllUsers();
        } catch (SQLException | UserNotFoundException e) {
            throw new RuntimeException(e);
        }
    %>
    <div class="text-center">
        <h2>DELETE USER</h2>
    </div>
    <form method="post">
        <div class="col-12 my-3">
            <label for="idUserForDelete" class="form-label">Select ID User</label>
            <input type="hidden" name="action" value="delete-user"/>
            <select class="form-select" name="idUserForDelete" id="idUserForDelete" required="">
                <option value="">Choose...</option>
                <% for (User user : users) { %>
                <option value="<%= user.getIdUser() %>">
                    <%= user.getIdUser() %> - <%= user.getDni() %> - <%= user.getName() %> - <%= user.getSurname() %> - <%= user.getUsername() %>
                </option>
                <% } %>
            </select>
        </div>
        <button class="w-100 btn btn-warning btn-lg" type="submit">Delete</button>
    </form>
</body>
</html>
