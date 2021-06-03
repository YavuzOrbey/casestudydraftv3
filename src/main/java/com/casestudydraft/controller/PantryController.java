package com.casestudydraft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pantry")
public class PantryController {

    @RequestMapping(value="/", method= RequestMethod.GET)
    public ModelAndView myPantry(){
        ModelAndView mav = null;
        return mav;
    }
}
