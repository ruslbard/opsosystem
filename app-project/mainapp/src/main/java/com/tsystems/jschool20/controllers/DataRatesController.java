package com.tsystems.jschool20.controllers;

import com.tsystems.jschool20.srvengine.api.RateService;
import com.tsystems.jschool20.srvengine.dtos.DTOOption;
import com.tsystems.jschool20.srvengine.dtos.DTORate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by ruslbard on 06.04.2017.
 */
@RestController
public class DataRatesController {

    @Autowired
    private RateService rateService;

    @RequestMapping(method = RequestMethod.POST, path = "/addNewRate", consumes = "application/json")
    public void addNewRate(@RequestBody DTORate dto){

        System.out.println(dto.toString());
        rateService.createNewRate(dto);

    }

    @RequestMapping(method = RequestMethod.GET, path = "/getAllRates", produces = "application/json")
    public Collection<DTORate> getAllRates(){

        return rateService.getAllRates();
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/getAllRateOptions", produces = "application/json")
    public Collection<DTOOption> getAllOptionsForRate(@RequestParam ("id") long id){

        return rateService.getAllRateOptions(id);
    }
}
