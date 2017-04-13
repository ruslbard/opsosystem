package com.tsystems.jschool20.srvengine.services;

import com.tsystems.jschool20.srvengine.api.ContractService;
import com.tsystems.jschool20.srvengine.dtos.*;
import com.tsystems.jschool20.srvengine.entities.Contract;
import com.tsystems.jschool20.srvengine.entities.Option;
import com.tsystems.jschool20.srvengine.repos.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by ruslbard on 09.04.2017.
 */
@Service
@Transactional
public class ContractServiceImpl implements ContractService {


    private static Contract entityFactory(DTOContract dto, PersonRepository personRepository, RateRepository rateRepository, PhoneNumberRepository phoneNumberRepository, OptionRepository optionRepository){

        Contract entity = new Contract();

        entity.setPerson(personRepository.getOne(dto.getPersonId()));
        entity.setRate(rateRepository.getOne(dto.getRateId()));
        entity.setPhoneNumber(phoneNumberRepository.getOne(dto.getPhoneNumberId()));

        Collection<Option> options = new ArrayList<Option>(dto.getOptionsIds().size());

        for (Long optionId : dto.getOptionsIds()) {

            Option option = optionRepository.findOne(optionId);
            options.add(option);
        }
        entity.setOptions(options);

        return entity;
    }

    private static DTOContractDetail dtoContractDetailFactory(Contract entityContract){

        DTOContractDetail dtoContractDetail = new DTOContractDetail();

        dtoContractDetail.setId(entityContract.getId());

        DTOPerson dtoPerson = new DTOPerson(entityContract.getPerson());
        dtoContractDetail.setPerson(dtoPerson);

        DTORate dtoRate = new DTORate(entityContract.getRate());
        dtoContractDetail.setRate(dtoRate);

        Collection<DTOOption> dtoContractOptions = new ArrayList<DTOOption>(entityContract.getOptions().size());

        for (Option option : entityContract.getOptions()) {
            DTOOption dtoOption = new DTOOption(option);
            dtoContractOptions.add(dtoOption);
        }
        dtoContractDetail.setContractOptions(dtoContractOptions);

        DTOPhoneNumber dtoPhoneNumber = new DTOPhoneNumber(entityContract.getPhoneNumber());
        dtoContractDetail.setPhoneNumber(dtoPhoneNumber);

        return dtoContractDetail;
    }

    private Logger logger = LoggerFactory.getLogger(ContractServiceImpl.class.getCanonicalName());

    private final ContractRepository contractRepository;
    private final PersonRepository personRepository;
    private final RateRepository rateRepository;
    private final OptionRepository optionRepository;
    private final PhoneNumberRepository phoneNumberRepository;

    @Autowired
    public ContractServiceImpl(ContractRepository contractRepository, PersonRepository personRepository, RateRepository rateRepository, OptionRepository optionRepository, PhoneNumberRepository phoneNumberRepository){

        this.contractRepository = contractRepository;
        this.personRepository = personRepository;
        this.rateRepository = rateRepository;
        this.optionRepository = optionRepository;
        this.phoneNumberRepository = phoneNumberRepository;

    }

    public DTOContract saveNewContract(DTOContract dto) {

        logger.info("Try save new Contract in saveNewContract.");

        contractRepository.save(ContractServiceImpl.entityFactory(dto, personRepository, rateRepository, phoneNumberRepository, optionRepository));

        return dto;
    }

    public Collection<DTOContractDetail> getContractDetailByPersonId(long id) {

        Collection<Contract> contracts = contractRepository.findContractByPersonId(id);
        Collection<DTOContractDetail> contractsDetails = new ArrayList<DTOContractDetail>(contracts.size());

        for (Contract contract : contracts) {
            contractsDetails.add(ContractServiceImpl.dtoContractDetailFactory(contract));
        }
        return contractsDetails;
    }
}
