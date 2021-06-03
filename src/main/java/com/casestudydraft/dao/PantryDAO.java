package com.casestudydraft.dao;

import com.casestudydraft.model.Ingredient;
import com.casestudydraft.model.Pantry;

public interface PantryDAO extends GenericDAO<Pantry> {
    void addIngredient(Ingredient ingredient);
    void removeIngredient(Ingredient ingredient);
    void modifyIngredient(Ingredient ingredient);
    void decreaseQuantity(Ingredient ingredient);
    void increaseQuantity(Ingredient ingredient);
}
