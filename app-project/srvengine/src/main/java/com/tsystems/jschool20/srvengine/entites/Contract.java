package com.tsystems.jschool20.srvengine.entites;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ruslbard on 09.04.2017.
 */
@Entity
@Table(name = "CONTRACTS")
public class Contract  implements Serializable {

    private long id;
    private Rate rate;
    private Abonent abonent;
    private PhoneNumber phoneNumber;

    public Contract() {

    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "contract_sequence")
    @SequenceGenerator(name = "contract_sequence", sequenceName = "CONTRACTS_ID_SEQ", allocationSize = 1)
    public long getId() {
        return id;
    }

    @OneToOne
    @JoinColumn(name = "RATE_ID")
    public Rate getRate() {
        return rate;
    }

    @OneToOne
    @JoinColumn(name = "ABONENT_ID")
    public Abonent getAbonent() {
        return abonent;
    }

    @OneToOne
    @JoinColumn(name = "PHONE_NUMBER_ID")
    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public void setAbonent(Abonent abonent) {
        this.abonent = abonent;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
