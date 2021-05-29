package com.casestudydraft.controller;

import com.casestudydraft.model.Measurement;
import com.casestudydraft.service.MeasurementService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="/measurement")
public class MeasurementController {
    @RequestMapping(method= RequestMethod.GET)
    public ModelAndView viewAllMeasurements(HttpServletRequest request) {
        ModelAndView mav = null;
        mav = new ModelAndView("measurement/index");
        return mav;
    }

    @RequestMapping(value="/create", method= RequestMethod.GET)
    public ModelAndView createMeasurement(HttpServletRequest request) {
        ModelAndView mav = null;
        mav = new ModelAndView("measurement/create");
        return mav;
    }

    @RequestMapping(value="/create", method= RequestMethod.POST)
    public ModelAndView storeMeasurement(HttpServletRequest request) {
        ModelAndView mav = null;
        MeasurementService measurementService = new MeasurementService();
        try {
            measurementService.findByName(request.getParameter("measurement_name").toLowerCase());
            mav = new ModelAndView("misc/duplicate");
        }
        catch(NoResultException e) {
            Measurement measurement = new Measurement(request.getParameter("measurement_name").toLowerCase());
            measurementService.saveToDatabase(measurement);
            mav = new ModelAndView("misc/success");
        }
        catch(Exception e) {
            mav = new ModelAndView("misc/error");
        }
        return mav;
    }
}