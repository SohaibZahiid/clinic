<%@ page import="java.util.List" %>
<%@ page import="org.clinic.entity.Dentist" %>
<%@ page import="org.clinic.entity.Patient" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="components/templateStart.jsp" %>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">Patients</h1>

<!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-body">
        <% List<Patient> patients = (List) request.getAttribute("patients");
            if (!patients.isEmpty()) {
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
                    <th>Blood type</th>
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
                    <th>Blood type</th>
                    <th>Phone</th>
                    <th>Address</th>
                    <th>Action</th>
                </tr>
                </tfoot>
                <tbody>
                <%
                    for (Patient patient : patients) {
                %>
                <tr>
                    <td><%= patient.getId() %>
                    </td>
                    <td><%= patient.getName() %>
                    </td>
                    <td><%= patient.getSurname() %>
                    </td>
                    <td><%= patient.getDni() %>
                    </td>
                    <td><%= patient.getBirthdate() %>
                    </td>
                    <td><%= patient.getBlood_type() %>
                    </td>
                    <td><%= patient.getPhone() %>
                    </td>
                    <td><%= patient.getAddress() %>
                    </td>
                    <td style="display: flex;">
                        <form class="mr-2" method="POST" action="DeletePatientServlet">
                            <input type="hidden" name="id" value="<%=patient.getId()%>"/>
                            <button type="submit" class="btn btn-danger"><i class="fa fa-trash"></i></button>
                        </form>
                        <form method="GET" action="UpdatePatientServlet">
                            <input type="hidden" name="id" value="<%=patient.getId()%>"/>
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
        <p>0 Patients found. </p>
        <%
            }
        %>

    </div>
</div>


<%@include file="components/templateEnd.jsp" %>