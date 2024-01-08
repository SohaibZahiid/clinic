package org.clinic.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.clinic.dao.PatientDao;
import org.clinic.entity.Dentist;
import org.clinic.entity.Patient;
import org.clinic.service.PatientService;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@WebServlet(name = "UpdatePatientServlet", value = "/UpdatePatientServlet")
public class UpdatePatientServlet extends HttpServlet {
    PatientService service = new PatientService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Patient patient = service.getPatientById(id);
        System.out.println(patient);
        request.setAttribute("patient", patient);
        request.getRequestDispatcher("updatePatient.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("first");
        String surname = request.getParameter("last");
        String dni = request.getParameter("dni");
        String birthdate = request.getParameter("birthdate");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String blood = request.getParameter("blood");


        Patient patient = new Patient();
        patient.setId(id);
        patient.setName(name);
        patient.setSurname(surname);
        patient.setDni(dni);
        patient.setBirthdate(LocalDate.parse(birthdate));
        patient.setPhone(phone);
        patient.setAddress(address);
        patient.setBlood_type(blood);


        Patient u = service.update(patient);

        response.sendRedirect("PatientServlet");
    }
}