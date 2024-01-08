<%@ page import="org.clinic.entity.Dentist" %>
<%@ page import="org.clinic.entity.Patient" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="components/templateStart.jsp"%>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">Update</h1>
<div class="card o-hidden border-0 shadow-lg my-5">
    <div class="card-body p-0">
        <!-- Nested Row within Card Body -->
        <div class="row">
            <div class="col-xl-7 m-auto">
                <div class="p-5">
                    <div class="text-center">
                        <h1 class="h4 text-gray-900 mb-4">Update Patient!</h1>
                    </div>
                    <% Patient patient = (Patient) request.getAttribute("patient"); %>
                    <form class="user" method="POST" action="UpdatePatientServlet">
                        <div class="form-group row">
                            <div class="col-sm-6 mb-3 mb-sm-0">
                                <input type="text" class="form-control form-control-user" required name="first" id="exampleFirstName"
                                       placeholder="First Name" value="<%=patient.getName()%>">
                            </div>
                            <div class="col-sm-6">
                                <input type="text" class="form-control form-control-user" required name="last" id="exampleLastName"
                                       placeholder="Last Name" value="<%=patient.getSurname()%>">
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-6 mb-3 mb-sm-0">
                                <input type="text" class="form-control form-control-user" required name="dni" id="dni"
                                       placeholder="DNI" value="<%=patient.getDni()%>">
                            </div>
                            <div class="col-sm-6">
                                <input type="date" class="form-control form-control-user" required name="birthdate" id="birthdate"
                                       placeholder="Birthdate" value="<%=patient.getBirthdate()%>">
                            </div>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control form-control-user" required
                                   id="speciality" placeholder="Blood type" name="blood" value="<%=patient.getBlood_type()%>">
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-6 mb-3 mb-sm-0">
                                <input type="tel" class="form-control form-control-user" required
                                       id="phone" placeholder="Phone" name="phone" value="<%=patient.getPhone()%>">
                            </div>
                            <div class="col-sm-6">
                                <input type="text" class="form-control form-control-user" required
                                       id="address" placeholder="Address" name="address" value="<%=patient.getAddress()%>">
                            </div>
                        </div>
                        <input type="hidden" name="id" value="<%=patient.getId()%>"/>
                        <button type="submit" class="btn btn-primary btn-user btn-block">
                            Update Account
                        </button>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="components/templateEnd.jsp"%>