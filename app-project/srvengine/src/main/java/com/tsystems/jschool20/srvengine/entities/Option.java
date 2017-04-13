package com.tsystems.jschool20.srvengine.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by ruslbard on 02.04.2017.
 */
@Entity
@Table(name = "OPTIONS")
public class Option implements Serializable{


    private long id;
    private String name;
    private long price;
    private long add_coast;
    private char isActive;
    private char defaultForRates;

    private Collection<Option> includeOptions;
    private Collection<Option> excludeOptions;

    private Collection<Rate> rates;

    public Option() {

    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "options_seq")
    @SequenceGenerator(name = "options_seq", sequenceName = "OPTIONS_ID_SEQ", allocationSize = 1)
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

    @Column(name = "ADD_COAST")
    public long getAdd_coast() {
        return add_coast;
    }

    @Column(name = "ACTIVE")
    public char getIsActive() {
        return isActive;
    }

    @Column(name = "DEFAULT_FOR_RATES")
    public char getDefaultForRates() {
        return defaultForRates;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
                name = "INCLUDE_OPTIONS",
                joinColumns = {@JoinColumn(name = "ID", referencedColumnName = "ID")},
                inverseJoinColumns = {@JoinColumn(name = "CHILD_OPTION_ID", referencedColumnName = "ID")}
    )
    public Collection<Option> getIncludeOptions() {
        return includeOptions;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "EXCLUDE_OPTIONS",
            joinColumns = {@JoinColumn(name = "ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "CHILD_OPTION_ID", referencedColumnName = "ID")}
    )
    public Collection<Option> getExcludeOptions() {
        return excludeOptions;
    }

    @ManyToMany
    @JoinTable(
            name = "RATES_OPTIONS_LINK",
            joinColumns = {@JoinColumn(name = "OPTION_ID")},
            inverseJoinColumns = {@JoinColumn(name = "RATE_ID")}
    )
    public Collection<Rate> getRates() {
        return rates;
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

    public void setAdd_coast(long add_coast) {
        this.add_coast = add_coast;
    }

    public void setIsActive(char isActive) {
        this.isActive = isActive;
    }

    public void setDefaultForRates(char defaultForRates) {
        this.defaultForRates = defaultForRates;
    }

    public void setIncludeOptions(Collection<Option> includeOptions) {
        this.includeOptions = includeOptions;
    }

    public void setExcludeOptions(Collection<Option> excludeOptions) {
        this.excludeOptions = excludeOptions;
    }

    public void setRates(Collection<Rate> rates) {
        this.rates = rates;
    }
}
