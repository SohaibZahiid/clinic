package org.clinic.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.clinic.entity.Appointment;
import org.clinic.entity.Dentist;

import java.util.List;

public class AppointmentDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinic-unit");
    EntityManager em = emf.createEntityManager();

    public List<Appointment> getAppointmentsByPatient(Long patientId) {
        // Implement logic to retrieve appointments for a specific patient
        return null;
    }

    public List<Appointment> getAppointmentsByDentist(Long dentistId) {
        // Implement logic to retrieve appointments for a specific dentist
        return null;
    }

    public Appointment save(Appointment appointment) {
        em.getTransaction().begin();
        em.persist(appointment);
        em.getTransaction().commit();
        return appointment;
    }

    public List<Appointment> getAllAppointments() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Appointment> query = cb.createQuery(Appointment.class);
        Root<Appointment> root = query.from(Appointment.class);
        query.select(cb.construct(Appointment.class, root.get("id"), root.get("patient"), root.get("dentist"), root.get("appointmentDateTime")));
        return em.createQuery(query).getResultList();
    }

    public Appointment delete(int id) {
        Appointment appointment = em.find(Appointment.class, id);
        em.getTransaction().begin();
        em.remove(appointment);
        em.getTransaction().commit();
        return appointment;
    }
}
