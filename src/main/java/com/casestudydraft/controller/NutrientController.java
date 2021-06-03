package com.casestudydraft.controller;

import com.casestudydraft.model.Measurement;
import com.casestudydraft.model.Nutrient;
import com.casestudydraft.service.MeasurementService;
import com.casestudydraft.service.NutrientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/nutrient")
public class NutrientController {
    @Autowired NutrientService nutrientService;
    @Autowired MeasurementService measurementService;

    @ModelAttribute("nutrients")
    public ArrayList<Nutrient> nutrients(){
        List<Nutrient> nutrients = nutrientService.findAll();
        return (ArrayList<Nutrient>) nutrients;
    }

    @ModelAttribute("measurements")
    public ArrayList<Measurement> measurements(){
        return (ArrayList<Measurement>) measurementService.findAll();
    }


    @RequestMapping(value="", method= RequestMethod.GET)
    public String redirectToMain(){
        return "redirect:nutrient/";
    }
    @RequestMapping(value="/", method= RequestMethod.GET)
    public ModelAndView viewAllNutrients(HttpServletRequest request){
        ModelAndView mav = null;
        mav = new ModelAndView("nutrient/index");
        return mav;
    }
    @RequestMapping(value="/create", method= RequestMethod.GET)
    public ModelAndView createNutrient(@ModelAttribute("measurements") ArrayList<Measurement> measurements){
        ModelAndView mav = null;
        mav = new ModelAndView("nutrient/create");
        return mav;
    }

    @RequestMapping(value="/create", method= RequestMethod.POST)
    public String storeNutrient(HttpServletRequest request,  @ModelAttribute("nutrient") Nutrient nutrient) { //no need to use modelattribute here very little data
        String mav = null;
        try {

            nutrient = nutrientService.findByName(request.getParameter("nutrient").toLowerCase());
            mav = "misc/duplicate";
        }
        catch(NoResultException e) {
            try {
                Measurement measurement = measurementService.findById(Integer.parseInt( request.getParameter("measurement")));

                nutrient = new Nutrient(request.getParameter("nutrient").toLowerCase(), measurement);
                nutrientService.saveToDatabase(nutrient);
                /*

                Problem with the following way is that because I'm not redirecting or asking for a new url
                it's not going to call the nutrientservice.findall method so it won't show the thing that was just added
                probably best to use a session attribute for that message (edit
                 */
                mav = "nutrient/index";
                //mav.addObject("message", "Successfully added!");
            }catch (NoResultException ex){
                System.out.println("Measurement not found!");
            }
            catch (Exception ex) {
                System.out.println(ex);
            }
        }
        catch(Exception e) {
            mav = "misc/error";
        }
        return mav;
    }



    @RequestMapping(value="/edit/{id}", method= RequestMethod.GET)
    public ModelAndView editNutrient(HttpServletRequest request, @PathVariable int id,
                                     @ModelAttribute("nutrient") Nutrient nutrient, BindingResult result,
                                     @ModelAttribute("measurements") ArrayList<Measurement> measurements) {
        ModelAndView mav = null;
        nutrient = nutrientService.findById(id);
        mav = new ModelAndView("nutrient/edit");
        mav.addObject(nutrient);
        return mav;
    }

    @RequestMapping(value="/edit/{id}", method= RequestMethod.POST)
    public ModelAndView updateNutrient(HttpServletRequest request,  @ModelAttribute("nutrient") Nutrient nutrient) {
        ModelAndView mav = null;
        mav = new ModelAndView("nutrient/edit");
        nutrientService.update(nutrient);
        return mav;
    }
    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String deleteNutrient(@PathVariable int id){
        nutrientService.delete(nutrientService.findById(id));
        return "redirect:/nutrient/";
    }
}
