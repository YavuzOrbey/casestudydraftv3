package com.casestudydraft.dao;

import com.casestudydraft.model.Nutrient;

public interface NutrientDAO extends GenericDAO<Nutrient> {
     Nutrient findByName(String name);
}
