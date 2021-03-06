package com.tsystems.jschool20.controllers;

import com.tsystems.jschool20.srvengine.api.ContractService;
import com.tsystems.jschool20.srvengine.api.PersonService;
import com.tsystems.jschool20.srvengine.dtos.DTOContractDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by ruslbard on 09.04.2017.
 */
@Controller
public class ContractsController {

    @Autowired
    private PersonService personService;
    @Autowired
    private ContractService contractService;

    @RequestMapping(method = RequestMethod.GET, path = "/operator/showNewContractForm")
    public String getNewContractForm(Model model, @RequestParam ("id") long id){

        model.addAttribute("person", personService.getPersonById(id));
        return "newContractForm";
    }

    @RequestMapping(value = "/operator/showAllContractsForm")
    public String showAllContractsForm(){

        return "allContractsForm";
    }

    @RequestMapping(value = "/operator/showEditContractForm")
    public String showEditContractForm(Model model, @RequestParam("id") long contractId){
        DTOContractDetail dtoContractDetail = contractService.getContractDetail(contractId);
        model.addAttribute("contractDetail", dtoContractDetail);
        return "editContractForm";
    }
}
