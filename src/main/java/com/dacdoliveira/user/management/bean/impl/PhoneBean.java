package com.dacdoliveira.user.management.bean.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.dacdoliveira.user.management.bean.IPhoneBean;
import com.dacdoliveira.user.management.bean.IUserBean;
import com.dacdoliveira.user.management.dto.PhoneDto;
import com.dacdoliveira.user.management.model.Phone;
import com.dacdoliveira.user.management.model.User;
import com.dacdoliveira.user.management.repository.IPhoneRepository;

@Stateless
public class PhoneBean implements IPhoneBean
{
    @Inject
    private IPhoneRepository phoneRepository;

    @Inject
    private IUserBean userBean;

    @Override
    public Response insert(PhoneDto phoneDto)
    {
        Map<String, String> statusMap = new HashMap<>();
        try
        {
            Phone phone = getPhoneByDto(phoneDto);
            phoneRepository.insert(phone);
            statusMap.put("Status", "Successful save phone");
            return Response.ok().entity(statusMap).build();
        }
        catch (PersistenceException e)
        {
           
            statusMap.put("Status", e.getMessage());
            return Response.status(Status.BAD_REQUEST).entity(statusMap).build();
        }

    }

    private Phone getPhoneByDto(PhoneDto phoneDto)
    {
        Phone phone = new Phone();
        phone.setDdd(phoneDto.getDdd());
        phone.setNumber(phoneDto.getNumber());
        phone.setType(phoneDto.getType());
        User user = userBean.getById(phoneDto.getUserId());
        if (Objects.isNull(user))
        {
            throw new PersistenceException("Failed save phone. User not found");
        }
        phone.setUser(user);
        return phone;
    }

    @Override
    public void deleteById(Long id)
    {
        Phone phone = phoneRepository.getById(id);
        if (!Objects.isNull(phone))
        {
            phoneRepository.delete(phone);
        }
    }

}
