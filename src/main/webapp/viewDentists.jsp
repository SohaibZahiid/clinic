<%@ page import="java.util.List" %>
<%@ page import="org.clinic.entity.Dentist" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="components/templateStart.jsp" %>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">Dentists</h1>

<!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-body">
        <% List<Dentist> dentists = (List) request.getAttribute("dentists");
            if (!dentists.isEmpty()) {
        %>
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>DNI</th>
                    <th>Birthdate</th>
                    <th>Speciality</th>
                    <th>Phone</th>
                    <th>Address</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>DNI</th>
                    <th>Birthdate</th>
                    <th>Speciality</th>
                    <th>Phone</th>
                    <th>Address</th>
                    <th>Action</th>
                </tr>
                </tfoot>
                <tbody>
                <%
                    for (Dentist dentist : dentists) {
                %>
                <tr>
                    <td><%= dentist.getId() %>
                    </td>
                    <td><%= dentist.getName() %>
                    </td>
                    <td><%= dentist.getSurname() %>
                    </td>
                    <td><%= dentist.getDni() %>
                    </td>
                    <td><%= dentist.getBirthdate() %>
                    </td>
                    <td><%= dentist.getSpeciality() %>
                    </td>
                    <td><%= dentist.getPhone() %>
                    </td>
                    <td><%= dentist.getAddress() %>
                    </td>
                    <td style="display: flex;">
                        <form class="mr-2" method="POST" action="DeleteDentistServlet">
                            <input type="hidden" name="id" value="<%=dentist.getId()%>"/>
                            <button type="submit" class="btn btn-danger"><i class="fa fa-trash"></i></button>
                        </form>
                        <form method="GET" action="UpdateDentistServlet">
                            <input type="hidden" name="id" value="<%=dentist.getId()%>"/>
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
        <p>0 Dentists found. </p>
        <%
            }
        %>

    </div>
</div>


<%@include file="components/templateEnd.jsp" %>