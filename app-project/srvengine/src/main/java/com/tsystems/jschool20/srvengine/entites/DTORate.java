package com.tsystems.jschool20.srvengine.entites;

import java.util.Collection;

/**
 * Created by ruslbard on 29.03.2017.
 */
public class DTORate {

    private long id;

    private String name;

    private double price;

    private Collection<Long> optionsIds;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Collection<Long> getOptionsIds() {
        return optionsIds;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setOptionsIds(Collection<Long> optionsIds) {
        this.optionsIds = optionsIds;
    }
}
