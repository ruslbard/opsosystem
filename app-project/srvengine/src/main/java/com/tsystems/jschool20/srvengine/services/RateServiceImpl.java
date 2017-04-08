package com.tsystems.jschool20.srvengine.services;

import com.tsystems.jschool20.srvengine.api.RateService;
import com.tsystems.jschool20.srvengine.entites.DTORate;
import com.tsystems.jschool20.srvengine.entites.Option;
import com.tsystems.jschool20.srvengine.entites.Rate;
import com.tsystems.jschool20.srvengine.repos.OptionRepository;
import com.tsystems.jschool20.srvengine.repos.RateRepository;
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
public class RateServiceImpl implements RateService {

    private final RateRepository rateRepository;

    private final OptionRepository optionRepository;

    @Autowired
    public RateServiceImpl(RateRepository rateRepository, OptionRepository optionRepository){

        this.rateRepository = rateRepository;
        this.optionRepository = optionRepository;
    }


    public Collection<Rate> getAllRates() {

        return rateRepository.findAll();
    }

    public DTORate createNewRate(DTORate dto) {

        Rate newRate = new Rate();

        newRate.setName(dto.getName());
        newRate.setPrice(dto.getPrice());

        Collection<Option> options = new ArrayList<Option>(dto.getOptionsIds().size());

        for (Long optionId : dto.getOptionsIds()) {

            options.add(optionRepository.findById(optionId));
        }

        newRate.setOptions(options);

        rateRepository.save(newRate);

        return dto;
    }

}
