package com.tsystems.jschool20.srvengine.api;

import com.tsystems.jschool20.srvengine.dtos.DTOAccount;
import com.tsystems.jschool20.srvengine.dtos.security.DTONewAccount;

/**
 * Created by ruslbard on 12.04.2017.
 */
public interface AccountService {

    DTOAccount getAccountById(long id);
    DTOAccount getAccountByLogin(String login);
    void addNewCommonAccount(DTONewAccount account);

}
