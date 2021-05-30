package com.casestudydraft.controller;

import com.casestudydraft.model.User;
import com.casestudydraft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AuthController {
    @Autowired UserService userService;

    @RequestMapping(value="/register", method = RequestMethod.GET)
    public ModelAndView registerScreen(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("auth/register");
        return mav;
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public ModelAndView registerUser(HttpServletRequest request, @ModelAttribute User user) {
        //should also create the user's pantry when registered
        ModelAndView mav = null;
        try {
            userService.findByEmail(user.getEmail());
            mav = new ModelAndView("misc/error");
        }catch(NoResultException | EmptyResultDataAccessException e ) {
            //User user = new User(request.getParameter("email"), request.getParameter("password"));
            userService.saveToDatabase(user);
            mav = new ModelAndView("misc/success");
        }catch(Exception e) {
            System.out.println(e);
        }
        return mav;
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView loginScreen(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("auth/login");
        return mav;
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ModelAndView loginUser(HttpServletRequest request) {
        ModelAndView mav = null;
        try {
            UserService userService = new UserService();
            User user = userService.findByEmail(request.getParameter("email"));
            boolean validated = userService.validateUser(user, request.getParameter("password"));
            if(validated) {
                HttpSession session = 	request.getSession();
                session.setAttribute("user", user);
                mav = new ModelAndView("misc/success");
            }else {
                mav = new ModelAndView("misc/error");
            }
        }catch(NoResultException e) {
            System.out.print(e);
        }
        return mav;
    }
}
