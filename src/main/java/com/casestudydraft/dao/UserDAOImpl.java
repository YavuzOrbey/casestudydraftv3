package com.casestudydraft.dao;

import com.casestudydraft.model.Role;
import com.casestudydraft.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;
@Repository
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
    public User findByEmail(String email) throws NoResultException {
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

    @Override
    public boolean validateUser(User user) throws NoResultException{
        User u = findByEmail(user.getEmail());
        return user.getPassword().equals(u.getPassword());
    }
}
