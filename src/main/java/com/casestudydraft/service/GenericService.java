package com.casestudydraft.service;


import com.casestudydraft.dao.GenericDAO;
import com.casestudydraft.model.BaseModel;
import com.casestudydraft.model.Measurement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class GenericService<E extends BaseModel,  T extends GenericDAO<E>> {
    //type parameters have to be a child of basemodel (one of the entities) and a child (or in this case something that implements) genericDAO
    // example GenericService<User, UserDAOImpl> User is self explanatory, UserDAOImpl implements UserDAO which is a child of GenericDAO<User>

    @Autowired T dao;
    public E findById(int id) {
        return dao.findById(id);
    }

    public E saveToDatabase(E entity){
        return dao.saveToDatabase(entity);
    }

    public void delete(E entity){
        dao.deleteFromDatabase(entity);
    }

    public void update(E entity){
        dao.updateDatabase(entity);
    }
}
