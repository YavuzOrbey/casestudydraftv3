package com.casestudydraft.dao;

import com.casestudydraft.model.Measurement;
import com.casestudydraft.model.Nutrient;
import com.casestudydraft.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;
import java.util.Set;

@Repository
public class NutrientDAOImpl implements NutrientDAO{
    @Override
    public Nutrient findById(int id) {
        return entityManager.find(Nutrient.class, id);
    }

    @Override
    public List<Nutrient> findAll() {
        Query q = entityManager.createQuery("SELECT n FROM Nutrient n");
        return (List<Nutrient>) q.getResultList();
    }
    @Override
    public Nutrient findByName(String name) throws NoResultException {
        Query q = entityManager.createQuery("SELECT n FROM Nutrient n WHERE n.name=:name"); //models needs to have getters I think
        q.setParameter("name", name);
        return (Nutrient) q.getSingleResult();
    }
}
