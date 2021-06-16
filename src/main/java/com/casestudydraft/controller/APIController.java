package com.casestudydraft.controller;

import com.casestudydraft.model.Ingredient;
import com.casestudydraft.model.Measurement;
import com.casestudydraft.model.Nutrient;
import com.casestudydraft.service.IngredientService;
import com.casestudydraft.service.MeasurementService;
import com.casestudydraft.service.NutrientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class APIController {
    @Autowired
    MeasurementService measurementService;

    @Autowired
    NutrientService nutrientService;


    @Autowired
    IngredientService ingredientService;

    @ModelAttribute("measurements")
    public ArrayList<Measurement> measurements(){

        List<Measurement> measurements = measurementService.listAll();
        return (ArrayList<Measurement>) measurements;
    }

    @ModelAttribute("nutrients")
    public ArrayList<Nutrient> nutrients(){

        List<Nutrient> nutrients = nutrientService.findAll();
        return (ArrayList<Nutrient>) nutrients;
    }

    @ModelAttribute("ingredients")
    public ArrayList<Ingredient> ingredients(){
        List<Ingredient> ingredients = ingredientService.findAll();
        return (ArrayList<Ingredient>) ingredients;
    }

    @RequestMapping(value="/measurements")
    public List<Measurement> viewAllMeasurements(@ModelAttribute("measurements") List<Measurement> measurements) {
        return measurements;
    }

    @RequestMapping(value="/measurement/{id}")
    public Measurement findMeasurement(@PathVariable Long id) {
            return measurementService.get(id);
    }
    @RequestMapping(value="/measurement")
    public Measurement findMatchingMeasurements(@RequestParam String q) {
        return measurementService.findByNameIgnoreCaseContaining(q);
    }
    @RequestMapping(value="/nutrients")
    public List<Nutrient> viewAllNutrients(@ModelAttribute("nutrients") List<Nutrient> nutrients) {
        return nutrients;
    }

    @RequestMapping(value="/nutrient/{id}")
    public Nutrient findNutrient(@PathVariable Long id) {
        return nutrientService.get(id);
    }

    @RequestMapping(value="/nutrient")
    public List<Nutrient> findMatchingNutrients(@RequestParam String q) {
        return nutrientService.findByNameIgnoreCaseContaining(q);
    }

    @RequestMapping(value="/ingredient")
    public List<Ingredient> viewAllIngredients(@ModelAttribute("ingredients") List<Ingredient> ingredients) {
        return ingredients;
    }

    @RequestMapping(value="/ingredient", method=RequestMethod.POST)
    public Ingredient storeIngredient(@ModelAttribute("ingredient") Ingredient ingredient, @RequestParam MultiValueMap<String, String> params,
                                      @RequestParam Map<String, String> nutrients) {
        System.out.println("hitting this ");
        System.out.println(ingredient);
        System.out.println(params);

        System.out.println(nutrients);
        return ingredient;
    }


    @RequestMapping(value="/ingredient/{id}")
    public Ingredient findIngredient(@PathVariable Long id) {
        return ingredientService.get(id);
    }
}
