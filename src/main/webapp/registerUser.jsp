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
                            <h1 class="h4 text-gray-900 mb-4">Register User!</h1>
                        </div>
                        <form class="user" method="POST" action="UserServlet" >
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <input type="text" class="form-control form-control-user" name="username" id="username"
                                           placeholder="Username" required>
                                </div>
                                <div class="col-sm-6">
                                    <input type="password" class="form-control form-control-user" name="password" id="password"
                                           placeholder="Password" required>
                                </div>
                            </div>

                            <div class="form-group">
                                <select class="form-control" style="border-radius: 999px; font-size: 12px; height: 50px" name="role" aria-label="Default select example" required>
                                    <option selected>Select...</option>
                                    <option value="admin">Admin</option>
                                    <option value="dentist">Dentist</option>
                                    <option value="patient">Patient</option>

                                </select>
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