package com.casestudydraft.service;

import com.casestudydraft.dao.IngredientNutrientDAOImpl;
import com.casestudydraft.model.IngredientNutrient;
import com.casestudydraft.repository.IngredientNutrientRepository;
import com.casestudydraft.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientNutrientService{
    @Autowired
    IngredientNutrientRepository ingredientNutrientRepository;
    public IngredientNutrient findById(int id){
        return ingredientNutrientRepository.getById(id);
    }

    public List<IngredientNutrient> findAll() {
        return ingredientNutrientRepository.findAll();
    }
}

