package org.clinic.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.clinic.service.DentistService;
import org.clinic.service.UserService;

import java.io.IOException;

@WebServlet(name = "DeleteDentistServlet", value = "/DeleteDentistServlet")
public class DeleteDentistServlet extends HttpServlet {
    DentistService service = new DentistService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        service.delete(id);
        response.sendRedirect("DentistServlet");
    }
}