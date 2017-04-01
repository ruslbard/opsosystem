package com.tsystems.jschool20.srvengine.entites;

/**
 * Created by ruslbard on 29.03.2017.
 */
public class DtoTariff extends AbstractTariff{

    public DtoTariff(long id, String name, long price, char isdeleted){
        this.setId(id);
        this.setName(name);
        this.setPrice(price);
        this.setDeleted(isdeleted);
    }

}
