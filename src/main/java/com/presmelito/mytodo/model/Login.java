package com.presmelito.mytodo.model;

import com.presmelito.mytodo.dao.LoginDao;

public class Login {
    private String userName;
    private String password;

    private User user;

    public Login(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean validate() {
        return new LoginDao().validate(this);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
