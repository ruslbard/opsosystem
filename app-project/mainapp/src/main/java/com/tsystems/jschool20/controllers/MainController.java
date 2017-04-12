package com.tsystems.jschool20.controllers;

import com.tsystems.jschool20.srvengine.api.AccountService;
import com.tsystems.jschool20.srvengine.api.PersonService;
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

    @RequestMapping(path = "/")
    public String showUserMainForm(Model model, @RequestParam ("login") String login){

        model.addAttribute("account", accountService.getAccountByLogin(login));
        model.addAttribute("person", personService.getPersonById(accountService.getAccountByLogin(login).getPersonId()));

        return "userMainForm";
    }
}
