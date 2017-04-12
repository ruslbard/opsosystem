package com.tsystems.jschool20.controllers;

import com.tsystems.jschool20.srvengine.api.ContractService;
import com.tsystems.jschool20.srvengine.dtos.DTOContract;
import com.tsystems.jschool20.srvengine.dtos.DTOContractDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.POST, path = "/saveNewContract", consumes = "application/json")
    public void createNewContract(@RequestBody DTOContract dto){

        contractService.saveNewContract(dto);
    }

    @RequestMapping(path = "/getContractDetailForPerson", produces = "application/json")
    public @ResponseBody
    DTOContractDetail getContractDetailForPerson(@RequestParam ("id") long id){

        return contractService.getContractDetailByPersonId(id);
    }
}
