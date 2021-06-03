package com.casestudydraft.dao;

import com.casestudydraft.model.Ingredient;
import com.casestudydraft.model.Measurement;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
@Repository
public class IngredientDAOImpl implements IngredientDAO{
    @Override
    public Ingredient findById(int id) {
        Ingredient ingredient=entityManager.find(Ingredient.class, id);
        return ingredient;
    }

    @Override
    public List<Ingredient> findAll() {
        Query q = entityManager.createQuery("SELECT i FROM Ingredient i ");
        return (List<Ingredient>) q.getResultList();
    }

    @Override
    public Ingredient findByName(String name) {
        Query q = entityManager.createQuery("SELECT i FROM Ingredient i WHERE i.name=:name ");
        q.setParameter("name", name);
        return  (Ingredient) q.getSingleResult();
    }
}
