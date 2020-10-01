package com.dacdoliveira.user.management.repository;

import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Model
public class JpaRepository
{

    private EntityManagerFactory factory;

    private EntityManager manager;

    public JpaRepository()
    {
        this.factory = Persistence.createEntityManagerFactory("user");
        this.manager = factory.createEntityManager();
    }

    public EntityManager getManager()
    {
        return manager;
    }

}
