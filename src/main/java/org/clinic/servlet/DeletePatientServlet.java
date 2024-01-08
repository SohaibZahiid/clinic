package org.clinic.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.clinic.service.PatientService;

import java.io.IOException;

@WebServlet(name = "DeletePatientServlet", value = "/DeletePatientServlet")
public class DeletePatientServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PatientService service = new PatientService();

        int id = Integer.parseInt(request.getParameter("id"));
        service.delete(id);
        response.sendRedirect("PatientServlet");
    }
}