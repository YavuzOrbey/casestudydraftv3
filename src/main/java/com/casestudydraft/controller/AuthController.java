package com.casestudydraft.controller;

import com.casestudydraft.model.User;
import com.casestudydraft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class AuthController {
    @Autowired UserService userService;

    @ModelAttribute("user")
    public User newUser(){
        return new User();
    }
    @RequestMapping(value="/register", method = RequestMethod.GET)
    public ModelAndView registerScreen(HttpServletRequest request) {
        ModelAndView mav = null;
        mav = new ModelAndView("auth/register");
        return  mav;
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String registerUser(HttpServletRequest request, @ModelAttribute("user") @Valid User user, BindingResult result) {
        //should also create the user's pantry when registered
        String url = "auth/register";
        if(user.getPassword()!=user.getPasswordConfirm()) {
            url = "auth/register"; //maybe throw a customexception here
            return url;
        }
        else
        try {
            userService.findByEmail(user.getEmail());
        }catch(NoResultException | EmptyResultDataAccessException e ) {
            //User user = new User(request.getParameter("email"), request.getParameter("password"));
            userService.saveToDatabase(user);
            url = "pages/dashboard";
        }catch(Exception e) {
            System.out.println(e);
        }
        return url;
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView loginScreen(HttpServletRequest request, @ModelAttribute("user") User user) {
        ModelAndView mav = new ModelAndView("auth/login");
        return mav;
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String loginUser(@ModelAttribute("user") @Valid User user, BindingResult result, Model model) {
        System.out.println(user);
        String url = "auth/login";

        if(result.hasErrors()){

            return url;
        }
        try {
          /*  User user = userService.findByEmail(request.getParameter("email"));
            boolean validated = userService.validateUser(user, request.getParameter("password"));
            if(validated) {
                HttpSession session = 	request.getSession();
                session.setAttribute("user", user);
                mav = new ModelAndView("misc/success");
            }else {
                mav = new ModelAndView("misc/error");
            }*/
            url = userService.validateUser(user) ? "pages/dashboard": "redirect:/";
        }catch(NoResultException e) {
            System.out.println(e);
        }
        System.out.println("URL IS: " + url);
        return url;
    }
}
