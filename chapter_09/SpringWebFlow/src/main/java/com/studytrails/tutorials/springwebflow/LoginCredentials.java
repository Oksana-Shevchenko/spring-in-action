package com.studytrails.tutorials.springwebflow;

import java.io.Serializable;

public class LoginCredentials implements Serializable {
    private String loginName;
    private String password;

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}

