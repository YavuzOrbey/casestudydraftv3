package com.casestudydraft.dao;


import com.casestudydraft.model.Role;
import com.casestudydraft.model.User;

import java.util.List;

public interface UserDAO extends GenericDAO<User> {

        User findByEmail(String email);
        List<User> findByRole(Role role);
        boolean validateUser(User user);
    }

