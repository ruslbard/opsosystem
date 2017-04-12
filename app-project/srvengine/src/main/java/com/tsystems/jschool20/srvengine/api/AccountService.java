package com.tsystems.jschool20.srvengine.api;

import com.tsystems.jschool20.srvengine.dtos.DTOAccount;

/**
 * Created by ruslbard on 12.04.2017.
 */
public interface AccountService {

    DTOAccount getAccountById(long id);
    DTOAccount getAccountByLogin(String login);
}
