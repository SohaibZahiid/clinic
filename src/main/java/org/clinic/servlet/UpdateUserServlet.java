package org.clinic.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.clinic.entity.User;
import org.clinic.service.UserService;

import java.io.IOException;

@WebServlet(name = "UpdateUserServlet", value = "/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    UserService service = new UserService();
    int id = 0;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = Integer.parseInt(request.getParameter("id"));
        User user = service.getUserById(id);
        System.out.println(user);
        request.setAttribute("user", user);
        request.getRequestDispatcher("updateUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        User user = new User();
        user.setUser_id(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);

        User u = service.updateUser(user);

        response.sendRedirect("UserServlet");

    }
}