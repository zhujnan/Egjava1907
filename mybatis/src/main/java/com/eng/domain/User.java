package com.eng.domain;

/**
 * Created by zhujn on 2019/9/26.
 */
public class User {
    private Integer id;
    private String loginname;
    private String password;
    public User(){}
    public User(Integer id, String loginname, String password) {
        this.id = id;
        this.loginname = loginname;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", loginname='" + loginname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
