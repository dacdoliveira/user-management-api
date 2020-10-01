package com.dacdoliveira.user.management.bean.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.dacdoliveira.user.management.bean.IUserBean;
import com.dacdoliveira.user.management.model.User;
import com.dacdoliveira.user.management.repository.IUserRepository;
@Stateless
public class UserBean implements IUserBean
{
    @Inject
    private IUserRepository userRepository;
    
    @Override
    public void insert(User user)
    {
        userRepository.insert(user);
    }

    @Override
    public List<User> listAll()
    {
        return userRepository.listAll();
    }

    @Override
    public User getByName(String name)
    {
        return userRepository.getByName(name);
    }

    @Override
    public User getById(Long id)
    {
        return userRepository.getById(id);
    }

    @Override
    public Response update(User user)
    {
        Map<String, String> statusMap = new HashMap<>();
        User savedUser = userRepository.getById(user.getId());
        if (savedUser!=null)
        {
            userRepository.update(user);
            statusMap.put("Status", "Successful update user");
            return Response.ok().entity(statusMap).build();
        }
        else
        {
            statusMap.put("Status", "Failed update user. User not found");
            return Response.status(Status.BAD_REQUEST).entity(statusMap).build();
        }
    }

    @Override
    public void deleteById(Long id)
    {
        User savedUser = userRepository.getById(id);
        if (savedUser!=null)
        {
            userRepository.deleteById(savedUser);
        }
    }

}
