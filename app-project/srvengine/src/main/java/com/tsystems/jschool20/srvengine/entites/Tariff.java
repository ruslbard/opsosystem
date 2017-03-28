package com.tsystems.jschool20.srvengine.entites;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.persistence.Table;

/**
 * Created by ruslbard on 27.03.2017.
 */
@Entity
@Table(name = "TARIFFS")
public class Tariff {


    private long id;

    private String name;

    private double price;

    private char isDeleted;

    public Tariff(){

    }

    public Tariff(String name, double price){

        this.id = 1L;
        this.name = name;
        this.price = price;
        this.isDeleted = 'N';

    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public long getId() {
        return id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @Column(name = "PRICE")
    public double getPrice() {
        return price;
    }

    @Column(name = "ISDELETED")
    @ColumnDefault("N")
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
