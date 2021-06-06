package com.casestudydraft.dao;

import java.util.List;

public interface GenericDAO<E> extends DatabaseDAO{
    E findById(int id);

    default E saveToDatabase(E entity){
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return entity;
    }
    default void updateDatabase(E entity){
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }
    default void deleteFromDatabase(E entity) throws IllegalArgumentException{
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }
    List<E> findAll();
}
