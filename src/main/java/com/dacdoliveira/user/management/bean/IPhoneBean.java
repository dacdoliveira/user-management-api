package com.dacdoliveira.user.management.bean;

import javax.ejb.Local;
import javax.ws.rs.core.Response;

import com.dacdoliveira.user.management.dto.PhoneDto;
@Local
public interface IPhoneBean
{
    public Response insert(PhoneDto phone);
}
