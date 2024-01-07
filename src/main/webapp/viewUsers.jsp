<%@ page import="java.util.List" %>
<%@ page import="org.clinic.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="components/templateStart.jsp" %>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">Users</h1>

<!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-body">
        <% List<User> users = (List) request.getAttribute("users");
            if (!users.isEmpty()) {
        %>
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Username</th>
                    <th>Role</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>Id</th>
                    <th>Username</th>
                    <th>Role</th>
                    <th>Action</th>
                </tr>
                </tfoot>
                <tbody>
                <%
                    for (User user : users) {
                %>
                <tr>
                    <td><%= user.getUser_id() %>
                    </td>
                    <td><%= user.getUsername() %>
                    </td>
                    <td><%= user.getRole() %>
                    </td>
                    <td style="display: flex;">
                        <form class="mr-2" method="POST" action="DeleteUserServlet">
                            <input type="hidden" name="id" value="<%=user.getUser_id()%>"/>
                            <button type="submit" class="btn btn-danger"><i class="fa fa-trash"></i></button>
                        </form>
                        <form method="GET" action="UpdateUserServlet">
                            <input type="hidden" name="id" value="<%=user.getUser_id()%>"/>
                            <button type="submit" class="btn btn-primary"><i class="fa fa-pen"></i></button>
                        </form>
                    </td>
                </tr>
                <%
                    }
                %>

                </tbody>
            </table>
        </div>
        <%
        } else {
        %>
        <p>0 Users found. </p>
        <%
            }
        %>

    </div>
</div>


<%@include file="components/templateEnd.jsp" %>