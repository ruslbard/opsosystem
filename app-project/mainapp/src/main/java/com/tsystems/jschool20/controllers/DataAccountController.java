package com.tsystems.jschool20.controllers;

import com.tsystems.jschool20.srvengine.api.AccountService;
import com.tsystems.jschool20.srvengine.dtos.DTOAccount;
import com.tsystems.jschool20.srvengine.dtos.security.DTONewAccount;
import com.tsystems.jschool20.srvengine.errors.BusinessLogicException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by ruslbard on 30.05.2017.
 */

@Controller
public class DataAccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/addNewCommonAccount", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public DTONewAccount addNewCommonAccount(@RequestBody Map map) {

        DTONewAccount dtoNewAccount = new DTONewAccount();
        dtoNewAccount.setLogin((String) map.get("login"));
        dtoNewAccount.setPassword((String) map.get("password"));
        dtoNewAccount.setRetypePassword((String) map.get("retypePassword"));

        accountService.addNewCommonAccount(dtoNewAccount);
        return dtoNewAccount;
    }

}
