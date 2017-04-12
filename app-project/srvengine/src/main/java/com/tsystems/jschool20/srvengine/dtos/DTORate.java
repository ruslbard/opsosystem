package com.tsystems.jschool20.srvengine.dtos;

import com.tsystems.jschool20.srvengine.entities.Option;
import com.tsystems.jschool20.srvengine.entities.Rate;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by ruslbard on 29.03.2017.
 */
public class DTORate {

    private long id;

    private String name;

    private double price;

    private Collection<Long> optionsIds;

    public DTORate() {
    }

    public DTORate(Rate entity){

        this.id = entity.getId();
        this.name = entity.getName();
        this.price = entity.getPrice();
        this.optionsIds = new ArrayList<Long>(entity.getOptions().size());

        for (Option option : entity.getOptions()) {
            this.optionsIds.add(option.getId());
        }
    }

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
