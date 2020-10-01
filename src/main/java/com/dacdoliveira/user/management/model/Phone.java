package com.dacdoliveira.user.management.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.dacdoliveira.user.management.service.UserJsonViews;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "phone")
public class Phone
{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usercontrol_id")
    @JsonView(UserJsonViews.FromPhone.class)
    @JsonBackReference
    
    private User user;
   
    @Id
    @GeneratedValue
    @JsonView(UserJsonViews.Normal.class)
    private Long id;

    @NotNull
    @JsonView(UserJsonViews.Normal.class)
    private Integer ddd;
    @NotNull
    @JsonView(UserJsonViews.Normal.class)
    private String number;

    @NotNull
    @JsonView(UserJsonViews.Normal.class)
    private String type;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Integer getDdd()
    {
        return ddd;
    }

    public void setDdd(Integer ddd)
    {
        this.ddd = ddd;
    }

    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

}
