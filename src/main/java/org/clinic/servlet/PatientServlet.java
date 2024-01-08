package org.clinic.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.clinic.entity.Dentist;
import org.clinic.entity.Patient;
import org.clinic.entity.User;
import org.clinic.service.PatientService;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@WebServlet(name = "PatientServlet", value = "/PatientServlet")
public class PatientServlet extends HttpServlet {

    PatientService service = new PatientService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Patient> patients = service.getAllPatients();
        request.setAttribute("patients", patients);
        request.getRequestDispatcher("viewPatients.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String first = request.getParameter("first");
        String last = request.getParameter("last");
        String dni = request.getParameter("dni");
        String birthdate = request.getParameter("birthdate");
        String blood_type = request.getParameter("blood");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        Patient patient = new Patient();
        patient.setName(first);
        patient.setSurname(last);
        patient.setDni(dni);
        patient.setBirthdate(LocalDate.parse(birthdate));
        patient.setBlood_type(blood_type);
        patient.setPhone(phone);
        patient.setAddress(address);

        service.save(patient);

        response.sendRedirect("PatientServlet");
    }
}