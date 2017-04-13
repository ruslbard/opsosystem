package com.tsystems.jschool20.srvengine.dtos;

import com.tsystems.jschool20.srvengine.entities.Option;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by ruslbard on 02.04.2017.
 */
public class DTOOption {



    private long id;
    private String name;
    private long price;
    private long addCoast;
    private char isActive;
    private char defaultForRates;

    private Collection<Long> includeOptionsIds;
    private Collection<Long> excludeOptionsIds;

    public DTOOption(){

    }

    public DTOOption(Option entity){

        this.id = entity.getId();
        this.name = entity.getName();
        this.price = entity.getPrice();
        this.addCoast = entity.getAddCoast();
        this.isActive = entity.getIsActive();
        this.defaultForRates = entity.getDefaultForRates();

        this.includeOptionsIds = new ArrayList<Long>(entity.getIncludeOptions().size());

        for (Option option : entity.getIncludeOptions()) {

            this.includeOptionsIds.add(option.getId());
        }

        this.excludeOptionsIds = new ArrayList<Long>(entity.getExcludeOptions().size());

        for (Option option : entity.getExcludeOptions()) {

            this.excludeOptionsIds.add(option.getId());
        }
    }

    public DTOOption(long id, String name, long price, long addCoast, char isActive, char defaultForRates, Collection<Long> includeOptionsIds, Collection<Long> excludeOptionsIds) {

        this.id = id;
        this.name = name;
        this.price = price;
        this.addCoast = addCoast;
        this.isActive = isActive;
        this.defaultForRates = defaultForRates;
        this.includeOptionsIds = includeOptionsIds;
        this.excludeOptionsIds = excludeOptionsIds;
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

    public void setAddCoast(long addCoast) {
        this.addCoast = addCoast;
    }

    public void setIsActive(char isActive) {
        this.isActive = isActive;
    }

    public void setDefaultForRates(char defaultForRates) {
        this.defaultForRates = defaultForRates;
    }

    public void setIncludeOptionsIds(Collection<Long> includeOptionsIds) {
        this.includeOptionsIds = includeOptionsIds;
    }

    public void setExcludeOptionsIds(Collection<Long> excludeOptionsIds) {
        this.excludeOptionsIds = excludeOptionsIds;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    public long getAddCoast() {
        return addCoast;
    }

    public char getIsActive() {
        return isActive;
    }

    public char getDefaultForRates() {
        return defaultForRates;
    }

    public Collection<Long> getIncludeOptionsIds() {
        return includeOptionsIds;
    }

    public Collection<Long> getExcludeOptionsIds() {
        return excludeOptionsIds;
    }
}
