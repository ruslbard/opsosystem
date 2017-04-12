package com.tsystems.jschool20.srvengine.dtos;

import java.util.Collection;

/**
 * Created by ruslbard on 12.04.2017.
 */
public class DTOContractDetail {

    private long id;
    private DTOPerson person;
    private DTORate rate;
    private Collection<DTOOption> contractOptions;
    private DTOPhoneNumber phoneNumber;

    public void setId(long id) {
        this.id = id;
    }

    public void setPerson(DTOPerson person) {
        this.person = person;
    }

    public void setRate(DTORate rate) {
        this.rate = rate;
    }

    public void setContractOptions(Collection<DTOOption> contractOptions) {
        this.contractOptions = contractOptions;
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

    public Collection<DTOOption> getContractOptions() {
        return contractOptions;
    }

    public DTOPhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
