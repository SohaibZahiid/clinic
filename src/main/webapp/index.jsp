<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String user = (String) request.getSession().getAttribute("user");
    if(user == null) {
        response.sendRedirect("login.jsp");
    }
%>

<%@include file="components/templateStart.jsp"%>
<h1>Welcome <%= user %></h1>
<%@include file="components/templateEnd.jsp"%>