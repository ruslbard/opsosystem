package com.tsystems.jschool20.srvengine.services;

import com.tsystems.jschool20.srvengine.api.ContractService;
import com.tsystems.jschool20.srvengine.dtos.*;
import com.tsystems.jschool20.srvengine.entities.Contract;
import com.tsystems.jschool20.srvengine.entities.Option;
import com.tsystems.jschool20.srvengine.repos.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
        entity.setIsBlocked(dto.getIsBlocked());

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

        dtoContractDetail.setIsBlocked(entityContract.getIsBlocked());

        return dtoContractDetail;
    }

    private Logger logger = LoggerFactory.getLogger(ContractServiceImpl.class.getCanonicalName());

    private final ContractRepository contractRepository;
    private final PersonRepository personRepository;
    private final RateRepository rateRepository;
    private final OptionRepository optionRepository;
    private final PhoneNumberRepository phoneNumberRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public ContractServiceImpl(ContractRepository contractRepository, PersonRepository personRepository, RateRepository rateRepository, OptionRepository optionRepository, PhoneNumberRepository phoneNumberRepository, AccountRepository accountRepository){

        this.contractRepository = contractRepository;
        this.personRepository = personRepository;
        this.rateRepository = rateRepository;
        this.optionRepository = optionRepository;
        this.phoneNumberRepository = phoneNumberRepository;
        this.accountRepository = accountRepository;

    }

    public DTOContract saveNewContract(DTOContract dto) {

        logger.info("Try save new Contract in saveNewContract.");

        Contract contract = ContractServiceImpl.entityFactory(dto, personRepository, rateRepository, phoneNumberRepository, optionRepository);
        contractRepository.save(contract);
        contract.getPhoneNumber().setIsIssued('Y');
        contract.getPhoneNumber().setContract(contract);



        return dto;
    }

    public DTOContract saveEditContract(DTOContract saveEditContract) {
        logger.info("Try save new Contract in saveNewContract.");

        Contract contract = contractRepository.findOne(saveEditContract.getId());

        contract.setRate(rateRepository.findOne(saveEditContract.getRateId()));
        Collection<Option> newOptionsSet = new ArrayList<Option>(saveEditContract.getOptionsIds().size());
        for (Long optionId : saveEditContract.getOptionsIds()) {
            Option option = optionRepository.findOne(optionId);
            newOptionsSet.add(option);
        }
        contract.setOptions(newOptionsSet);
        contractRepository.save(contract);
        return saveEditContract;
    }

    public Collection<DTOContractDetail> getAllContracts() {
        Collection<Contract> contracts = contractRepository.findAll();
        Collection<DTOContractDetail> contractsDetails = new ArrayList<DTOContractDetail>(contracts.size());

        for (Contract contract : contracts) {
            contractsDetails.add(ContractServiceImpl.dtoContractDetailFactory(contract));
        }
        return contractsDetails;
    }

    public DTOContractDetail getContractDetail(long contractId) {
        Contract contract = contractRepository.findOne(contractId);
        return ContractServiceImpl.dtoContractDetailFactory(contract);
    }

    public Collection<DTOContractDetail> getContractsDetailByPersonId(long id) {

        Collection<Contract> contracts = contractRepository.findAllByPersonId(id);
        Collection<DTOContractDetail> contractsDetails = new ArrayList<DTOContractDetail>(contracts.size());

        for (Contract contract : contracts) {
            contractsDetails.add(ContractServiceImpl.dtoContractDetailFactory(contract));
        }
        return contractsDetails;
    }

    public DTOContractDetail getContractDetailByPhoneNumber(String phone) {

        Contract contract = contractRepository.findOneByPhoneNumberPhone(phone);
        return ContractServiceImpl.dtoContractDetailFactory(contract);
    }

    public void changeContractRateTo(String accountLogin, long newRateId) {
        Contract contract = contractRepository.findOneByPhoneNumberPhone(accountLogin);
        contract.setRate(rateRepository.findOne(newRateId));
        contract.setOptions(new ArrayList<Option>(0));
        contractRepository.save(contract);
    }

    public void changeContractRateTo(long contractId, long newRateId) {
        Contract contract = contractRepository.findOne(contractId);
        contract.setRate(rateRepository.findOne(newRateId));
        contract.setOptions(new ArrayList<Option>(0));
        contractRepository.save(contract);
    }

    public void addOption(String accountLogin, long optionId){
        Contract contract = contractRepository.findOneByPhoneNumberPhone(accountLogin);
        Option option = optionRepository.findOne(optionId);
        contract.getOptions().add(option);
        contractRepository.save(contract);
    }

    public void removeOption(String accountLogin, long optionId){
        Contract contract = contractRepository.findOneByPhoneNumberPhone(accountLogin);
        Option option = optionRepository.findOne(optionId);
        contract.getOptions().remove(option);
        contractRepository.save(contract);
    }

    public void addOption(long contractId, long optionId) {
        Contract contract = contractRepository.findOne(contractId);
        Option option = optionRepository.findOne(optionId);
        contract.getOptions().add(option);
        contractRepository.save(contract);
    }

    public void removeOption(long contractId, long optionId) {
        Contract contract = contractRepository.findOne(contractId);
        Option option = optionRepository.findOne(optionId);
        contract.getOptions().remove(option);
        contractRepository.save(contract);
    }

    public void blockContractByOperator(long contractId) {
        Contract contract = contractRepository.findOne(contractId);
        contract.setIsBlocked(new String(new StringBuffer().append('O')));
        contractRepository.save(contract);
    }

    public void unblockContractByOperator(long contractId) {
        Contract contract = contractRepository.findOne(contractId);
        contract.setIsBlocked(null);
        contractRepository.save(contract);
    }

    public void blockContractByCommonUser(String accountLogin) {
        Contract contract = contractRepository.findOneByPhoneNumberPhone(accountLogin);
        contract.setIsBlocked(new String(new StringBuffer().append('C')));
        contractRepository.save(contract);
    }

    public void unblockContractByCommonUser(String accountLogin) {
        Contract contract = contractRepository.findOneByPhoneNumberPhone(accountLogin);
        contract.setIsBlocked(null);
        contractRepository.save(contract);
    }

}
