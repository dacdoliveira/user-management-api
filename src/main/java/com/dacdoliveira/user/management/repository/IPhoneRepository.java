package com.dacdoliveira.user.management.repository;

import java.util.List;

import com.dacdoliveira.user.management.model.Phone;

public interface IPhoneRepository
{
    public void insert(Phone phone);
    
    public List<Phone> listByUserId(long userId);
    
    public void update(Phone phone);
    
    public void delete(Phone phone);
}
