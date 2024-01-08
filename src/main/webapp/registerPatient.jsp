<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="components/templateStart.jsp"%>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">Register</h1>
<div class="card o-hidden border-0 shadow-lg my-5">
    <div class="card-body p-0">
        <!-- Nested Row within Card Body -->
        <div class="row">
            <div class="col-xl-7 m-auto">
                <div class="p-5">
                    <div class="text-center">
                        <h1 class="h4 text-gray-900 mb-4">Register Patient!</h1>
                    </div>
                    <form class="user" method="POST" action="PatientServlet">
                        <div class="form-group row">
                            <div class="col-sm-6 mb-3 mb-sm-0">
                                <input type="text" class="form-control form-control-user" name="first" id="exampleFirstName"
                                       placeholder="First Name" required>
                            </div>
                            <div class="col-sm-6">
                                <input type="text" class="form-control form-control-user" name="last" id="exampleLastName"
                                       placeholder="Last Name" required>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-6 mb-3 mb-sm-0">
                                <input type="text" class="form-control form-control-user" name="dni" id="dni"
                                       placeholder="DNI" required>
                            </div>
                            <div class="col-sm-6">
                                <input type="date" class="form-control form-control-user" name="birthdate" id="birthdate"
                                       placeholder="Birthdate" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control form-control-user"
                                   id="blood" placeholder="Blood type" name="blood" required>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-6 mb-3 mb-sm-0">
                                <input type="tel" class="form-control form-control-user"
                                       id="phone" placeholder="Phone" name="phone" required>
                            </div>
                            <div class="col-sm-6">
                                <input type="text" class="form-control form-control-user"
                                       id="address" placeholder="Address" name="address" required>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary btn-user btn-block">
                            Register Account
                        </button>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="components/templateEnd.jsp"%>