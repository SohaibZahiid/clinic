<%@ page import="org.clinic.entity.User" %>
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
                        <h1 class="h4 text-gray-900 mb-4">Update User!</h1>
                    </div>
                    <% User user = (User) request.getAttribute("user"); %>
                    <form class="user" method="POST" action="UpdateUserServlet" >
                        <div class="form-group row">
                            <div class="col-sm-6 mb-3 mb-sm-0">
                                <input type="text" class="form-control form-control-user" name="username" id="username"
                                       placeholder="Username" value="<%=user.getUsername()%>" required>
                            </div>
                            <div class="col-sm-6">
                                <input type="password" class="form-control form-control-user" name="password" id="password"
                                       placeholder="Password" value="<%=user.getPassword()%>" required>
                            </div>
                        </div>

                        <div class="form-group">
                            <input type="text" class="form-control form-control-user" name="role"
                                   id="role" placeholder="Role" value="<%=user.getRole()%>" required>
                        </div>

                        <input type="hidden" name="id" value="<%=user.getUser_id()%>" required/>

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