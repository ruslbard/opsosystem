package com.tsystems.jschool20.srvengine.dtos;

/**
 * Created by ruslbard on 12.04.2017.
 */
public class DTOAccount {

    private long id;
    private String login;
    private String pwd;
    private long roleId;
    private long personId;

    public DTOAccount() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPwd() {
        return pwd;
    }

    public long getRoleId() {
        return roleId;
    }

    public long getPersonId() {
        return personId;
    }
}
