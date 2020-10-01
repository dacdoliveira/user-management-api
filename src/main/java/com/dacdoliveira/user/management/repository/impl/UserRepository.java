package com.dacdoliveira.user.management.repository.impl;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.dacdoliveira.user.management.model.User;
import com.dacdoliveira.user.management.repository.IUserRepository;
import com.dacdoliveira.user.management.repository.JpaRepository;

@Model
public class UserRepository implements IUserRepository
{
    @Inject
    private JpaRepository jpaRepository;
   
    @Override
    public void insert(User user)
    {
        EntityManager manager = jpaRepository.getManager();
        manager.getTransaction().begin();
        manager.persist(user);
        manager.getTransaction().commit();

    }

    @Override
    public List<User> listAll()
    {
        EntityManager manager = jpaRepository.getManager();
        manager.getTransaction().begin();
        List<User> users = manager.createQuery("FROM User").getResultList();
        manager.getTransaction().commit();
        return users;
    }

    @Override
    public User getByName(String name)
    {
        EntityManager manager = jpaRepository.getManager();
        manager.getTransaction().begin();
        String queryFormat = "FROM User u WHERE u.name= '%s' ";
        Query query = manager.createQuery(String.format(queryFormat, name));
        List<User> users = query.getResultList();
        User user = (users != null && !users.isEmpty()) ? users.get(0) : null;
        manager.getTransaction().commit();
        return user;
    }

    @Override
    public User getById(Long id)
    {
        EntityManager manager = jpaRepository.getManager();
        manager.getTransaction().begin();
        User user = manager.find(User.class, id);
        manager.getTransaction().commit();
        return user;
    }

    @Override
    public void update(User user)
    {
        EntityManager manager = jpaRepository.getManager();
        manager.getTransaction().begin();
        manager.merge(user);
        manager.getTransaction().commit();
    }

    @Override
    public void deleteById(User user)
    {
        EntityManager manager = jpaRepository.getManager();
        manager.getTransaction().begin();
        manager.remove(user);
        manager.getTransaction().commit();

    }

}
