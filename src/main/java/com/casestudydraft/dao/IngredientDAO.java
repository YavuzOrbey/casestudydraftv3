package com.casestudydraft.dao;

import com.casestudydraft.model.Ingredient;

public interface IngredientDAO extends GenericDAO<Ingredient> {
    Ingredient findByName(String name);
}
