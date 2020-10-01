package com.dacdoliveira.user.management.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.dacdoliveira.user.management.service.UserJsonViews;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "usercontrol")
public class User
{
    @Id
    @GeneratedValue
    @JsonView(UserJsonViews.Normal.class)
    private Long id;

    @NotNull
    @Size(min = 1, max = 120)
    @JsonView(UserJsonViews.Normal.class)
    private String name;
    @NotNull
    @JsonView(UserJsonViews.Normal.class)
    private String email;
    @NotNull
    @JsonView(UserJsonViews.Normal.class)
    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "usercontrol_id", nullable = true)
    @JsonView(UserJsonViews.FromUser.class)
    @JsonManagedReference
    private List<Phone> phones;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public List<Phone> getPhones()
    {
        return phones;
    }

    public void setPhones(List<Phone> phones)
    {
        this.phones = phones;
    }

}
