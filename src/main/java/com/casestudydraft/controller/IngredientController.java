package com.casestudydraft.controller;

import com.casestudydraft.model.Ingredient;
import com.casestudydraft.model.IngredientNutrient;
import com.casestudydraft.model.Measurement;
import com.casestudydraft.model.Nutrient;
import com.casestudydraft.service.IngredientNutrientService;
import com.casestudydraft.service.IngredientService;
import com.casestudydraft.service.MeasurementService;
import com.casestudydraft.service.NutrientService;
import com.casestudydraft.tools.FormHelper;
import com.casestudydraft.tools.KeyValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ingredient")
public class IngredientController {
    @Autowired NutrientService nutrientService;
    @Autowired MeasurementService measurementService;
    @Autowired IngredientService ingredientService;
    @Autowired IngredientNutrientService ingredientNutrientService;
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

    @ModelAttribute("form")
    public FormHelper form(){
        return new FormHelper();
    }
    @RequestMapping(value="", method= RequestMethod.GET)
    public String redirectToMain(){
        return "redirect:ingredient/";
    }
    @RequestMapping(value="/", method= RequestMethod.GET)
    public ModelAndView viewAllIngredients(HttpServletRequest request,  @ModelAttribute("ingredients") ArrayList<Ingredient> ingredients) {
        ModelAndView mav = null;
        mav = new ModelAndView("ingredient/index");
        return mav;
    }
    @RequestMapping(value="/create", method= RequestMethod.GET)
    public ModelAndView createIngredient(HttpServletRequest request,
                                         @ModelAttribute("measurements") ArrayList<Measurement> measurements,  BindingResult result,
                                         @ModelAttribute("ingredient") Ingredient ingredient) {

        ModelAndView mav = null;
        ArrayList<Nutrient> nutrients = (ArrayList<Nutrient>) nutrientService.findAll();
        List<IngredientNutrient> ingredientNutrients = new ArrayList<>();
        for(int i=0; i<nutrients.size(); i++){
            ingredientNutrients.add(new IngredientNutrient(nutrients.get(i)));
        }

        ingredient.setIngredientNutrients(ingredientNutrients);
        mav = new ModelAndView("ingredient/create1", "ingredientNutrients", ingredientNutrients);
        return mav;
    }

    @RequestMapping(value="/create", method= RequestMethod.POST)
    public ModelAndView storeIngredient(HttpServletRequest request,
                                        @ModelAttribute("ingredient") Ingredient ingredient,
                                        BindingResult result) {
        ModelAndView mav = null;
        if(result.hasErrors()){
            mav = new ModelAndView("ingredient/create");
            return mav;

        }
        ingredient.setMeasurement(measurementService.get(ingredient.getMeasurement().getId()));
        //the problem is when I get ingredient back from form the list ingredient.ingredientNutrients is filled with
        // IngredientNutrients that have the amount field filled in but the ingredient and nutrient field are null
        // cannot fill a object datatype field in html so lets think of another way....


        //what if in the form we had a form:hidden which had a path of path="ingredientNutrients[index].nutrient.id
        // and we set THAT equal to the id of the nutrient during the loop

        //When this comes back from the form the ingredientNutrients is going to be an arraylist where each
        // IngredientNutrient only has the amount of that nutrient for the ingredient  and the nutrient object type is
        // going to have an id
        /*example IngredientNutrient:
        {
        id: 0,
        nutrient: {id: 1, name: null, ingredientNutrients: null}
        ingredient: null,
        amount: 10
        }

        so for each IngredientNutrient we're going to setIngredient to the ingredient and the nutrient to the
        id inside of the nutrient property (which is really just used to pluck the id)
         */
        ingredient.getIngredientNutrients().forEach(ingredientNutrient -> {
            ingredientNutrient.setIngredient(ingredient);
            ingredientNutrient.setNutrient(nutrientService.get(ingredientNutrient.getNutrient().getId()));
        });
        ingredientService.save(ingredient);

        mav = new ModelAndView("redirect:");
        return mav;
}
    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String deleteNutrient(@PathVariable int id){
        ingredientService.delete(ingredientService.get(id));
        return "redirect:/ingredient/";
    }


}
