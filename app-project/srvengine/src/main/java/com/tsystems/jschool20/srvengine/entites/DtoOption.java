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

    protected Collection<DtoOption> includeOptions;
    protected Collection<DtoOption> excludeOptions;

    public DtoOption(){

    }

    public DtoOption(long id, String name, long price, long add_coast, char isActive, Collection<DtoOption> includeOptions, Collection<DtoOption> excludeOptions) {

        this.id = id;
        this.name = name;
        this.price = price;
        this.add_coast = add_coast;
        this.isActive = isActive;
        this.includeOptions = includeOptions;
        this.excludeOptions = excludeOptions;
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

    public void setIncludeOptions(Collection<DtoOption> includeOptions) {
        this.includeOptions = includeOptions;
    }

    public void setExcludeOptions(Collection<DtoOption> excludeOptions) {
        this.excludeOptions = excludeOptions;
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

    public Collection<DtoOption> getIncludeOptions() {
        return includeOptions;
    }

    public Collection<DtoOption> getExcludeOptions() {
        return excludeOptions;
    }
}
