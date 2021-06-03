package com.casestudydraft.service;

import com.casestudydraft.dao.MeasurementDAO;
import com.casestudydraft.dao.MeasurementDAOImpl;
import com.casestudydraft.dao.UserDAOImpl;
import com.casestudydraft.model.Measurement;
import com.casestudydraft.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;
@Service
public class MeasurementService extends GenericService<Measurement, MeasurementDAOImpl> {

    public List<Measurement> findAll() {
        return dao.findAll();
    }
    public Measurement findByName(String name) throws NoResultException {
        return dao.findByName(name);
    }
    public void delete(Measurement measurement){
        dao.deleteFromDatabase(measurement);
    }

    public void update(Measurement measurement){
        dao.updateDatabase(measurement);
    }

}
