package com.casestudydraft.controller;

import com.casestudydraft.model.Ingredient;
import com.casestudydraft.model.Measurement;
import com.casestudydraft.model.Nutrient;
import com.casestudydraft.model.Recipe;
import com.casestudydraft.service.IngredientNutrientService;
import com.casestudydraft.service.IngredientService;
import com.casestudydraft.service.MeasurementService;
import com.casestudydraft.service.NutrientService;
import com.casestudydraft.tools.FormHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/recipe")
public class RecipeController {
    @Autowired
    NutrientService nutrientService;
    @Autowired
    MeasurementService measurementService;
    @Autowired
    IngredientService ingredientService;
    @Autowired
    IngredientNutrientService ingredientNutrientService;
    @ModelAttribute("ingredient")
    public Ingredient setUpIngredient(){
        Ingredient ingredient = new Ingredient();
        return ingredient;
    }

    @ModelAttribute("measurements")
    public ArrayList<Measurement> measurements(){

        List<Measurement> measurements = measurementService.findAll();
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

    @RequestMapping(value="", method= RequestMethod.GET)
    public String redirectToMain(){
        return "redirect:recipe/";
    }
    @RequestMapping(value="/", method= RequestMethod.GET)
    public ModelAndView viewAllRecipes(HttpServletRequest request, @ModelAttribute("recipes") ArrayList<Recipe> recipes) {
        ModelAndView mav = null;
        mav = new ModelAndView("recipe/index");
        return mav;
    }

    @RequestMapping(value="/create", method= RequestMethod.GET)
    public ModelAndView createRecipe(@ModelAttribute("measurements") ArrayList<Measurement> measurements,
                                     @ModelAttribute("ingredients") ArrayList<Ingredient> ingredients){
        ModelAndView mav = null;
        mav = new ModelAndView("recipe/create");
        mav.addObject("recipe", new Recipe());
        return mav;
    }

    @RequestMapping(value="/create", method= RequestMethod.POST)
    public ModelAndView storeRecipe(HttpServletRequest request,
                                        @ModelAttribute("recipe") Recipe recipe,
                                        BindingResult result) {
        ModelAndView mav = null;
        if(result.hasErrors()){
            mav = new ModelAndView("recipe/create");
            return mav;

        }
        //maybe stop trying to bind recipe.recipeIngredients as well as all other stuff that ALREADY exists

        System.out.println(recipe.getRecipeIngredients());
//        ingredient.setMeasurement(measurementService.get(ingredient.getMeasurement().getId()));
//        ingredient.getIngredientNutrients().forEach(ingredientNutrient -> {
//            ingredientNutrient.setIngredient(ingredient);
//            ingredientNutrient.setNutrient(nutrientService.get(ingredientNutrient.getNutrient().getId()));
//        });
//        ingredientService.save(ingredient);
//
//        mav = new ModelAndView("redirect:");
        return mav;
    }

}
