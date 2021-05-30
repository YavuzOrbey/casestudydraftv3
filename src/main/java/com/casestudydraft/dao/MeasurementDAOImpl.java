package com.casestudydraft.dao;

import com.casestudydraft.model.Measurement;
import com.casestudydraft.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
@Repository
public class MeasurementDAOImpl implements MeasurementDAO{
    @Override
    public Measurement findById(int id) {
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
