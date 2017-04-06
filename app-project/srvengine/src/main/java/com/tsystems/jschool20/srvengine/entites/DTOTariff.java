package com.tsystems.jschool20.srvengine.entites;

import java.util.Collection;

/**
 * Created by ruslbard on 29.03.2017.
 */
public class DTOTariff {

    private long id;

    private String name;

    private long price;

//    private char isDeleted;

    private Collection<Long> optionsIds;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

//    public char getIsDeleted() {
//        return isDeleted;
//    }

    public Collection<Long> getOptionsIds() {
        return optionsIds;
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

//    public void setIsDeleted(char isDeleted) {
//        this.isDeleted = isDeleted;
//    }

    public void setOptionsIds(Collection<Long> optionsIds) {
        this.optionsIds = optionsIds;
    }
}
