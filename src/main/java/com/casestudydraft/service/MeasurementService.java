package com.casestudydraft.service;

import com.casestudydraft.dao.MeasurementDAO;
import com.casestudydraft.model.Measurement;

import javax.persistence.Query;
import java.util.List;

public class MeasurementService implements MeasurementDAO {

    @Override
    public Measurement findById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Measurement> findAll() {
        Query q = entityManager.createQuery("SELECT m FROM Measurement m ");
        return (List<Measurement>) q.getResultList();
    }
    public Measurement findByName(String name) {
        Query q = entityManager.createQuery("SELECT m FROM Measurement m WHERE m.name=:name ");
        q.setParameter("name", name);
        return  (Measurement) q.getSingleResult();
    }
}
