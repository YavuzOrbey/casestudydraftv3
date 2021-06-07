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
                                         @ModelAttribute("nutrients")ArrayList<Nutrient> nutrients,
                                         @ModelAttribute("ingredient") Ingredient ingredient) {
        //@ModelAttribute("form") FormHelper formHelper
        //todo fix all of this if there is time
        ModelAndView mav = null;
        /*Map<String, KeyValuePair<Nutrient, Integer>> nutrientMap = new HashMap<String, KeyValuePair<Nutrient, Integer>>();
        for(int i=0; i<nutrients.size(); i++){
            nutrientMap.put(nutrients.get(i).getName(),
                    new  KeyValuePair<Nutrient, Integer>(nutrients.get(i), 0)); //second number will be the amount
        }
        formHelper.setNutrientMap(nutrientMap);
        System.out.println(formHelper.getNutrientMap());*/

        /*List<KeyValuePair<Nutrient, Integer>> nutrientAndAmountList = new ArrayList<>();
        for(int i=0; i<nutrients.size(); i++){
            nutrientAndAmountList.add(new KeyValuePair<>(nutrients.get(i), 0));
        }
        formHelper.setNutrientList(nutrientAndAmountList);
        System.out.println(formHelper);
*/
        List<IngredientNutrient> ingredientNutrients = new ArrayList<>();
        for(int i=0; i<nutrients.size(); i++){
            ingredientNutrients.add(new IngredientNutrient(nutrients.get(i)));
        }
        ingredient.setIngredientNutrients(ingredientNutrients);
        mav = new ModelAndView("ingredient/create1", "ingredientNutrients", ingredientNutrients);
        return mav;
    }
    @Transactional
    @RequestMapping(value="/create", method= RequestMethod.POST)
    public ModelAndView storeIngredient(HttpServletRequest request,
                                        @ModelAttribute("ingredient") Ingredient ingredient,
                                        BindingResult result) {
        //@ModelAttribute("form")  @Valid FormHelper formHelper,
        ModelAndView mav = null;
        if(result.hasErrors()){
            mav = new ModelAndView("ingredient/create");
            return mav;

     }
        ingredient.setMeasurement(measurementService.findById(1));
        System.out.println(ingredient);
        //the problem is when I get ingredient back from form the list ingredient.ingredientNutrients is filled with
        // IngredientNutrients that have the amount field filled in but the ingredient and nutrient field are null
        // cannot fill a object datatype field in html so lets think of another way....


        //what if in the form we had a form:hidden which had a path of path="ingredientNutrients[index].nutrient.id
        // and we set THAT equal to the id of the nutrient during the loop

        ingredient.getIngredientNutrients().forEach(ingredientNutrient -> {
            ingredientNutrient.setIngredient(ingredient);
            ingredientNutrient.setNutrient(nutrientService.findById(ingredientNutrient.getNutrient().getId()));
        });
        Ingredient savedIngredient = ingredientService.saveToDatabase(ingredient);
        System.out.println(savedIngredient.getIngredientNutrients());

        //Ingredient savedIngredient = ingredientService.saveToDatabase(ingredient);
         /*
        Ingredient savedIngredient = ingredientService.saveToDatabase(formHelper.getIngredient());
        List<KeyValuePair<String, String>> nutrientAmounts = formHelper.getNutrientAmounts();
       // Map<String,  KeyValuePair<Nutrient, Integer>> theMap =  formHelper.getNutrientMap();
     //  System.out.println(theMap);

        *//* formHelper.getNutrientAmounts().forEach(keyValuePair->{
            IngredientNutrient ingredientNutrient = new IngredientNutrient();
            ingredientNutrient.setIngredient(savedIngredient);
            Nutrient nutrient = nutrientService.findById(keyValuePair.getFirst());
            ingredientNutrient.setNutrient(nutrient); // the first will be the nutrient
            ingredientNutrient.setAmount(keyValuePair.getSecond()); //second will be the amount
            //ingredientNutrientService.saveToDatabase(ingredientNutrient);
            savedIngredient.getIngredientNutrients().add(ingredientNutrient);
        });

     *//*
        for(int i=0; i<nutrientAmounts.size(); i++){
            IngredientNutrient ingredientNutrient = new IngredientNutrient();
            ingredientNutrient.setIngredient(savedIngredient);
            Nutrient nutrient = nutrientService.findById( Integer.parseInt(nutrientAmounts.get(i).getFirst()));
            ingredientNutrient.setNutrient(nutrient); // the first will be the nutrient
            ingredientNutrient.setAmount(Integer.parseInt(nutrientAmounts.get(i).getSecond())); //second will be the amount
            ingredientNutrientService.saveToDatabase(ingredientNutrient);
        }*/
//*/
//            ingredientNutrient.setAmount(value);
//
//        });
//
//        Measurement measurement = new Measurement(request.getParameter("measurement"));
       // System.out.println(ingredient.getNutrients()); //from trying to bind that form to that list
//        Nutrient nutrient = nutrientService.findById(1);
//        savedIngredient.getNutrients().add(nutrient);
//        ingredientService.mapNutrientsToIngredient(savedIngredient, nutrientService.findAll() );
//        ingredientService.saveToDatabase(ingredient);
        //what needs to happen?

        //need to get nutrient ids and ingredient id and match them in the respective database table
        //save ingredient to database then

//        ingredient.setNutrients(nutrientService.findAll());
//        System.out.println(ingredient);
//        Ingredient savedIngredient = ingredientService.saveToDatabase(ingredient);

        //ingredientService.
//        System.out.println(ingredient.getId());
        mav = new ModelAndView("misc/success");
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
    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String deleteNutrient(@PathVariable int id){
        ingredientService.delete(ingredientService.findById(id));
        return "redirect:/ingredient/";
    }
}
