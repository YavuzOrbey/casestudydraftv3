package com.casestudydraft.service;


import com.casestudydraft.dao.NutrientDAOImpl;
import com.casestudydraft.model.Measurement;
import com.casestudydraft.model.Nutrient;
import com.casestudydraft.repository.MeasurementRepository;
import com.casestudydraft.repository.NutrientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;

@Service
public class NutrientService  {
    @Autowired
    NutrientRepository nutrientRepository;

    public void save(Nutrient nutrient){
        nutrientRepository.save(nutrient);
    }
    public List<Nutrient> findAll() {
        return nutrientRepository.findAll();
    }

    public Nutrient get(Long id){
        return nutrientRepository.findById(id).get();
    }
    public Nutrient findByName(String name){
        return nutrientRepository.findByName(name);
    }
    public void delete(Nutrient nutrient){
        nutrientRepository.delete(nutrient);
    }


}
