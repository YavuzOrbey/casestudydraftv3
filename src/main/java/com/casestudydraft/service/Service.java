package com.casestudydraft.service;


import com.casestudydraft.dao.GenericDAO;

public abstract class Service<E, T extends GenericDAO<E>> {
    T Dao;
    public E findById(int id) {
        return Dao.findById(id);
    }
}
