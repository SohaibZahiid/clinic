package org.clinic.dao;



import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.clinic.entity.Dentist;

import jakarta.persistence.EntityManager;
import org.clinic.entity.User;

import java.util.List;

public class DentistDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinic-unit");
    EntityManager em = emf.createEntityManager();

    public Dentist save(Dentist dentist) {
        em.getTransaction().begin();
        em.persist(dentist);
        em.getTransaction().commit();
        return dentist;
    }

    public List<Dentist> getAllDentists() {
        String jpql = "SELECT d FROM Dentist d";
        TypedQuery<Dentist> query = em.createQuery(jpql, Dentist.class);
        return query.getResultList();
    }
}
