package org.clinic.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.clinic.entity.Dentist;
import org.clinic.entity.User;
import org.clinic.service.DentistService;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@WebServlet(name = "UpdateDentistServlet", value = "/UpdateDentistServlet")
public class UpdateDentistServlet extends HttpServlet {
    DentistService service = new DentistService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Dentist dentist = service.getDentistById(id);
        System.out.println(dentist);
        request.setAttribute("dentist", dentist);
        request.getRequestDispatcher("updateDentist.jsp").forward(request, response);
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
        String speciality = request.getParameter("speciality");


        Dentist dentist = new Dentist();
        dentist.setId(id);
        dentist.setName(name);
        dentist.setSurname(surname);
        dentist.setDni(dni);
        dentist.setBirthdate(LocalDate.parse(birthdate));
        dentist.setPhone(phone);
        dentist.setAddress(address);
        dentist.setSpeciality(speciality);

        Dentist u = service.update(dentist);

        response.sendRedirect("DentistServlet");
    }
}