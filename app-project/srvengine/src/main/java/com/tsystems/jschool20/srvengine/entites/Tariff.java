package com.tsystems.jschool20.srvengine.entites;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by ruslbard on 27.03.2017.
 */
@Entity
@Table(name = "TARIFFS")
public class Tariff extends AbstractTariff implements Serializable{


    public Tariff(){

    }

    public Tariff(String name, long price){

        this.id = getId();
        this.name = name;
        this.price = price;
        this.isDeleted = 'N';

    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator="tariff_sequence")
    @SequenceGenerator(name="tariff_sequence",sequenceName="TARIFFS_ID_SEQ", allocationSize=1)
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
    public char getDeleted() {

        return isDeleted;
    }
}
