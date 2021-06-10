package com.casestudydraft.dao;

import com.casestudydraft.model.Ingredient;
import com.casestudydraft.model.Recipe;

import java.util.List;

public interface RecipeDAO extends GenericDAO<Recipe>{
    Recipe findByName(String name);
    List<Recipe> findByIngredients(List<Ingredient> ingredientList);
}
