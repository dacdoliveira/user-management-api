package com.dacdoliveira.user.management.repository.impl;

import java.util.List;

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
    public List<Phone> listByUserId(long userId)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(Phone phone)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Phone phone)
    {
        // TODO Auto-generated method stub

    }

}
