<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    User user = (User) session.getAttribute("loggedUser");
    if (user == null) {
        response.sendRedirect("login.jsp");
    } else {
%>
<%@include file="components/templateStart.jsp" %>
<h1>Welcome <%= user.getUsername() %>
</h1>
<%@include file="components/templateEnd.jsp" %>
<%
    }
%>

