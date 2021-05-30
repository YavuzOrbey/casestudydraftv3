package com.casestudydraft.service;

import com.casestudydraft.dao.MeasurementDAO;
import com.casestudydraft.dao.MeasurementDAOImpl;
import com.casestudydraft.dao.UserDAOImpl;
import com.casestudydraft.model.Measurement;
import com.casestudydraft.model.User;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.List;
@Service
public class MeasurementService extends GenericService<Measurement, MeasurementDAOImpl> {


    public List<Measurement> findAll() {
        System.out.println(dao);
        return dao.findAll();
    }
    public Measurement findByName(String name) {
        return dao.findByName(name);
    }
}
