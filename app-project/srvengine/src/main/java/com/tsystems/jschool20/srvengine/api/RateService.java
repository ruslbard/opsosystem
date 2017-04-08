package com.tsystems.jschool20.srvengine.api;

import com.tsystems.jschool20.srvengine.entites.DTORate;
import com.tsystems.jschool20.srvengine.entites.Rate;

import java.util.Collection;

/**
 * Created by ruslbard on 30.03.2017.
 */
public interface RateService {

    Collection<DTORate> getAllRates();
    DTORate createNewRate(DTORate dto);
}
