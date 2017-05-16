package com.tsystems.jschool20.controllers;

import com.tsystems.jschool20.srvengine.api.ContractService;
import com.tsystems.jschool20.srvengine.dtos.DTOContract;
import com.tsystems.jschool20.srvengine.dtos.DTOContractDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

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

    @RequestMapping(value = "/common/getContractDetailForPerson", produces = "application/json")
    public @ResponseBody
    Collection<DTOContractDetail> getContractDetailForPerson(@RequestParam ("id") long id){

        return contractService.getContractsDetailByPersonId(id);
    }

    @RequestMapping(value = "/common/getContractDetailForPhoneNumber", produces = "application/json")
    public @ResponseBody
    DTOContractDetail getContractDetailForPhoneNumber(@RequestParam ("phoneNumber") String phoneNumber){

        return contractService.getContractDetailByPhoneNumber(phoneNumber);
    }

    @RequestMapping(value = "/common/changeContractRateTo", method = RequestMethod.PUT, consumes = "application/json")
    public void changeContractRateTo(@RequestBody long id){

        contractService.changeContractRateTo(id, getPrincipal().getUsername());
    }

    private UserDetails getPrincipal() {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return (UserDetails) principal;
        } else {
            return null;
        }
    }
}
