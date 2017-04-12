package com.tsystems.jschool20.srvengine.dtos;

import java.util.Collection;

/**
 * Created by ruslbard on 09.04.2017.
 */
public class DTOContract {

    private long id;
    private long personId;
    private long rateId;
    private long phoneNumberId;
    private Collection<Long> optionsIds;

    public DTOContract() {
    }

    public long getId() {
        return id;
    }

    public long getPersonId() {
        return personId;
    }

    public long getRateId() {
        return rateId;
    }

    public long getPhoneNumberId() {
        return phoneNumberId;
    }

    public Collection<Long> getOptionsIds() {
        return optionsIds;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public void setRateId(long rateId) {
        this.rateId = rateId;
    }

    public void setPhoneNumberId(long phoneNumberId) {
        this.phoneNumberId = phoneNumberId;
    }

    public void setOptionsIds(Collection<Long> optionsIds) {
        this.optionsIds = optionsIds;
    }
}
