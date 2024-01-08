<%@ page import="org.clinic.entity.Patient" %>
<%@ page import="java.util.List" %>
<%@ page import="org.clinic.entity.Dentist" %>
<%@ page import="org.clinic.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="components/templateStart.jsp" %>
<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">Appointment</h1>
<%
    /*
    User loggedUser = (User) session.getAttribute("loggedUser");

    if(loggedUser == null || !loggedUser.getRole().equals("admin")) {
        response.sendRedirect("index.jsp");
    }
    */


    List<Patient> patients = (List<Patient>) request.getAttribute("patients");
    List<Dentist> dentists = (List<Dentist>) request.getAttribute("dentists");
%>
<div class="card o-hidden border-0 shadow-lg my-5">
    <div class="card-body p-0">
        <!-- Nested Row within Card Body -->
        <div class="row">
            <div class="col-xl-7 m-auto">
                <div class="p-5">
                    <div class="text-center">
                        <h1 class="h4 text-gray-900 mb-4">Schedule Appointment!</h1>
                    </div>
                    <form class="user" method="POST" action="AppointmentServlet">
                        <div class="form-group row">
                            <div class="col-sm-6 mb-3 mb-sm-0">
                                <select class="form-control" style="border-radius: 999px; font-size: 12px; height: 50px" name="dentist" aria-label="Default select example" required>
                                    <option selected>Select...</option>
                                    <% for (Dentist dentist : dentists) {
                                    %>
                                    <option value="<%=dentist.getId()%>"><%=dentist.getName()%></option>
                                    <%
                                        }
                                    %>
                                </select>
                            </div>
                            <div class="col-sm-6">
                                <select class="form-control" style="border-radius: 999px; font-size: 12px; height: 50px" name="patient" aria-label="Default select example" required>
                                    <option selected>Select...</option>
                                    <% for (Patient patient : patients) {
                                    %>
                                    <option value="<%=patient.getId()%>"><%=patient.getName()%></option>
                                    <%
                                        }
                                    %>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <input type="datetime-local" class="form-control form-control-user" name="datetime"
                                   id="datetime" placeholder="Date and Time" required>
                        </div>

                        <button type="submit" class="btn btn-primary btn-user btn-block">
                            Book
                        </button>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="components/templateEnd.jsp" %>