<%--
  Created by IntelliJ IDEA.
  User: Fran
  Date: 07/05/2025
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%
    session = request.getSession(false);
    if (session != null) {
        session.invalidate();
    }

    response.sendRedirect("index.jsp");
%>
