package com.tsystems.jschool20.srvengine.entites;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by ruslbard on 27.03.2017.
 */
@Entity
@Table(name = "TARIFFS")
public class Tariff implements Serializable{


    private long id;

    private String name;

    private long price;

    private char isDeleted;

    private Collection<Option> options;

    public Tariff(){

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
    public char getIsDeleted() {

        return isDeleted;
    }

    @ManyToMany
    @JoinTable(
            name = "TARIFFS_OPTIONS_LINK",
            joinColumns = {@JoinColumn(name = "TARIFF_ID")},
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
