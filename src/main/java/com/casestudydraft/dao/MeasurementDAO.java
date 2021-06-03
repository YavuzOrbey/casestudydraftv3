package com.casestudydraft.dao;

import com.casestudydraft.model.Measurement;

public interface MeasurementDAO extends GenericDAO<Measurement>{
        Measurement findByName(String name);

}
