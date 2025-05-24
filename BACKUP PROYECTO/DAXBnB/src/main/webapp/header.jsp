<%@ page import="daxbnb.DAO.UsersDAO" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="daxbnb.exceptions.users.UserNotFoundException" %>
<%@ page import="daxbnb.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Fran
  Date: 05/05/2025
  Time: 8:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Header</title>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

    <!-- Icons Kit from Font Awesome -->
    <script src="https://kit.fontawesome.com/909f859384.js" crossorigin="anonymous"></script>
</head>
<body>
    <%
        UsersDAO usersDAO = new UsersDAO();

        session = request.getSession(false);
        User user = null;

        if (session != null) {
            user = (User) session.getAttribute("user");
        }
    %>
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <div class="container-fluid">
            <div class="col-6">
                <% if (user != null) {
                    try {
                        if (usersDAO.isAdmin(user.getIdUser())) {%>
                            <a class="mx-3 my-1 navbar-brand" href="admin-panel.jsp" title="Admin Panel">
                                <img src="img/logo.png" alt="Logo" style="width:40px;" class="rounded-pill">
                            </a>
                        <%} else {%>
                            <a class="mx-3 my-1 navbar-brand" href="index.jsp" title="Index">
                                <img src="img/logo.png" alt="Logo" style="width:40px;" class="rounded-pill">
                            </a>
                        <%}
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    } %>
                <%} else {%>
                    <a class="mx-3 my-1 navbar-brand" href="index.jsp" title="Index">
                        <img src="img/logo.png" alt="Logo" style="width:40px;" class="rounded-pill">
                    </a>
                <%}%>
            </div>
            <% if (user != null) {%>
                <div class="col-6 d-flex justify-content-end align-items-center text-end">
                    <%try {
                        if (usersDAO.isAdmin(user.getIdUser())) { %>
                            <span class="mx-4 text-light">Welcome, admin!</span>
                        <% } else { %>
                            <span class="mx-4 text-light">Welcome, <%=user.getUsername()%></span>
                        <% }
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }%>
                    <a class="navbar-brand px-3" href="user-profile.jsp" title="Profile">
                        <i class="fa-solid fa-circle-user"></i>
                    </a>
                    <a class="navbar-brand px-3" href="logout.jsp" title="Logout">
                        <i class="fa-solid fa-right-from-bracket"></i>
                    </a>

                </div>
            <%} else {%>
                <div class="col-6 text-end">
                    <a class="navbar-brand px-3" href="login.jsp" title="Login">
                        <i class="fa-solid fa-right-to-bracket"></i>
                    </a>
                </div>
            <%}%>
        </div>
    </nav>
</body>
</html>
