package com.casestudydraft.service;

import com.casestudydraft.dao.PantryDAOImpl;
import com.casestudydraft.model.Ingredient;
import com.casestudydraft.model.Pantry;
import org.springframework.stereotype.Service;

@Service
public class PantryService extends GenericService<Pantry, PantryDAOImpl> {
    public void addIngredient(Ingredient ingredient){
        dao.addIngredient(ingredient);
    }

    public void removeIngredient(Ingredient ingredient){

        dao.removeIngredient(ingredient);
    }
    public void decreaseQuantity(Ingredient ingredient){
        dao.decreaseQuantity(ingredient);
    }
    public void increaseQuantity(Ingredient ingredient){
        dao.increaseQuantity(ingredient);
    }

}
