package com.tsystems.jschool20.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ruslbard on 09.04.2017.
 */
@Controller
public class ContractsController {

    @RequestMapping(path = "/showNewContractForm")
    public String getNewContractForm(){

        return "newContractForm";
    }
}
