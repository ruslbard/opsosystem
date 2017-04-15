package com.tsystems.jschool20.srvengine.services;

import com.tsystems.jschool20.srvengine.api.RateService;
import com.tsystems.jschool20.srvengine.dtos.DTOOption;
import com.tsystems.jschool20.srvengine.dtos.DTORate;
import com.tsystems.jschool20.srvengine.entities.Option;
import com.tsystems.jschool20.srvengine.entities.Rate;
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

    public static Rate RateFactory(Rate entity, DTORate dto, OptionRepository optionRepository){

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPrice((long)dto.getPrice()*100);

        Collection<Option> options = new ArrayList<Option>(dto.getOptionsIds().size());

        for (Long optionId : dto.getOptionsIds()) {

            options.add(optionRepository.findOne(optionId));
        }

        entity.setOptions(options);

        return entity;
    }

    @Autowired
    public RateServiceImpl(RateRepository rateRepository, OptionRepository optionRepository){

        this.rateRepository = rateRepository;
        this.optionRepository = optionRepository;
    }


    public Collection<DTORate> getAllRates() {


        Collection<Rate> rates = rateRepository.findAll();
        Collection<DTORate> dtos = new ArrayList<DTORate>(rates.size());

        for (Rate rate : rates) {

            DTORate dto = new DTORate(rate);
            dtos.add(dto);
        }

        return dtos;
    }

    public DTORate createNewRate(DTORate dto) {

        rateRepository.save(RateServiceImpl.RateFactory(new Rate(), dto, optionRepository));

        return dto;
    }

    @Transactional
    public DTORate saveEditRate(DTORate dto) {

        Rate rate = rateRepository.getOne(dto.getId());
        if (rate != null){
            RateServiceImpl.RateFactory(rate, dto, optionRepository);
            rateRepository.save(rate);
        }
        return dto;
    }

    public DTORate getRate(long id){

        Rate rate = rateRepository.getOne(id);
        return new DTORate(rate);
    }
}
