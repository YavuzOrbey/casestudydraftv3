package com.casestudydraft.service;

import com.casestudydraft.dao.DatabaseDAO;
import com.casestudydraft.dao.UserDAO;
import com.casestudydraft.dao.UserDAOImpl;
import com.casestudydraft.model.Role;
import com.casestudydraft.model.User;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class UserService extends Service<User> {
    UserDAOImpl userDAO;
    public User findById(int id) {
        return userDAO.findById(id);
    }

    public void updateDatabase(User entity) {

    }


    public User findByEmail(String email) throws NoResultException {
            return userDAO.findByEmail(email);
    }

    public List<User> findAll() {
            return userDAO.findAll();
    }

    public List<User> findByRole(Role role) {
        return userDAO.findByRole(role);
    }

    public boolean isRole(User user, Role role){
        return user.getRoles().contains(role);
    }

    public boolean validateUser(User user, String password) {
        return user.getPassword().equals(password);
    }
}
