package com.hispanicpvp.hispanicmanagerbot.jpautil;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static EntityManagerFactory entityManagerFactory;
    private static final String PERSISTENCE_UNIT = "managerbot";

    public static EntityManagerFactory getEntityManagerFactory() {
        if(entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }

        return entityManagerFactory;
    }
}