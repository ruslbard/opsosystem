package com.tsystems.jschool20.srvengine.services;

import com.oracle.webservices.internal.api.databinding.Databinding;
import com.tsystems.jschool20.srvengine.api.AccountService;
import com.tsystems.jschool20.srvengine.dtos.DTOAccount;
import com.tsystems.jschool20.srvengine.dtos.security.DTONewAccount;
import com.tsystems.jschool20.srvengine.entities.*;
import com.tsystems.jschool20.srvengine.errors.BusinessLogicException;
import com.tsystems.jschool20.srvengine.errors.DatabaseException;
import com.tsystems.jschool20.srvengine.repos.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;

/**
 * Created by ruslbard on 12.04.2017.
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    public static DTOAccount dtoFactory(Account entity){

        DTOAccount dto = new DTOAccount();

        dto.setId(entity.getId());
        dto.setLogin(entity.getLogin());
        dto.setPwd(entity.getPwd());
        dto.setRoleId(entity.getRole().getId());
        dto.setPersonId(entity.getPerson().getId());

        return dto;
    }

    private Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class.getCanonicalName());

    private final AccountRepository accountRepository;
    private PasswordEncoder passwordEncoder;
    private final PhoneNumberRepository phoneNumberRepository;
    private final ContractRepository contractRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, PhoneNumberRepository phoneNumberRepository, ContractRepository contractRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder){

        this.accountRepository = accountRepository;
        this.phoneNumberRepository = phoneNumberRepository;
        this.passwordEncoder = passwordEncoder;
        this.contractRepository = contractRepository;
        this.roleRepository = roleRepository;

    }

    public DTOAccount getAccountById(long id) {

        logger.info("Try get account information by ID in getAccountById().");

        return AccountServiceImpl.dtoFactory(accountRepository.findOne(id));

    }

    public DTOAccount getAccountByLogin(String login) {

        logger.info("Try get account information by LOGIN in getAccountByLogin().");

        return AccountServiceImpl.dtoFactory(accountRepository.findOneByLogin(login));
    }

    public void addNewCommonAccount(DTONewAccount newAccount) {
        if (newAccount.getPassword().equals(newAccount.getRetypePassword())){
            Account account = accountRepository.findOneByLogin(newAccount.getLogin());
            if (account == null){
                PhoneNumber phoneNumber = phoneNumberRepository.findOneByPhoneAndIsIssued(newAccount.getLogin(), 'Y');
                if (phoneNumber == null){
                    throw new BusinessLogicException("Phone number not found.");
                }
                account = new Account();
                account.setLogin(newAccount.getLogin());
                account.setPwd(passwordEncoder.encode(newAccount.getPassword()));

                Contract contract = contractRepository.findOne(phoneNumber.getContract().getId());


                if (contract.getIsBlocked() != null && contract.getIsBlocked().equals("O")){
                    throw new BusinessLogicException("Contract is blocked by operator. You cannot register account.");
                }

                account.setPerson(contract.getPerson());

                Role role = roleRepository.findOneByName("ROLE_CLIENT");

                if (role == null){
                    throw new BusinessLogicException("Unknown error");
                }

                account.setRole(role);

                try{
                    accountRepository.save(account);
                }catch (PersistenceException e){
                    logger.error(e.getMessage());
                    throw new DatabaseException("Error with new account.");
                }


            }else{
                throw new BusinessLogicException("Account already exist.");
            }

        }else{
            throw new BusinessLogicException("Password and retype password not equal.");
        }
    }
}
