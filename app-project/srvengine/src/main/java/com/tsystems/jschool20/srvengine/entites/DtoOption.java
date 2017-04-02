package com.tsystems.jschool20.srvengine.entites;

import java.util.Collection;

/**
 * Created by ruslbard on 02.04.2017.
 */
public class DtoOption {



    protected long id;
    protected String name;
    protected long price;
    protected long add_coast;
    protected char isActive;

    protected Collection<Long> includeOptionsIds;
    protected Collection<Long> excludeOptionsIds;

    public DtoOption(){

    }

    public DtoOption(long id, String name, long price, long add_coast, char isActive, Collection<Long> includeOptionsIds, Collection<Long> excludeOptionsIds) {

        this.id = id;
        this.name = name;
        this.price = price;
        this.add_coast = add_coast;
        this.isActive = isActive;
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

    public void setAdd_coast(long add_coast) {
        this.add_coast = add_coast;
    }

    public void setIsActive(char isActive) {
        this.isActive = isActive;
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

    public long getAdd_coast() {
        return add_coast;
    }

    public char getIsActive() {
        return isActive;
    }

    public Collection<Long> getIncludeOptionsIds() {
        return includeOptionsIds;
    }

    public Collection<Long> getExcludeOptionsIds() {
        return excludeOptionsIds;
    }
}
