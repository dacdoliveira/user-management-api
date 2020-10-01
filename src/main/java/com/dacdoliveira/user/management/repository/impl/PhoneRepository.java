package com.dacdoliveira.user.management.repository.impl;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.dacdoliveira.user.management.model.Phone;
import com.dacdoliveira.user.management.repository.IPhoneRepository;
import com.dacdoliveira.user.management.repository.JpaRepository;
@Model
public class PhoneRepository implements IPhoneRepository
{
    @Inject
    private JpaRepository jpaRepository;

    @Override
    public void insert(Phone phone)
    {
        EntityManager manager = jpaRepository.getManager();
        manager.getTransaction().begin();
        manager.persist(phone);
        manager.getTransaction().commit();

    }

    @Override
    public void delete(Phone phone)
    {
        EntityManager manager = jpaRepository.getManager();
        manager.getTransaction().begin();
        manager.remove(phone);
        manager.getTransaction().commit();

    }

    @Override
    public Phone getById(Long id)
    {
        EntityManager manager = jpaRepository.getManager();
        manager.getTransaction().begin();
        Phone phone = manager.find(Phone.class, id);
        manager.getTransaction().commit();
        return phone;
    }

}
