package org.clinic.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.clinic.entity.Dentist;
import org.clinic.entity.Patient;
import org.clinic.entity.User;

import java.util.List;

public class PatientDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinic-unit");
    EntityManager em = emf.createEntityManager();

    public Patient save(Patient patient) {
        em.getTransaction().begin();
        em.persist(patient);
        em.getTransaction().commit();
        return patient;
    }

    public List<Patient> getAllPatients() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Patient> query = cb.createQuery(Patient.class);
        Root<Patient> root = query.from(Patient.class);
        query.select(cb.construct(Patient.class, root.get("id"), root.get("name"), root.get("surname"), root.get("dni"), root.get("birthdate"), root.get("phone"),root.get("address"), root.get("blood_type")));
        return em.createQuery(query).getResultList();
    }

    public Patient delete(int id) {
        Patient patient = em.find(Patient.class, id);
        em.getTransaction().begin();
        em.remove(patient);
        em.getTransaction().commit();
        return patient;
    }

    public Patient update(Patient patient) {
        em.getTransaction().begin();

        Patient p = em.find(Patient.class, patient.getId());
        p.setName(patient.getName());
        p.setSurname(patient.getSurname());
        p.setDni(patient.getDni());
        p.setBirthdate(patient.getBirthdate());
        p.setPhone(patient.getPhone());
        p.setAddress(patient.getAddress());
        p.setBlood_type(patient.getBlood_type());

        em.getTransaction().commit();

        return p;
    }

    public Patient getPatientById(int id) {
        Patient patient = em.find(Patient.class, id);
        return patient;
    }
}
