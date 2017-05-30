package com.tsystems.jschool20.srvengine.dtos.security;

/**
 * Created by ruslbard on 30.05.2017.
 */

public class DTONewAccount {
    private String login;
    private String password;
    private String retypePassword;

    public DTONewAccount() {
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getRetypePassword() {
        return retypePassword;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRetypePassword(String retypePassword) {
        this.retypePassword = retypePassword;
    }
}
