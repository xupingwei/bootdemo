package com.xaaolaf.doman.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by xupingwei on 2017/5/7.
 */
@Entity(name = "t_address")
public class Address {
    @Id
    @GeneratedValue
    private long id;
    private String city = "";
    private String street = "";

    public Address() {
    }

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
