package com.example.springbootjdbc.pojo;

import java.util.Date;

public class User {

    /** 用户id */
    private Integer id;

    /** 用户名 */
    private String username;

    /** 用户密码 */
    private String password;

    /** 用户生日 */
    private Date birthday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
