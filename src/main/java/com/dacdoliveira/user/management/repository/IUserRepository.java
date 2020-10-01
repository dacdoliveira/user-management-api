package com.dacdoliveira.user.management.repository;

import java.util.List;

import com.dacdoliveira.user.management.model.User;

public interface IUserRepository
{
    public void insert(User user);
    
    public List<User> listAll();
    
    public User getByName(String name);
    
    public User getById(Long id);
    
    public void update(User user);
    
    public void deleteById(User user); 
}
