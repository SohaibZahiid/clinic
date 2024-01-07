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
import java.util.Date;
import java.util.List;

@WebServlet(name = "DentistServlet", value = "/DentistServlet")
public class DentistServlet extends HttpServlet {

    DentistService service = new DentistService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Dentist> dentists = service.getAllDentists();

        request.setAttribute("dentists", dentists);
        request.getRequestDispatcher("viewDentists.jsp").forward(request, response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String first = request.getParameter("first");
        String last = request.getParameter("last");
        String dni = request.getParameter("dni");
        String birthdate = request.getParameter("birthdate");
        String speciality = request.getParameter("speciality");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date;
        try {
            date = dateFormat.parse(birthdate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Dentist dentist = new Dentist();
        dentist.setName(first);
        dentist.setSurname(last);
        dentist.setDni(dni);
        dentist.setBirthdate(date);
        dentist.setSpeciality(speciality);
        dentist.setPhone(phone);
        dentist.setAddress(address);

        System.out.println(dentist);

        service.save(dentist);

       // response.sendRedirect("DentistServlet");

    }
}