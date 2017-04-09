package com.tsystems.jschool20.srvengine.entites;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by ruslbard on 09.04.2017.
 */
@Entity
@Table(name = "ABONENTS")
public class Abonent implements Serializable {

    private long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String passSerias;
    private String passNumber;
    private String passIssuedBy;
    private Date passIssuedDate;
    private String email;

    public Abonent(){

    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "abonent_sequence")
    @SequenceGenerator(name = "abonent_sequence", sequenceName = "ABONENTS_ID_SEQ", allocationSize = 1)
    public long getId() {
        return id;
    }

    @Column(name = "FIRSTNAME")
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "LASTNAME")
    public String getLastName() {
        return lastName;
    }

    @Column(name = "BIRTHDATE")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    @Column(name = "PASS_SERIAS")
    public String getPassSerias() {
        return passSerias;
    }

    @Column(name = "PASS_NUMBER")
    public String getPassNumber() {
        return passNumber;
    }

    @Column(name = "PASS_ISSUEDBY")
    public String getPassIssuedBy() {
        return passIssuedBy;
    }

    @Column(name = "PASS_ISSUEDDATE")
    public Date getPassIssuedDate() {
        return passIssuedDate;
    }

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
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
}
