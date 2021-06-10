package com.casestudydraft.dao;

import com.casestudydraft.model.Ingredient;
import com.casestudydraft.model.Recipe;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class RecipeDAOImpl implements RecipeDAO{
    @Override
    public Recipe findById(int id) {
        return null;
    }

    @Override
    public List<Recipe> findAll() {
        return null;
    }

    @Override
    public Recipe findByName(String name) {
        return null;
    }

    @Override
    public List<Recipe> findByIngredients(List<Ingredient> ingredientList) {
        //given a list of ingredients filter recipes to only those that contain those ingredients
        return null;
    }
}
