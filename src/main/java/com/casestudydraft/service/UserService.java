package com.casestudydraft.service;

import com.casestudydraft.dao.DatabaseDAO;
import com.casestudydraft.dao.UserDAO;
import com.casestudydraft.model.Role;
import com.casestudydraft.model.User;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class UserService implements UserDAO, DatabaseDAO  {

    @Override
    public User findById(int id) {
        User user =  entityManager.find(User.class, id);
        return user;
    }

    @Override
    public void updateDatabase(User entity) {

    }

    @Override
    public User findByEmail(String email) throws NoResultException {
        Query q = entityManager.createQuery("SELECT u from User u WHERE u.email=:email");
        q.setParameter("email", email);
        return (User) q.getSingleResult();
    }

    @Override
    public List<User> findAll() {
        Query q = entityManager.createQuery("SELECT u FROM User u ");
        return (List<User>) q.getResultList();
    }

    @Override
    public List<User> findByRole(Role role) {
        String query = "SELECT u from User u INNER JOIN u.roles r";
        Query q = DatabaseDAO.entityManager.createQuery(query);
        return (List<User>) q.getResultList();
    }

    public boolean isRole(User user, Role role){
        return user.getRoles().contains(role);
    }

    public boolean validateUser(User user, String password) {
        return user.getPassword().equals(password);
    }
}
