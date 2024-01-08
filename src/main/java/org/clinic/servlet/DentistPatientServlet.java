package org.clinic.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.clinic.entity.Dentist;
import org.clinic.entity.Patient;
import org.clinic.service.DentistService;
import org.clinic.service.PatientService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DentistPatientServlet", value = "/DentistPatientServlet")
public class DentistPatientServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PatientService patientService = new PatientService();
        DentistService dentistService = new DentistService();

        List<Patient> patients = patientService.getAllPatients();
        List<Dentist> dentists = dentistService.getAllDentists();

        request.setAttribute("patients", patients);
        request.setAttribute("dentists", dentists);
        request.getRequestDispatcher("scheduleAppointment.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}