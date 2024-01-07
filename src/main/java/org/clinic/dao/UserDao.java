package org.clinic.dao;


import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.clinic.entity.User;

import java.util.List;

public class UserDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinic-unit");
    EntityManager em = emf.createEntityManager();


    public User save(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        return user;
    }

    public List<User> getAllUsers() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(cb.construct(User.class, root.get("user_id"), root.get("username"), root.get("password"), root.get("role")));
        return em.createQuery(query).getResultList();
    }

    public User delete(int id) {
        User user = em.find(User.class, id);
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
        return user;
    }

    public User getUserById(int id) {
        User user = em.find(User.class, id);
        return user;
    }

    public User updateUser(User user) {
        em.getTransaction().begin();

        User u = em.find(User.class, user.getUser_id());
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setRole(user.getRole());

        em.getTransaction().commit();

        return u;
    }

    public User login(String username, String password) {
        em.getTransaction().begin();

        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :password", User.class);
        query.setParameter("username", username);
        query.setParameter("password", password);

        try {
            User user = query.getSingleResult();
            em.getTransaction().commit();
            return user;
        } catch (NoResultException e) {
            return null;
        }
    }
}
