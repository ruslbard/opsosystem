package com.tsystems.jschool20.srvengine.dtos;

import org.springframework.stereotype.Component;

/**
 * Created by ruslbard on 29.03.2017.
 */
@Component
public class TariffDTO {

    private String textname;
    private Double price;

    public String getTextname() {
        return textname;
    }

    public void setTextname(String textname) {
        this.textname = textname;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
