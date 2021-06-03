package com.casestudydraft.service;


import com.casestudydraft.dao.NutrientDAOImpl;
import com.casestudydraft.model.Nutrient;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;

@Service
public class NutrientService extends GenericService<Nutrient, NutrientDAOImpl>  {
    public List<Nutrient> findAll(){ return dao.findAll();}
    public Nutrient findByName(String name) throws NoResultException {
        Nutrient nutrient;
        nutrient = dao.findByName(name);
        return nutrient;
    }
}
