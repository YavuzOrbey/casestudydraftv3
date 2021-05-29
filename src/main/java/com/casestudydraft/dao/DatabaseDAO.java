package com.casestudydraft.dao;

import javax.persistence.*;

public interface DatabaseDAO {
    EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("food");;
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    static void closeDatabase(){
        entityManager.close();
        entityManagerFactory.close();
    }

    static EntityManager getEntityManager() {
        return entityManager;
    }
}
