package com.tsystems.jschool20.srvengine.entites;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by ruslbard on 27.03.2017.
 */
@Entity
@Table(name = "RATES")
public class Rate implements Serializable{


    private long id;

    private String name;

    private long price;

    private char isDeleted;

    private Collection<Option> options;

    public Rate(){

    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator="rate_sequence")
    @SequenceGenerator(name="rate_sequence",sequenceName="RATES_ID_SEQ", allocationSize=1)
    public long getId() {

        return id;
    }

    @Column(name = "NAME")
    public String getName() {

        return name;
    }

    @Column(name = "PRICE")
    public long getPrice() {

        return price;
    }

    @Column(name = "ISDELETED")
    @ColumnDefault("N")
    public char getIsDeleted() {

        return isDeleted;
    }

    @ManyToMany
    @JoinTable(
            name = "RATES_OPTIONS_LINK",
            joinColumns = {@JoinColumn(name = "RATE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "OPTION_ID")}
    )
    public Collection<Option> getOptions() {
        return options;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setIsDeleted(char isDeleted) {
        this.isDeleted = isDeleted;
    }

    public void setOptions(Collection<Option> options) {
        this.options = options;
    }
}
