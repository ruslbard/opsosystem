package com.tsystems.jschool20.srvengine.api;

import com.tsystems.jschool20.srvengine.dtos.Tariff_DTO;
import com.tsystems.jschool20.srvengine.entites.Tariff;

import java.util.Collection;
import java.util.List;

/**
 * Created by ruslbard on 30.03.2017.
 */
public interface TariffService {

    Collection<Tariff> getAllTariffs();
}
