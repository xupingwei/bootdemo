package com.xaaolaf.doman.bean;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by xupingwei on 2017/5/7.
 */
@Entity
@Table(name = "t_user")
public class UserInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "phone", nullable = true)
    private String phone = "";
    @Column(name = "password")
    private String password = "";
    @Column(name = "token")
    private String token = "";

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public UserInfo(String phone, String passwod, String token, Address address) {
        this.phone = phone;
        this.password = passwod;
        this.token = token;
        this.address = address;
    }

    public UserInfo(String phone, String passwod) {
        this.phone = phone;
        this.password = passwod;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserInfo() {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
