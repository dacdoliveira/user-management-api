package com.dacdoliveira.user.management.dto;

public class PhoneDto
{
    private Long id;
    
    private Integer ddd;
    
    private String number;
    
    private String type;
    
    private Long userId;

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

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }
}
