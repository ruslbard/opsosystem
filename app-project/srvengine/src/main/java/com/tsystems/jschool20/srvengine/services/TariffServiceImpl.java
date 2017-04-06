package com.tsystems.jschool20.srvengine.services;

import com.tsystems.jschool20.srvengine.api.TariffService;
import com.tsystems.jschool20.srvengine.entites.AbstractTariff;
import com.tsystems.jschool20.srvengine.entites.DTOTariff;
import com.tsystems.jschool20.srvengine.entites.Option;
import com.tsystems.jschool20.srvengine.entites.Tariff;
import com.tsystems.jschool20.srvengine.repos.OptionRepository;
import com.tsystems.jschool20.srvengine.repos.TariffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by ruslbard on 29.03.2017.
 */
@Service
@Transactional
public class TariffServiceImpl implements TariffService {

    private final TariffRepository tariffRepository;

    private final OptionRepository optionRepository;

    @Autowired
    public TariffServiceImpl(TariffRepository tariffRepository, OptionRepository optionRepository){

        this.tariffRepository = tariffRepository;
        this.optionRepository = optionRepository;
    }


    public Collection<Tariff> getAllTariffs() {

        return tariffRepository.findAll();
    }

    public DTOTariff createNewTariff(DTOTariff dto) {

        Tariff newTariff = new Tariff();

        newTariff.setName(dto.getName());
        newTariff.setPrice(dto.getPrice());
//        newTariff.setIsDeleted(dto.getIsDeleted());

        Collection<Option> options = new ArrayList<Option>(dto.getOptionsIds().size());

        for (Long optionId : dto.getOptionsIds()) {

            options.add(optionRepository.findById(optionId));
        }

        newTariff.setOptions(options);

        tariffRepository.save(newTariff);

        return dto;
    }

}
