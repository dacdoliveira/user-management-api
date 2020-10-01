package com.dacdoliveira.user.management.service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dacdoliveira.user.management.bean.IPhoneBean;
import com.dacdoliveira.user.management.bean.IUserBean;
import com.dacdoliveira.user.management.dto.PhoneDto;
import com.dacdoliveira.user.management.model.User;

@Path(value = "/user-management")
@ApplicationPath("/resources")
public class UserService extends Application
{
    // http://localhost:8080/test-api/resources/user-management/list-users
    @Inject
    private IUserBean userBean;

    @Inject
    private IPhoneBean phoneBean;

    @GET
    @Path("/list-users")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listUsers()
    {
        List<User> users = userBean.listAll();
        return Response.ok().entity(users).build();
    }

    @GET
    @Path("/get-by-name")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByName(@QueryParam("name") String name)
    {
        User user = userBean.getByName(name);
        return Response.ok().entity(user).build();
    }

    @GET
    @Path("/get-by-id")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@QueryParam("id") long id)
    {
        User user = userBean.getById(id);
        return Response.ok().entity(user).build();
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveUser(User user)
    {
        userBean.insert(user);
        return Response.ok().build();
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(User user)
    {
       return userBean.update(user);
    }

    @DELETE
    @Path("/delete-by-id")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(@QueryParam("id") long id)
    {
        userBean.deleteById(id);
        return Response.ok().build();
    }

    @POST
    @Path("/phone-save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response savePhone(PhoneDto phone)
    {
        return phoneBean.insert(phone);
    }
}
