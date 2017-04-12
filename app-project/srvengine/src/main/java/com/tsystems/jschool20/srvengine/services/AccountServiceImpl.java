package com.tsystems.jschool20.srvengine.services;

import com.tsystems.jschool20.srvengine.api.AccountService;
import com.tsystems.jschool20.srvengine.dtos.DTOAccount;
import com.tsystems.jschool20.srvengine.entities.Account;
import com.tsystems.jschool20.srvengine.repos.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository){

        this.accountRepository = accountRepository;
    }

    public DTOAccount getAccountById(long id) {

        return AccountServiceImpl.dtoFactory(accountRepository.findOne(id));
    }

    public DTOAccount getAccountByLogin(String login) {
        return AccountServiceImpl.dtoFactory(accountRepository.findAccountByLogin(login));
    }
}
