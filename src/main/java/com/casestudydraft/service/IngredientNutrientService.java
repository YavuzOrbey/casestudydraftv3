package com.casestudydraft.service;

import com.casestudydraft.dao.IngredientNutrientDAOImpl;
import com.casestudydraft.model.IngredientNutrient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientNutrientService extends GenericService<IngredientNutrient, IngredientNutrientDAOImpl>{
    public IngredientNutrient findById(int id){
        return dao.findById(id);
    }

    public List<IngredientNutrient> findAll() {
        return dao.findAll();
    }
}

