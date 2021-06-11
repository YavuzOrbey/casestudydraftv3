package com.casestudydraft.service;

import com.casestudydraft.dao.IngredientDAO;
import com.casestudydraft.dao.IngredientDAOImpl;
import com.casestudydraft.dao.MeasurementDAOImpl;
import com.casestudydraft.model.Ingredient;
import com.casestudydraft.model.Measurement;
import com.casestudydraft.model.Nutrient;
import com.casestudydraft.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;
@Service
public class IngredientService {
    @Autowired
    IngredientRepository ingredientRepository;
    public Ingredient get(long id){
        return ingredientRepository.getById(id);
    }
    public Ingredient save(Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }
    public List<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }
    public Ingredient findByName(String name) {
        return ingredientRepository.findByName(name);
    }
    public void delete(Ingredient ingredient){
        ingredientRepository.delete(ingredient);
    }
}
