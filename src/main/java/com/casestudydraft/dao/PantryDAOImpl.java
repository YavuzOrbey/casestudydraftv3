package com.casestudydraft.dao;

import com.casestudydraft.model.Ingredient;
import com.casestudydraft.model.Nutrient;
import com.casestudydraft.model.Pantry;
import com.casestudydraft.model.User;
import com.casestudydraft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
@Repository
public class PantryDAOImpl implements PantryDAO{
    @Autowired
    UserService userService;
    @Override
    public Pantry findById(int id) {
        return null;
    }

    @Override
    public List<Pantry> findAll() {
        Query q = entityManager.createQuery("SELECT p FROM Pantry p");
        return (List<Pantry>) q.getResultList();
    }

    @Override
    public void addIngredient(Ingredient ingredient) {
            //get current user
            User user = userService.findById(1);
            //get current's users pantry
            Pantry userPantry =user.getPantry();
            //add ingredient to pantry ingredients
            //userPantry.getIngredients().add(ingredient);
            //save pantry to database

    }

    @Override
    public void removeIngredient(Ingredient ingredient) {
        //get current user
        User user = userService.findById(1);
        //get current's users pantry
        Pantry userPantry =user.getPantry();
        //remove ingredient from pantry ingredients
        //userPantry.getIngredients().remove(ingredient);
    }

    @Override
    public void modifyIngredient(Ingredient ingredient) {
        //get current user

        //get current's users pantr

        //modify number of specific ingredient in pantry
    }

    @Override
    public void decreaseQuantity(Ingredient ingredient) {

    }

    @Override
    public void increaseQuantity(Ingredient ingredient) {
        User user = userService.findById(1);
        //get current's users pantry
        Pantry userPantry =user.getPantry();
    }
}
