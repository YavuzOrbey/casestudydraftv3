package com.casestudydraft.service;

import com.casestudydraft.dao.IngredientDAO;
import com.casestudydraft.model.Ingredient;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IngredientService implements IngredientDAO {
    @Override
    public Ingredient findById(int id) {
        return null;
    }

    @Override
    public List<Ingredient> findAll() {
        return null;
    }
}
