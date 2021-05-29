package com.casestudydraft.controller;

import com.casestudydraft.model.Ingredient;
import com.casestudydraft.model.Measurement;
import com.casestudydraft.service.IngredientService;
import com.casestudydraft.service.NutrientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("ingredient")
public class IngredientController {
    @ModelAttribute
    public Ingredient setUpIngredient(){
        Ingredient ingredient = new Ingredient();
        return ingredient;
    }

    @RequestMapping(method= RequestMethod.GET)
    public ModelAndView viewAllIngredients(HttpServletRequest request) {
        ModelAndView mav = null;
        mav = new ModelAndView("ingredient/index");
        return mav;
    }

    @RequestMapping(value="/create", method= RequestMethod.GET)
    public ModelAndView createIngredient(HttpServletRequest request) {
        ModelAndView mav = null;
        //get all the nutrients and populate the form with them
        NutrientService nutrientService = new NutrientService();
        //nutrientService.getAll();
        mav = new ModelAndView("ingredient/create");
        return mav;
    }

    @RequestMapping(value="/create", method= RequestMethod.POST)
    public ModelAndView storeIngredient(HttpServletRequest request, @ModelAttribute("ingredient") Ingredient ingredient) {
//        Measurement measurement = new Measurement(request.getParameter("measurement"));
        IngredientService ingredientService = new IngredientService();
        ingredientService.saveToDatabase(ingredient);
        System.out.println(ingredient.getId());
        ModelAndView mav = new ModelAndView("misc/success");
        return mav;
        //the only reason I'm using the request is to get these params so lets change it to modelattribute way of doing it

        //however this isn't goign to work for the nutrition info because they're not fields of a class. THe nutrients and ingredients are ina a many to many relationship
        // WHY that and not just having them as fields in the ingredient? Because not ever ingredient is going to have fat, or Vitamin A, or B etc

        /*
         * try {
         * ingredientService.findByName(request.getParameter("name").toLowerCase()); mav
         * = new ModelAndView("misc/duplicate"); } catch(NoResultException e) { String
         * name = request.getParameter("name").toLowerCase(); Integer servingSize =
         * Integer.parseInt( request.getParameter("serving")); Integer calories =
         * Integer.parseInt( request.getParameter("calories")); Integer totalFat =
         * Integer.parseInt( request.getParameter("total_fat")); Integer saturatedFat =
         * Integer.parseInt( request.getParameter("saturated_fat")); Integer transFat =
         * Integer.parseInt( request.getParameter("trans_fat")); Integer cholesterol =
         * Integer.parseInt( request.getParameter("cholesterol")); Integer sodium =
         * Integer.parseInt( request.getParameter("sodium")); Integer totalCarbs =
         * Integer.parseInt( request.getParameter("total_carbs")); Integer fiber =
         * Integer.parseInt( request.getParameter("fiber")); Integer sugar =
         * Integer.parseInt( request.getParameter("sugar")); Integer protein =
         * Integer.parseInt( request.getParameter("protein"));
         *
         * Ingredient ingredient = new Ingredient(name,servingSize,calories);
         * NutrientService nutrientService = new NutrientService(); Nutrient
         * totalFatNutrient = nutrientService.findByName("total_fat"); // get nutrient
         * total_fat
         *
         * //get nutrient saturated_fat etc
         * ingredientService.saveToDatabase(ingredient);
         */
//        mav = new ModelAndView("misc/success");
//    }
//	catch(Exception e) {
//        mav = new ModelAndView("misc/error");
//        mav.addObject("error", e);
//    }

}
}
