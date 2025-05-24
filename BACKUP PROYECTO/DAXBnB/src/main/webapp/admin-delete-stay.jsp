<%@ page import="daxbnb.DAO.StaysDAO" %>
<%@ page import="daxbnb.model.Stay" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="daxbnb.exceptions.stays.StayNotFoundException" %><%--
  Created by IntelliJ IDEA.
  User: Fran
  Date: 08/05/2025
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
    <%
        StaysDAO staysDAO = new StaysDAO();
        Stay selectedStay = null;
        List<Stay> stays;
        try {
            stays = staysDAO.getAllStays();
        } catch (SQLException | StayNotFoundException e) {
            throw new RuntimeException(e);
        }
    %>
    <div class="text-center">
        <h2>DELETE STAY</h2>
    </div>
    <form method="post">
        <div class="col-12 my-3">
            <label for="idStayForDelete" class="form-label">Select ID Stay</label>
            <input type="hidden" name="action" value="delete-stay"/>
            <select class="form-select" name="idStayForDelete" id="idStayForDelete" required="">
                <option value="">Choose...</option>
                <% for (Stay stay : stays) { %>
                <option value="<%= stay.getIdStay() %>">
                    <%= stay.getIdStay() %> - <%= stay.getTitle() %> - <%= stay.getCity() %> - <%= stay.getCategory().getCategoryName() %>
                </option>
                <% } %>
            </select>
        </div>
        <button class="w-100 btn btn-primary btn-lg" type="submit">Delete</button>
    </form>
</body>
</html>
