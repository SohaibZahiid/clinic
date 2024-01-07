package org.clinic.dao;



import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.clinic.entity.Dentist;

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
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Dentist> query = cb.createQuery(Dentist.class);
        Root<Dentist> root = query.from(Dentist.class);
        query.select(cb.construct(Dentist.class, root.get("id"), root.get("name"), root.get("surname"), root.get("dni"), root.get("birthdate"), root.get("phone"),root.get("address"), root.get("speciality")));
        return em.createQuery(query).getResultList();
    }

    public Dentist delete(int id) {
        Dentist dentist = em.find(Dentist.class, id);
        em.getTransaction().begin();
        em.remove(dentist);
        em.getTransaction().commit();
        return dentist;
    }

    public Dentist update(Dentist dentist) {
        em.getTransaction().begin();

        Dentist d = em.find(Dentist.class, dentist.getId());
        d.setName(dentist.getName());
        d.setSurname(dentist.getSurname());
        d.setDni(dentist.getDni());
        d.setBirthdate(dentist.getBirthdate());
        d.setPhone(dentist.getPhone());
        d.setAddress(dentist.getAddress());

        em.getTransaction().commit();

        return d;
    }

    public Dentist getDentistById(int id) {
        Dentist dentist = em.find(Dentist.class, id);
        return dentist;
    }
}
