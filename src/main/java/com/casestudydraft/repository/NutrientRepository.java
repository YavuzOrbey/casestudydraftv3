package com.casestudydraft.repository;

import com.casestudydraft.model.Nutrient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NutrientRepository extends JpaRepository<Nutrient, Long> {
    Nutrient findByName(String name);
}
