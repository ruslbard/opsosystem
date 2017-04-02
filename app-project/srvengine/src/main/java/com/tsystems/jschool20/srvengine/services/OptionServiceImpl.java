package com.tsystems.jschool20.srvengine.services;

import com.tsystems.jschool20.srvengine.api.OptionService;
import com.tsystems.jschool20.srvengine.entites.DtoOption;
import com.tsystems.jschool20.srvengine.entites.Option;
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

    @Autowired
    public OptionServiceImpl(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }

    @Transactional
    public Collection<DtoOption> getAllOptions() {

        Collection<Option> allOptions = this.optionRepository.findAll();
        Collection<DtoOption> dtos = new ArrayList<DtoOption>(allOptions.size());
        for (Option option : allOptions) {

            DtoOption dto = new DtoOption();
            dto.setId(option.getId());
            dto.setName(option.getName());
            dto.setPrice(option.getPrice());
            dto.setAdd_coast(option.getAdd_coast());
            dto.setIsActive(option.getIsActive());

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
