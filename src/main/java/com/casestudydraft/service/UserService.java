package com.casestudydraft.service;

import com.casestudydraft.dao.UserDAOImpl;
import com.casestudydraft.model.Role;
import com.casestudydraft.model.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
@Service
public class UserService extends GenericService<User, UserDAOImpl> {
   /* UserDAOImpl userDAO;
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

*/
    public void updateDatabase(User entity) {

    }


    public User findByEmail(String email) throws NoResultException {
        User user = null;
        try{
            user = dao.findByEmail(email); //this is weird it stops throwing a noresultexception and instead throws this new spring exception
        }catch(EmptyResultDataAccessException e){
            throw e;
        }
        return user;
    }

    public List<User> findAll() {
        return dao.findAll();
    }

    public List<User> findByRole(Role role) {
        return dao.findByRole(role);
    }

    public boolean isRole(User user, Role role){
        return user.getRoles().contains(role);
    }

    public boolean validateUser(User user) throws NoResultException{
        return dao.validateUser(user);
    }
}
