package com.casestudydraft.service;

import com.casestudydraft.dao.UserDAOImpl;
import com.casestudydraft.model.Role;
import com.casestudydraft.model.User;
import com.casestudydraft.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

}
