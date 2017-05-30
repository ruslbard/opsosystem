package com.tsystems.jschool20.srvengine.services;

import com.tsystems.jschool20.srvengine.api.OptionService;
import com.tsystems.jschool20.srvengine.api.RateService;
import com.tsystems.jschool20.srvengine.dtos.DTOOption;
import com.tsystems.jschool20.srvengine.entities.Option;
import com.tsystems.jschool20.srvengine.repos.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by ruslbard on 02.04.2017.
 */
@Service
@Transactional
public class OptionServiceImpl implements OptionService {

    private OptionRepository optionRepository;
    private RateService rateService;

    @Autowired
    public OptionServiceImpl(OptionRepository optionRepository, RateService rateService) {
        this.optionRepository = optionRepository;
        this.rateService = rateService;
    }

    private static void entityFactory(Option entity, DTOOption dto, OptionRepository optionRepository){

        entity.setId(dto.getId());
        entity.setPrice(dto.getPrice());
        entity.setAddCoast(dto.getAddCoast());

        if (dto.getIncludeOptionsIds() != null) {
            Collection<Option> includeOptions = new ArrayList<Option>(dto.getIncludeOptionsIds().size());

            for (Long optionId : dto.getIncludeOptionsIds()) {
                Option option = optionRepository.getOne(optionId);
                includeOptions.add(option);
            }

            entity.setIncludeOptions(includeOptions);
        }
        else{
            entity.setIncludeOptions(null);
        }


        if (dto.getExcludeOptionsIds() != null) {
            Collection<Option> excludeOptions = new ArrayList<Option>(dto.getExcludeOptionsIds().size());

            for (Long optionId : dto.getExcludeOptionsIds()) {
                Option option = optionRepository.getOne(optionId);
                excludeOptions.add(option);
            }
            entity.setExcludeOptions(excludeOptions);
        }
        else{
            entity.setExcludeOptions(null);
        }

    }

    @Transactional
    public Collection<DTOOption> getAllOptions() {

        Collection<Option> allOptions = this.optionRepository.findAll();
        Collection<DTOOption> dtos = new ArrayList<DTOOption>(allOptions.size());
        for (Option option : allOptions) {

            DTOOption dto = new DTOOption();
            dto.setId(option.getId());
            dto.setName(option.getName());
            dto.setPrice(option.getPrice());
            dto.setAddCoast(option.getAddCoast());
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

    public Collection<DTOOption> getAllOptionsForRate(long id){

        Collection<Option> rateOptions = optionRepository.findOptionByRatesId(id);

        Collection<DTOOption> dtos = new ArrayList<DTOOption>(rateOptions.size());

        for (Option option : rateOptions) {

            DTOOption dto = new DTOOption(option);
            dtos.add(dto);
        }

        return dtos;
    }

    public DTOOption getOption(long id) {

        DTOOption dto = new DTOOption(optionRepository.findOne(id));
        return dto;
    }

    public void saveOption(DTOOption dto) {

        Option option = optionRepository.findOne(dto.getId());

        if (option != null){
            OptionServiceImpl.entityFactory(option, dto, optionRepository);

            optionRepository.save(option);
        }
    }
}
