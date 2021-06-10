package com.casestudydraft.repository;

import com.casestudydraft.model.Measurement;
import org.springframework.data.repository.CrudRepository;

public interface MeasurementRepository extends CrudRepository<Measurement, Long> {
}
