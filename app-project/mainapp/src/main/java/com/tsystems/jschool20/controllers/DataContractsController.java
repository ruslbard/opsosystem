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

    @RequestMapping(path = "/operator/getAllContracts", produces = "application/json")
    @ResponseBody
    public Collection<DTOContractDetail> getAllContracts(){

        return contractService.getAllContracts();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/operator/saveNewContract", consumes = "application/json")
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

    @RequestMapping(value = "/common/getContractDetail", produces = "application/json")
    public @ResponseBody
    DTOContractDetail getContractDetail(){

        return contractService.getContractDetailByPhoneNumber(getPrincipal().getUsername());
    }

    @RequestMapping(value = "/common/changeContractRateTo", method = RequestMethod.PUT, consumes = "application/json")
    public void changeContractRateTo(@RequestBody long id){

        contractService.changeContractRateTo(getPrincipal().getUsername(), id);
    }

    @RequestMapping(value = "/common/addContractOption", method = RequestMethod.PUT, consumes = "application/json")
    public void addContractOption(@RequestBody long optionId){

        contractService.addOption(getPrincipal().getUsername(), optionId);
    }

    @RequestMapping(value = "/common/removeContractOption", method = RequestMethod.PUT, consumes = "application/json")
    public void removeContractOption(@RequestBody long optionId){

        contractService.removeOption(getPrincipal().getUsername(), optionId);
    }

    @RequestMapping(value = "/operator/blockContract", method = RequestMethod.PUT, consumes = "application/json")
    public void blockContractByOperator(@RequestBody long contractId){
        contractService.blockContractByOperator(contractId);
    }

    @RequestMapping(value = "/operator/unblockContract", method = RequestMethod.PUT, consumes = "application/json")
    public void unblockContractByOperator(@RequestBody long contractId){
        contractService.unblockContractByOperator(contractId);
    }

    @RequestMapping(value = "/common/blockContract")
    public void blockContractByCommonUser(){
        contractService.blockContractByCommonUser(getPrincipal().getUsername());
    }

    @RequestMapping(value = "/common/unblockContract")
    public void unblockContractByCommon(){
        contractService.unblockContractByCommonUser(getPrincipal().getUsername());
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
