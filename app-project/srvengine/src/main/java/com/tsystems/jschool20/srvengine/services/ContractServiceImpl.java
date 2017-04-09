package com.tsystems.jschool20.srvengine.services;

import com.tsystems.jschool20.srvengine.api.ContractService;
import com.tsystems.jschool20.srvengine.entites.DTOContract;
import com.tsystems.jschool20.srvengine.repos.AbonentRepository;
import com.tsystems.jschool20.srvengine.repos.ContractRepository;
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
    private final AbonentRepository abonentRepository;

    @Autowired
    public ContractServiceImpl(ContractRepository contractRepository, AbonentRepository abonentRepository){

        this.contractRepository = contractRepository;
        this.abonentRepository = abonentRepository;
    }

    public DTOContract createNewContract(DTOContract newContract) {
        return null;
    }
}
