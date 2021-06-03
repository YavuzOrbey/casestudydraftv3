package com.casestudydraft.service;

import com.casestudydraft.dao.IngredientDAO;
import com.casestudydraft.dao.IngredientDAOImpl;
import com.casestudydraft.dao.MeasurementDAOImpl;
import com.casestudydraft.model.Ingredient;
import com.casestudydraft.model.Measurement;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IngredientService extends GenericService<Ingredient, IngredientDAOImpl> {
    public Ingredient findById(int id) {
        return dao.findById(id);
    }


    public List<Ingredient> findAll() {
        return dao.findAll();
    }

    public Ingredient findByName(String name) {
        return dao.findByName(name);
    }
}
