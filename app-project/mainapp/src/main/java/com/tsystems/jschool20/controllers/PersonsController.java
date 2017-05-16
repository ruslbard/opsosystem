package com.tsystems.jschool20.controllers;

import com.tsystems.jschool20.srvengine.api.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ruslbard on 11.04.2017.
 */
@Controller
public class PersonsController {


    @RequestMapping(path = "/operator/showAddNewPersonForm")
    public String showNewPersonForm(){

        return "newPersonForm";
    }

    @RequestMapping(path = "/operator/showAllPersonsForm")
    public String showAllPersonsForm(){

        return "allPersonsForm";
    }
}
