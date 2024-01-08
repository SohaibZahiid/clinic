package org.clinic.service;

import org.clinic.dao.AppointmentDao;
import org.clinic.entity.Appointment;

import java.util.List;

public class AppointmentService {
    AppointmentDao dao;

    public AppointmentService() {
        this.dao = new AppointmentDao();
    }

    public List<Appointment> getAppointmentsByPatient(Long patientId) {
        return dao.getAppointmentsByPatient(patientId);
    }

    public Appointment save(Appointment appointment) {
        return dao.save(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return dao.getAllAppointments();
    }

    public Appointment delete(int id) {
        return dao.delete(id);
    }
}
