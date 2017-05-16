package com.tsystems.jschool20.srvengine.services;

import com.tsystems.jschool20.srvengine.api.AccountService;
import com.tsystems.jschool20.srvengine.dtos.DTOAccount;
import com.tsystems.jschool20.srvengine.dtos.security.DTOAccountDetails;
import com.tsystems.jschool20.srvengine.entities.Account;
import com.tsystems.jschool20.srvengine.repos.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    private Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class.getCanonicalName());

    private final AccountRepository accountRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, PasswordEncoder passwordEncoder){

        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public DTOAccount getAccountById(long id) {

        logger.info("Try get account information by ID in getAccountById().");

        return AccountServiceImpl.dtoFactory(accountRepository.findOne(id));

    }

    public DTOAccount getAccountByLogin(String login) {

        logger.info("Try get account information by LOGIN in getAccountByLogin().");

        return AccountServiceImpl.dtoFactory(accountRepository.findOneByLogin(login));
    }


}
