package com.tsystems.jschool20.srvengine.api;

import com.tsystems.jschool20.srvengine.entites.AbstractTariff;
import com.tsystems.jschool20.srvengine.entites.DTOTariff;
import com.tsystems.jschool20.srvengine.entites.Tariff;

import java.util.Collection;

/**
 * Created by ruslbard on 30.03.2017.
 */
public interface TariffService {

    Collection<Tariff> getAllTariffs();
    DTOTariff createNewTariff(DTOTariff dto);
}
