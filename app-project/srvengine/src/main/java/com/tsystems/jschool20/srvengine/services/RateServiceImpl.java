package com.tsystems.jschool20.srvengine.services;

import com.tsystems.jschool20.srvengine.api.RateService;
import com.tsystems.jschool20.srvengine.dtos.DTOOption;
import com.tsystems.jschool20.srvengine.dtos.DTORate;
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

    public static Rate RateFactory(DTORate dto, OptionRepository optionRepository){
        Rate entity = new Rate();

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPrice((long)dto.getPrice()*100);

        Collection<Option> options = new ArrayList<Option>(dto.getOptionsIds().size());

        for (Long optionId : dto.getOptionsIds()) {

            options.add(optionRepository.findById(optionId));
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

            DTORate dto = new DTORate();

            dto.setId(rate.getId());
            dto.setName(rate.getName());

            dtos.add(dto);
        }

        return dtos;
    }

    public DTORate createNewRate(DTORate dto) {

        Rate newRate = new Rate();

        newRate.setName(dto.getName());
        newRate.setPrice((long)dto.getPrice()*100);

        System.out.println(dto.getPrice());
        System.out.println(newRate.getPrice());

        Collection<Option> options = new ArrayList<Option>(dto.getOptionsIds().size());

        for (Long optionId : dto.getOptionsIds()) {

            options.add(optionRepository.findById(optionId));
        }

        newRate.setOptions(options);

        rateRepository.save(newRate);

        return dto;
    }

    public DTORate getRate(long id){

        Rate rate = rateRepository.getOne(id);

        DTORate dto = new DTORate();

        dto.setId(rate.getId());
        dto.setName(rate.getName());
        dto.setPrice(rate.getPrice());

        Collection<Long> optionsIds = new ArrayList<Long>(rate.getOptions().size());

        for (Option option : rate.getOptions()) {

            Long optionId = option.getId();
            optionsIds.add(optionId);

        }

        dto.setOptionsIds(optionsIds);

        return dto;
    }

    public Collection<DTOOption> getAllRateOptions(long id) {

        Rate rate = rateRepository.getOne(id);

        Collection<Option> rateOptions = rate.getOptions();
        Collection<DTOOption> dtos = new ArrayList<DTOOption>(rateOptions.size());

        System.out.println(rateOptions.toString());

        for (Option option : rateOptions) {

            DTOOption dto = new DTOOption();
            dto.setId(option.getId());
            dto.setName(option.getName());
            dto.setPrice(option.getPrice());
            dto.setAdd_coast(option.getAdd_coast());
            dto.setIsActive(option.getIsActive());
            dto.setDefaultForRates(option.getDefaultForRates());

            Collection<Option> includeOptions = option.getIncludeOptions();

            if (!includeOptions.isEmpty()) {

                dto.setIncludeOptionsIds(new ArrayList<Long>(includeOptions.size()));

                for (Option includeOption : includeOptions) {

                    dto.getIncludeOptionsIds().add(includeOption.getId());
                }

            }

            Collection<Option> excludeOptions = option.getExcludeOptions();

            if (!excludeOptions.isEmpty()) {

                dto.setExcludeOptionsIds(new ArrayList<Long>(excludeOptions.size()));

                for (Option excludeOption : excludeOptions) {

                    dto.getExcludeOptionsIds().add(excludeOption.getId());
                }

            }


            dtos.add(dto);

        }

        return dtos;
    }

}
