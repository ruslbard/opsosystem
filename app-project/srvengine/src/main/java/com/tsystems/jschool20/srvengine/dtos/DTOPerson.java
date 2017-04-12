package com.tsystems.jschool20.srvengine.dtos;

import com.tsystems.jschool20.srvengine.entities.Person;

import java.util.Date;

/**
 * Created by ruslbard on 11.04.2017.
 */
public class DTOPerson {

    private long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String passSerias;
    private String passNumber;
    private String passIssuedBy;
    private Date passIssuedDate;
    private String email;

    public DTOPerson(){

    }

    public DTOPerson(Person entity){

        this.id = entity.getId();
        this.firstName = entity.getFirstName();
        this.lastName = entity.getLastName();
        this.dateOfBirth = entity.getDateOfBirth();
        this.passSerias = entity.getPassSerias();
        this.passNumber = entity.getPassNumber();
        this.passIssuedBy = entity.getPassIssuedBy();
        this.passIssuedDate = entity.getPassIssuedDate();
        this.email = entity.getEmail();
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPassSerias(String passSerias) {
        this.passSerias = passSerias;
    }

    public void setPassNumber(String passNumber) {
        this.passNumber = passNumber;
    }

    public void setPassIssuedBy(String passIssuedBy) {
        this.passIssuedBy = passIssuedBy;
    }

    public void setPassIssuedDate(Date passIssuedDate) {
        this.passIssuedDate = passIssuedDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPassSerias() {
        return passSerias;
    }

    public String getPassNumber() {
        return passNumber;
    }

    public String getPassIssuedBy() {
        return passIssuedBy;
    }

    public Date getPassIssuedDate() {
        return passIssuedDate;
    }

    public String getEmail() {
        return email;
    }
}
