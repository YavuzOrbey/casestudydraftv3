package com.casestudydraft.dao;

import com.casestudydraft.model.Measurement;

import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;
@Repository
public class MeasurementDAOImpl implements MeasurementDAO{
    @Override
    public Measurement findById(int id) {
        System.out.println("Coming back from database:");
        System.out.println(entityManager.find(Measurement.class, id));
        return entityManager.find(Measurement.class, id);
    }

    @Override
    public List<Measurement> findAll() {
        Query q = entityManager.createQuery("SELECT m FROM Measurement m ");
        return (List<Measurement>) q.getResultList();
    }

    public Measurement findByName(String name) throws NoResultException {
        Query q = entityManager.createQuery("SELECT m FROM Measurement m WHERE m.name=:name ");
        q.setParameter("name", name);
        return  (Measurement) q.getSingleResult();
    }
}
