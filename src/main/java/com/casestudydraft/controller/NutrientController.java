package com.casestudydraft.controller;

import com.casestudydraft.model.Measurement;
import com.casestudydraft.model.Nutrient;
import com.casestudydraft.service.MeasurementService;
import com.casestudydraft.service.NutrientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
@RequestMapping("/nutrient")
public class NutrientController {
    @Autowired NutrientService nutrientService;
    @ModelAttribute("nutrients")
    public ArrayList<Nutrient> nutrients(){
        return (ArrayList<Nutrient>) nutrientService.findAll();
    }

    @ModelAttribute("nutrient")
    public Nutrient nutrient(){
        return new Nutrient();
    }
    public ModelAndView viewAllNutrients(HttpServletRequest request, @ModelAttribute("nutrients") ArrayList<Nutrient> nutrients){
        ModelAndView mav = null;
        mav = new ModelAndView("nutrient/index");
        return mav;
    }

    @RequestMapping(value="/create", method= RequestMethod.GET)
    public ModelAndView createNutrient(){
        ModelAndView mav = null;
        mav = new ModelAndView("nutrient/create");
        return mav;
    }

    @RequestMapping(value="/create", method= RequestMethod.POST)
    public ModelAndView storeNutrient(HttpServletRequest request, @ModelAttribute("nutrient") Nutrient nutrient) {
        ModelAndView mav = null;
        try {
            nutrientService.findByName(request.getParameter("nutrient_name").toLowerCase());
            mav = new ModelAndView("misc/duplicate");
        }
        catch(NoResultException e) {
//            Nutrient nutrient  = new Nutrient(request.getParameter("nutrient_name").toLowerCase(),
//                    request.getParameter("measurement_name").toLowerCase());
            nutrientService.saveToDatabase(nutrient);
            mav = new ModelAndView("misc/success");
        }
        catch(Exception e) {
            mav = new ModelAndView("misc/error");
        }
        return mav;
    }
}
