package com.xaaolaf.doman;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by xupingwei on 2017/5/3.
 */
@Entity
@Table(name = "t_user")
public class UserInfo {

    @Id
    private int id;
    private String name;
    private String password;
    private String salt;
    private String role;


}
