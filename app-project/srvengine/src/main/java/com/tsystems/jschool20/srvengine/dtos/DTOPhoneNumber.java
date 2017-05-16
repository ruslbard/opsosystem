package com.tsystems.jschool20.srvengine.dtos;

import com.tsystems.jschool20.srvengine.entities.PhoneNumber;

/**
 * Created by ruslbard on 11.04.2017.
 */
public class DTOPhoneNumber {

    private long id;
    private String phone;
    private char isIssued;
    private long contractId;

    public DTOPhoneNumber() {
    }

    public DTOPhoneNumber(PhoneNumber entity) {

        this.id = entity.getId();
        this.phone = entity.getPhone();
        this.isIssued = entity.getIsIssued();
        if (entity.getContract() != null) {
            this.contractId = entity.getContract().getId();
        }
    }

    public long getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public char getIsIssued() {
        return isIssued;
    }

    public long getContractId() {
        return contractId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setIsIssued(char isIssued) {
        this.isIssued = isIssued;
    }

    public void setContractId(long contractId) {
        this.contractId = contractId;
    }
}
