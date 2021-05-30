package com.casestudydraft.dao;

import com.casestudydraft.model.Measurement;
import com.casestudydraft.model.Nutrient;
import com.casestudydraft.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
@Repository
public class NutrientDAOImpl implements NutrientDAO{
    @Override
    public Nutrient findById(int id) {
        return null;
    }

    @Override
    public List<Nutrient> findAll() {
        Query q = entityManager.createQuery("SELECT n FROM Nutrient n");
        return (List<Nutrient>) q.getResultList();
    }

    public Nutrient findByName(String name) {
        Query q = entityManager.createQuery("SELECT n FROM Nutrient n WHERE n.name=:name ");
        q.setParameter("name", name);
        return (Nutrient) q.getSingleResult();
    }
}
