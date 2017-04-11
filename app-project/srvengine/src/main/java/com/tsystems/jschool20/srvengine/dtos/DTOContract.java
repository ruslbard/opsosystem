package com.tsystems.jschool20.srvengine.dtos;

import java.util.Date;

/**
 * Created by ruslbard on 09.04.2017.
 */
public class DTOContract {

    private long id;
    private DTOPerson person;
    private DTORate rate;
    private DTOPhoneNumber phoneNumber;

    public DTOContract() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPerson(DTOPerson person) {
        this.person = person;
    }

    public void setRate(DTORate rate) {
        this.rate = rate;
    }

    public void setPhoneNumber(DTOPhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public DTOPerson getPerson() {
        return person;
    }

    public DTORate getRate() {
        return rate;
    }

    public DTOPhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
