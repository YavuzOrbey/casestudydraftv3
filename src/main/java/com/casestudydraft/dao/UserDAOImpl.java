package com.casestudydraft.dao;

import com.casestudydraft.model.Role;
import com.casestudydraft.model.User;

import javax.persistence.Query;
import java.util.List;

public class UserDAOImpl implements UserDAO{
    @Override
    public User findById(int id) {
        User user =  entityManager.find(User.class, id);
        return user;
    }

    @Override
    public List<User> findAll() {
        Query q = entityManager.createQuery("SELECT u FROM User u ");
        return (List<User>) q.getResultList();
    }

    @Override
    public User findByEmail(String email) {
        Query q = entityManager.createQuery("SELECT u from User u WHERE u.email=:email");
        q.setParameter("email", email);
        return (User) q.getSingleResult();
    }

    @Override
    public List<User> findByRole(Role role) {
        String query = "SELECT u from User u INNER JOIN u.roles r";
        Query q = DatabaseDAO.entityManager.createQuery(query);
        return (List<User>) q.getResultList();
    }
}
