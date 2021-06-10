package com.casestudydraft.controller;

import com.casestudydraft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pantry")
public class PantryController {
    @Autowired
    UserService userService;
    @RequestMapping(value="/", method= RequestMethod.GET)
    public ModelAndView myPantry(){

        //find current user
        userService.findById(1);
        ModelAndView mav = null;
        return mav;
    }
}
