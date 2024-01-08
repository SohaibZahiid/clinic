package org.clinic.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.clinic.entity.Appointment;
import org.clinic.service.AppointmentService;
import org.clinic.service.PatientService;

import java.io.IOException;

@WebServlet(name = "DeleteAppointmentServlet", value = "/DeleteAppointmentServlet")
public class DeleteAppointmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AppointmentService service = new AppointmentService();

        int id = Integer.parseInt(request.getParameter("id"));
        service.delete(id);
        response.sendRedirect("AppointmentServlet");
    }
}