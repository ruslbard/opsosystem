package com.tsystems.jschool20.srvengine.entites;

/**
 * Created by ruslbard on 01.04.2017.
 */
public class AbstractTariff {

    private long id;

    private String name;

    private double price;

    private char isDeleted;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public char getDeleted() {
        return isDeleted;
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

    public void setDeleted(char deleted) {
        this.isDeleted = deleted;
    }
}
