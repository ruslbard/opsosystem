package com.tsystems.jschool20.srvengine.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ruslbard on 12.04.2017.
 */
@Entity
@Table(name = "OPSYSTEM_ROLES")
public class Role implements Serializable {

    private long id;
    private String name;
    private String Desc;

    public Role() {
    }

    @Id
    @GeneratedValue(generator = "roles_sequence")
    @SequenceGenerator(name = "roles_sequence", sequenceName = "OPSYSTEM_ROLES_ID_SEQ", allocationSize = 1)
    public long getId() {
        return id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @Column(name = "DESC_ROLE")
    public String getDesc() {
        return Desc;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }
}
