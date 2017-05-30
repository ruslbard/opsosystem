package com.tsystems.jschool20.controllers;

import com.tsystems.jschool20.srvengine.api.OptionService;
import com.tsystems.jschool20.srvengine.dtos.DTOOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by ruslbard on 03.04.2017.
 */
@Controller
public class DataOptionsController {

    @Autowired
    private OptionService optionService;

    @ResponseBody
    @RequestMapping(value = "/getAllOptions", produces = "application/json")
    public Collection<DTOOption> getAllOptions(){
        return optionService.getAllOptions();
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/getAllRateOptions", produces = "application/json")
    public Collection<DTOOption> getAllOptionsForRate(@RequestParam("id") long id){

        return optionService.getAllOptionsForRate(id);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/getAllContractOptions", produces = "application/json")
    public Collection<DTOOption> getAllContractOptions(@RequestParam ("id") long id){
        return null;
    }
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/getOption", produces = "application/json")
    public DTOOption getOption(@RequestParam ("id") long id){

        return optionService.getOption(id);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/operator/saveEditOption", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public DTOOption saveEditOption(@RequestBody DTOOption dto){
        optionService.saveOption(dto);
        return dto;
    }

}
