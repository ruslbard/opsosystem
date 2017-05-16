package com.tsystems.jschool20.srvengine.services.security;

import com.tsystems.jschool20.srvengine.dtos.security.DTOAccountDetails;
import com.tsystems.jschool20.srvengine.entities.Account;
import com.tsystems.jschool20.srvengine.repos.AccountRepository;
import com.tsystems.jschool20.srvengine.services.AccountServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by ruslbard on 24.04.2017.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Autowired
    public UserDetailsServiceImpl(AccountRepository accountRepository){

        this.accountRepository = accountRepository;
    }

    private Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class.getCanonicalName());

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Account account = accountRepository.findOneByLogin(s);
        if (account == null){
            throw new UsernameNotFoundException(String.format("User %s not found", s));
        }

        DTOAccountDetails userDetails = new DTOAccountDetails(account);

        logger.debug(String.format("Create UserDetails object with: User: [%s]", userDetails.getUsername()));

        return new User(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
    }
}
