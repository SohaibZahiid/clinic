<%@ page import="org.clinic.entity.Dentist" %>
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
                        <h1 class="h4 text-gray-900 mb-4">Update Dentist!</h1>
                    </div>
                    <% Dentist dentist = (Dentist) request.getAttribute("dentist"); %>
                    <form class="user" method="POST" action="UpdateDentistServlet">
                        <div class="form-group row">
                            <div class="col-sm-6 mb-3 mb-sm-0">
                                <input type="text" class="form-control form-control-user" name="first" id="exampleFirstName"
                                       placeholder="First Name" value="<%=dentist.getName()%>" required>
                            </div>
                            <div class="col-sm-6">
                                <input type="text" class="form-control form-control-user" name="last" id="exampleLastName"
                                       placeholder="Last Name" value="<%=dentist.getSurname()%>" required>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-6 mb-3 mb-sm-0">
                                <input type="text" class="form-control form-control-user" name="dni" id="dni"
                                       placeholder="DNI" value="<%=dentist.getDni()%>" required>
                            </div>
                            <div class="col-sm-6">
                                <input type="date" class="form-control form-control-user" name="birthdate" id="birthdate"
                                       placeholder="Birthdate" value="<%=dentist.getBirthdate()%>" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control form-control-user"
                                   id="speciality" placeholder="Speciality" name="speciality" value="<%=dentist.getSpeciality()%>" required>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-6 mb-3 mb-sm-0">
                                <input type="tel" class="form-control form-control-user"
                                       id="phone" placeholder="Phone" name="phone" value="<%=dentist.getPhone()%>" required>
                            </div>
                            <div class="col-sm-6">
                                <input type="text" class="form-control form-control-user"
                                       id="address" placeholder="Address" name="address" value="<%=dentist.getAddress()%>" required>
                            </div>
                        </div>
                        <input type="hidden" name="id" value="<%=dentist.getId()%>"/>
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