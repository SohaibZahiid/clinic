package org.clinic.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.clinic.dao.DentistDao;
import org.clinic.entity.Appointment;
import org.clinic.entity.Dentist;
import org.clinic.entity.Patient;
import org.clinic.entity.User;
import org.clinic.service.AppointmentService;
import org.clinic.service.DentistService;
import org.clinic.service.PatientService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet(name = "AppointmentServlet", value = "/AppointmentServlet")
public class AppointmentServlet extends HttpServlet {

    AppointmentService service = new AppointmentService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Appointment> appointments = service.getAllAppointments();

        request.setAttribute("appointments", appointments);
        request.getRequestDispatcher("viewAppointments.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int patient_id = Integer.parseInt(request.getParameter("patient"));
        int dentist_id = Integer.parseInt(request.getParameter("dentist"));
        String datetime = request.getParameter("datetime");

        DentistService dentistService = new DentistService();
        PatientService patientService = new PatientService();

        Dentist dentist = dentistService.getDentistById(dentist_id);
        Patient patient = patientService.getPatientById(patient_id);

        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setDentist(dentist);
        appointment.setAppointmentDateTime(LocalDateTime.parse(datetime));

        service.save(appointment);

        response.sendRedirect("AppointmentServlet");
    }
}