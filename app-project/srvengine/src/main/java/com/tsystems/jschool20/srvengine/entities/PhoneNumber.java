package com.tsystems.jschool20.srvengine.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ruslbard on 09.04.2017.
 */
@Entity
@Table(name = "PHONE_NUMBERS")
public class PhoneNumber implements Serializable {

    private long id;
    private String phone;
    private char isIssued;
    private Contract contract;

    public PhoneNumber() {
    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "phone_number_sequence")
    @SequenceGenerator(name = "phone_number_sequence", sequenceName = "PHONE_NUMBERS_ID_SEQ", allocationSize = 1)
    public long getId() {
        return id;
    }

    @Column(name = "PHONE_NUMBER")
    public String getPhone() {
        return phone;
    }

    @Column(name = "ISSUED")
    public char getIsIssued() {
        return isIssued;
    }

    @OneToOne
    @JoinColumn(name = "CONTRACT_ID")
    public Contract getContract() {
        return contract;
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

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
