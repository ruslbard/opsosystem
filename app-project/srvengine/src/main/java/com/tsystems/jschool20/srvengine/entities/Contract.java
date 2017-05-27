package com.tsystems.jschool20.srvengine.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by ruslbard on 09.04.2017.
 */
@Entity
@Table(name = "CONTRACTS")
public class Contract implements Serializable {

    private long id;
    private Rate rate;
    private Person person;
    private PhoneNumber phoneNumber;
    private Collection<Option> options;
    private String isBlocked;

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
    @JoinColumn(name = "PERSON_ID")
    public Person getPerson() {
        return person;
    }

    @OneToOne
    @JoinColumn(name = "PHONE_NUMBER_ID")
    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    @ManyToMany
    @JoinTable(
            name = "CONTRACTS_OPTIONS_LINK",
            joinColumns = {@JoinColumn(name = "CONTRACT_ID")},
            inverseJoinColumns = {@JoinColumn(name = "OPTION_ID")}
    )
    public Collection<Option> getOptions() {
        return options;
    }


    @Column(name = "ISBLOCKED")
    public String getIsBlocked() {
        return isBlocked;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setOptions(Collection<Option> options) {
        this.options = options;
    }

    public void setIsBlocked(String isBlocked) {
        this.isBlocked = isBlocked;
    }
}
