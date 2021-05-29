package com.casestudydraft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @GetMapping("/")
    public String welcome() {
        return "redirect:home";
    }
    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("pages/landing");
        return mav;
    }


}
