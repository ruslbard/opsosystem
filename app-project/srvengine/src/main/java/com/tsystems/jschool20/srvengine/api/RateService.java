package com.tsystems.jschool20.srvengine.api;

import com.tsystems.jschool20.srvengine.dtos.DTOOption;
import com.tsystems.jschool20.srvengine.dtos.DTORate;

import java.util.Collection;

/**
 * Created by ruslbard on 30.03.2017.
 */
public interface RateService {

    Collection<DTORate> getAllRates();
    DTORate createNewRate(DTORate dto);
    DTORate getRate(long id);
    DTORate saveEditRate(DTORate dto);
}
