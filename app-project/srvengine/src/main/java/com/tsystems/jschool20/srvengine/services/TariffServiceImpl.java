package com.tsystems.jschool20.srvengine.services;

import com.tsystems.jschool20.srvengine.api.TariffService;
import com.tsystems.jschool20.srvengine.entites.Tariff;
import com.tsystems.jschool20.srvengine.repos.TariffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by ruslbard on 29.03.2017.
 */
@Service
@Transactional
public class TariffServiceImpl implements TariffService {

    private final TariffRepository tariffRepository;

    @Autowired
    public TariffServiceImpl(TariffRepository tariffRepository){

        this.tariffRepository = tariffRepository;
    }



    public Collection<Tariff> getAllTariffs() {

        Collection<Tariff> tariffs = (tariffRepository.findAll());
        return tariffs;
    }

}