package com.tsystems.jschool20.srvengine.services;

import com.tsystems.jschool20.srvengine.api.ContractService;
import com.tsystems.jschool20.srvengine.api.PhoneNumbersService;
import com.tsystems.jschool20.srvengine.dtos.DTOContract;
import com.tsystems.jschool20.srvengine.entites.Person;
import com.tsystems.jschool20.srvengine.entites.PhoneNumber;
import com.tsystems.jschool20.srvengine.entites.Rate;
import com.tsystems.jschool20.srvengine.repos.OptionRepository;
import com.tsystems.jschool20.srvengine.repos.PersonRepository;
import com.tsystems.jschool20.srvengine.repos.ContractRepository;
import com.tsystems.jschool20.srvengine.repos.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ruslbard on 09.04.2017.
 */
@Service
@Transactional
public class ContractServiceImpl implements ContractService {

    private final ContractRepository contractRepository;
    private final PersonRepository personRepository;
    private final RateRepository rateRepository;
    private final OptionRepository optionRepository;

    @Autowired
    public ContractServiceImpl(ContractRepository contractRepository, PersonRepository personRepository, RateRepository rateRepository, OptionRepository optionRepository){

        this.contractRepository = contractRepository;
        this.personRepository = personRepository;
        this.rateRepository = rateRepository;
        this.optionRepository = optionRepository;

    }

    public DTOContract saveNewContract(DTOContract newContract) {

        Person person = PersonServiceImpl.entityFactory(newContract.getPerson());
        Rate rate = RateServiceImpl.RateFactory(newContract.getRate(), optionRepository);
//        PhoneNumber phoneNumber = PhoneNumbersServiceImpl.phoneNumberFactory();
        System.out.println("Contract saved.");
        return null;
    }
}
