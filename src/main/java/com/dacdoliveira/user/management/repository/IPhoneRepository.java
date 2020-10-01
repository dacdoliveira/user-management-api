package com.dacdoliveira.user.management.repository;

import com.dacdoliveira.user.management.model.Phone;

public interface IPhoneRepository
{
    public void insert(Phone phone);

    public Phone getById(Long id);

    public void delete(Phone phone);

}
