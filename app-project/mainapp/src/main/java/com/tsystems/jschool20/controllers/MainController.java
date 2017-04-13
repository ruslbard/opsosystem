package com.tsystems.jschool20.controllers;

import com.tsystems.jschool20.srvengine.api.AccountService;
import com.tsystems.jschool20.srvengine.api.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by ruslbard on 11.04.2017.
 */
@Controller
public class MainController {

    @Autowired
    private PersonService personService;

    @Autowired
    private AccountService accountService;

    private Logger logger = LoggerFactory.getLogger(MainController.class.getCanonicalName());

//    @RequestMapping(path = "/")
//    public String showUserMainForm(Model model, @RequestParam ("login") String login){
//
//        logger.debug("Get controller showUserMainForm with login: [" + login + "]");
//
//        model.addAttribute("account", accountService.getAccountByLogin(login));
//        model.addAttribute("person", personService.getPersonById(accountService.getAccountByLogin(login).getPersonId()));
//
//        return "userMainForm?id=4";
//    }

    @RequestMapping(path = "/")
    public String showUserMainForm(Model model){

        logger.debug("Get controller showUserMainForm with login");
        model.addAttribute("account", accountService.getAccountByLogin("common"));
        model.addAttribute("person", personService.getPersonById(accountService.getAccountByLogin("common").getPersonId()));

        return "userMainForm";
    }
}
