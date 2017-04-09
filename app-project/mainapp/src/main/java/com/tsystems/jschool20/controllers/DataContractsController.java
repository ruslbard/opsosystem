package com.tsystems.jschool20.controllers;

import com.tsystems.jschool20.srvengine.api.ContractService;
import com.tsystems.jschool20.srvengine.entites.DTOContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ruslbard on 09.04.2017.
 */
@RestController
public class DataContractsController {

    @Autowired
    private ContractService contractService;

    @RequestMapping(path = "/getAllContracts")
    public DTOContract getAllContracts(){

        return null;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/createNewContract", consumes = "application/json")
    public void createNewContract(@RequestBody DTOContract dto){

        contractService.createNewContract(dto);
    }
}
