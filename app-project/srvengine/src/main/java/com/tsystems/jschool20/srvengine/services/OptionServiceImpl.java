package com.tsystems.jschool20.srvengine.services;

import com.tsystems.jschool20.srvengine.api.OptionService;
import com.tsystems.jschool20.srvengine.entites.AbstractOption;
import com.tsystems.jschool20.srvengine.entites.DtoOption;
import com.tsystems.jschool20.srvengine.entites.Option;
import com.tsystems.jschool20.srvengine.repos.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by ruslbard on 02.04.2017.
 */
@Service
@Transactional
public class OptionServiceImpl implements OptionService {

    private OptionRepository optionRepository;

    @Autowired
    public OptionServiceImpl(OptionRepository optionRepository){
        this.optionRepository = optionRepository;
    }

    public Collection<AbstractOption> getAllOptions() {

        Collection<Option> allOptions = this.optionRepository.findAll();
        Collection<AbstractOption> dtos = new ArrayList<AbstractOption>();
        for (Option option : allOptions) {

            DtoOption dto = new DtoOption();
            dto.setId(option.getId());
            dto.setName(option.getName());
            dto.setPrice(option.getPrice());
            dto.setAdd_coast(option.getAdd_coast());
            dto.setIsActive(option.getIsActive());

            Collection<DtoOption> dtoIncludeOptions = new Collection<DtoOption>();

            dto.setIncludeOptions(option.getIncludeOptions());

            dtos.add(dto);

        }

        return dtos;
    }

    public Collection<Option> getIncludeOptions(long optionId) {
        return null;
    }

    public Collection<Option> getExcludeOptions(long optionId) {
        return null;
    }
}
