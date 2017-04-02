package com.tsystems.jschool20.srvengine.entites;

import java.util.Collection;
import java.util.List;

/**
 * Created by ruslbard on 02.04.2017.
 */
public class AbstractOption {

    protected long id;
    protected String name;
    protected long price;
    protected long add_coast;
    protected char isActive;

    protected Collection<AbstractOption> includeOptions;
    protected Collection<AbstractOption> excludeOptions;

    public AbstractOption() {

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

    public void setIncludeOptions(List<AbstractOption> includeOptions) {
        this.includeOptions = includeOptions;
    }

    public void setExcludeOptions(List<AbstractOption> excludeOptions) {
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

    public Collection<AbstractOption> getIncludeOptions() {
        return includeOptions;
    }

    public Collection<AbstractOption> getExcludeOptions() {
        return excludeOptions;
    }
}
