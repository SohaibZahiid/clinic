<%@ page import="java.util.List" %>
<%@ page import="org.clinic.entity.Appointment" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="components/templateStart.jsp" %>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">Appointments</h1>

<!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-body">
        <% List<Appointment> appointments = (List) request.getAttribute("appointments");
            if (!appointments.isEmpty()) {
        %>
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Patient</th>
                    <th>Dentist</th>
                    <th>Date</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>Id</th>
                    <th>Patient</th>
                    <th>Dentist</th>
                    <th>Date</th>
                    <th>Action</th>
                </tr>
                </tfoot>
                <tbody>
                <%
                    for (Appointment appointment : appointments) {
                %>
                <tr>
                    <td><%= appointment.getId() %>
                    </td>
                    <td><%= appointment.getPatient().getName() %>
                    </td>
                    <td><%= appointment.getDentist().getName() %>
                    </td>
                    <td><%= appointment.getAppointmentDateTime() %>
                    </td>
                    <td style="display: flex;">
                        <form method="POST" action="DeleteAppointmentServlet">
                            <input type="hidden" name="id" value="<%=appointment.getId()%>"/>
                            <button type="submit" class="btn btn-danger"><i class="fa fa-trash"></i></button>
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
        <p>0 Appointments found. </p>
        <%
            }
        %>

    </div>
</div>


<%@include file="components/templateEnd.jsp" %>