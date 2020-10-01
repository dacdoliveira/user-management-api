package com.dacdoliveira.user.management.bean;

import java.util.List;

import javax.ejb.Local;
import javax.ws.rs.core.Response;

import com.dacdoliveira.user.management.model.User;
@Local
public interface IUserBean
{
    public void insert(User user);

    public List<User> listAll();

    public User getByName(String name);

    public User getById(Long id);

    public Response update(User user);

    public void deleteById(Long id);

}
