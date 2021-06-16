package com.casestudydraft.repository;

import com.casestudydraft.model.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
    Measurement findByName(String name);
    Measurement findByNameIgnoreCaseContaining(String name);
}
