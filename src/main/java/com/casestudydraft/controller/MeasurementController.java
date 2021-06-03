package com.casestudydraft.controller;

import com.casestudydraft.model.Measurement;

import com.casestudydraft.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/measurement")
public class MeasurementController {
    @Autowired MeasurementService measurementService;

    @ModelAttribute("measurements")
    public ArrayList<Measurement> measurements(){
        List<Measurement> measurements = measurementService.findAll();
        return (ArrayList<Measurement>) measurements;
    }
    @RequestMapping(value="", method= RequestMethod.GET)
    public String redirectToMain(){
        return "redirect:measurement/";
    }
    @RequestMapping(value="/", method= RequestMethod.GET)
    public ModelAndView viewAllMeasurements(HttpServletRequest request) {
        ModelAndView mav = null;
        mav = new ModelAndView("measurement/index");
        return mav;
    }

    @RequestMapping(value="/create", method= RequestMethod.GET)
    public ModelAndView createMeasurement(HttpServletRequest request) {
        System.out.println("hello");
        ModelAndView mav = null;
        mav = new ModelAndView("measurement/create");
        mav.addObject("message", "");
        return mav;
    }

    @RequestMapping(value="/create", method= RequestMethod.POST)
    public ModelAndView storeMeasurement(HttpServletRequest request) {
        ModelAndView mav = null;
        try {
            measurementService.findByName(request.getParameter("measurement_name").toLowerCase());
            mav = new ModelAndView("misc/duplicate");
        }
        catch(NoResultException e) {
            Measurement measurement = new Measurement(request.getParameter("measurement_name").toLowerCase());
            measurementService.saveToDatabase(measurement);
            mav = new ModelAndView("measurement/create");
            mav.addObject("message", "Successfully added!");
        }
        catch(Exception e) {
            mav = new ModelAndView("measurement/create");
            mav.addObject("message", "An error occurred");
        }
        return mav;
    }

    @RequestMapping(value="/edit/{id}", method= RequestMethod.GET)
    public ModelAndView editMeasurement(HttpServletRequest request, @PathVariable int id,
                                          @ModelAttribute("measurement") Measurement measurement, BindingResult result) {
        ModelAndView mav = null;
        measurement = measurementService.findById(id);
        mav = new ModelAndView("measurement/edit");
        mav.addObject(measurement);
        return mav;
    }
    @RequestMapping(value="/edit/{id}", method= RequestMethod.POST)
    public ModelAndView updateMeasurement(HttpServletRequest request,  @ModelAttribute("measurement") Measurement measurement) {
        ModelAndView mav = null;
        mav = new ModelAndView("measurement/edit");
        System.out.println(measurement); // ok so if you don't have getters and setters for stuff when you use model binding it wont have those fields values
        measurementService.update(measurement);
        return mav;
    }
    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String deleteMeasurement(@PathVariable int id){
        measurementService.delete(measurementService.findById(id));
        return "redirect:/measurement/";
    }
}