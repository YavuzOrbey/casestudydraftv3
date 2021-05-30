package com.casestudydraft.service;


import com.casestudydraft.dao.NutrientDAOImpl;
import com.casestudydraft.model.Nutrient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NutrientService extends GenericService<Nutrient, NutrientDAOImpl>  {
    public List<Nutrient> findAll(){ return dao.findAll();}
    public Nutrient findByName(String name){
        return dao.findByName(name);
    }
}
