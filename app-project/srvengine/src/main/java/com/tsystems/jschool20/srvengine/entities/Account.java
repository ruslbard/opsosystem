package com.tsystems.jschool20.srvengine.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ruslbard on 12.04.2017.
 */
@Entity
@Table(name = "ACCOUNTS")
public class Account implements Serializable {

    private long id;
    private String login;
    private String pwd;
    private Role role;
    private Person person;

    public Account() {
    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "account_sequence")
    @SequenceGenerator(name = "account_sequence", sequenceName = "ACCOUNTS_ID_SEQ", allocationSize = 1)
    public long getId() {
        return id;
    }

    @Column(name = "LOGIN")
    public String getLogin() {
        return login;
    }

    @Column(name = "PWD")
    public String getPwd() {
        return pwd;
    }

    @ManyToOne
    @JoinColumn(name = "ROLE_ID",
            foreignKey = @ForeignKey(name = "ACCOUNTS_ROLES_FK"))
    public Role getRole() {
        return role;
    }

    @OneToOne
    @JoinColumn(name = "PERSON_ID",
            foreignKey = @ForeignKey(name = "ACCOUNTS_PERSONS_FK"))
    public Person getPerson() {
        return person;
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

    public void setRole(Role role) {
        this.role = role;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
