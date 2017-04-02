package com.tsystems.jschool20.srvengine.entites;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by ruslbard on 02.04.2017.
 */
@Entity
@Table(name = "OPTIONS")
public class Option implements Serializable{


    protected long id;
    protected String name;
    protected long price;
    protected long add_coast;
    protected char isActive;

    protected Collection<Option> includeOptions;
    protected Collection<Option> excludeOptions;

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

    @Column(name = "ISACTIVE")
    public char getIsActive() {
        return isActive;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
                name = "INCLUDE_OPTIONS",
                joinColumns = {@JoinColumn(name = "ID", referencedColumnName = "ID")},
                inverseJoinColumns = {@JoinColumn(name = "CHILD_ID", referencedColumnName = "ID")}
    )
    public Collection<Option> getIncludeOptions() {
        return includeOptions;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "EXCLUDE_OPTIONS",
            joinColumns = {@JoinColumn(name = "ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "CHILD_ID", referencedColumnName = "ID")}
    )
    public Collection<Option> getExcludeOptions() {
        return excludeOptions;
    }
}
